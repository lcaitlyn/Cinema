package edu.school21.cinema.controllers;

import edu.school21.cinema.models.Hall;
import edu.school21.cinema.repositories.HallRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/admin/panel/halls")
public class HallController {

    @Autowired
    HallRepository hallRepository;

    @GetMapping
    public String halls(Model model) {
        List<Hall> halls = hallRepository.findAll();
        model.addAttribute("halls", halls);
        return "halls";
    }

    @GetMapping("/add")
    public String fuck() {
        return "fuck";
    }


}
