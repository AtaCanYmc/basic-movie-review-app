package com.atacanymc.basicmoviereviewapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class ReviewMovieDto {
    private String id;
    private String imdbId;
    private String title;
    private String poster;
}
