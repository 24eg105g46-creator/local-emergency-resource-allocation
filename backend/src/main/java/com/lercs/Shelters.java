package com.lercs;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Shelters extends JpaRepository<Shelter,Long>{List<Shelter> findByStatus(FacilityStatus s);}
