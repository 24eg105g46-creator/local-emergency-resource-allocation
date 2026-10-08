package com.lercs;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
public interface Histories extends JpaRepository<StatusHistory,Long>{List<StatusHistory> findByEmergencyIdOrderByChangedAtAsc(Long id);}
