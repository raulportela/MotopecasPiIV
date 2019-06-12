/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.controller.endereco;

import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import Motopecas.JRL.MotoPecas.entidade.cartao.Cartao;
import Motopecas.JRL.MotoPecas.entidade.endereco.Endereco;
import Motopecas.JRL.MotoPecas.repository.cartao.CartaoRepository;
import Motopecas.JRL.MotoPecas.repository.cliente.ClienteRepository;
import Motopecas.JRL.MotoPecas.repository.endereco.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
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
@RequestMapping("/mv/endereco")
public class EnderecoController {

    @Autowired
    private EnderecoRepository enderecoRepository;

    @PostMapping("/salvar")
    public ModelAndView salvar(
            @ModelAttribute("endereco") Endereco endereco,
            /*BindingResult bindingResult,*/ RedirectAttributes redirectAttributes,Authentication authentication) {
        Cliente cliente = (Cliente) authentication.getPrincipal();
        enderecoRepository.desativarSelecionado();
        endereco.setSelecionado(1);
        endereco.setCliente(cliente);
        enderecoRepository.save(endereco);
        redirectAttributes.addFlashAttribute("mensagemSucesso",
                " Endereco salvo com sucesso");
        return new ModelAndView("redirect:/mv/venda/confirmacao");
    }
}
