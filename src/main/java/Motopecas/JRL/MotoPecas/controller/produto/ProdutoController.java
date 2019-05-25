package Motopecas.JRL.MotoPecas.controller.produto;

import Motopecas.JRL.MotoPecas.entidade.carrinho.Carrinho;
import Motopecas.JRL.MotoPecas.entidade.produto.Produto;
import Motopecas.JRL.MotoPecas.repository.carrinho.CarrinhoRepository;
import Motopecas.JRL.MotoPecas.repository.produto.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Raul Portela
 */
@Controller
@RequestMapping("/mv/produto")
public class ProdutoController {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CarrinhoRepository carrinhoRepository;

    @GetMapping("/listAll")
    public ModelAndView listAll(
            @RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "qtd", defaultValue = "100") int qtd) {
        List<Produto> listaProdutos;
        listaProdutos = produtoRepository.findAll(offset, qtd);
        return new ModelAndView("/produto/categoria").addObject("produtos", listaProdutos);
    }

    @GetMapping("/{id}/presentationByid")
    public ModelAndView presentationById(@PathVariable("id") Long id) {
        Produto produto = produtoRepository.findById(id);
        return new ModelAndView("/produto/especificacao").addObject("produtoEspecificacao", produto);
    }

    @GetMapping("/{id}/additemcart")
    public ModelAndView additemcart(@PathVariable("id") Long id,
            @RequestParam(name = "listaCarrinho", required = false) List<Carrinho> listaCarrinho,
            @RequestParam(name = "totalValorCarrinho", required = false) String totalValorCarrinho) {
        Produto produto;
        Carrinho carrinho = new Carrinho();
        if (listaCarrinho != null && listaCarrinho.isEmpty()) {
            produto = produtoRepository.findById(id);
            carrinho.setProduto(produto);
            carrinhoRepository.save(carrinho);
            
        } else {
            produto = produtoRepository.findById(id);
            carrinho.setQuantidade(2);
            carrinho.setProduto(produto);
            carrinhoRepository.save(carrinho);
        }
        ModelAndView mv = new ModelAndView("redirect:/mv/venda/carrinho");
        return mv;
    }

    public ModelAndView paginamoto() {
        ModelAndView mv = new ModelAndView("/produto/pageModeloMoto");
        return mv;
    }
}
