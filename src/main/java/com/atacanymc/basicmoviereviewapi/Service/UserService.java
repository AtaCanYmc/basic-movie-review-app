package com.atacanymc.basicmoviereviewapi.Service;

import com.atacanymc.basicmoviereviewapi.DTO.Converter.UserDtoConverter;
import com.atacanymc.basicmoviereviewapi.DTO.Request.CreateUserRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.UpdateUserRequest;
import com.atacanymc.basicmoviereviewapi.DTO.UserDto;
import com.atacanymc.basicmoviereviewapi.Enum.UserStatus;
import com.atacanymc.basicmoviereviewapi.Exception.UserNotFoundException;
import com.atacanymc.basicmoviereviewapi.Model.Review;
import com.atacanymc.basicmoviereviewapi.Model.User;
import com.atacanymc.basicmoviereviewapi.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService{
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    protected User findUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException("User not found with id: " + id));
    }

    protected void addReviewToUser(String userId, Review review) {
        User user = findUserById(userId);
        user.addReview(review);
        userRepository.save(user);
    }

    protected void removeReviewFromUser(String userId, Review review) {
        User user = findUserById(userId);
        user.removeReview(review);
        userRepository.save(user);
    }

    @Override
    public UserDto createUser(CreateUserRequest request) {
        User user = new User(
                request.getUsername(),
                request.getEmail(),
                request.getPassword()
        );
        return userDtoConverter.convert(userRepository.save(user));
    }

    @Override
    public UserDto deleteUser(String id) {
        User user = findUserById(id);
        userRepository.delete(user);
        return userDtoConverter.convert(user);
    }

    @Override
    public UserDto updateUser(String id, UpdateUserRequest request) {
        User user = findUserById(id);
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setUpdatedDate(java.time.LocalDateTime.now());
        return userDtoConverter.convert(userRepository.save(user));
    }

    @Override
    public UserDto getUser(String id) {
        return userDtoConverter.convert(findUserById(id));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userDtoConverter::convert)
                .collect(java.util.stream.Collectors.toList());
    }

    @Override
    public UserDto changeUserStatus(String id, int status) {
        User user = findUserById(id);
        user.setStatus(UserStatus.fromInteger(status));
        user.setUpdatedDate(java.time.LocalDateTime.now());
        return userDtoConverter.convert(userRepository.save(user));
    }
}
