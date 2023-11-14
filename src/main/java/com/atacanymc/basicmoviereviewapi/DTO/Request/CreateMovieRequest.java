package com.atacanymc.basicmoviereviewapi.DTO.Request;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class CreateMovieRequest {
    private String imdbId;
    private String title;
    private String releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> backdrops;
    private List<String> genres;
}
