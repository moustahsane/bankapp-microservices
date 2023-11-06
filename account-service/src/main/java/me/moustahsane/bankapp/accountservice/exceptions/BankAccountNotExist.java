package me.moustahsane.bankapp.accountservice.exceptions;

public class BankAccountNotExist extends Exception {
    public BankAccountNotExist(String customerNotExist) {
        super(customerNotExist);
    }
}
