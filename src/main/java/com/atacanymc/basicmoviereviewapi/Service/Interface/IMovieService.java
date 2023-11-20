package com.atacanymc.basicmoviereviewapi.Service.Interface;

import com.atacanymc.basicmoviereviewapi.DTO.MovieDto;
import com.atacanymc.basicmoviereviewapi.DTO.Request.CreateMovieRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.UpdateMovieRequest;
import com.atacanymc.basicmoviereviewapi.Model.Movie;

import java.util.List;

public interface IMovieService {
    public List<MovieDto> getAllMovies();
    public MovieDto getMovieById(String id);
    public MovieDto getMovieByImdbId(String imdbId);
    public MovieDto createMovie(CreateMovieRequest request);
    public MovieDto updateMovie(String id, UpdateMovieRequest request);
    public MovieDto deleteMovieById(String id);
}
