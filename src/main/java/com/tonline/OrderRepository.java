package com.tonline;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tonline.jpa.OrderData;

import java.util.List;


@Repository
public interface OrderRepository extends CrudRepository<OrderData, Integer> {


    /**
     * This Method wth fetch result based on the customer status ans order status
     * @param customerStatus
     * @param orderStatus
     * @return List<OrderData></>
     * */
    @Query(value = "select od.* from orderdata od join customer c on c.customerid = od.customerid where c.status = :customerStatus and od.status= :orderStatus", nativeQuery = true)
    List<OrderData> getOrderDataByActiveCustomerAndOrderStatus(@Param("customerStatus") boolean customerStatus, @Param("orderStatus") String orderStatus);

}
