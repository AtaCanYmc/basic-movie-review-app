package com.atacanymc.basicmoviereviewapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class UserReviewDto {
    private String id;
    private String body;
    private int rating;
    private ReviewMovieDto movie;
}
