package com.hahaha.health;

import java.util.ArrayList;
import java.util.List;

public class test{

    public static int temperatureTrend(int[] temperatureA, int[] temperatureB) {
        //先遍历数组计算趋势
        int len = temperatureA.length;
        int[] trendA = new int[len-1];
        int[] trendB = new int[len-1];
        for(int i=0;i<temperatureA.length-1;i++){
            int a = temperatureA[i+1]-temperatureA[i];
            trendA[i] = a>0?1:(a<0?-1:0);
            int b = temperatureB[i+1]-temperatureB[i];
            trendB[i] = b>0?1:(b<0?-1:0);
        }

        //根据趋势找趋势相同的区间，滑动窗口
        //左右起点l,r
        int max=0;
        for(int l=0;l<trendA.length;l++){
            for(int r=l;r<trendA.length;r++){
                if(trendA[r]==trendB[r]){
                    max = Math.max(max, r-l+1);
                }
                else{
                    break;
                }
            }
        }

        return max;


    }

    static int[][] direction = {{0,-1},{-1,0},{0,1},{1,0}};

    public static boolean walkAstep(int r,int c,int d,String[] plate,int num){
        int row = plate.length;
        int col = plate[0].length();
        if(num==0 || r<0 || r>=row || c<0 || c>=col) return false;
        if(plate[r].charAt(c)=='O') return true;
        if(plate[r].charAt(c)=='E') d=(d+1)%4;
        if(plate[r].charAt(c)=='W') d=(d+3)%4;
        num--;
        r+=direction[d][0];
        c+=direction[d][1];
        return walkAstep(r,c,d,plate,num);
    }
    public static int[][] ballGame(int num, String[] plate) {
        List<int[]> ans = new ArrayList<>();
        int row = plate.length;
        int col = plate[0].length();
        for(int i=1;i<col-1;i++){
            if(plate[0].charAt(i)=='O') continue;
            if(walkAstep(0,i,3,plate,num)){
                ans.add(new int[]{0,i});
            }
        }
        for(int i=1;i<col-1;i++){
            if(plate[row-1].charAt(i)=='O') continue;
            if(walkAstep(row-1,i,1,plate,num)){
                ans.add(new int[]{row-1,i});
            }
        }
        for(int i=1;i<row-1;i++){
            if(plate[i].charAt(0)=='O') continue;
            if(walkAstep(i,0,2,plate,num)){
                ans.add(new int[]{i,0});
            }
        }
        for(int i=1;i<row-1;i++){
            if(plate[i].charAt(col-1)=='O') continue;
            if(walkAstep(i,col-1,0,plate,num)){
                ans.add(new int[]{i,col-1});
            }
        }
        return ans.toArray(new int[0][]);




    }

    public static void main(String args[]){
        String[] plate = {".....","....O","....O","....."};
        int[][] ans = ballGame(3,plate);
        System.out.println(ans);
    }
}