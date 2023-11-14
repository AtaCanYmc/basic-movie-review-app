package com.atacanymc.basicmoviereviewapi.DTO.Converter;

import com.atacanymc.basicmoviereviewapi.DTO.MovieReviewDto;
import com.atacanymc.basicmoviereviewapi.DTO.ReviewDto;
import com.atacanymc.basicmoviereviewapi.Model.Review;
import org.springframework.stereotype.Component;

@Component
public class MovieReviewDtoConverter {
    final ReviewUserDtoConverter reviewUserDtoConverter;

    public MovieReviewDtoConverter(ReviewUserDtoConverter reviewUserDtoConverter) {
        this.reviewUserDtoConverter = reviewUserDtoConverter;
    }

    public MovieReviewDto convert(Review from) {
        return new MovieReviewDto(
                from.getId(),
                from.getBody(),
                from.getRating(),
                reviewUserDtoConverter.convert(from.getReviewer()),
                from.getCreatedDate(),
                from.getUpdatedDate()
        );
    }
}
