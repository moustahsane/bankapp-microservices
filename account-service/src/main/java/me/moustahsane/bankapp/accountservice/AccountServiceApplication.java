package me.moustahsane.bankapp.accountservice;


import me.moustahsane.bankapp.accountservice.services.IBankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IBankAccountService bankAccountService
    ) {

        return  args -> {

            for (int i = 0; i < 10; i++) {

                bankAccountService.saveCurrentBankAccount(Math.random()*10000, Math.random()*10,Long.valueOf(i));
                bankAccountService.saveSavingBankAccount(Math.random()*10000, Math.random()*5,Long.valueOf(i));
            }



        };
    }

}
