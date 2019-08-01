package com.lyszczarzmarcin.portfolio.controller;

import com.lyszczarzmarcin.portfolio.model.Car;
import com.lyszczarzmarcin.portfolio.model.DTO.PartialCarDTO;
import com.lyszczarzmarcin.portfolio.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    CarService carService;

    @PostMapping()
    public Car addCar(@RequestBody Car car) {
        return carService.addCars(car);
    }

    @GetMapping()
    public List<Car> list() {
        List<Car> carList = carService.getAllCars();
        return carList;
    }

    @GetMapping("/{id}")
    public Car carById(@PathVariable Long id) {
        return carService.getCarById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteCar(@PathVariable Long id) {
        carService.deletaCar(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/{branchId}")
    public void changeBranchOfCar(@PathVariable Long id, @PathVariable Long branchId) {
        carService.changeBranch(id, branchId);
    }

    @PatchMapping("/{id}")
    public void updateCarDistanceAndPrice(@PathVariable Long id, @Valid @RequestBody PartialCarDTO partialCarDTO){
        carService.updateCarParameter(id, partialCarDTO);
    }

}
