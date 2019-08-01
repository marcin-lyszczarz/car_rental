package com.lyszczarzmarcin.portfolio.controller;

import com.lyszczarzmarcin.portfolio.model.BranchOffice;
import com.lyszczarzmarcin.portfolio.model.Car;
import com.lyszczarzmarcin.portfolio.model.Employee;
import com.lyszczarzmarcin.portfolio.service.BranchOfficeService;
import com.sun.xml.internal.txw2.annotation.XmlNamespace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branch")
public class BranchOfficeController {

    @Autowired
    BranchOfficeService branchOfficeService;

    @PostMapping()
    public BranchOffice addBranchOffice(@RequestBody BranchOffice branchOffice){
        return branchOfficeService.addBranches(branchOffice);
    }

    @GetMapping()
    public List<BranchOffice> list(){
        List<BranchOffice> branchOfficeList = branchOfficeService.getAllBranchOffice();
        return branchOfficeList;
    }

    @GetMapping("/{id}")
    public BranchOffice branchOfficeById(@PathVariable Long id){
        return branchOfficeService.getBranchOfficeById(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteBranch(@PathVariable Long id){
        branchOfficeService.deleteBranchOffice(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public BranchOffice editInfoBranchOffice(@PathVariable Long id, @RequestBody BranchOffice branchOffice) {
        return branchOfficeService.updateBranches(branchOffice, id);
}


}
