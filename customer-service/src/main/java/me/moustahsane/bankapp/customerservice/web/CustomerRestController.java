package me.moustahsane.bankapp.customerservice.web;


import lombok.RequiredArgsConstructor;
import me.moustahsane.bankapp.customerservice.dto.CustomerDTO;
import me.moustahsane.bankapp.customerservice.exceptions.CustomerNotExist;
import me.moustahsane.bankapp.customerservice.services.CustomerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CustomerRestController {

    final CustomerService customerService;

    @GetMapping("/customers")
    public List<CustomerDTO> customerList(){
        return customerService.customersList();
    }

    @GetMapping("/customers/{id}")
    public CustomerDTO findCustomerById(@PathVariable("id") Long customerId) throws CustomerNotExist {
        return customerService.getCustomer(customerId);
    }
}
