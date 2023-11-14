package com.atacanymc.basicmoviereviewapi.Model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDateTime;

@Document(collection = "reviews")
@Data
@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Review extends BaseEntity{
    private @Id String id;
    private String body;
    private int rating;
    @DocumentReference(collection = "users", lazy = true)
    private User reviewer;
    @DocumentReference(collection = "movies", lazy = true)
    private Movie movie;

    public Review(String body, int rating, User reviewer, Movie movie) {
        this.body = body;
        this.rating = rating;
        this.reviewer = reviewer;
        this.movie = movie;
        this.setCreatedDate(LocalDateTime.now());
        this.setUpdatedDate(LocalDateTime.now());
    }
}
