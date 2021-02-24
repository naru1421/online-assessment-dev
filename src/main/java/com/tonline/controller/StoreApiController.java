package com.tonline.controller;

import java.util.List;

import com.tonline.jpa.Customer;
import com.tonline.jpa.OrderData;
import com.tonline.service.CustomerService;
import com.tonline.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Response;


/*
Please implement below endpoints to return json
*/
@RestController
public class StoreApiController {

    @Autowired
    private CustomerService customerService;

    @Autowired
    private OrderService orderService;

    @GetMapping("/registeredCustomersNotOrderedYet")
    public List<Customer> getActiveCustomersWithNoOrders() throws Exception {

        return customerService.getCustomersWithNoOrders();
    }


    @GetMapping("/orderValueFromActiveCustomers")
    String TotalValueOfCompletedOrdersOfActiveCustomers() throws Exception{

        return orderService.totalCostOfCompletedOrdersOfActiveCustomers();
    }


}
