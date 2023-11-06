package me.moustahsane.bankapp.accountservice.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CurrentAccountDTO extends  BankAccountDTO {
    double overDraft;
}
