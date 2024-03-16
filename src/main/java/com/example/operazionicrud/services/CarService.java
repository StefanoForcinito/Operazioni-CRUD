package com.example.operazionicrud.services;

import com.example.operazionicrud.entities.Car;
import com.example.operazionicrud.repositories.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class CarService {
    @Autowired
    CarRepository carRepository;

    public Car createCar(Car carToCreate){
        carRepository.save(carToCreate);
        return carToCreate;
    }

    public List<Car> getAllCars(){
        List<Car> allCars = carRepository.findAll();
        return allCars;
    }

    public Optional<Car> getCarById(Long idToFind){
        return carRepository.findById(idToFind);
    }

    public Optional<Car> updateCarType(Long idToFind, String typeToUpdate){
        Optional<Car> carToUpdate = carRepository.findById(idToFind);
        if (carToUpdate.isPresent()){
            carToUpdate.get().setType(typeToUpdate);
            carRepository.save(carToUpdate.get());
        }
        return carToUpdate;
    }

    public Optional<Car> deleteSpecificCar(Long id){
        Optional<Car> eventDeleted = carRepository.findById(id);
        if (eventDeleted.isPresent()){
            carRepository.delete(eventDeleted.get());
        }
        return eventDeleted;
    }

    public List<Car> deleteAllCars(){
        List<Car> carsDeleted = carRepository.findAll();
        carRepository.deleteAll();
        return carsDeleted;
    }
}
