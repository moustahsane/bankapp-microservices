package me.moustahsane.bankapp.accountservice.web;


import lombok.RequiredArgsConstructor;
import me.moustahsane.bankapp.accountservice.dtos.BankAccountDTO;
import me.moustahsane.bankapp.accountservice.exceptions.BankAccountNotExist;
import me.moustahsane.bankapp.accountservice.services.IBankAccountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class BankAccountRestController {

    final private IBankAccountService bankAccountService;

    @GetMapping
    public List<BankAccountDTO> getBankAccounts(){
        return bankAccountService.bankAccountList();
    }

    @GetMapping("/{accountId}")
    public BankAccountDTO getBankAccounts(@PathVariable String accountId) throws BankAccountNotExist {
        return bankAccountService.getBankAccount(accountId);
    }
}
