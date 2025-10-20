package com.animalia.Animalia.controllers;
import com.animalia.Animalia.services.AnimalService;
import com.animalia.Animalia.models.Animal;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/animales")
public class MainController {
    @Autowired
    private AnimalService AS;

    @GetMapping()
    public String listadoAnimales(Model model) {
        model.addAttribute("animales", AS.listarAnimales());
        return "index";
    }

    @GetMapping("/crear")
    public String crearAnimal(Model model) {
        model.addAttribute("animal", new Animal());
        return "crear";
    }

    @PostMapping("/crear")
    public String crearAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "crear";
        } else {
            AS.crearAnimal(animal);
            return "redirect:/animales";
        }
    }

    @GetMapping("/detalles/{id}")
    public String mostrarAnimal(@PathVariable Integer id, Model model){
        model.addAttribute("animal", AS.getAnimalById(id));
        return "detalles";
    }

    @GetMapping("/editar/{id}")
    public String modificarAnimal(@PathVariable Integer id, Model model){
        model.addAttribute("animal", AS.getAnimalById(id));
        return "editar";
    }

    @PostMapping("/editar")
    public String modificarAnimal(@Valid @ModelAttribute("animal") Animal animal, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editar";
        } else {
            AS.actualizarAnimal(animal);
            return "redirect:/animales";
        }
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarAnimal(@PathVariable Integer id, Model model) {
        model.addAttribute("animal", AS.getAnimalById(id));
        return "eliminar";
    }

    @PostMapping("/eliminar/{id}")
    public String eliminarAnimal(@PathVariable Integer id) {
        AS.eliminarAnimal(AS.getAnimalById(id));
        return "redirect:/animales";
    }
}