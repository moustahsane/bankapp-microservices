package me.moustahsane.bankapp.accountservice.mappers;

import me.moustahsane.bankapp.accountservice.dtos.BankAccountDTO;
import me.moustahsane.bankapp.accountservice.dtos.CurrentAccountDTO;
import me.moustahsane.bankapp.accountservice.dtos.SavingAccountDTO;
import me.moustahsane.bankapp.accountservice.entities.BankAccount;
import me.moustahsane.bankapp.accountservice.entities.CurrentAccount;
import me.moustahsane.bankapp.accountservice.entities.SavingAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;


@Component
public class BankAccountMapperImpl implements  BankAccountMapper {
    @Override
    public SavingAccountDTO savingBankAccountToSavingBankAccountDTO(SavingAccount bankAccount) {
        SavingAccountDTO savingAccountDTO = new SavingAccountDTO();
        BeanUtils.copyProperties(bankAccount, savingAccountDTO);
        savingAccountDTO.setType(bankAccount.getClass().getSimpleName());
        return savingAccountDTO;
    }

    @Override
    public SavingAccount savingBankAccountDTOToSavingBankAccount(SavingAccountDTO bankAccountDTO) {
        SavingAccount savingAccount = new SavingAccount();
        BeanUtils.copyProperties(bankAccountDTO, savingAccount);
        return savingAccount;
    }

    @Override
    public CurrentAccountDTO currentBankAccountToCurrentBankAccountDTO(CurrentAccount bankAccount) {
        CurrentAccountDTO savingAccountDTO = new CurrentAccountDTO();
        BeanUtils.copyProperties(bankAccount, savingAccountDTO);
        savingAccountDTO.setType(bankAccount.getClass().getSimpleName());
        return savingAccountDTO;
    }

    @Override
    public CurrentAccount currentBankAccountDTOToCurrentBankAccount(CurrentAccountDTO bankAccountDTO) {
        CurrentAccount savingAccount = new CurrentAccount();
        BeanUtils.copyProperties(bankAccountDTO, savingAccount);
        return savingAccount;
    }

    @Override
    public BankAccountDTO bankAccountToBankAccountDTO(BankAccount bankAccount) {
        BankAccountDTO bankAccountDTO = new BankAccountDTO();
        BeanUtils.copyProperties(bankAccount,bankAccountDTO);
        return bankAccountDTO;
    }

    @Override
    public BankAccount bankAccountDTOToBankAccount(BankAccountDTO bankAccountDTO) {
        BankAccount bankAccount= new BankAccount();
        BeanUtils.copyProperties(bankAccountDTO,bankAccount);
        return bankAccount;
    }
}
