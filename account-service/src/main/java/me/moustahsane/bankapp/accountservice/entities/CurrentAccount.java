package me.moustahsane.bankapp.accountservice.entities;

import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@DiscriminatorValue("CA")
public class CurrentAccount extends  BankAccount {
    private double overDraft;
}
