package com.example.sborders.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sborders.entity.Orders;


@Repository
public interface OrdersRepository extends JpaRepository<Orders, Long>{

}
