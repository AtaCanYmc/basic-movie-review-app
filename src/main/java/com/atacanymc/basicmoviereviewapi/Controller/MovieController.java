package com.atacanymc.basicmoviereviewapi.Controller;

import com.atacanymc.basicmoviereviewapi.DTO.MovieDto;
import com.atacanymc.basicmoviereviewapi.DTO.Request.CreateMovieRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.UpdateMovieRequest;
import com.atacanymc.basicmoviereviewapi.Model.Movie;
import com.atacanymc.basicmoviereviewapi.Service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/movie-api/movie")
public class MovieController {
    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public ResponseEntity<List<MovieDto>> getAllMovies() {
        return ResponseEntity.ok(movieService.getAllMovies());
    }

    @GetMapping("/{id}")
    public ResponseEntity<MovieDto> getMovieById(@PathVariable String id) {
        return ResponseEntity.ok(movieService.getMovieById(id));
    }

    @GetMapping("/imdb/{imdbId}")
    public ResponseEntity<MovieDto> getMovieByImdbId(@PathVariable String imdbId) {
        return ResponseEntity.ok(movieService.getMovieByImdbId(imdbId));
    }

    @PostMapping
    public ResponseEntity<MovieDto> createMovie(@RequestBody CreateMovieRequest request) {
        return ResponseEntity.ok(movieService.createMovie(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MovieDto> updateMovie(@PathVariable String id, @RequestBody UpdateMovieRequest request) {
        return ResponseEntity.ok(movieService.updateMovie(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<MovieDto> deleteMovieById(@PathVariable String id) {
        return ResponseEntity.ok(movieService.deleteMovieById(id));
    }
}
