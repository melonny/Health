### 数据库
```sql
create table user(
    id int primary key AUTO_INCREMENT, -- 主键自增
    username varchar(255), -- 用户名
    password varchar(255), -- 密码
    email varchar(255), -- 邮箱
    role varchar(255), -- 角色(管理员、普通用户等等)
    state tinyint -- 状态(禁用、启用)
)
```
### 对象&方法
***User***
```java
public class User {
    private Integer id;
    private String username;
    private String password;
    private String email;
    private String role;
    private boolean state;
}
```
***userRegister***
```java
public class userRegister {
    private User user;
    private String code;
}
```
### 接口
- 注册：/addUser
```java
@RequestMapping("/adduser")
public String addUser(@RequestBody userRegister userregister){
    User user = userregister.getUser();
    if(userservice.getUserByMessage(user.getUsername(), user.getPassword())!=null){
        return "exit";
    }
    String validCode = userregister.getCode();
    String redisCode = redis.get(user.getEmail());
    if(!redisCode.equals(validCode)){
        return "codeError";
    }
    user.setRole("普通用户");
    user.setState(false);
    int i = userservice.addUser(user);
    return i > 0 ?"success":"error";
}
```
- 登录：/login
```java
@RequestMapping("/login")
public String login(@RequestBody User user){
    String flag = "error";
    User us=userservice.getUserByMessage(user.getUsername(), user.getPassword());
    System.out.println("user:"+us);
    HashMap<String,Object> res = new HashMap<>();
    if(us!=null){
        flag="ok";
        String tk = token.createToken(us.getUsername(), us.getId());
        res.put("token", tk);
    }else{
        res.put("token", "-1");
    }
    res.put("flag", flag);
    res.put("user", user);
    String res_json = JSON.toJSONString(res);
    System.out.println(res_json);
    return res_json;
}
```