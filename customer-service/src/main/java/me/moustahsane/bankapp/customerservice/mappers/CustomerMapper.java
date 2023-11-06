package me.moustahsane.bankapp.customerservice.mappers;

import me.moustahsane.bankapp.customerservice.dto.CustomerDTO;
import me.moustahsane.bankapp.customerservice.enteties.Customer;

public interface CustomerMapper {

    CustomerDTO customerToCustomerDTO(Customer customer);
    Customer customerDtoToCustomer(CustomerDTO customerDto);
}
