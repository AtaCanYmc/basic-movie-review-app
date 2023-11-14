package com.atacanymc.basicmoviereviewapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class ReviewDto {
    private String id;
    private String body;
    private int rating;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private ReviewUserDto reviewer;
    private ReviewMovieDto movie;
}
