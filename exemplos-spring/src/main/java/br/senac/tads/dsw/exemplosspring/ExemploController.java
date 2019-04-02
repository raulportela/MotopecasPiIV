/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import java.time.LocalDateTime;
import java.util.Arrays;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author fernando.tsuda
 */
@Controller
public class ExemploController {

    @GetMapping
    public String ex1() {
        return "view-ex1";
    }

    @GetMapping("/ex2")
    public String ex2(Model model) {
        model.addAttribute("titulo", "Título gerado no Controller");
        model.addAttribute("dataHora", LocalDateTime.now());
        model.addAttribute("lista",
                Arrays.asList("Item 1", "Item 2", "Item 3"));
        return "view-ex2";
    }

}
