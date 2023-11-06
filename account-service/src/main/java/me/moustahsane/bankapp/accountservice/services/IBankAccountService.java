package me.moustahsane.bankapp.accountservice.services;

import me.moustahsane.bankapp.accountservice.dtos.BankAccountDTO;
import me.moustahsane.bankapp.accountservice.dtos.CurrentAccountDTO;
import me.moustahsane.bankapp.accountservice.dtos.SavingAccountDTO;
import me.moustahsane.bankapp.accountservice.exceptions.BankAccountNotExist;

import java.util.List;

public interface IBankAccountService {

    CurrentAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId);

    SavingAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId);

    List<BankAccountDTO> bankAccountList();

    BankAccountDTO getBankAccount(String idAccount) throws BankAccountNotExist;






}
