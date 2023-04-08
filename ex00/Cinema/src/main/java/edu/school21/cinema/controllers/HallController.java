package edu.school21.cinema.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
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
        model.addAttribute("hall", new Hall());
        return "halls";
    }

    @PostMapping("/add")
    public String fuck(@ModelAttribute Hall hall, BindingResult bindingResult) {
        if (!bindingResult.hasErrors()) {
            hallRepository.
        }
    }


}
