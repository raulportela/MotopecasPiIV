/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.tads.dsw.exemplosspringjpa.controller;

import br.senac.tads.dsw.exemplosspringjpa.entidade.Produto;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author fernando.tsuda
 */
@Controller
public class ProdutoController {
    
    public ModelAndView listar() {
        return new ModelAndView("produto/lista");
    }
    
    public ModelAndView adicionarNovo() {
        return new ModelAndView("produto/formulario").addObject(new Produto());
    }
    
    public ModelAndView editar(Long id) {
        return new ModelAndView("produto/formulario").addObject(new Produto());
    }
    
    public ModelAndView salvar(Produto produto, BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        return new ModelAndView("redirect:/produto/lista");
    }
    
    public ModelAndView remover(Long id) {
        return new ModelAndView("redirect:/produto/lista");
    }
    
}
