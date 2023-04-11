package edu.school21.cinema.repositories;

import edu.school21.cinema.models.MovieSession;
import org.springframework.stereotype.Repository;

@Repository
public class MovieSessionDao extends AbstractDao<MovieSession> {

    public MovieSessionDao() {
        super(MovieSession.class);
    }
}
