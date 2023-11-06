package me.moustahsane.bankapp.customerservice.mappers;

import me.moustahsane.bankapp.customerservice.dto.CustomerDTO;
import me.moustahsane.bankapp.customerservice.enteties.Customer;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class CustomerMapperImpl implements  CustomerMapper{
    @Override
    public CustomerDTO customerToCustomerDTO(Customer customer) {
        CustomerDTO customerDto = new CustomerDTO();
        BeanUtils.copyProperties(customer,customerDto);
        return customerDto;
    }

    @Override
    public Customer customerDtoToCustomer(CustomerDTO customerDto) {
        Customer customer = new Customer();
        BeanUtils.copyProperties(customerDto,customer);
        return customer;
    }

}
