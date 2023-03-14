## 数据库
```sql
create table personal_profile(
    id int primary key, -- 用户id，与user表关联
    sex varchar(20), -- 性别
    age varchar(20), -- 年龄
    height float, -- 身高
    weight float, -- 体重
    foreign key (id) references user(id)
)
```
## 对象 & 方法
```java
@Data
@AllArgsConstructor
@NoArgsConstructor
public class personalProfile {
    private int id;
    private String sex;
    private String age;
    private float height;
    private float weight;
}
```
## 接口
```java
@RequestMapping("/userDetail")
public class personalProfileController {
    @Autowired
    personalProfileService profileService;
    
    @GetMapping("/personalProfile")
    public String getPersonalProfile(int id){
        personalProfile p = profileService.selectProfileById(id);
        if(p == null){
            return "null";
        }
        Map<String, String> m = new HashMap<>();
        m.put("sex", p.getSex());
        m.put("age", p.getAge());
        m.put("height", p.getHeight().toString());
        m.put("weight", p.getWeight().toString());
        return JSON.toJSONString(m);
    }
    
    @PostMapping("/personalProfile")
    public String addPersonalProfile(personalProfile p){
        int i = profileService.addProfile(p);
        return i>0?"success":"error";
    }
    
    @PutMapping("/personalProfile")
    public String changePersonalProfile(personalProfile p){
        int i = profileService.changeProfile(p);
        return i>0?"success":"error";
    }
}
```