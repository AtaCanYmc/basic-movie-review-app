package com.atacanymc.basicmoviereviewapi.Service;

import com.atacanymc.basicmoviereviewapi.DTO.Converter.ReviewDtoConverter;
import com.atacanymc.basicmoviereviewapi.DTO.Request.CreateReviewRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.UpdateReviewRequest;
import com.atacanymc.basicmoviereviewapi.DTO.ReviewDto;
import com.atacanymc.basicmoviereviewapi.Exception.ReviewNotFoundException;
import com.atacanymc.basicmoviereviewapi.Model.Review;
import com.atacanymc.basicmoviereviewapi.Repository.ReviewRepository;
import com.atacanymc.basicmoviereviewapi.Service.Interface.IReviewService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReviewService implements IReviewService {

    final private ReviewRepository reviewRepository;
    final private ReviewDtoConverter reviewDtoConverter;
    final private UserService userService;
    final private MovieService movieService;

    public ReviewService(ReviewRepository reviewRepository, ReviewDtoConverter reviewDtoConverter,
                         UserService userService, MovieService movieService) {
        this.reviewRepository = reviewRepository;
        this.reviewDtoConverter = reviewDtoConverter;
        this.userService = userService;
        this.movieService = movieService;
    }

    protected Review findReviewById(String id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new ReviewNotFoundException("Review not found with id: " + id));
    }

    @Override
    public ReviewDto getReview(String id) {
        return reviewDtoConverter.convert(findReviewById(id));
    }

    @Override
    public List<ReviewDto> getAllReviews() {
        return reviewRepository.findAll()
                .stream()
                .map(reviewDtoConverter::convert)
                .toList();
    }

    @Override
    public ReviewDto createReview(CreateReviewRequest request) {
        Review review = reviewRepository.save(new Review(
                request.getBody(),
                request.getRating(),
                userService.findUserById(request.getReviewerId()),
                movieService.findMovieById(request.getMovieId())
        ));
        movieService.addReviewToMovie(request.getMovieId(), review);
        userService.addReviewToUser(request.getReviewerId(), review);
        return reviewDtoConverter.convert(review);
    }

    @Override
    public ReviewDto updateReview(String id, UpdateReviewRequest request) {
        Review review = findReviewById(id);
        review.setBody(request.getBody());
        review.setRating(request.getRating());
        return reviewDtoConverter.convert(reviewRepository.save(review));
    }

    @Override
    public ReviewDto deleteReview(String id) {
        Review review = findReviewById(id);
        userService.removeReviewFromUser(review.getReviewer().getId(), review);
        movieService.removeReviewFromMovie(review.getMovie().getId(), review);
        reviewRepository.delete(review);
        return reviewDtoConverter.convert(review);
    }
}
