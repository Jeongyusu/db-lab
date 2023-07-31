package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    public static Connection getInstance(){
      //MYSQL 연결 정보
        String url = "jdbc:mysql://127.0.0.1:3306/metadb";
        String username = "root";
        String password = "2ckgkqrur@";


        try {
            // Class.forName -> 클래스 내의 스태틱 블록 실행.
            Class.forName("com.mysql.cj.jdbc.Driver");
            //커넥션 -> 프로토콜이 적용된 소켓
            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("DB 연결성공");
            return connection;
        } catch (Exception e) {
            System.out.println("DB 연결실패 :" + e.getMessage());
        }
        return null;
    }

    public static void main(String[] args) {
        getInstance();
    }
}
