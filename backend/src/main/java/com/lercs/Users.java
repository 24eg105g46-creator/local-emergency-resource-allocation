package com.lercs;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;
public interface Users extends JpaRepository<User,Long>{Optional<User> findByEmail(String email);}
