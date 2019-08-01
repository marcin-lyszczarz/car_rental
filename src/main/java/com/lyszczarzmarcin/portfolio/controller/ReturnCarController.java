package com.lyszczarzmarcin.portfolio.controller;

import com.lyszczarzmarcin.portfolio.model.ReturnCar;
import com.lyszczarzmarcin.portfolio.repository.CarRepository;
import com.lyszczarzmarcin.portfolio.service.ReturnCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/return")
public class ReturnCarController {

    @Autowired
    ReturnCarService returnCarService;

    @PostMapping
    public ReturnCar addReturnCar(@RequestBody ReturnCar returnCar){
        return returnCarService.addOrUpdateReturnCar(returnCar);
    }

    @GetMapping
    public List<ReturnCar> getAllReturns(){
        return returnCarService.getAllReturnCars();
    }

    @GetMapping("/{id}")
    public ReturnCar returnCarById(@PathVariable Long id){
        return returnCarService.getReturnCarById(id);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id){
        returnCarService.deleteReturnCar(id);
        return ResponseEntity.noContent().build();
    }
}
