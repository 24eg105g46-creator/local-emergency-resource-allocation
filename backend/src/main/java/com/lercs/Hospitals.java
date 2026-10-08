package com.lercs;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Hospitals extends JpaRepository<Hospital,Long>{List<Hospital> findByEmergencyAvailableTrueAndStatus(FacilityStatus s);}
