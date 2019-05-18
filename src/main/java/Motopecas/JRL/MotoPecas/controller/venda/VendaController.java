package Motopecas.JRL.MotoPecas.controller.venda;

import Motopecas.JRL.MotoPecas.entidade.carrinho.Carrinho;
import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import Motopecas.JRL.MotoPecas.entidade.produto.Produto;
import Motopecas.JRL.MotoPecas.repository.carrinho.CarrinhoRepository;
import Motopecas.JRL.MotoPecas.repository.cliente.ClienteRepository;
import Motopecas.JRL.MotoPecas.repository.itemVenda.ItemVendaRepository;
import Motopecas.JRL.MotoPecas.repository.produto.ProdutoRepository;
import Motopecas.JRL.MotoPecas.repository.venda.VendaRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
    ClienteRepository clienteRepository;
    
    @Autowired
    ItemVendaRepository itemVendaRepository;

    @Autowired
    CarrinhoRepository carrinhoRepository;

    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/carrinho")
    public ModelAndView carrinho(
            @RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "qtd", defaultValue = "100") int qtd) {
        List<Carrinho> listaCarrinho;
            listaCarrinho = carrinhoRepository.findCarrinhoByIdCliente(1l);
        return new ModelAndView("/venda/carrinho").addObject("listaCarrinho", listaCarrinho);

    }

    @GetMapping("/confirmacao")
    public ModelAndView confirmacao() {
        List<Carrinho> listaCarrinho;
        listaCarrinho = carrinhoRepository.findCarrinhoByIdCliente(1l);
        
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
    public ModelAndView pagamento( @RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "qtd", defaultValue = "100") int qtd){
        long id = 1;
        Cliente c = clienteRepository.findById(id);
        
        List<Carrinho> listaCarrinho;
            listaCarrinho = carrinhoRepository.findCarrinhoByIdCliente(1l);
        return new ModelAndView("/venda/pagamento").addObject("listaCarrinho", listaCarrinho).addObject("clienteSessao", c);
     
    }
}
