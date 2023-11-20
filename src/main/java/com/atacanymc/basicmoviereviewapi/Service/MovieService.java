package com.atacanymc.basicmoviereviewapi.Service;

import com.atacanymc.basicmoviereviewapi.DTO.Converter.MovieDtoConverter;
import com.atacanymc.basicmoviereviewapi.DTO.MovieDto;
import com.atacanymc.basicmoviereviewapi.DTO.Request.CreateMovieRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.UpdateMovieRequest;
import com.atacanymc.basicmoviereviewapi.Exception.InvalidDateException;
import com.atacanymc.basicmoviereviewapi.Exception.MovieNotFoundException;
import com.atacanymc.basicmoviereviewapi.Model.Movie;
import com.atacanymc.basicmoviereviewapi.Model.Review;
import com.atacanymc.basicmoviereviewapi.Repository.MovieRepository;
import com.atacanymc.basicmoviereviewapi.Service.Interface.IMovieService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class MovieService implements IMovieService {

    private final MovieRepository movieRepository;
    private final MovieDtoConverter movieDtoConverter;

    public MovieService(MovieRepository movieRepository, MovieDtoConverter movieDtoConverter) {
        this.movieRepository = movieRepository;
        this.movieDtoConverter = movieDtoConverter;
    }

    protected Movie findMovieById(String id) {
        return movieRepository.findById(id)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with id: " + id));
    }

    protected void addReviewToMovie(String movieId, Review review) {
        Movie movie = findMovieById(movieId);
        movie.addReview(review);
        movieRepository.save(movie);
    }

    protected void removeReviewFromMovie(String movieId, Review review) {
        Movie movie = findMovieById(movieId);
        movie.removeReview(review);
        movieRepository.save(movie);
    }

    protected LocalDate parseDate(String date) {
        LocalDate localDate = null;
        try {
            localDate = LocalDate.parse(date);
            return localDate;
        } catch (Exception e) {
            throw new InvalidDateException("Invalid date format: " + date);
        }
    }

    @Override
    public List<MovieDto> getAllMovies() {
        return movieRepository.findAll()
                .stream()
                .map(movieDtoConverter::convert)
                .toList();
    }

    @Override
    public MovieDto getMovieById(String id) {
        return movieDtoConverter.convert(findMovieById(id));
    }

    @Override
    public MovieDto getMovieByImdbId(String imdbId) {
        return movieDtoConverter.convert(movieRepository.findByImdbId(imdbId)
                .orElseThrow(() -> new MovieNotFoundException("Movie not found with imdbId: " + imdbId)));
    }

    @Override
    public MovieDto createMovie(CreateMovieRequest request) {
        Movie movie = new Movie(
                request.getImdbId(),
                request.getTitle(),
                parseDate(request.getReleaseDate()),
                request.getTrailerLink(),
                request.getPoster(),
                request.getBackdrops(),
                request.getGenres()
        );
        return movieDtoConverter.convert(movieRepository.save(movie));
    }

    @Override
    public MovieDto updateMovie(String id, UpdateMovieRequest request) {
        Movie movie = findMovieById(id);
        movie.setImdbId(request.getImdbId());
        movie.setTitle(request.getTitle());
        movie.setReleaseDate(parseDate(request.getReleaseDate()));
        movie.setTrailerLink(request.getTrailerLink());
        movie.setPoster(request.getPoster());
        movie.setBackdrops(request.getBackdrops());
        movie.setGenres(request.getGenres());
        return movieDtoConverter.convert(movieRepository.save(movie));
    }

    @Override
    public MovieDto deleteMovieById(String id) {
        Movie movie = findMovieById(id);
        movieRepository.delete(movie);
        return movieDtoConverter.convert(movie);
    }
}
