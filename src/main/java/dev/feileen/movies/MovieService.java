package dev.feileen.movies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//service layer. most of business logic will occur here. uses repository class, 
//talks to repository and gets all the movies which will be returned to the api layer. 


@Service
public class MovieService {

    //instantiate this here for us 
    @Autowired
    private MovieRepository movieRepository;
    
    public List<Movie> allMovies() {
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String imdbId) {
        return movieRepository.findMovieByImdbId(imdbId);
    }
    
}
