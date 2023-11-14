package com.atacanymc.basicmoviereviewapi.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
public class CreateReviewRequest {
    private String body;
    private int rating;
    private String reviewerId;
    private String movieId;
}
