package com.atacanymc.basicmoviereviewapi.Controller;


import com.atacanymc.basicmoviereviewapi.DTO.Request.CreateUserRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.UpdateUserRequest;
import com.atacanymc.basicmoviereviewapi.DTO.UserDto;
import com.atacanymc.basicmoviereviewapi.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.atacanymc.basicmoviereviewapi.Service.Interface.IUserService;

import java.util.List;

@RestController
@RequestMapping("/movie-api/user")
public class UserController {
    private final UserService userService;

    public UserController(IUserService userService) {
        this.userService = (UserService) userService;
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updateUser(@PathVariable String id, @RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable String id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PatchMapping("/{id}/change-status")
    public ResponseEntity<UserDto> changeUserStatus(@PathVariable String id, @RequestParam(required = true) int status) {
        return ResponseEntity.ok(userService.changeUserStatus(id, status));
    }

    @PatchMapping("/{id}/change-role")
    public ResponseEntity<UserDto> changeUserRole(@PathVariable String id, @RequestParam(required = true) int role) {
        return ResponseEntity.ok(userService.changeUserRole(id, role));
    }

}
