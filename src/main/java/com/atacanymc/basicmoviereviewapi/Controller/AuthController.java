package com.atacanymc.basicmoviereviewapi.Controller;

import com.atacanymc.basicmoviereviewapi.DTO.LoginResponse;
import com.atacanymc.basicmoviereviewapi.DTO.Request.LoginRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.RegisterRequest;
import com.atacanymc.basicmoviereviewapi.DTO.UserDto;
import com.atacanymc.basicmoviereviewapi.Service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movie-api/auth")
public class AuthController {
    private final UserService userService;

    public AuthController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/login")
    public ResponseEntity<LoginResponse> login(@RequestBody LoginRequest request) {
        return ResponseEntity.ok(new LoginResponse("token"));
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> register(@RequestBody RegisterRequest request) {
        return ResponseEntity.ok(userService.registerUser(request));
    }
}


