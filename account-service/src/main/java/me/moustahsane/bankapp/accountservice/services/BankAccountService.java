package me.moustahsane.bankapp.accountservice.services;


import lombok.RequiredArgsConstructor;
import me.moustahsane.bankapp.accountservice.dtos.BankAccountDTO;
import me.moustahsane.bankapp.accountservice.dtos.CurrentAccountDTO;
import me.moustahsane.bankapp.accountservice.dtos.SavingAccountDTO;
import me.moustahsane.bankapp.accountservice.emuns.AccountStatus;
import me.moustahsane.bankapp.accountservice.entities.BankAccount;
import me.moustahsane.bankapp.accountservice.entities.CurrentAccount;
import me.moustahsane.bankapp.accountservice.entities.SavingAccount;
import me.moustahsane.bankapp.accountservice.exceptions.BankAccountNotExist;
import me.moustahsane.bankapp.accountservice.mappers.BankAccountMapper;
import me.moustahsane.bankapp.accountservice.repositories.BankAccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@Transactional()
@RequiredArgsConstructor
public class BankAccountService implements IBankAccountService {

    final BankAccountMapper mapper;
    final private BankAccountRepository bankAccountRepository;
    @Override
    public CurrentAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) {
        CurrentAccount dbBankAccount ;
        dbBankAccount = new CurrentAccount();
        dbBankAccount.setCustomerId(customerId);
        dbBankAccount.setBalance(initialBalance);
        dbBankAccount.setCreatedAt(new Date());
        dbBankAccount.setStatus(AccountStatus.CREATED);
        dbBankAccount.setOverDraft(overDraft);
        dbBankAccount.setId(UUID.randomUUID().toString());
        dbBankAccount = bankAccountRepository.save(dbBankAccount);
        return mapper.currentBankAccountToCurrentBankAccountDTO(dbBankAccount);


    }

    @Override
    public SavingAccountDTO saveSavingBankAccount(double initialBalance, double interestRate, Long customerId) {
        SavingAccount dbBankAccount ;
        dbBankAccount = new SavingAccount();
        dbBankAccount.setCustomerId(customerId);
        dbBankAccount.setBalance(initialBalance);
        dbBankAccount.setCreatedAt(new Date());
        dbBankAccount.setStatus(AccountStatus.CREATED);
        dbBankAccount.setInterestRate(interestRate);
        dbBankAccount.setId(UUID.randomUUID().toString());
        dbBankAccount = bankAccountRepository.save(dbBankAccount);
        return mapper.savingBankAccountToSavingBankAccountDTO(dbBankAccount);
    }

    @Override
    public List<BankAccountDTO> bankAccountList() {
        List<BankAccount> bankAccounts = bankAccountRepository.findAll();



        return bankAccounts.stream().map( account ->{
            if (account instanceof  SavingAccount ) {
                return  mapper.savingBankAccountToSavingBankAccountDTO((SavingAccount) account);
            }
            return  mapper.currentBankAccountToCurrentBankAccountDTO((CurrentAccount) account);

        }).collect(Collectors.toList());
    }

    @Override
    public BankAccountDTO getBankAccount(String idAccount) throws BankAccountNotExist {
        BankAccount bankAccount = getBankaccountNotExist(idAccount);
        if(bankAccount instanceof  SavingAccount)
        {
            return  mapper.savingBankAccountToSavingBankAccountDTO((SavingAccount) bankAccount);
        }else{
            return  mapper.savingBankAccountToSavingBankAccountDTO((SavingAccount) bankAccount);
        }
    }

    private BankAccount getBankaccountNotExist(String accountId) throws BankAccountNotExist {

        return bankAccountRepository.findById(accountId)
                .orElseThrow(() -> new BankAccountNotExist("BANKACCOUNT_NOT_EXIST"));
    }
}
