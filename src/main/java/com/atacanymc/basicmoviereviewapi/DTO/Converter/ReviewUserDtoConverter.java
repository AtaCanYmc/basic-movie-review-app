package com.atacanymc.basicmoviereviewapi.DTO.Converter;

import com.atacanymc.basicmoviereviewapi.DTO.ReviewUserDto;
import com.atacanymc.basicmoviereviewapi.Model.User;
import org.springframework.stereotype.Component;

@Component
public class ReviewUserDtoConverter {
    public ReviewUserDto convert(User from) {
        return new ReviewUserDto(
                from.getId(),
                from.getUsername(),
                from.getStatus()
        );
    }
}
