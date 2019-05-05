/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.controller.produto;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Raul Portela
 */
@Controller
@RequestMapping("/mv/produto")
public class Produto {

    @GetMapping("/categoria")
    public ModelAndView carrinho() {
        ModelAndView mv = new ModelAndView("/produto/categoria");
        return mv;
    }
    
    @GetMapping("/especificacao")
    public ModelAndView confirmacao() {
        ModelAndView mv = new ModelAndView("/produto/especificacao");
        return mv;
    }
    
    @GetMapping("/pagemoto")
    public ModelAndView paginamoto() {
        ModelAndView mv = new ModelAndView("/produto/pageModeloMoto");
        return mv;
    }
}
