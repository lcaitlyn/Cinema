package edu.school21.cinema.repositories;

import edu.school21.cinema.models.Movie;
import org.springframework.stereotype.Repository;

@Repository
public class MovieDao extends AbstractDao<Movie> {

    public MovieDao() {
        super(Movie.class);
    }
}
