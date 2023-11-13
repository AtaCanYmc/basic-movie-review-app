package com.atacanymc.basicmoviereviewapi.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UpdateUserRequest {
    private String username;
    private String password;
    private String email;
}
