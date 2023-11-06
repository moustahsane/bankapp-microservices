package me.moustahsane.bankapp.accountservice.mappers;

import me.moustahsane.bankapp.accountservice.dtos.BankAccountDTO;
import me.moustahsane.bankapp.accountservice.dtos.CurrentAccountDTO;
import me.moustahsane.bankapp.accountservice.dtos.SavingAccountDTO;
import me.moustahsane.bankapp.accountservice.entities.BankAccount;
import me.moustahsane.bankapp.accountservice.entities.CurrentAccount;
import me.moustahsane.bankapp.accountservice.entities.SavingAccount;
import org.springframework.stereotype.Component;


@Component
public interface BankAccountMapper {

    SavingAccountDTO savingBankAccountToSavingBankAccountDTO(SavingAccount bankAccount);
    SavingAccount savingBankAccountDTOToSavingBankAccount(SavingAccountDTO bankAccountDTO);

    CurrentAccountDTO currentBankAccountToCurrentBankAccountDTO(CurrentAccount bankAccount);
    CurrentAccount currentBankAccountDTOToCurrentBankAccount(CurrentAccountDTO bankAccountDTO);
    BankAccountDTO bankAccountToBankAccountDTO(BankAccount bankAccount);
    BankAccount bankAccountDTOToBankAccount(BankAccountDTO bankAccountDTO);

}
