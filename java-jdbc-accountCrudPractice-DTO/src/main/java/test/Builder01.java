package test;


import lombok.Getter;

@Getter
class Person {

    //int 는 초기값 null을 넣지 못하기 때문에 Integer 클래스사용(랩핑클래스)
    private Integer id;
    private String name;
    private Integer age;


    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class Builder01 {
    public static void main(String[] args) {
        Person p1 = new Person(null, "홍길동", 20);

    }
}
