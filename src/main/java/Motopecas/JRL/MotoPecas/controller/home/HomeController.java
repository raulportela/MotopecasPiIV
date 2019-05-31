package Motopecas.JRL.MotoPecas.controller.home;

import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import Motopecas.JRL.MotoPecas.repository.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
@RequestMapping("/mv")
public class HomeController {

    @GetMapping("/home")
    public ModelAndView home(Authentication authentication) {
        Cliente cliente = null;
        if (authentication != null) {
            cliente = (Cliente) authentication.getPrincipal();
        }
        
      return  new ModelAndView("/home/home").addObject("clienteSessao", cliente);
        
    }
}
