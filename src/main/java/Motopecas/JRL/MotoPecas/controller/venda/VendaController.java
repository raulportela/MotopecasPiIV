package Motopecas.JRL.MotoPecas.controller.venda;

import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import Motopecas.JRL.MotoPecas.entidade.produto.Produto;
import Motopecas.JRL.MotoPecas.entidade.venda.ItemVenda;
import Motopecas.JRL.MotoPecas.repository.produto.ProdutoRepository;
import Motopecas.JRL.MotoPecas.repository.venda.VendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
public class VendaController {

    
    @Autowired
    VendaRepository vendaRepository;
    
    @Autowired
    ProdutoRepository produtoRepository;
    
    @GetMapping("/carrinho")
    public ModelAndView carrinho() {
        Cliente cliente = null; //Resgatar o cliente da sessão
        List<ItemVenda> itensCarrinho;
        itensCarrinho = vendaRepository.findCarrinhoByCliente(cliente.getId());
        return new ModelAndView("/venda/carrinho").addObject(itensCarrinho);
        
    }
    
    @GetMapping("/confirmacao")
    public ModelAndView confirmacao() {
        ModelAndView mv = new ModelAndView("/venda/confirmacao");
        return mv;
    }
    
    @GetMapping("/{id}/additemcart")
    public ModelAndView additemcart(@PathVariable("id") Long id) {
        Produto produto = produtoRepository.findById(id);
        ModelAndView mv = new ModelAndView("/venda/confirmacao");
        return mv;
    }
    
    @GetMapping("/pagamento")
    public ModelAndView pagamento() {
        ModelAndView mv = new ModelAndView("/venda/pagamento");
        return mv;
    }
}
