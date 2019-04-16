/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/exemplo-sessao1")
@SessionAttributes("contador1")
public class ExemploSessao1Controller {

    private int contador = 0;

    @GetMapping
    public ModelAndView contarAcesso(@ModelAttribute("contador1") int contador) {
        contador++;
        return new ModelAndView("contador-sessao1");
    }

    @ModelAttribute("contador1")
    public int getContador() {
        return 0;
    }

}
