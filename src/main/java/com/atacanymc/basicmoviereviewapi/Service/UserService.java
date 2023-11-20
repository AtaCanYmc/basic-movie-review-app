package com.atacanymc.basicmoviereviewapi.Service;

import com.atacanymc.basicmoviereviewapi.DTO.Converter.UserDtoConverter;
import com.atacanymc.basicmoviereviewapi.DTO.LoginResponse;
import com.atacanymc.basicmoviereviewapi.DTO.Request.CreateUserRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.RegisterRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.UpdateUserRequest;
import com.atacanymc.basicmoviereviewapi.DTO.UserDto;
import com.atacanymc.basicmoviereviewapi.Enum.UserRole;
import com.atacanymc.basicmoviereviewapi.Enum.UserStatus;
import com.atacanymc.basicmoviereviewapi.Exception.UserNotFoundException;
import com.atacanymc.basicmoviereviewapi.Model.Review;
import com.atacanymc.basicmoviereviewapi.Model.User;
import com.atacanymc.basicmoviereviewapi.Repository.UserRepository;
import com.atacanymc.basicmoviereviewapi.Security.EncryptionService;
import com.atacanymc.basicmoviereviewapi.Security.TokenService;
import com.atacanymc.basicmoviereviewapi.Service.Interface.IUserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    private final TokenService tokenService;
    private final EncryptionService encryptionService;

    public UserService(UserRepository userRepository, UserDtoConverter userDtoConverter,
                       TokenService tokenService, EncryptionService encryptionService) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
        this.tokenService = tokenService;
        this.encryptionService = encryptionService;
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

    protected void isUserExist(String username, String email) {
        if (userRepository.findByUsername(username).isPresent()) {
            throw new UserNotFoundException("User already exist with username: " + username);
        }
        if (userRepository.findByEmail(email).isPresent()) {
            throw new UserNotFoundException("User already exist with email: " + email);
        }
    }

    @Override
    public UserDto registerUser(RegisterRequest request) {
        isUserExist(request.getUsername(), request.getEmail());
        User user = new User(
                request.getUsername(),
                request.getEmail(),
                encryptionService.encryptPassword(request.getPassword()),
                UserRole.USER
        );
        return userDtoConverter.convert(userRepository.save(user));
    }

    @Override
    public LoginResponse loginUser(String username, String password) {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UserNotFoundException("User not found with username: " + username));

        if (!encryptionService.verifyPassword(password, user.getPassword())) {
            throw new UserNotFoundException("Wrong password for user: " + username);
        } else {
            return new LoginResponse(tokenService.generateJWT(user));
        }
    }

    @Override
    public UserDto createUser(CreateUserRequest request) {
        isUserExist(request.getUsername(), request.getEmail());
        User user = new User(
                request.getUsername(),
                request.getEmail(),
                encryptionService.encryptPassword(request.getPassword()),
                UserRole.fromInteger(request.getRole())
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
        isUserExist(request.getUsername(), request.getEmail());
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

    public UserDto changeUserRole(String id, int role) {
        User user = findUserById(id);
        user.setRole(UserRole.fromInteger(role));
        user.setUpdatedDate(java.time.LocalDateTime.now());
        return userDtoConverter.convert(userRepository.save(user));
    }
}
