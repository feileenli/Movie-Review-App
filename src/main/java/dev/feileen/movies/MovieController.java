package dev.feileen.movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/movies")

//api layer. only concerned with getting request from user and returning a response 

public class MovieController {

    @Autowired
    private MovieService movieService; 

    @GetMapping
        //invoke this method when that url is requested 
    public ResponseEntity<List<Movie>> getAllMovies() {
        //httpstatus.ok means 200 
        // return new ResponseEntity<String>("All Movies!", HttpStatus.OK);
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    //@pathvariable means that we are using information passed in the path var 
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.singleMovie(imdbId), HttpStatus.OK);
    }

}