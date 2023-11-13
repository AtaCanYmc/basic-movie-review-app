package com.atacanymc.basicmoviereviewapi.DTO.Request;

import com.atacanymc.basicmoviereviewapi.Enum.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CreateUserRequest {
    private String username;
    private String password;
    private String email;
}
