package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Movie;
import edu.school21.cinema.repositories.MovieDao;
import edu.school21.cinema.repositories.MovieImageDao;
import edu.school21.cinema.utils.LocalDateConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/panel/films")
public class MovieController {

    @Autowired
    MovieDao movieDao;

    @Autowired
    MovieImageDao movieImageDao;

    @GetMapping
    public String films(Model model) {
        model.addAttribute("movies", movieDao.findAll());
        return "movie";
    }

    @GetMapping("/add")
    public String getAdd(Model model) {
        model.addAttribute("movie", new Movie());
        return "add-movie";
    }

    @PostMapping("/add")
    public String postAdd(@ModelAttribute @Valid Movie movie,
                          BindingResult bindingResult,
                          @RequestParam("movieImage") MultipartFile movieImage) {
        if (bindingResult.hasErrors() && !movieImage.isEmpty()) {
            return "add-movie";
        }
        movieDao.save(movie);
        return "redirect:/admin/panel/films";
    }

}
