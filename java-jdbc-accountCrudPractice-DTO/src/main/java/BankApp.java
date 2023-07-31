import db.DBConnection;
import dto.AccountDetailDTO;
import model.account.Account;
import model.account.AccountDAO;
import model.transaction.Transaction;
import model.transaction.TransactionDAO;
import util.MyStringUtils;

import java.sql.Connection;
import java.util.List;

public class BankApp {
    public static void main(String[] args) {
        Connection connection = DBConnection.getInstance();
        AccountDAO accountDAO = new AccountDAO(connection);
        TransactionDAO transactionDAO = new TransactionDAO(connection);
//        try {
//            // 이체 요청 정보
//            String wAccountPassword = "1234";
//            int wAccountNumber = 3333;
//            int dAccountNumber = 2222;
//            int amount = 1200;
//
//            // 0원 이체 확인하기 (컨트롤러에서 체크)
//            if(amount <= 0){
//                System.out.println("[유효성 오류] 0원 이하의 금액을 이체할 수 없습니다");
//                return;
//            }
//
//            // 동일 계좌 이체 확인하기 (컨트롤러에서 체크)
//            if(wAccountNumber == dAccountNumber){
//                System.out.println("[유효성 오류] 입출금 계좌가 동일할 수 없습니다");
//                return;
//            }
//
//            // --------------------------------------------- 트랜잭션 시작
//            connection.setAutoCommit(false);
//
//            // 계좌 찾기 (서비스에서 체크)
//            Account wAccount = accountDAO.getAccountByNumber(wAccountNumber);
//            Account dAccount = accountDAO.getAccountByNumber(dAccountNumber);
//
//            // 계좌 존재 확인 (서비스에서 체크)
//            if(wAccount == null){
//                throw new RuntimeException("출금 계좌가 존재하지 않습니다");
//            }
//            if(dAccount == null){
//                throw new RuntimeException("입금 계좌가 존재하지 않습니다");
//            }
//
//            // 계좌 비밀번호 확인 (서비스에서 체크)
//            if(!wAccount.getAccountPassword().equals(wAccountPassword)){
//                throw new RuntimeException("출금 계좌의 비밀번호가 올바르지 않습니다");
//            }
//
//            // 계좌 잔액 확인 (서비스에서 체크)
//            if(wAccount.getAccountBalance() < amount){
//                throw new RuntimeException("출금 계좌의 잔액이 부족합니다");
//            }
//
//            // 계좌 업데이트 (서비스에서 업데이트)
//            int wBalance = wAccount.getAccountBalance() - amount;
//            int dBalance = dAccount.getAccountBalance() + amount;
//            accountDAO.updateAccount(wBalance, wAccountNumber);
//            accountDAO.updateAccount(dBalance, dAccountNumber);
//
//            // 트랜잭션 이력 남기기 (서비스에서 인서트)
//            Transaction transaction = Transaction.builder()
//                    .transactionAmount(amount)
//                    .transactionWAccountNumber(wAccountNumber)
//                    .transactionDAccountNumber(dAccountNumber)
//                    .transactionWBalance(wBalance)
//                    .transactionDBalance(dBalance)
//                    .build();
//            transactionDAO.transfer(transaction);
//            connection.commit();
//            // --------------------------------------------- 트랜잭션 종료
//        } catch (Exception e) {
//            try {
//                connection.rollback();
//                System.out.println("[catch] "+e.getMessage());
//            }catch (Exception innerEx){
//                innerEx.printStackTrace();
//            }
//        } finally {
//            try {
//                connection.setAutoCommit(true);
//            }catch (Exception e){
//                e.printStackTrace();
//            }
//
//        }


        try {
            int accountNumber = 1111;
            List<AccountDetailDTO> dtos = transactionDAO.details(accountNumber);
            System.out.println("=============000님의 계좌 상세===============");
            System.out.println("본인 계좌번호 : "+dtos.get(0).getAccountNumber());
            System.out.println("본인 계좌현재잔액 : "+dtos.get(0).getCurrentBalance());
            System.out.println("=============트랜잭션 내역 시작===============");
            dtos.forEach(dto -> {
                System.out.print("[");
                if(dto.getSender() == accountNumber){
                    System.out.println("**출금**");
                }else{
                    System.out.println("**입금**");
                }
                System.out.println("    보낸 계좌 : "+dto.getSender());
                System.out.println("    받은 계좌 : "+dto.getReceiver());
                System.out.println("    이체 금액 : "+dto.getAmount());
                System.out.println("    잔액 : "+dto.getBalance());
                System.out.println("    날짜 : "+ MyStringUtils.dateFormat(dto.getTransferDate()));
                System.out.println("]");
                System.out.println();
            });
            System.out.println("=============트랜잭션 내역 끝===============");
        }catch (Exception e){

        }

    }
}