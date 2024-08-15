package dev.feileen.movies;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

//repository layer. data access layer for api. talks to database and gets data back. 

@Repository

public interface MovieRepository extends MongoRepository<Movie, ObjectId> {
    Optional<Movie> findMovieByImdbId(String imdbId); 

    @Query("{'genres': ?0}")
    List<Movie> findMoviesByGenre(String genre);

    @Query("{'title': ?0}")
    List<Movie> searchMovieTitle(String title);
}
