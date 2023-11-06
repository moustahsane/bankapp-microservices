package me.moustahsane.bankapp.customerservice.services;

import me.moustahsane.bankapp.customerservice.dto.CustomerDTO;
import me.moustahsane.bankapp.customerservice.exceptions.CustomerNotExist;

import java.util.List;

public interface CustomerService {

    CustomerDTO getCustomer(Long customerId) throws CustomerNotExist;
    List<CustomerDTO> customersList();
    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

}
