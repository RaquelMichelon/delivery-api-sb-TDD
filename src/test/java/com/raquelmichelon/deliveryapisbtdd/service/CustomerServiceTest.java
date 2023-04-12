package com.raquelmichelon.deliveryapisbtdd.service;

import com.raquelmichelon.deliveryapisbtdd.model.Customer;
import com.raquelmichelon.deliveryapisbtdd.repository.CustomerRepository;
import com.raquelmichelon.deliveryapisbtdd.service.exception.UnicCpfException;
import com.raquelmichelon.deliveryapisbtdd.service.impl.CustomerServiceImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

/**
 * @author raquelmichelon
 *
 */
@RunWith(SpringRunner.class)
public class CustomerServiceTest {

    private static final String NAME = "Raquel Michelon";
    private static final String CPF = "000-000-000-00";

    @MockBean
    private CustomerRepository customerRepository;

    private CustomerService customerService;

    private Customer customer;


    @Before
    public void setUp() throws Exception {

        customerService = new CustomerServiceImpl(customerRepository);

        customer = new Customer();
        customer.setName(NAME);
        customer.setCpf(CPF);

        //by default, return an empty optional when findByCpf is called
        when(customerRepository.findByCpf(CPF )).thenReturn(Optional.empty());

    }

    @Test
    public void shouldSaveCustomerInRepository() throws Exception {

        customerService.save(customer);

        verify(customerRepository).save(customer);
    }

    @Test(expected = UnicCpfException.class)
    public void shouldNotSaveTwoCustomersWithSameCpf() throws Exception {

        //this method overrides the default behavior present in the @Before setup
        when(customerRepository.findByCpf(CPF)).thenReturn(Optional.of(customer));

        customerService.save(customer);
    }
}
