package com.tonline;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tonline.jpa.Customer;

import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    /**
     * This method will fetch the list of customer with active status
     ** @return List<Customer></>
     */
    List<Customer> findCustomerByStatusIsTrue();

    /**
     * This method will fetch the list of customer who have not order yet based on status
     * @param status
     ** @return List<Customer></>
     */
    @Query(value = "select c.* from customer c left outer join orderdata od on c.customerid = od.customerid where c.status = :status and od.customerid is NULL", nativeQuery = true)
    List<Customer> getCustomersWithNoOrders(@Param("status") boolean status);
}
