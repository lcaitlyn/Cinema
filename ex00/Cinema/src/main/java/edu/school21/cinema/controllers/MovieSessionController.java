package edu.school21.cinema.controllers;

import edu.school21.cinema.models.MovieSession;
import edu.school21.cinema.repositories.HallDao;
import edu.school21.cinema.repositories.MovieSessionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/panel/sessions")
public class MovieSessionController {

    @Autowired
    MovieSessionDao sessionDao;

    @Autowired
    HallDao hallDao;


    @GetMapping
    public String sessions(Model model) {
        model.addAttribute("movieSessions", sessionDao.findAll());
        return "movie-session";
    }

    @GetMapping("/add")
    public String getAdd(Model model) {
        model.addAttribute("movieSession", new MovieSession());
        System.out.println(hallDao.findAll());
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
