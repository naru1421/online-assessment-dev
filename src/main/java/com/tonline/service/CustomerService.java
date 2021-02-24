package com.tonline.service;

import com.tonline.jpa.Customer;

import java.util.List;

public interface CustomerService {

    List<Customer> getCustomersWithNoOrders() throws Exception;

}
