package com.atacanymc.basicmoviereviewapi.DTO.Converter;

import com.atacanymc.basicmoviereviewapi.DTO.UserDto;
import com.atacanymc.basicmoviereviewapi.Model.User;
import org.springframework.stereotype.Component;

@Component
public class UserDtoConverter {
    private final UserReviewDtoConverter userReviewDtoConverter;

    public UserDtoConverter(UserReviewDtoConverter userReviewDtoConverter) {
        this.userReviewDtoConverter = userReviewDtoConverter;
    }

    public UserDto convert(User from) {
        return new UserDto(
                from.getId(),
                from.getUsername(),
                from.getEmail(),
                from.getStatus(),
                from.getCreatedDate(),
                from.getUpdatedDate(),
                from.getReviews().stream()
                        .map(userReviewDtoConverter::convert)
                        .collect(java.util.stream.Collectors.toList())
        );
    }
}
