package dev.feileen.movies;

import java.util.List;
import java.util.Map;
// import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/reviews")
@CrossOrigin(origins = "http://localhost:3000") // Allow requests from your frontend


public class ReviewController {

    @Autowired
    private ReviewService reviewService; 

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>
        (reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId")),
        HttpStatus.CREATED);
    }

    @GetMapping
        //invoke this method when that url is requested 
    public ResponseEntity<List<Review>> getAllReviews() {
        //httpstatus.ok means 200 
        // return new ResponseEntity<String>("All Movies!", HttpStatus.OK);
        return new ResponseEntity<List<Review>>(reviewService.allReviews(), HttpStatus.OK);
    }

    // @GetMapping("/{imdbId}")
    // //@pathvariable means that we are using information passed in the path var 
    // public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
    //     return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    // }
    
    
}
