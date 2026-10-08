package com.lercs;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface Categories extends JpaRepository<EmergencyCategory,Long>{Optional<EmergencyCategory> findByName(String name);}
