package com.lercs;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AuditLogs extends JpaRepository<AuditLog,Long>{Page<AuditLog> findAllByOrderByCreatedAtDesc(Pageable p);}
