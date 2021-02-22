package com.tonline;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.tonline.jpa.Customer;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Integer> {
}
