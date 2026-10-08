package com.lercs;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

record AdminUserRequest(@NotNull Role role,@NotNull Boolean active) {}

@RestController
@RequestMapping("/api/admin/users")
class AdminController {
 private final Users users;
 private final AuditLogs logs;
 AdminController(Users users,AuditLogs logs){this.users=users;this.logs=logs;}

 @GetMapping PageView<UserView> list(@RequestParam(defaultValue="0") int page,@RequestParam(defaultValue="25") int size){requireAdmin();var p=users.findAll(PageRequest.of(Math.max(0,page),Math.max(1,Math.min(100,size))));return new PageView<>(p.getContent().stream().map(UserView::from).toList(),p.getNumber(),p.getSize(),p.getTotalElements(),p.getTotalPages());}

 @PatchMapping("/{id}") ApiResponse<UserView> update(@PathVariable Long id,@Valid @RequestBody AdminUserRequest request){User actor=requireAdmin();User target=users.findById(id).orElseThrow(()->new ResponseStatusException(HttpStatus.NOT_FOUND,"User not found"));if(target.id.equals(actor.id)&&(!request.active()||request.role()!=actor.role))throw new IllegalArgumentException("You cannot disable or change your own administrator role");target.role=request.role();target.active=request.active();User saved=users.save(target);logs.save(new AuditLog(actor,"USER_UPDATE","User",saved.id.toString(),"role="+saved.role+", active="+saved.active));return ApiResponse.ok("User account updated",UserView.from(saved));}

 private User requireAdmin(){User actor=AuthController.currentUser(users);if(actor.role!=Role.ADMIN)throw new AccessDeniedException("Admin role required");return actor;}
}
