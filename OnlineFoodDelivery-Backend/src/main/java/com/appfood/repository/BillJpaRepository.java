package com.appfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appfood.model.Bill;

public interface BillJpaRepository extends JpaRepository<Bill,Integer>
{

}
