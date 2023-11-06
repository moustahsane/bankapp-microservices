package me.moustahsane.bankapp.customerservice;

import me.moustahsane.bankapp.customerservice.dto.CustomerDTO;
import me.moustahsane.bankapp.customerservice.services.CustomerService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerService customerService){

        return  args -> {

            List.of("HAMZA","AMINE","KHADIJA","MARYAM","WALID", "ALI").forEach(c-> {
                CustomerDTO customerDTO = new CustomerDTO();
                customerDTO.setEmail(c+"@gmail.com");
                customerDTO.setName(c);
                customerService.saveCustomer(customerDTO);
            });

        };
    }

}
