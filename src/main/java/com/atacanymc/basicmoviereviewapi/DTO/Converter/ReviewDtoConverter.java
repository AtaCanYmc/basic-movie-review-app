package com.atacanymc.basicmoviereviewapi.DTO.Converter;

import com.atacanymc.basicmoviereviewapi.DTO.ReviewDto;
import com.atacanymc.basicmoviereviewapi.Model.Review;
import org.springframework.stereotype.Component;

@Component
public class ReviewDtoConverter {
    private final ReviewUserDtoConverter reviewUserDtoConverter;
    private final ReviewMovieDtoConverter reviewMovieDtoConverter;

    public ReviewDtoConverter(ReviewUserDtoConverter reviewUserDtoConverter, ReviewMovieDtoConverter reviewMovieDtoConverter) {
        this.reviewUserDtoConverter = reviewUserDtoConverter;
        this.reviewMovieDtoConverter = reviewMovieDtoConverter;
    }

    public ReviewDto convert(Review from) {
        return new ReviewDto(
                from.getId(),
                from.getBody(),
                from.getRating(),
                from.getCreatedDate(),
                from.getUpdatedDate(),
                reviewUserDtoConverter.convert(from.getReviewer()),
                reviewMovieDtoConverter.convert(from.getMovie())
        );
    }
}
