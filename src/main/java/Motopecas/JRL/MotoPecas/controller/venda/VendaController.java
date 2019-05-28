package Motopecas.JRL.MotoPecas.controller.venda;

import Motopecas.JRL.MotoPecas.entidade.carrinho.Carrinho;
import Motopecas.JRL.MotoPecas.entidade.cartao.Cartao;
import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import Motopecas.JRL.MotoPecas.entidade.endereco.Endereco;
import Motopecas.JRL.MotoPecas.entidade.venda.ItemVenda;
import Motopecas.JRL.MotoPecas.entidade.venda.Venda;
import Motopecas.JRL.MotoPecas.repository.carrinho.CarrinhoRepository;
import Motopecas.JRL.MotoPecas.repository.cliente.ClienteRepository;
import Motopecas.JRL.MotoPecas.repository.endereco.EnderecoRepository;
import Motopecas.JRL.MotoPecas.repository.produto.ProdutoRepository;
import Motopecas.JRL.MotoPecas.repository.venda.VendaRepository;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
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
@SessionAttributes("numeropedido")
public class VendaController {

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    EnderecoRepository enderecoRepository;

    @Autowired
    CarrinhoRepository carrinhoRepository;

    @Autowired
    VendaRepository vendaRepository;

    @Autowired
    ProdutoRepository produtoRepository;

    @GetMapping("/carrinho")
    public ModelAndView carrinho(HttpServletRequest request,
            @RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "qtd", defaultValue = "100") int qtd) {
        List<Carrinho> listaCarrinho;
        listaCarrinho = carrinhoRepository.findCarrinhoByIdCliente(1l);
        double totalCarrinho = gerarTotal(listaCarrinho);
        return new ModelAndView("/venda/carrinho")
                .addObject("listaCarrinho", listaCarrinho)
                .addObject("valorTotalCarrinho", totalCarrinho);
        
    }
    
    @GetMapping("/confirmacao")
    public ModelAndView confirmacao(@ModelAttribute("numeropedido") String numeroPedido,
            RedirectAttributes redirectAttributes) {
        Cliente cliente = clienteRepository.findById(1l);
        List<Carrinho> listaCarrinho;
        getNumeroPedido(numeroPedido);
        listaCarrinho = carrinhoRepository.findCarrinhoByIdCliente(1l);
        double totalCarrinho = gerarTotal(listaCarrinho);
        ModelAndView mv = new ModelAndView("/venda/confirmacao")
                .addObject("listaCarrinho", listaCarrinho)
                .addObject("valorTotalCarrinho", totalCarrinho)
                .addObject("cliente", cliente);
        return mv;
    }

    @GetMapping("/pagamento")
    public ModelAndView pagamento(@RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "qtd", defaultValue = "100") int qtd) {
        long id = 1;
        Cliente c = clienteRepository.findById(id);
        Cartao cartao = new Cartao();

        Endereco endereco = enderecoRepository.findByIdCliente(id);
        List<Carrinho> listaCarrinho;
        listaCarrinho = carrinhoRepository.findCarrinhoByIdCliente(1l);
        return new ModelAndView("/venda/pagamento").addObject("listaCarrinho", listaCarrinho).addObject("clienteSessao", c).addObject("cartao", cartao).addObject("endereco", endereco);
    }

    @GetMapping("/efetuarvenda")
    public ModelAndView efetuarVenda(@ModelAttribute("numeropedido") String numeroPedido) {
        Cliente cliente = clienteRepository.findById(1l);
        Venda venda = new Venda();
        venda.setIdCliente(cliente.getId());
        venda.setData(LocalDate.now());
        venda.setParcelas(3);
        venda.setNotaFiscal(numeroPedido);
        List<ItemVenda> listaVenda = new ArrayList<>();
        List<Carrinho> listaCarrinho;
        listaCarrinho = carrinhoRepository.findCarrinhoByIdCliente(1l);
        double totalCompra = 0;
        for (Endereco endereco : cliente.getEndereco()) {
            if (endereco.getSelecionado() == 1) {
                venda.setEndereco(endereco);
            }
        }
        for (Carrinho carrinho : listaCarrinho) {
            totalCompra += (carrinho.getQuantidade() * carrinho.getProduto().getValor());
            ItemVenda itemVenda = new ItemVenda();
            itemVenda.setProduto(carrinho.getProduto());
            itemVenda.setQuantidade(carrinho.getQuantidade());
            listaVenda.add(itemVenda);
        }
        BigDecimal s = new BigDecimal(""+totalCompra);
        venda.setValorTotal(s);
        venda.setItensVenda(listaVenda);
        vendaRepository.saveVenda(venda);
        return new ModelAndView("redirect:/mv/venda/pedido").addObject("numeropedido", numeroPedido);
    }
    
    @GetMapping("/pedido")
    public ModelAndView pedido(@ModelAttribute("numeropedido") String numeroPedido) {
        Venda venda = vendaRepository.findByNotaFiscal(numeroPedido);
        return new ModelAndView("/venda/pedido").addObject("venda", venda);
    }

    public int gerarNumeroPedido(String pedido) {
        Random rand = new Random();
        int randomNum = rand.nextInt((99999999 - 10000000) + 1) + 10000000;
        if (pedido == null) {
            pedido = "" + randomNum;
        }
        boolean continuar = true;
        while (continuar) {
            Venda venda = vendaRepository.findByNotaFiscal(pedido);
            if (venda == null) {
                return randomNum;
            } else {
                gerarNumeroPedido(pedido);
            }
        }
        return randomNum;
    }
    
    @GetMapping("/{id}/higher")
    public ModelAndView higherQtd(@PathVariable("id") String idCarrinho) {
        List<Carrinho> listaCarrinho = carrinhoRepository.findCarrinhoByIdCliente(1l);
        for (Carrinho carrinho : listaCarrinho) {
            if (idCarrinho.equals((""+carrinho.getId()))) {
                carrinho.setQuantidade(carrinho.getQuantidade()+1);
                carrinhoRepository.save(carrinho);
                return new ModelAndView("redirect:/mv/venda/carrinho");
            }
            
        }
        return new ModelAndView("redirect:/mv/venda/carrinho");
    }
    
    @GetMapping("/{id}/alteraddress")
    public ModelAndView alterAddres(@PathVariable("id") Long idEndereco) {
        enderecoRepository.alterById(idEndereco);
        return new ModelAndView("redirect:/mv/venda/confirmacao");
    }
    
    @GetMapping("/{id}/lower")
    public ModelAndView lowerQtd(@PathVariable("id") String idCarrinho) {
        List<Carrinho> listaCarrinho = carrinhoRepository.findCarrinhoByIdCliente(1l);
        for (Carrinho carrinho : listaCarrinho) {
            if (idCarrinho.equals((""+carrinho.getId()))) {
                carrinho.setQuantidade(carrinho.getQuantidade()-1);
                if (carrinho.getQuantidade() == 0) {
                    carrinhoRepository.deleteById(carrinho);
                }
                carrinhoRepository.save(carrinho);
                return new ModelAndView("redirect:/mv/venda/carrinho");
            }
            
        }
        return new ModelAndView("redirect:/mv/venda/carrinho");
    }
    
    @ModelAttribute("numeropedido")
    public String getNumeroPedido(String numeropedido) {
        return ""+gerarNumeroPedido(null);
    }
    
    public double gerarTotal(List<Carrinho> listaCarrinho){
        double totalCarrinho = 0;
        for (Carrinho carrinho : listaCarrinho) {
            totalCarrinho += (carrinho.getQuantidade() * carrinho.getProduto().getValor());
        }
        return totalCarrinho;
    }
}
