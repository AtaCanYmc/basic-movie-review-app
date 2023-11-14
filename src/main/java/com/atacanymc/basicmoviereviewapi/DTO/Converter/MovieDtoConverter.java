package com.atacanymc.basicmoviereviewapi.DTO.Converter;

import com.atacanymc.basicmoviereviewapi.DTO.MovieDto;
import com.atacanymc.basicmoviereviewapi.Model.Movie;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MovieDtoConverter {
    private final MovieReviewDtoConverter movieReviewDtoConverter;

    public MovieDtoConverter(MovieReviewDtoConverter movieReviewDtoConverter) {
        this.movieReviewDtoConverter = movieReviewDtoConverter;
    }

    public MovieDto convert(Movie from) {
        return new MovieDto(
                from.getId(),
                from.getImdbId(),
                from.getTitle(),
                from.getReleaseDate(),
                from.getTrailerLink(),
                from.getPoster(),
                from.getBackdrops(),
                from.getGenres(),
                from.getReviews()
                        .stream()
                        .map(movieReviewDtoConverter::convert)
                        .toList()
        );
    }
}
