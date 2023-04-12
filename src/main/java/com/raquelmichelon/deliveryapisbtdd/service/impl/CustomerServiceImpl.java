package com.raquelmichelon.deliveryapisbtdd.service.impl;

import com.raquelmichelon.deliveryapisbtdd.model.Customer;
import com.raquelmichelon.deliveryapisbtdd.repository.CustomerRepository;
import com.raquelmichelon.deliveryapisbtdd.service.CustomerService;
import com.raquelmichelon.deliveryapisbtdd.service.exception.UnicCpfException;

import java.util.Optional;

public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    public CustomerServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @Override
    public Customer save(Customer customer) throws UnicCpfException {
        Optional<Customer> customerOptional = customerRepository.findByCpf(customer.getCpf());

        if(customerOptional.isPresent()) {
            throw new UnicCpfException();
        }

        return customerRepository.save(customer);
    }
}
