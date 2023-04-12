package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.models.MovieSession;
import edu.school21.cinema.repositories.HallDao;
import edu.school21.cinema.repositories.MovieDao;
import edu.school21.cinema.repositories.MovieSessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.beans.PropertyEditor;

@Controller
@RequestMapping("/admin/panel/sessions")
public class MovieSessionController {

    @Autowired
    MovieSessionDao sessionDao;

    @Autowired
    HallDao hallDao;

    @Autowired
    MovieDao movieDao;

    @GetMapping
    public String sessions(Model model) {
        model.addAttribute("movieSessions", sessionDao.findAll());
        return "movie-session";
    }

    @GetMapping("/add")
    public String getAdd(Model model) {
        model.addAttribute("movieSession", new MovieSession());
        model.addAttribute("movies", movieDao.findAll());
        model.addAttribute("halls", hallDao.findAll());
        return "add-movie-session";
    }

    @PostMapping("/add")
    public String postAdd(@ModelAttribute @Valid MovieSession session, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "add-movie-session";
        }
        sessionDao.save(session);
        return "redirect:/admin/panel/sessions";
    }
}
