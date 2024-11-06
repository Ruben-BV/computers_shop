package org.factoriaf5.computers_shop.repositories;

import org.factoriaf5.computers_shop.models.Computer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
    
}



