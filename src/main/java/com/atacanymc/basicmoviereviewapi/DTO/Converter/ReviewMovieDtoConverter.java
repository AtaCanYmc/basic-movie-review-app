package com.atacanymc.basicmoviereviewapi.DTO.Converter;

import com.atacanymc.basicmoviereviewapi.DTO.ReviewMovieDto;
import com.atacanymc.basicmoviereviewapi.Model.Movie;
import org.springframework.stereotype.Component;

@Component
public class ReviewMovieDtoConverter {
    public ReviewMovieDto convert(Movie movie) {
        return new ReviewMovieDto(
                movie.getId(),
                movie.getImdbId(),
                movie.getTitle(),
                movie.getPoster()
        );
    }
}
