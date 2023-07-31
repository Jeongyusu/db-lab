package dao;

//DB 접근 미들웨어
//SRP (Single Responsibility Principle) 단일책임의 원칙
//Data Access Object

import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {

    public void insert(int accountNumber, String accountPassword, int accountBalance){
        // 1. DB 연결
        Connection conn = DBConnection.getInstance();

        //2. 버퍼로 SQL 쓰기

        try {
            String sql = "insert into account_tb" +
                    "(account_number, account_password, account_balance, account_created_at)" +
                    " values(?, ?, ?, now())";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, accountNumber);
            statement.setString(2, accountPassword);
            statement.setInt(3, accountBalance);

            int result = statement.executeUpdate(); //flush (변경된 row 카운트를 응답)
            System.out.println("결과 : " + result);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int accountBalance, int accountNumber){
        // 1. DB 연결
        Connection conn = DBConnection.getInstance();

        //2. 버퍼로 SQL 쓰기

        try {
            String sql = "update account_tb set account_balance = ? where account_number = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, accountBalance);
            statement.setInt(2, accountNumber);


            int result = statement.executeUpdate(); //flush (변경된 row 카운트를 응답)
            System.out.println("결과 : " + result);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void delete(int accountNumber){
        Connection conn = DBConnection.getInstance();

        //2. 버퍼로 SQL 쓰기

        try {
            String sql = "Delete from account_tb where account_number = ?";

            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, accountNumber);



            int result = statement.executeUpdate(); //flush (변경된 row 카운트를 응답)
            System.out.println("결과 : " + result);

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void selectOne(){}

    public void selectAll(){}

}
