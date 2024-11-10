package org.factoriaf5.computers_shop.repositories;


import org.factoriaf5.computers_shop.models.Computer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import jakarta.transaction.Transactional;

public interface ComputerRepository extends JpaRepository<Computer, Long> {
    @Modifying
    @Transactional
    @Query("DELETE FROM Computer c WHERE c.brand = :brand")
    void deleteAllByBrand(String brand);
}



