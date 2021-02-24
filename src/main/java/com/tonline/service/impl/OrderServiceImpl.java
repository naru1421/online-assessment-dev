package com.tonline.service.impl;

import com.tonline.OrderRepository;
import com.tonline.jpa.OrderData;
import com.tonline.jpa.OrderStatus;
import com.tonline.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {
    private static final Logger log = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    OrderRepository orderRepository;

    /**
     *Method to get total cost of completed orders for active customers
     * @return String
     *  */
    @Override
    public String totalCostOfCompletedOrdersOfActiveCustomers() throws Exception {
        String sum = null;
        List<OrderData> orderDataList;
        try {
             orderDataList = orderRepository.getOrderDataByActiveCustomerAndOrderStatus(true, OrderStatus.COMPLETED.name());
            log.debug("orders from active customers with completed status " + orderDataList.toString());
        } catch (Exception e) {
            log.debug("unable to fetch data from DB for orders ", e);
            throw new Exception("Unable to fetch data for orders");
        }
        if (!CollectionUtils.isEmpty(orderDataList))
            sum = String.valueOf(orderDataList.stream().mapToDouble(OrderData::getTotalCost).sum());
        return sum;
    }
}
