package br.ifsc.slo.tecinfo.pi.projetointegrador.controller;


import br.ifsc.slo.tecinfo.pi.projetointegrador.model.Item;
import br.ifsc.slo.tecinfo.pi.projetointegrador.repositorio.ItemRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/itens/")
public class ItemController {

    private ItemRepositorio repositorio;
    @Autowired
    private ItemController(ItemRepositorio repositorio){ this.repositorio = repositorio; }

    @GetMapping("cadastrar")
    public String showSignUpdateForm(Item item, Model model){

        model.addAttribute("itens", repositorio.findAll());
        return "add-prato";
    }

    @GetMapping("mostrar")
    public String showSignUpdateForm(Model model){
    model.addAttribute("itens", repositorio.findAll());
    return "index";
    }

    @PostMapping("add")
    public String addItem(@Valid Item item, BindingResult result, Model model) {
        repositorio.save(item);
        return "redirect:mostrar";
    }

    @GetMapping("update/{codItem}")
    public String updateItem(@PathVariable("codItem") int codItem, @Valid Item item, Model model){
        repositorio.save(item);
        return "redirect:/itens/mostrar";
    }

    @GetMapping("apagar/{codItem}")
    public String deleteItem(@PathVariable("codItem") int codItem, Model model) {
        Item item = repositorio.findById(codItem)
                .orElseThrow(() -> new IllegalArgumentException("Código inválido: " + codItem));
        repositorio.delete(item);
        return "redirect:/itens/mostrar";
    }

}
