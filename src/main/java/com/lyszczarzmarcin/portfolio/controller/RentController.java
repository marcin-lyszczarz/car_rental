package com.lyszczarzmarcin.portfolio.controller;

import com.lyszczarzmarcin.portfolio.model.Rent;
import com.lyszczarzmarcin.portfolio.service.RentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rent")
public class RentController {

    @Autowired
    RentService rentService;

    @PostMapping
    public Rent addRent(@RequestBody Rent rent){
        return rentService.addOrUpdateRents(rent);
    }

    @GetMapping
    public List<Rent> list(){
        return rentService.getAllRents();
    }

    @GetMapping("/{id}")
    public Rent rentById(@PathVariable Long id){
       return rentService.getRentById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteRent(@PathVariable Long id){
        rentService.deleteRent(id);
        return ResponseEntity.noContent().build();
    }


}
