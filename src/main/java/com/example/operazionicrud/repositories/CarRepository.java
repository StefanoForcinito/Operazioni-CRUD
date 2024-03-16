package com.example.operazionicrud.repositories;

import com.example.operazionicrud.entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<Car,Long> {}
