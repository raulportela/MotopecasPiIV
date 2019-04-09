/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspring;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/formulario")
public class FormularioController {

    @GetMapping
    public ModelAndView abrirFormulario() {
        ModelAndView mv = new ModelAndView("formulario")
                .addObject("dados", new Dados());
        return mv;
    }

    @PostMapping
    public ModelAndView salvarFormulario(
            @ModelAttribute("dados") Dados dadosPreenchidos,
            RedirectAttributes ra) {
        ModelAndView mv = new ModelAndView("redirect:/formulario/resultado");
        ra.addFlashAttribute("dados", dadosPreenchidos);
        return mv;
    }
   
    @GetMapping("/resultado")
    public ModelAndView mostrarResultado() {
         ModelAndView mv = new ModelAndView("resultado-formulario");
         return mv;
    }

}
