package com.atacanymc.basicmoviereviewapi.DTO.Converter;

import com.atacanymc.basicmoviereviewapi.DTO.UserReviewDto;
import com.atacanymc.basicmoviereviewapi.Model.Review;
import org.springframework.stereotype.Component;

@Component
public class UserReviewDtoConverter {
    private final ReviewMovieDtoConverter reviewMovieDtoConverter;

    public UserReviewDtoConverter(ReviewMovieDtoConverter reviewMovieDtoConverter) {
        this.reviewMovieDtoConverter = reviewMovieDtoConverter;
    }

    public UserReviewDto convert(Review from) {
        return new UserReviewDto(
                from.getId(),
                from.getBody(),
                from.getRating(),
                reviewMovieDtoConverter.convert(from.getMovie())
        );
    }
}
