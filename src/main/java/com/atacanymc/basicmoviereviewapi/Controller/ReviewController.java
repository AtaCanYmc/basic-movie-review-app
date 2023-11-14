package com.atacanymc.basicmoviereviewapi.Controller;

import com.atacanymc.basicmoviereviewapi.DTO.Request.CreateReviewRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.UpdateReviewRequest;
import com.atacanymc.basicmoviereviewapi.DTO.ReviewDto;
import org.springframework.web.bind.annotation.*;
import com.atacanymc.basicmoviereviewapi.Service.ReviewService;
import com.atacanymc.basicmoviereviewapi.Model.Review;
import org.springframework.http.ResponseEntity;

import java.util.List;

@RestController
@RequestMapping("/movie-api/review")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @GetMapping
    public ResponseEntity<List<ReviewDto>> getAllReviews() {
        return ResponseEntity.ok(reviewService.getAllReviews());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ReviewDto> getReview(@PathVariable String id) {
        return ResponseEntity.ok(reviewService.getReview(id));
    }

    @PostMapping
    public ResponseEntity<ReviewDto> createReview(@RequestBody CreateReviewRequest request) {
        return ResponseEntity.ok(reviewService.createReview(request));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ReviewDto> updateReview(@PathVariable String id, @RequestBody UpdateReviewRequest request) {
        return ResponseEntity.ok(reviewService.updateReview(id, request));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ReviewDto> deleteReview(@PathVariable String id) {
        return ResponseEntity.ok(reviewService.deleteReview(id));
    }
}
