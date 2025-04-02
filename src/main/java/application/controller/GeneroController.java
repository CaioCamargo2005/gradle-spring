package application.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.repository.GeneroRepository;
import application.service.GeneroService;

@Controller
@RequestMapping("/generos")
public class GeneroController {

    private final GeneroService generoService;

    @Autowired
    public GeneroController(GeneroService generoService) {
        this.generoService = generoService;
    }

    @GetMapping
    public String listarGeneros(Model model) {
        model.addAttribute("generos", generoService.findAll());
        return "genero/listar";
    }

    @GetMapping("/novo")
    public String mostrarFormularioNovo(Model model) {
        model.addAttribute("genero", new Genero());
        return "genero/formulario";
    }

    @PostMapping("/salvar")
    public String salvarGenero(@ModelAttribute("genero") Genero genero) {
        generoService.save(genero);
        return "redirect:/generos";
    }

    @GetMapping("/editar/{id}")
    public String mostrarFormularioEditar(@PathVariable("id") Long id, Model model) {
        generoService.findById(id).ifPresent(genero -> model.addAttribute("genero", genero));
        return "genero/formulario";
    }

    @PostMapping("/deletar/{id}")
    public String deletarGenero(@PathVariable("id") Long id) {
        generoService.delete(id);
        return "redirect:/generos";
    }
}