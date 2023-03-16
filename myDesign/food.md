## 数据库
- 首先建立一张表，存储食物：id、名称、类别
```sql
create table food_catogory(
    id int primary key auto_increment,
    name varchar(255),
    kind varchar(255)
)
```
```sql
insert into food_catogory(name, kind)
values ('米饭', '碳水化合物'),('面包', '碳水化合物'),('柠檬','水果'),('牛排','肉');
```
- 用户吃饭表：用户id，食物id，eat_time
```sql
create table user_eat(
    user_id int,
    food_id int,
    eat_time timestamp,
    foreign key (user_id) references user(id),
    foreign key (food_id) references food_catogory(id)
)
```

## 接口
- 前端的token在登录的时候获取，存储在localstorage

```java
@PostMapping("/eat")
public String eatFood(@RequestHeader("Authorization")String token,
@RequestParam("foodId")Integer foodId,
@RequestParam("timeStamp")Timestamp timestamp){
        User tokenuser = tokenutil.jwtParser(token);
        User user = null;
        if(tokenuser != null) user = userservice.selectUserById(tokenuser.getId());
        if(user == null){
            return "eatFail";
        }else{
            return userservice.eatFood(user.getId(), foodId, timestamp)>0?"eatSuccess":"eatFail";
        }
    }
```
