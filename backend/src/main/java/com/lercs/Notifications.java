package com.lercs;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
public interface Notifications extends JpaRepository<Notification,Long>{Page<Notification> findByUserIdOrderByCreatedAtDesc(Long userId,Pageable p);}
