package com.example.sportshopee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sportshopee.entity.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{

}
