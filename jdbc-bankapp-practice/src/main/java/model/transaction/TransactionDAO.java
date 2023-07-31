package model.transaction;

import dto.AccountDetailDTO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TransactionDAO {
    private Connection connection;

    public TransactionDAO(Connection connection) {
        this.connection = connection;
    }

    public List<AccountDetailDTO> details(int accountNumber) throws SQLException {
        List<AccountDetailDTO> dtos = new ArrayList<>();
        String sql = "select ac.account_number, ";
        sql += "ac.account_balnce, ";
        sql += "transaction_amount amount, ";
        sql += "transaction_w_account_number sender, ";
        sql += "transaction_d_account_number receiver, ";
        sql += "if(ts.trannsaction_w_account_number = ?, ts.transaction_w_balance, ts.transaction_d_balance) balance, ";
        sql += "ts.transaction_created_at transfer_date ";
        sql += "from account_tb ac ";
        sql += "inner join transaction_tb ts on ac.account_number = ts.transaction_w_account_number ";
        sql += "OR ac.account_number = ts.transaction_d_account_number ";
        sql += "where ac.account_number = ?";

        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, accountNumber);
            statement.setInt(2, accountNumber);
            try (ResultSet rs = statement.executeQuery()){
                while (rs.next()) {
                    AccountDetailDTO dto = AccountDetailDTO.builder()
                            .accountNumber(rs.getInt("account_number"))
                            .currentBalance(rs.getInt("account_balance"))
                            .sender(rs.getInt("sender"))
                            .receiver(rs.getInt("receiver"))
                            .amount(rs.getInt("amount"))
                            .balance(rs.getInt("balance"))
                            .transferDate(rs.getTimestamp("transfer_date"))
                            .build();
                    dtos.add(dto);
                }
            }
        }
        return dtos;

    }

    public void transfer(Transaction transaction) throws SQLException{
        String query = "INSERT INTO transaction_tb (transaction_amount, transaction_w_balance, transaction_d_balance, transaction_w_account_number, transaction_d_account_number, transaction_created_at) VALUES (?, ?, ?, ?, ?, now())";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setInt(1, transaction.getTransactionAmount());
            statement.setInt(2, transaction.getTransactionWBalance());
            statement.setInt(3, transaction.getTransactionDBalance());
            statement.setInt(4, transaction.getTransactionWAccountNumber());
            statement.setInt(5, transaction.getTransactionDAccountNumber());
            statement.executeUpdate();
        }
    }
}
