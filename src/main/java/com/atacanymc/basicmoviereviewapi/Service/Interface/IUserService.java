package com.atacanymc.basicmoviereviewapi.Service.Interface;

import com.atacanymc.basicmoviereviewapi.DTO.LoginResponse;
import com.atacanymc.basicmoviereviewapi.DTO.Request.CreateUserRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.RegisterRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.UpdateUserRequest;
import com.atacanymc.basicmoviereviewapi.DTO.UserDto;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public interface IUserService {
    public UserDto registerUser(RegisterRequest request);
    public LoginResponse loginUser(String username, String password);
    public UserDto createUser(CreateUserRequest request);
    public UserDto deleteUser(String id);
    public UserDto updateUser(String id, UpdateUserRequest request);
    public UserDto getUser(String id);
    public List<UserDto> getAllUsers();
    public UserDto changeUserStatus(String id, int status);
}
