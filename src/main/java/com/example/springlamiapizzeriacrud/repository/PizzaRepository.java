package com.example.springlamiapizzeriacrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springlamiapizzeriacrud.model.Pizza;

public interface PizzaRepository extends JpaRepository<Pizza, Integer>{

}
