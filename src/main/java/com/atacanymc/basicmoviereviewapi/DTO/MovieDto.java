package com.atacanymc.basicmoviereviewapi.DTO;

import com.atacanymc.basicmoviereviewapi.Model.Review;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDate;
import java.util.List;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class MovieDto {
    private String id;
    private String imdbId;
    private String title;
    private LocalDate releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> backdrops;
    private List<String> genres;
    private List<MovieReviewDto> reviews;


}
