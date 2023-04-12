package com.raquelmichelon.deliveryapisbtdd.repository;

import com.raquelmichelon.deliveryapisbtdd.model.Customer;

import java.util.Optional;

/**
 * @author raquelmichelon
 *
 */

public interface CustomerRepository {
    Customer save(Customer customer);

    Optional<Customer> findByCpf(String cpf);
}
