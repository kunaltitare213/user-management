package org.com.usermanagement.controller;

import jakarta.validation.Valid;
import org.com.usermanagement.dto.UserRequest;
import org.com.usermanagement.dto.UserResponce;
import org.com.usermanagement.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private  final UserService userService;

    public  UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponce> getUser(@PathVariable Long id){
        return ResponseEntity.ok(userService.getUserById(id));
    }

    @PostMapping
    public ResponseEntity<UserResponce> createUser(
            @Valid @RequestBody UserRequest request){
        return ResponseEntity.ok(userService.createUser(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponce> updateUser(
            @PathVariable Long id,
            @Valid @RequestBody UserRequest request){
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping
    public ResponseEntity<List<UserResponce>> getAllUsers() {
       return ResponseEntity.ok( userService.getAllUsers());
    }

}
