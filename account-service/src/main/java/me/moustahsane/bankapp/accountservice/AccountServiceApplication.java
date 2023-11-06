package me.moustahsane.bankapp.accountservice;


import me.moustahsane.bankapp.accountservice.clients.CustomerFeignClient;
import me.moustahsane.bankapp.accountservice.dtos.CustomerDTO;
import me.moustahsane.bankapp.accountservice.services.IBankAccountService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableFeignClients
public class AccountServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IBankAccountService bankAccountService, CustomerFeignClient customerFeignClient
                            ) {

        return  args -> {

            List<CustomerDTO> customers = customerFeignClient.customersList();
              customers.forEach( customer -> {

                bankAccountService.saveCurrentBankAccount(Math.random()*10000, Math.random()*10,Long.valueOf(customer.getId()));
                bankAccountService.saveSavingBankAccount(Math.random()*10000, Math.random()*5,Long.valueOf(customer.getId()));
            });



        };
    }

}
