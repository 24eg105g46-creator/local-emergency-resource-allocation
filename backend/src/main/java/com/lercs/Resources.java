package com.lercs;
import org.springframework.data.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import jakarta.persistence.LockModeType;
import java.util.Optional;
public interface Resources extends JpaRepository<Resource,Long>{Page<Resource> findByActiveTrue(Pageable p);@Lock(LockModeType.PESSIMISTIC_WRITE) @Query("select r from Resource r where r.id=:id") Optional<Resource> findByIdForUpdate(@Param("id")Long id);}
