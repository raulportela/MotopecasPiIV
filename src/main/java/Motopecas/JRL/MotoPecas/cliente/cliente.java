/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.cliente;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Raul Portela
 */
@Controller
@RequestMapping("/mv/cliente")
public class cliente{

    @GetMapping("/contato")
    public ModelAndView contato() {
        ModelAndView mv = new ModelAndView("/cliente/contato");
        return mv;
    }
    
    @GetMapping("/cadastro")
    public ModelAndView cadastro() {
        ModelAndView mv = new ModelAndView("/cliente/cadastro");
        return mv;
    }
}
