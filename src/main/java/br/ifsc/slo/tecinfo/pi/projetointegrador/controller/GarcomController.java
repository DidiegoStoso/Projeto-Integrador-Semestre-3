package br.ifsc.slo.tecinfo.pi.projetointegrador.controller;

import br.ifsc.slo.tecinfo.pi.projetointegrador.model.Garcom;
import br.ifsc.slo.tecinfo.pi.projetointegrador.repositorio.GarcomRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/garcom")
public class GarcomController {

    private GarcomRepositorio repositorio;
    @Autowired
    private GarcomController(GarcomRepositorio repositorio){ this.repositorio = repositorio; }

    @GetMapping("/cadastrar")
    public String showRegistrationForm(Model model, Garcom garcom){
        model.addAttribute(garcom);
        return "registration";
    }

    @PostMapping("/cadastrar")
    public String registerUserAccount(@Valid Garcom garcom, BindingResult result){
        repositorio.save(garcom);
        return "redirect:/itens/mostrar";
    }

}
