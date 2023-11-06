package me.moustahsane.bankapp.accountservice.repositories;

import me.moustahsane.bankapp.accountservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount , String> {
}
