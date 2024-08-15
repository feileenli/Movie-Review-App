package dev.feileen.movies;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

@Service
public class ReviewService {

    @Autowired
    private ReviewRepository reviewRepository; 

    @Autowired
    private MongoTemplate mongoTemplate;

    public Review createReview(String reviewBody, String imdbId) {
        Review review = reviewRepository.insert(new Review(reviewBody));
        //what class are you updating? Movie class. Which movie? Whichever one 
        //where the imdbId matches the imdbId passed in. Now apply a new update
        //where we push a review in the array of reviewIds. 
        mongoTemplate.update(Movie.class) 
            .matching(Criteria.where("imdbId").is(imdbId))
            .apply(new Update().push("reviewIDs").value(review))
            .first();
            //.first makes sure you're getting a single movie and updating that movie 
        return review;
    }

    public List<Review> allReviews() {
        return reviewRepository.findAll();
    }
        
    

}
