package me.moustahsane.bankapp.accountservice.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import me.moustahsane.bankapp.accountservice.emuns.AccountStatus;

import java.util.Date;



@AllArgsConstructor @NoArgsConstructor
@Data
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", length = 4,discriminatorType = DiscriminatorType.STRING)

public class BankAccount {


    @Id
    private String id;

    private double balance;

    private Date createdAt;

    @Enumerated(EnumType.STRING)
    private AccountStatus status;

   // @Transient
    //private Customer customer;

    private Long customerId;




}
