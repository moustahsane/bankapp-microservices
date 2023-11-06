package me.moustahsane.bankapp.accountservice.clients;


import me.moustahsane.bankapp.accountservice.dtos.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "COSTUMER-SERVICE")
public interface CustomerFeignClient {

    @GetMapping("/customers")
    List<CustomerDTO> customersList();

    @GetMapping("/customers/{id}")
    CustomerDTO findCustomerById(@PathVariable("id") Long customerId);

}
