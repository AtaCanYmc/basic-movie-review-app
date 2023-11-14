package com.atacanymc.basicmoviereviewapi.Service;

import com.atacanymc.basicmoviereviewapi.DTO.Request.CreateUserRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.UpdateUserRequest;
import com.atacanymc.basicmoviereviewapi.DTO.UserDto;
import com.atacanymc.basicmoviereviewapi.Model.User;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserService {
    public UserDto createUser(CreateUserRequest request);
    public UserDto deleteUser(String id);
    public UserDto updateUser(String id, UpdateUserRequest request);
    public UserDto getUser(String id);
    public List<UserDto> getAllUsers();
    public UserDto changeUserStatus(String id, int status);
}
