/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.controller.cliente;

import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import Motopecas.JRL.MotoPecas.controller.produto.ProdutoController;
import Motopecas.JRL.MotoPecas.entidade.cartao.Cartao;
import Motopecas.JRL.MotoPecas.entidade.endereco.Endereco;
import Motopecas.JRL.MotoPecas.repository.cartao.CartaoRepository;
import Motopecas.JRL.MotoPecas.repository.cliente.ClienteRepository;
import Motopecas.JRL.MotoPecas.repository.endereco.EnderecoRepository;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
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
@RequestMapping("/mv/cliente")
public class ClienteController{
    
    @Autowired
    private ClienteRepository clienteRepository;
    
    @Autowired
    private EnderecoRepository enderecoRepository;
    
    @Autowired
    private CartaoRepository cartaoRepository;

    @GetMapping("/contato")
    public ModelAndView contato() {
        ModelAndView mv = new ModelAndView("/cliente/contato");
        return mv;
    }
    
    @GetMapping("/cadastro")
    public ModelAndView cadastro() {
        return new ModelAndView("/cliente/cadastro")
                .addObject("cliente", new Cliente());
        
    }
    
    @GetMapping("/perfil")
    public ModelAndView perfil(Authentication authentication) {
          Cliente cliente = null;
        if (authentication != null) {
            cliente = (Cliente) authentication.getPrincipal();
        }
        
        List<Endereco> listEndereco = new ArrayList<>();
        if(!cliente.getEndereco().isEmpty()){
            listEndereco = enderecoRepository.findByAll(cliente);
        }
        
        List<Cartao> listCartao = new ArrayList<>();
        if(!cliente.getCartao().isEmpty()){
            listCartao = cartaoRepository.findByIdCliente(cliente);
        }
        
        return new ModelAndView("/cliente/perfil").addObject(listEndereco).addObject(listCartao).addObject(cliente);
    }
    
    
    @PostMapping("/salvar")
    public ModelAndView salvar(
            @ModelAttribute("cliente") Cliente cliente, 
            /*BindingResult bindingResult,*/ RedirectAttributes redirectAttributes) {
        cliente.setDataNascimento(LocalDateTime.now());
        
        clienteRepository.save(cliente);
        redirectAttributes.addFlashAttribute("mensagemSucesso", 
                "Cliente " + cliente.getNome() + " salvo com sucesso");
        return new ModelAndView("redirect:/login");
    }
}
