package com.lercs;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;
public interface ResponderAssignments extends JpaRepository<ResponderAssignment,Long>{List<ResponderAssignment> findByResponder_User_Id(Long userId);Optional<ResponderAssignment> findFirstByEmergencyIdAndResponder_User_IdAndStatusIn(Long emergencyId,Long userId,List<AssignmentStatus> statuses);}
