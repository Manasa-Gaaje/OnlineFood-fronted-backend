package com.appfood.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.appfood.model.Item;

public interface ItemJpaRepository extends JpaRepository<Item, Integer>
{

}
