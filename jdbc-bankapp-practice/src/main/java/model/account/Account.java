package model.account;

import lombok.Builder;
import lombok.Getter;

import java.sql.Timestamp;

@Getter
public class Account {
   private int accountNumber; // Pk
   private String accountPassword;
   private int accountBalance;
   private Timestamp accountCreatedAt;

    @Builder
    public Account(int accountNumber, String accountPassword, int accountBalance, Timestamp accountCreatedAt) {
        this.accountNumber = accountNumber;
        this.accountPassword = accountPassword;
        this.accountBalance = accountBalance;
        this.accountCreatedAt = accountCreatedAt;
    }
}
