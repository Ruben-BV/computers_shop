package org.factoriaf5.computers_shop.controllers;

import java.util.List;

import org.factoriaf5.computers_shop.models.Computer;
import org.factoriaf5.computers_shop.services.ComputerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ComputerController {
    
    private ComputerService computerService;

    public ComputerController (ComputerService computerService) {
        this.computerService = computerService;
    }
    
    // Add a new computer
    @PostMapping(path = "/computers")
    public ResponseEntity<Computer> addComputer(@RequestBody Computer computer){
        return new ResponseEntity<>(computerService.addComputer(computer), HttpStatus.CREATED);
    }
    
    // Get the list of all the computers
    @GetMapping(path = "/computers")
    public List<Computer> getComputers() {
        return computerService.getAll();
    }

    // Find a computer by brand
    @GetMapping(path = "/computers/{brand}")
    public List<Computer> findComputerByBrand(@PathVariable String brand) {
        return computerService.findComputerByBrand(brand);
    }

    // Delete a computer by brand
    @DeleteMapping(path = "/computers/{brand}")
    public ResponseEntity<Void> deleteComputerByBrand(@PathVariable String brand) {
        computerService.deleteComputerByBrand(brand);
        return ResponseEntity.noContent().build();
        
    }

}
