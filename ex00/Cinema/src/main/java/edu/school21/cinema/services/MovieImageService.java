package edu.school21.cinema.services;

import edu.school21.cinema.repositories.MovieImageDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieImageService {

    @Autowired
    MovieImageDao imageDao;


}
