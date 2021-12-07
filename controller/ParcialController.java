package com.examplespring.pruebamvc.controller;

import com.examplespring.pruebamvc.dto.Parcial;
import com.examplespring.pruebamvc.service.ParcialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

import java.io.IOException;

@ApiIgnore
@Controller
public class ParcialController {
    private final ParcialService parcialService;

    @Autowired
    public ParcialController(ParcialService parcialService) {
        this.parcialService = parcialService;
    }
    @GetMapping("/parcial")
    public String Formulario(Model model) {
        model.addAttribute("parcial", new Parcial());
        return "parcial";
    }
    @RequestMapping("/parcial")
    public String Formulario(@ModelAttribute Parcial parcial, Model model) throws IOException {
        model.addAttribute("parcial", parcial);
        parcialService.setDNI(parcial.getDni());
        return "redirect:datosInfraccion";
    }
    @GetMapping("/datosInfraccion")
    public String obtenerDatos(Model model) throws IOException {
        model.addAttribute("datosInfraccions", parcialService.findAllDatos());
        return "datosInfraccion";
    }
}
