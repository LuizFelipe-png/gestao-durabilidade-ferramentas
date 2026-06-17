package com.ferramental.monitoramento.controller;

import com.ferramental.monitoramento.model.FerramentaDTO;
import com.ferramental.monitoramento.service.FerramentaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author Usuario
 */
@Controller
public class FerramentaController {
    
    @Autowired
    private FerramentaService service;
    
    @GetMapping("/")
    public String index() {
        return "redirect:/ferramentas";
    }
    
    @GetMapping("/ferramentas")
    public String listarFerramentas(Model model) {
        List<FerramentaDTO> lista = service.listarFerramentas();
        model.addAttribute("ferramentas", lista);
        
        return "ferramentas";
    }
    
    @PostMapping("/ferramentas/salvar")
    public String salvarFerramenta(@ModelAttribute FerramentaDTO ferramenta) {
        service.criar(ferramenta);
        
        return "redirect:/ferramentas";
    }
}