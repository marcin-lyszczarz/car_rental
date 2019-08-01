package com.lyszczarzmarcin.portfolio.service;

import com.lyszczarzmarcin.portfolio.model.Car;
import com.lyszczarzmarcin.portfolio.model.Client;
import com.lyszczarzmarcin.portfolio.model.Reservation;
import com.lyszczarzmarcin.portfolio.model.enums.CarStatus;
import com.lyszczarzmarcin.portfolio.repository.CarRepository;
import com.lyszczarzmarcin.portfolio.repository.ClientRepository;
import com.lyszczarzmarcin.portfolio.repository.ReservationRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationServiceImpl implements ReservationService {

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    ClientRepository clientRepository;

    @Autowired
    CarRepository carRepository;

    @Override
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    @Override
    public Reservation getReservationById(Long id) {
        return reservationRepository.findById(id).get();
    }

    @Override
    public Reservation addReservations(Reservation reservation) {
        reservation.setReservedDate(LocalDateTime.now());
        return reservationRepository.save(reservation);
    }

    @Override
    public void deleteReservation(Long idReservation) {
        Optional<Reservation> optionalReservation = reservationRepository.findById(idReservation);
        Reservation reservation = optionalReservation.get();
        Car car = reservation.getCar();
        if (car!=null){
            car.setStatus(CarStatus.AVAILABLE);
            carRepository.save(car);
        }
        LocalDateTime reservedDate = reservation.getReservedDate();

        reservationRepository.deleteById(idReservation);
    }

    @Override
    public Reservation signClient(Long idClient, Long id, Long idCar, LocalDate startDate, LocalDate returnDate){

        Optional<Car> optionalCar = carRepository.findById(idCar);
        Car car = optionalCar.get();
        if (car.getStatus()!= CarStatus.AVAILABLE){
            return null;
        }

        Optional<Client> optionalClient = clientRepository.findById(idClient);
        Client client = optionalClient.get();

        Optional<Reservation> optionalReservation = reservationRepository.findById(id);
        Reservation reservation = optionalReservation.get();

        reservation.setClient(client);
        reservation.setCar(car);
        reservation.setResevationFrom(LocalDateTime.of(startDate.getYear(), startDate.getMonth(), startDate.getDayOfMonth(), 00,00,00));
        reservation.setResevationTo(LocalDateTime.of(returnDate.getYear(), returnDate.getMonth(), returnDate.getDayOfMonth(), 00,00,00));
        car.setStatus(CarStatus.RENTED);
        carRepository.save(car);
        return reservationRepository.save(reservation);
    }
}
