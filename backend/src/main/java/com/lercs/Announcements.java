package com.lercs;
import org.springframework.data.jpa.repository.JpaRepository;
import java.time.Instant;
import java.util.List;
public interface Announcements extends JpaRepository<Announcement,Long>{List<Announcement> findByActiveTrueAndExpiryAtAfterOrActiveTrueAndExpiryAtIsNullOrderByCreatedAtDesc(Instant now);}
