package me.moustahsane.bankapp.accountservice.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SavingAccountDTO extends  BankAccountDTO{

    double interestRate;
}
