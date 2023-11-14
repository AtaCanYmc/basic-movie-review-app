package com.atacanymc.basicmoviereviewapi.Model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.DocumentReference;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


@Document(collection = "movies")
@Data
@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Movie extends BaseEntity{
    private @Id String id;
    private String imdbId;
    private String title;
    private LocalDate releaseDate;
    private String trailerLink;
    private String poster;
    private List<String> backdrops;
    private List<String> genres;
    @DocumentReference
    private List<Review> reviews;

    public Movie(String imdbId, String title, LocalDate releaseDate, String trailerLink, String poster, List<String> backdrops, List<String> genres) {
        this.imdbId = imdbId;
        this.title = title;
        this.releaseDate = releaseDate;
        this.trailerLink = trailerLink;
        this.poster = poster;
        this.backdrops = backdrops;
        this.genres = genres;
        this.setCreatedDate(LocalDateTime.now());
        this.setUpdatedDate(LocalDateTime.now());
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }

    public void removeReview(Review review) {
        this.reviews.remove(review);
    }
}
