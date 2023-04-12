package com.raquelmichelon.deliveryapisbtdd.service;

import com.raquelmichelon.deliveryapisbtdd.model.Customer;
import com.raquelmichelon.deliveryapisbtdd.service.exception.UnicCpfException;

/**
 * @author raquelmichelon
 *
 */
public interface CustomerService {
    Customer save(Customer customer) throws UnicCpfException;
}
