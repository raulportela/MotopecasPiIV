package Motopecas.JRL.MotoPecas.home;

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
public class Home {

    @GetMapping("/home")
    public ModelAndView home() {
        ModelAndView mv = new ModelAndView("/home/home");
        return mv;
    }
}
