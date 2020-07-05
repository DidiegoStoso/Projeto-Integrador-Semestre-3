package br.ifsc.slo.tecinfo.pi.projetointegrador.controller;

import br.ifsc.slo.tecinfo.pi.projetointegrador.model.Garcom;
import br.ifsc.slo.tecinfo.pi.projetointegrador.model.Role;
import br.ifsc.slo.tecinfo.pi.projetointegrador.repositorio.GarcomRepositorio;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Controller
@RequestMapping("/garcom")
public class GarcomController {

    private final GarcomRepositorio repositorio;
    @Autowired
    private GarcomController(GarcomRepositorio repositorio){ this.repositorio = repositorio; }

    @GetMapping("/cadastrar")
    public String showRegistrationForm(Model model, Garcom garcom){
        model.addAttribute(garcom);
        return "registration";
    }

    @PostMapping("/cadastrar")
    public String registerUserAccount(@Valid Garcom waiter, BindingResult result){
        Garcom garcom = new Garcom();
        garcom.setCpf(waiter.getCpf());
        garcom.setNome(waiter.getNome());
        garcom.setEmail(waiter.getEmail());
        garcom.setLogin(waiter.getLogin());
        garcom.setSenha(new BCryptPasswordEncoder().encode(waiter.getSenha()));
        List<Role> roles = new ArrayList<>();
        roles.add(new Role("ROLE_GARCOM"));
        garcom.setRoles(roles);
        
        
        repositorio.save(garcom); 
        System.out.println("aaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
        return "redirect:/itens/mostrar";
    }

}
