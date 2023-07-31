package practice;

import dao.AccountDAO;
import db.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountInsert {
    public static void main(String[] args) {
        AccountDAO accountDAO = new AccountDAO();
        accountDAO.insert(2222, "1234", 1000);
        accountDAO.insert(3333, "1234", 1000);
    }

}
