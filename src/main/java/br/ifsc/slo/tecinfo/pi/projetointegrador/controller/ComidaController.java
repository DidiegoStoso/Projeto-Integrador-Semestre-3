package br.ifsc.slo.tecinfo.pi.projetointegrador.controller;


import br.ifsc.slo.tecinfo.pi.projetointegrador.model.Comida;
import br.ifsc.slo.tecinfo.pi.projetointegrador.repositorio.ComidaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/comidas/")
public class ComidaController {

    private ComidaRepositorio repositorio;
    @Autowired
    private ComidaController(ComidaRepositorio repositorio){ this.repositorio = repositorio; }

    @GetMapping("cadastrar")
    public String showSignUpdateForm(Comida food, Model model){

        model.addAttribute("comidas", repositorio.findAll());
        return "add-prato";
    }

    @GetMapping("mostrar")
    public String showSignUpdateForm(Model model){
    model.addAttribute("comidas", repositorio.findAll());
    return "Index";
    }

    @PostMapping("add")
    public String addFood(@Valid Comida comida, BindingResult result, Model model) {
        repositorio.save(comida);
        return "redirect:mostrar";
    }

    @GetMapping("update/{codComida}")
    public String updateFood(@PathVariable("codComida") int codComida, @Valid Comida comida, Model model){
        repositorio.save(comida);
        return "redirect:/comidas/mostrar";
    }

    @GetMapping("apagar/{codComida}")
    public String deleteFood(@PathVariable("codComida") int codComida, Model model) {
        Comida comida = repositorio.findById(codComida)
                .orElseThrow(() -> new IllegalArgumentException("Código inválido: " + codComida));
        repositorio.delete(comida);
        return "redirect:/comidas/mostrar";
    }

}
