package com.tonline.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tonline.dto.Customer;


/*
Please implement below endpoints to return json
*/
@RestController
public class StoreApiController {


    @GetMapping("/registeredCustomersNotOrderedYet")
    public List<Customer> getActiveCustomersWithNoOrders() {

        return null;
    }


    @GetMapping("/orderValueFromActiveCustomers")
    String TotalValueOfCompletedOrdersOfActiveCustomers() {

        return null;
    }


}
