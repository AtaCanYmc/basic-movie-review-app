package com.atacanymc.basicmoviereviewapi.Service;

import com.atacanymc.basicmoviereviewapi.DTO.Request.CreateReviewRequest;
import com.atacanymc.basicmoviereviewapi.DTO.Request.UpdateReviewRequest;
import com.atacanymc.basicmoviereviewapi.DTO.ReviewDto;
import com.atacanymc.basicmoviereviewapi.Model.Review;

import java.util.List;

public interface IReviewService {
    public ReviewDto getReview(String id);
    public List<ReviewDto> getAllReviews();
    public ReviewDto createReview(CreateReviewRequest request);
    public ReviewDto updateReview(String id, UpdateReviewRequest request);
    public ReviewDto deleteReview(String id);
}
