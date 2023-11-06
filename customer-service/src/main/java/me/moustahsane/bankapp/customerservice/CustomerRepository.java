package me.moustahsane.bankapp.customerservice;

import me.moustahsane.bankapp.customerservice.enteties.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}

