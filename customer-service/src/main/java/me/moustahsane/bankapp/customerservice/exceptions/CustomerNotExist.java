package me.moustahsane.bankapp.customerservice.exceptions;

public class CustomerNotExist extends Exception {
    public CustomerNotExist(String customerNotExist) {
        super(customerNotExist);
    }
}
