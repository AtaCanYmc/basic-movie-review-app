package com.atacanymc.basicmoviereviewapi.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class MovieReviewDto {
    private String id;
    private String body;
    private int rating;
    private ReviewUserDto reviewer;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
