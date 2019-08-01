package com.lyszczarzmarcin.portfolio.service;

import com.lyszczarzmarcin.portfolio.model.BranchOffice;
import com.lyszczarzmarcin.portfolio.model.Car;
import com.lyszczarzmarcin.portfolio.model.DTO.PartialCarDTO;
import com.lyszczarzmarcin.portfolio.repository.BranchOfficeRepository;
import com.lyszczarzmarcin.portfolio.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.persistence.EntityNotFoundException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    CarRepository carRepository;

    @Autowired
    BranchOfficeRepository branchOfficeRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarById(Long id) {
        return carRepository.findById(id).get();
    }

    @Override
    public Car addCars(Car car) {
        return carRepository.save(car);
    }

    @Override
    public void changeBranch(Long id, Long newBranchId) {


        Optional<Car> optionalCar = carRepository.findById(id);

        if (!optionalCar.isPresent()) {
            throw new EntityNotFoundException("Samochód o podanym ID nie istnieje w bazie danych");
        }
        Car car = optionalCar.get();
        BranchOffice newBranchOffice = branchOfficeRepository.getOne(newBranchId);
        car.setCarBranchOffice(newBranchOffice);

        carRepository.save(car);
    }

    @Override
    public void deletaCar(Long id) {
        carRepository.deleteById(id);
    }

    @Override
    public void updateCarParameter(Long id, PartialCarDTO partialCarDTO) {
        String distance = partialCarDTO.getDistance();
        String price = partialCarDTO.getPrice();

        Optional<Car> optionalCar = carRepository.findById(id);
        if (!optionalCar.isPresent()) {
            throw new EntityNotFoundException("Samochód o podanym ID nie istnieje w bazie danych");
        }

        Car car = optionalCar.get();
        car.setPrice(price);
        car.setDistance(distance);
        carRepository.save(car);
    }
}
