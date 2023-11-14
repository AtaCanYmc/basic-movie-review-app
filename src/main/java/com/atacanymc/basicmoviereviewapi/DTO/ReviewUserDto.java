package com.atacanymc.basicmoviereviewapi.DTO;

import com.atacanymc.basicmoviereviewapi.Enum.UserStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ReviewUserDto {
    private String id;
    private String username;
    private UserStatus status;
}
