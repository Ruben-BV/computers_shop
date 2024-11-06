package org.factoriaf5.computers_shop.services;

import java.util.List;

import org.factoriaf5.computers_shop.models.Computer;
import org.factoriaf5.computers_shop.repositories.ComputerRepository;
import org.springframework.stereotype.Service;

@Service
public class ComputerService {
    
    private final ComputerRepository computerRepository;

    public ComputerService(ComputerRepository computerRepository) {
        this.computerRepository = computerRepository;
    }
    public List<Computer> getAll(){
        return computerRepository.findAll();
    }
}
