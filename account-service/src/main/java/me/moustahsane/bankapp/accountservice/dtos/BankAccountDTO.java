package me.moustahsane.bankapp.accountservice.dtos;

import lombok.Data;
import me.moustahsane.bankapp.accountservice.emuns.AccountStatus;

import java.util.Date;

@Data
public class BankAccountDTO {

    private String id;
    private  double balance;
    private Date createdAt;

    private String type;
    private AccountStatus status;
    private  Long customerId;


}
