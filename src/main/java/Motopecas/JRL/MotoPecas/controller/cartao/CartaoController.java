/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.controller.cartao;

import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import Motopecas.JRL.MotoPecas.entidade.cartao.Cartao;
import Motopecas.JRL.MotoPecas.repository.cartao.CartaoRepository;
import Motopecas.JRL.MotoPecas.repository.cliente.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Raul Portela
 */
@Controller
@RequestMapping("/mv/cartao")
public class CartaoController{
    
    @Autowired
    private CartaoRepository cartaoRepository;
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    
    @PostMapping("/salvar")
    public ModelAndView salvar(
            @ModelAttribute("cartao") Cartao cartao, 
            /*BindingResult bindingResult,*/ RedirectAttributes redirectAttributes) {
        Cliente cliente = clienteRepository.findById(1l);
        cartao.setCliente(cliente);
        cartaoRepository.save(cartao);
        redirectAttributes.addFlashAttribute("mensagemSucesso", 
                "Cartao " + cartao.getBandeira()+ " salvo com sucesso");
        return new ModelAndView("redirect:/mv/venda/confirmacao");
    }
}
