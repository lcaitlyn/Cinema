package edu.school21.cinema.controllers;

import edu.school21.cinema.repositories.HallDao;
import edu.school21.cinema.models.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/admin/panel/halls")
public class HallController {

    private final HallDao hallDao;

    @Autowired
    public HallController(HallDao hallDao) {
        this.hallDao = hallDao;
    }

    @GetMapping
    public String halls(Model model) {
        List<Hall> halls = hallDao.findAll();
        model.addAttribute("halls", halls);
        model.addAttribute("hall", new Hall());
        return "hall";
    }

    @PostMapping("/add")
    public String fuck(@ModelAttribute @Valid Hall hall, BindingResult bindingResult) {

//        if (true) {
//            bindingResult.reject("id", "такой зал уже есть");
//            return "redirect:/admin/panel/halls";
//        }
//
//
//        if (bindingResult.hasErrors()) {
//            bindingResult.addError(new ObjectError("id", "такое уже есть"));
//            return "hall";
//        }


        if (!bindingResult.hasErrors()) {
            hallDao.save(hall);
        }
        return "redirect:/admin/panel/halls";
    }
}
