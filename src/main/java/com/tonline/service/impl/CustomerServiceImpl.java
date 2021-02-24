package com.tonline.service.impl;

import com.tonline.CustomerRepository;
import com.tonline.jpa.Customer;
import com.tonline.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    private static final Logger log = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    CustomerRepository customerRepository;

    /**
     * Method to return active customers with no orders
     * @return List<Customer></>
     * */
    @Override
    public List<Customer> getCustomersWithNoOrders() throws Exception {
        List<Customer> customers;
        try {
            customers = customerRepository.getCustomersWithNoOrders(true);
            log.debug("Customers list with active status and no orders " + customers.toString());
        } catch (Exception e ){
            log.debug("Unable to fetch data for customers", e);
            throw  new Exception("System error: Unable to fetch data for customers");

        }
        return customers;
    }
}
