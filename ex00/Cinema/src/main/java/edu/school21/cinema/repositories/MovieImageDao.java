package edu.school21.cinema.repositories;

import edu.school21.cinema.models.MovieImage;
import org.springframework.stereotype.Repository;

@Repository
public class MovieImageDao extends AbstractDao<MovieImage> {

    public MovieImageDao() {
        super(MovieImage.class);
    }
}
