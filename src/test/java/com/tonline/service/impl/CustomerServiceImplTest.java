package com.tonline.service.impl;

import com.tonline.CustomerRepository;
import com.tonline.jpa.Customer;
import com.tonline.service.CustomerService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class CustomerServiceImplTest {
    @MockBean
    CustomerRepository customerRepository;

    @Autowired
    CustomerService customerService;

    @Test
    void getCustomersWithNoOrders() throws Exception {
        Customer testCustomer = new Customer();
        testCustomer.setCustomerId(1);
        testCustomer.setEmail("test@gmail.com");
        testCustomer.setName("testCustomer");
        testCustomer.setStatus(true);
        Mockito.when(customerRepository.getCustomersWithNoOrders(true)).thenReturn(Collections.singletonList(testCustomer));
        List<Customer> customerList = customerService.getCustomersWithNoOrders();
        Assert.assertEquals(1,customerList.size());
        Assert.assertEquals("test@gmail.com",customerList.get(0).getEmail());
        Assert.assertEquals("testCustomer",customerList.get(0).getName());

    }
}