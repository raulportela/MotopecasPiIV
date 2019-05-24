package Motopecas.JRL.MotoPecas.controller.venda;

import Motopecas.JRL.MotoPecas.entidade.carrinho.Carrinho;
import Motopecas.JRL.MotoPecas.entidade.cartao.Cartao;
import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import Motopecas.JRL.MotoPecas.entidade.endereco.Endereco;
import Motopecas.JRL.MotoPecas.entidade.produto.Produto;
import Motopecas.JRL.MotoPecas.repository.carrinho.CarrinhoRepository;
import Motopecas.JRL.MotoPecas.repository.cliente.ClienteRepository;
import Motopecas.JRL.MotoPecas.repository.endereco.EnderecoRepository;
import Motopecas.JRL.MotoPecas.repository.itemVenda.ItemVendaRepository;
import Motopecas.JRL.MotoPecas.repository.produto.ProdutoRepository;
import Motopecas.JRL.MotoPecas.repository.venda.VendaRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
    EnderecoRepository enderecoRepository;
    
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

    
    @PostMapping("/confirmacao")
    public ModelAndView confirmacao(
    @ModelAttribute("cartao") Cartao cartao,
            RedirectAttributes redirectAttributes ) {
        long id = 1;
        Cliente cliente = clienteRepository.findById(id);
        List <Cartao> listaCartao = new ArrayList<Cartao>();
        listaCartao.add(cartao);
        cliente.setCartao(listaCartao);
        List<Carrinho> listaCarrinho;
        listaCarrinho = carrinhoRepository.findCarrinhoByIdCliente(1l);
        return new ModelAndView("/venda/pagamento").addObject("listaCarrinho", listaCarrinho).addObject("clienteSessao", cliente);
        
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
        Cartao cartao = new Cartao();
        
        Endereco endereco =  enderecoRepository.findByIdCliente(id);
        List<Carrinho> listaCarrinho;
            listaCarrinho = carrinhoRepository.findCarrinhoByIdCliente(1l);
        return new ModelAndView("/venda/pagamento").addObject("listaCarrinho", listaCarrinho).addObject("clienteSessao", c).addObject("cartao",cartao).addObject("endereco", endereco);
     
    }
}
