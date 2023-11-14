package com.atacanymc.basicmoviereviewapi.Repository;

import com.atacanymc.basicmoviereviewapi.Model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    Optional<Movie> findByImdbId(String imdbId);
}
