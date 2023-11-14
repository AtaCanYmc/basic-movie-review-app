package com.atacanymc.basicmoviereviewapi.DTO.Request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
public class UpdateReviewRequest {
    private String body;
    private int rating;
}
