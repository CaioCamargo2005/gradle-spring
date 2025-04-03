package application.controller;

import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import application.model.Genero;
import application.repository.GeneroRepository;



@Controller
public class IndexController {
    @Autowired
    private GeneroRepository database;

    @RequestMapping(value = "/")
    public String home() {
        return "list";
    }

    @RequestMapping(value = {"/list", ""})
    public String select(Model ui){
        ui.addAttribute("registros", database.findAll());
        return "list";
    }

    @RequestMapping("/insert")
    public String insert(){
        return "formInsert";
    }

    @RequestMapping(value = "/insert", method = RequestMethod.POST)
    public String insert(@RequestParam("descricao") String descricao) {
        Genero data = new Genero();
        data.setNome(descricao);

        database.save(data);

        return "redirect:/list";
    }

    @RequestMapping("/update")
    public String update(@RequestParam("id") long id, Model ui){
        Optional<Genero> resultado = database.findById(id);
        
        if(resultado.isPresent()) {
            ui.addAttribute("registros", resultado.get());
            return "formUpdate";
        }
        
        return "redirect:/list";
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String update(
    @RequestParam("id") long id,
    @RequestParam("nome") String descricao){
        Optional<Genero> resultado = database.findById(id);

        if(resultado.isPresent()) {
            resultado.get().setNome(descricao);

            database.save(resultado.get());
        }
        
        return "redirect:/list";
    }

    @RequestMapping(value = "/delete")
    public String delete(@RequestParam("id") long id, Model ui){
    Optional<Genero> resultado = database.findById(id);

    if(resultado.isPresent()) {
        ui.addAttribute("registros", resultado.get());
        return "formDelete";
    }
    
    return "redirect:/list";
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public String delete(@RequestParam("id") long id){
        database.deleteById(id);
        return "redirect:/list";
    }
}