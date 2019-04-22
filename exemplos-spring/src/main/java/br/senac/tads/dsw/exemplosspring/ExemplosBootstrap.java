package br.senac.tads.dsw.exemplosspring;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fernando.tsuda
 */
@Controller
@RequestMapping("/exemplos-bootstrap")
public class ExemplosBootstrap {

    @GetMapping("/carousel")
    public String exemploCarousel() {
        return "carousel";
    }
    
}
