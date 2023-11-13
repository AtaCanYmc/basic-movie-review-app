package com.atacanymc.basicmoviereviewapi.Service;

import com.atacanymc.basicmoviereviewapi.DTO.Request.CreateUserRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.UpdateUserRequest;
import com.atacanymc.basicmoviereviewapi.Model.User;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IUserService {
    public User createUser(CreateUserRequest request);
    public User deleteUser(ObjectId id);
    public User updateUser(ObjectId id, UpdateUserRequest request);
    public User getUser(ObjectId id);
    public List<User> getAllUsers();
    public User changeUserStatus(ObjectId id, int status);
}
