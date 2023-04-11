package com.raquelmichelon.deliveryapisbtdd.service.impl;

import com.raquelmichelon.deliveryapisbtdd.model.Customer;
import com.raquelmichelon.deliveryapisbtdd.repository.CustomerRepository;
import com.raquelmichelon.deliveryapisbtdd.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) {
        return customerRepository.save(customer);
    }
}
