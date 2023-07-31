package test;


import lombok.Getter;

import java.sql.Timestamp;

@Getter
class User {

   private Integer id;
   private String username;
   private String password;
   private Boolean status; // true 활동, false 휴면
   private Timestamp createdAt; // 가입날짜 now()로 보통 자바에서 넣음

}

public class Builder02 {
    public static void main(String[] args) {
        Person p1 = new Person(null, "홍길동", 20);

    }
}
