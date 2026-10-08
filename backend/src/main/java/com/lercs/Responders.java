package com.lercs;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.*;
public interface Responders extends JpaRepository<ResponderProfile,Long>{Optional<ResponderProfile> findByUserId(Long id);List<ResponderProfile> findByVerificationAndAvailability(Verification v,Availability a);}
