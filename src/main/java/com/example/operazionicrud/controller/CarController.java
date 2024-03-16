package com.example.operazionicrud.controller;

import com.example.operazionicrud.entities.Car;
import com.example.operazionicrud.services.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/cars")
public class CarController {
    @Autowired
    CarService carService;

    @PostMapping("/create")
    public ResponseEntity<Car> createCar(@RequestBody Car carToCreate) {
        Car createdCar = carService.createCar(carToCreate);
        return ResponseEntity.ok(createdCar);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Car>> getAllCars() {
        List<Car> carsList = carService.getAllCars();
        return ResponseEntity.ok(carsList);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable Long id) {
        Optional<Car> carFound = carService.getCarById(id);
        if (carFound.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(carFound.get());
    }

    @PutMapping("/editType/{id}")
    public ResponseEntity<Car> updateCarType(@PathVariable Long id, @RequestParam String type) {
        Optional<Car> updatedCar = carService.updateCarType(id, type);
        if (updatedCar.isPresent()) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(updatedCar.get());
    }

    @DeleteMapping("/deleteAll")
    public ResponseEntity<List<Car>> deleteAllCars() {
        List<Car> deletedCars = carService.deleteAllCars();
        return ResponseEntity.ok(deletedCars);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Car> deleteCarById(@PathVariable Long id) {
        Optional<Car> deletedCar = carService.deleteSpecificCar(id);
        if (deletedCar.isEmpty()) {
            return ResponseEntity.ok(deletedCar.get());

        }
        return ResponseEntity.status(HttpStatus.CONFLICT).build();

    }
}