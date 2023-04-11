package com.raquelmichelon.deliveryapisbtdd.repository;

import com.raquelmichelon.deliveryapisbtdd.model.Customer;

/**
 * @author raquelmichelon
 *
 */

public interface CustomerRepository {
    Customer save(Customer customer);
}
