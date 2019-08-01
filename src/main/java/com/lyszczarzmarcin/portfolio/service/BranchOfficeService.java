package com.lyszczarzmarcin.portfolio.service;

import com.lyszczarzmarcin.portfolio.model.BranchOffice;
import com.lyszczarzmarcin.portfolio.model.Car;
import com.lyszczarzmarcin.portfolio.model.Reservation;

import java.util.List;

public interface BranchOfficeService {
    public List<BranchOffice> getAllBranchOffice();
    public BranchOffice getBranchOfficeById(Long id);
    public BranchOffice addBranches(BranchOffice branchOffice);
    public void deleteBranchOffice(Long id);
    public BranchOffice updateBranches(BranchOffice branchOffice, Long id);
}
