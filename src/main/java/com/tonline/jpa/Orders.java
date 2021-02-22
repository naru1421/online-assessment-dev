package com.tonline.jpa;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Orders {

@Id
@GeneratedValue(strategy = GenerationType.AUTO)

private Long id;
private int customerId;
private double totalCost;
private OrderStatus orderStatus;

public Long getId() {
return id;
}

public void setId(Long id) {
this.id = id;
}

public int getCustomerId() {
return customerId;
}

public void setCustomerId(int customerId) {
this.customerId = customerId;
}

public double getTotalCost() {
return totalCost;
}

public void setTotalCost(double totalCost) {
this.totalCost = totalCost;
}

public OrderStatus getOrderStatus() {
return orderStatus;
}

public void setOrderStatus(OrderStatus orderStatus) {
this.orderStatus = orderStatus;
}


}
