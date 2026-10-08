package com.lercs;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface Emergencies extends JpaRepository<Emergency,Long>{Page<Emergency> findByReporterId(Long id,Pageable p);}
