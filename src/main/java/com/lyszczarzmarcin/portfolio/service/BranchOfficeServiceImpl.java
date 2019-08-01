package com.lyszczarzmarcin.portfolio.service;

import com.lyszczarzmarcin.portfolio.model.BranchOffice;
import com.lyszczarzmarcin.portfolio.model.Car;
import com.lyszczarzmarcin.portfolio.model.Employee;
import com.lyszczarzmarcin.portfolio.repository.BranchOfficeRepository;
import com.lyszczarzmarcin.portfolio.repository.CarRepository;
import com.lyszczarzmarcin.portfolio.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BranchOfficeServiceImpl implements BranchOfficeService {

    @Autowired
    BranchOfficeRepository branchOfficeRepository;

    @Autowired
    CarRepository carRepository;

    @Autowired
    EmployeeRepository employeeRepository;


    @Override
    public BranchOffice addBranches(BranchOffice branchOffice) {
        branchOffice.getCars().forEach(

                c -> {
                    Car car = carRepository.getOne(c.getId());
                    car.setCarBranchOffice(branchOffice);
                });
        branchOffice.getEmployees().forEach(
                e -> {
                    Employee employee = employeeRepository.getOne(e.getId());
                    employee.setEmplBranchOffice(branchOffice);
                });
        return branchOfficeRepository.save(branchOffice);
    }

    @Override
    public List<BranchOffice> getAllBranchOffice() {
        return branchOfficeRepository.findAll();
    }

    @Override
    public BranchOffice getBranchOfficeById(Long id) {
        return branchOfficeRepository.findById(id).get();
    }

    public BranchOffice updateBranches(BranchOffice branchOffice, Long id) {
        Optional<BranchOffice> editBranchOptional = branchOfficeRepository.findById(id);
        if (editBranchOptional.isPresent()) {
            BranchOffice editBranch = editBranchOptional.get();
            if (branchOffice.getAdress() != null)
                editBranch.setAdress(branchOffice.getAdress());
            if (branchOffice.getCity() != null)
                editBranch.setCity(branchOffice.getCity());
            return branchOfficeRepository.save(editBranch);
        }
        return null;
    }


    @Override
    public void deleteBranchOffice(Long id) {
        branchOfficeRepository.deleteById(id);
    }

}
