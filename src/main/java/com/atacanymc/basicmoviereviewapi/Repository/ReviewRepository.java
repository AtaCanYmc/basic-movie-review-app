package com.atacanymc.basicmoviereviewapi.Repository;

import com.atacanymc.basicmoviereviewapi.Model.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReviewRepository extends MongoRepository<Review, String> {

}
