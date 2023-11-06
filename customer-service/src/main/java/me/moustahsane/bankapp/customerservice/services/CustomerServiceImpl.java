package me.moustahsane.bankapp.customerservice.services;

import lombok.RequiredArgsConstructor;
import me.moustahsane.bankapp.customerservice.CustomerRepository;
import me.moustahsane.bankapp.customerservice.dto.CustomerDTO;
import me.moustahsane.bankapp.customerservice.enteties.Customer;
import me.moustahsane.bankapp.customerservice.exceptions.CustomerNotExist;
import me.moustahsane.bankapp.customerservice.mappers.CustomerMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements  CustomerService {

    final CustomerRepository customerRepository;
    final CustomerMapper mapper;
    @Override
    public CustomerDTO getCustomer(Long customerId) throws CustomerNotExist {

        var customer = customerRepository.findById(customerId).orElseThrow(()->new CustomerNotExist("CUSTOMER_NOT_EXIST"));
        return mapper.customerToCustomerDTO(customer);
    }

    @Override
    public List<CustomerDTO> customersList() {
        return customerRepository.findAll().stream().map(c->mapper.customerToCustomerDTO(c)).collect(Collectors.toList());
    }

    @Override
    public CustomerDTO saveCustomer(CustomerDTO customerDTO) {
        Customer dbCustomer = customerRepository.save( mapper.customerDtoToCustomer(customerDTO));

        return mapper.customerToCustomerDTO(dbCustomer);
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        Customer dbCustomer = customerRepository.save( mapper.customerDtoToCustomer(customerDTO));

        return mapper.customerToCustomerDTO(dbCustomer);
    }
}
