package com.appfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appfood.model.Order;

public interface OrderJpaRepository extends JpaRepository<Order, Integer>
{

}
