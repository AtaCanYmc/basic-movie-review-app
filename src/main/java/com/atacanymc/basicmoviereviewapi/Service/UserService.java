package com.atacanymc.basicmoviereviewapi.Service;

import com.atacanymc.basicmoviereviewapi.DTO.Request.CreateUserRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.UpdateUserRequest;
import com.atacanymc.basicmoviereviewapi.Enum.UserStatus;
import com.atacanymc.basicmoviereviewapi.Exception.UserNotFoundException;
import com.atacanymc.basicmoviereviewapi.Model.User;
import com.atacanymc.basicmoviereviewapi.Repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    protected User findUserById(ObjectId id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    @Override
    public User createUser(CreateUserRequest request) {
        User user = new User(
                request.getUsername(),
                request.getEmail(),
                request.getPassword()
        );
        return userRepository.save(user);
    }

    @Override
    public User deleteUser(ObjectId id) {
        User user = findUserById(id);
        userRepository.delete(user);
        return user;
    }

    @Override
    public User updateUser(ObjectId id, UpdateUserRequest request) {
        User user = findUserById(id);
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        return userRepository.save(user);
    }

    @Override
    public User getUser(ObjectId id) {
        return findUserById(id);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User changeUserStatus(ObjectId id, int status) {
        User user = findUserById(id);
        user.setStatus(UserStatus.fromInteger(status));
        return userRepository.save(user);
    }
}
