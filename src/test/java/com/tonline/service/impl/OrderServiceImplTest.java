package com.tonline.service.impl;

import com.tonline.OrderRepository;
import com.tonline.jpa.OrderData;
import com.tonline.service.OrderService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.ArrayList;
import java.util.List;
@SpringBootTest
class OrderServiceImplTest {

    @Autowired
    OrderService orderService;

    @MockBean
    private OrderRepository orderRepository;

    @Test
    void totalCostOfCompletedOrdersOfActiveCustomers() throws Exception {
        List<OrderData> testDataList = new ArrayList<>();
        OrderData orderData1 = new OrderData();
        orderData1.setTotalCost(10.0);
        OrderData orderData2 = new OrderData();
        orderData2.setTotalCost(21.5);
        testDataList.add(orderData1);
        testDataList.add(orderData2);

        Mockito.when(orderRepository.getOrderDataByActiveCustomerAndOrderStatus(true,"COMPLETED")).thenReturn(testDataList);

        String totalValue = orderService.totalCostOfCompletedOrdersOfActiveCustomers();
        Assert.assertEquals("31.5",totalValue);
    }
}