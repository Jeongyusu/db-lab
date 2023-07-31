package model.transaction;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter @ToString
public class Transaction {
    private int transactionNumber;
    private int transactionAmount;
    private int transactionWBalance;
    private int transactionDBalance;
    private int transactionWAccountNumber;
    private int transactionDAccountNumber;
    private Timestamp transactionCreatedAt;


    @Builder
    public Transaction(Integer transactionNumber, Integer transactionAmount, Integer transactionWBalance, Integer transactionDBalance, Integer transactionWAccountNumber, Integer transactionDAccountNumber, Timestamp transactionCreatedAt) {
        this.transactionNumber = transactionNumber;
        this.transactionAmount = transactionAmount;
        this.transactionWBalance = transactionWBalance;
        this.transactionDBalance = transactionDBalance;
        this.transactionWAccountNumber = transactionWAccountNumber;
        this.transactionDAccountNumber = transactionDAccountNumber;
        this.transactionCreatedAt = transactionCreatedAt;
    }
}