package com.atacanymc.basicmoviereviewapi.Controller;


import com.atacanymc.basicmoviereviewapi.DTO.Request.CreateUserRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.UpdateUserRequest;
import com.atacanymc.basicmoviereviewapi.Model.User;
import com.atacanymc.basicmoviereviewapi.Service.UserService;
import org.bson.types.ObjectId;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.atacanymc.basicmoviereviewapi.Service.IUserService;

import java.util.List;

@RestController
@RequestMapping("/movie-api/user")
public class UserController {
    private final UserService userService;

    public UserController(IUserService userService) {
        this.userService = (UserService) userService;
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        return ResponseEntity.ok(userService.getAllUsers());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable ObjectId id) {
        return ResponseEntity.ok(userService.getUser(id));
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody CreateUserRequest request) {
        return ResponseEntity.ok(userService.createUser(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> updateUser(@PathVariable ObjectId id, @RequestBody UpdateUserRequest request) {
        return ResponseEntity.ok(userService.updateUser(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable ObjectId id) {
        return ResponseEntity.ok(userService.deleteUser(id));
    }

    @PutMapping("/{id}/status")
    public ResponseEntity<User> changeUserStatus(@PathVariable ObjectId id, @RequestParam(required = true) int status) {
        return ResponseEntity.ok(userService.changeUserStatus(id, status));
    }

}
