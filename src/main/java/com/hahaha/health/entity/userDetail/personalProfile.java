package com.hahaha.health.entity.userDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class personalProfile {
    private int id;
    private String sex;
    private String age;
    private Float height;
    private Float weight;
}
