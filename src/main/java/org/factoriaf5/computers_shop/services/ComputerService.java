package org.factoriaf5.computers_shop.services;

import java.util.ArrayList;
import java.util.List;

import org.factoriaf5.computers_shop.models.Computer;
import org.factoriaf5.computers_shop.repositories.ComputerRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

@Service
public class ComputerService {
    
    private final ComputerRepository computerRepository;

    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }

    public Computer addComputer(Computer computer){
            return computerRepository.save(computer);
    }



    public List<Computer> getAll(){
        return computerRepository.findAll();
    }



    public List<Computer> findComputerByBrand(String brand) {
        List<Computer> computers = computerRepository.findAll();
        List<Computer> result = new ArrayList<>();

        for (Computer computer : computers) {
            if (computer.getBrand().equalsIgnoreCase(brand)) {
                result.add(computer);
            }
        }

        return result;
    }


    @Transactional
    public void deleteComputerByBrand(String brand) {
        computerRepository.deleteAllByBrand(brand);
    }

}
