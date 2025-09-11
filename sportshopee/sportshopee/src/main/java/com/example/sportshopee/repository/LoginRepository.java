package com.example.sportshopee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.sportshopee.entity.Login;

@Repository
public interface LoginRepository extends JpaRepository<Login, String>{

}
