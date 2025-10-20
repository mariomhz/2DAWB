package com.asirem.Asirem.controllers;

import com.asirem.Asirem.interfaces.IPerfumeService;
import com.asirem.Asirem.models.Perfume;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/perfumes")
public class PerfumeController {
    @Autowired
    private IPerfumeService perfumeService;

    @GetMapping()
    public String listPerfumes(Model model) {
        model.addAttribute("perfumes", perfumeService.getAllPerfumes());
        return "index";
    }

    @GetMapping("/add")
    public String addPerfume(Model model) {
        model.addAttribute("perfume", new Perfume());
        return "add";
    }

    @PostMapping("/add")
    public String addPerfume(@Valid @ModelAttribute("perfume") Perfume perfume, BindingResult br) {
        if (br.hasErrors()) {
            return "add";
        } else {
            perfumeService.addPerfume(perfume);
            return "redirect:/perfumes";
        }
    }

    @GetMapping("/details/{id}")
    public String showPerfume(@PathVariable Integer id, Model model) {
        model.addAttribute("perfume", perfumeService.getPerfumeById(id));
        return "details";
    }

    @GetMapping("/edit/{id}")
    public String updatePerfume(@PathVariable Integer id, Model model) {
        model.addAttribute("perfume", perfumeService.getPerfumeById(id));
        return "edit";
    }

    @PostMapping("/edit")
    public String updatePerfume(@Valid @ModelAttribute("perfume") Perfume perfume, BindingResult br) {
        if (br.hasErrors()) {
            return "edit";
        } else {
            perfumeService.updatePerfume(perfume);
            return "redirect:/perfumes";
        }
    }

    @GetMapping("/delete/{id}")
    public String deletePerfume(@PathVariable Integer id, Model model) {
        model.addAttribute("perfume", perfumeService.getPerfumeById(id));
        return "delete";
    }

    @PostMapping("/delete/{id}")
    public String deletePerfume(@PathVariable Integer id) {
        perfumeService.deletePerfume(perfumeService.getPerfumeById(id).getId());
        return "redirect:/perfumes";
    }
}
