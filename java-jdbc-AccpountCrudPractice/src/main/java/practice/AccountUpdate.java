package practice;

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountUpdate {
    public static void main(String[] args) {
        // 1. DB 연결
        Connection conn = DBConnection.getInstance();

        //2. 버퍼로 SQL 쓰기

        try {
            String sql = "update account_tb set account_balance = ? where account_number = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, 900);
            statement.setInt(2, 1111);


            int result = statement.executeUpdate(); //flush (변경된 row 카운트를 응답)
            System.out.println("결과 : " + result);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
