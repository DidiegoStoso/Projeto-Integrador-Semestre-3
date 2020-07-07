package br.ifsc.slo.tecinfo.pi.projetointegrador.controller;

import br.ifsc.slo.tecinfo.pi.projetointegrador.model.Pedido;
import br.ifsc.slo.tecinfo.pi.projetointegrador.repositorio.PedidoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/pedido/")
public class PedidoController {

    private PedidoRepositorio repositorio;
    @Autowired
    private PedidoController(PedidoRepositorio repositorio){
        this.repositorio = repositorio;
    }

    @GetMapping("confirmar")
    public String showSignUpdateForm(Pedido pedido, Model model){
        model.addAttribute("pedidos", repositorio.findAll());
        return "pedido";
    }

    @PostMapping("add")
    public String addPedido(@PathVariable("codPedido") int codPedido, @Valid Pedido pedido, Model model){
       repositorio.save(pedido);
       return "index";
    }
}
