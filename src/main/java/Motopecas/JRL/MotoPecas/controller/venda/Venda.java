package Motopecas.JRL.MotoPecas.controller.venda;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Raul Portela
 */
@Controller
@RequestMapping("/mv/venda")
public class Venda {

    @GetMapping("/carrinho")
    public ModelAndView carrinho() {
        ModelAndView mv = new ModelAndView("/venda/carrinho");
        return mv;
    }
    
    @GetMapping("/confirmacao")
    public ModelAndView confirmacao() {
        ModelAndView mv = new ModelAndView("/venda/confirmacao");
        return mv;
    }
    
    @GetMapping("/pagamento")
    public ModelAndView pagamento() {
        ModelAndView mv = new ModelAndView("/venda/pagamento");
        return mv;
    }
}
