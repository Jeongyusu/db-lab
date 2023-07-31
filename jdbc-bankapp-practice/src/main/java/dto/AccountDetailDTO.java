package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.sql.Timestamp;

@Getter @Setter
@AllArgsConstructor
@Builder

public class AccountDetailDTO {


    //조인한 테이블의 데이터를 담을 수 있도록
    private Integer accountNumber;
    private Integer currentBalance;


    //트랜잭션
    private Integer sender; //보내는사람의 계좌를 말함.
    private Integer receiver; //받는사람의 계좌를 말함.
    private Integer amount;
    private Integer balance;
    private Timestamp transferDate;
}
