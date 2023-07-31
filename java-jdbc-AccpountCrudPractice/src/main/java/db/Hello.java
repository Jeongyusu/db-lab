package db;

public class Hello {

    static {
        System.out.println("안녕");
    }

    public static void main(String[] args) {
        try {
            Class.forName("db.Hello");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}