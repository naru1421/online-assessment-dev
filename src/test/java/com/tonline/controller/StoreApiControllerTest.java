package com.tonline.controller;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.tonline.jpa.Customer;
import com.tonline.service.CustomerService;
import com.tonline.service.OrderService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import static org.junit.Assert.assertEquals;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class StoreApiControllerTest {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;
    @MockBean
    private OrderService orderService;


    @Test
    void getActiveCustomersWithNoOrders() throws Exception {
        String url = "/registeredCustomersNotOrderedYet";
        Customer testCustomer = new Customer();
        testCustomer.setCustomerId(1);
        testCustomer.setEmail("test@gmail.com");
        testCustomer.setName("testCustomer");
        testCustomer.setStatus(true);
        Mockito.when(customerService.getCustomersWithNoOrders()).thenReturn(Collections.singletonList(testCustomer));
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200,status);

        List<Customer> customersList = new ObjectMapper().readValue(result.getResponse().getContentAsString(), new TypeReference<List<Customer>>() {
        });
        assertEquals(1,customersList.size());

    }

    @Test
    void totalValueOfCompletedOrdersOfActiveCustomers() throws Exception {
        String url = "/orderValueFromActiveCustomers";
        Mockito.when(orderService.totalCostOfCompletedOrdersOfActiveCustomers()).thenReturn("40.0");
        MvcResult result = mvc.perform(MockMvcRequestBuilders.get(url)).andReturn();
        int status = result.getResponse().getStatus();
        assertEquals(200,status);
        assertEquals("40.0",result.getResponse().getContentAsString());

    }
}