package com.atacanymc.basicmoviereviewapi.DTO;

import com.atacanymc.basicmoviereviewapi.Enum.UserStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UserDto {
    private String id;
    private String username;
    private String email;
    private UserStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private List<UserReviewDto> reviews;
}
