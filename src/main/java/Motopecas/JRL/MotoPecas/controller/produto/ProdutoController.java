package Motopecas.JRL.MotoPecas.controller.produto;

import Motopecas.JRL.MotoPecas.entidade.produto.Produto;
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
    public ModelAndView additemcart(@PathVariable("id") Long id) {
        //A varialvel id está com o numero do id que ta vindo do front.. 
        Produto produto = produtoRepository.findById(id);
        
        //Essa variavel produto, já está com as informações do produto.. 
        //Implementei o metodo na classe CARRINHO REPOSITORY, de salvar;
        //Daqui pra baixo, é só usar ela denovo e depois voltar pra tela de listagem que é o quejá está sendo feito na proxima linha
        //Agora tem que fazer o que precisa pra passar do carrinho, que é a escolha de Endereço e opção de pagamento;
        //Depois da escolha de pagamento, ir para a tela de confirmação;
        //Utiliza a tela do front de produto que ta com o nome de "Categoria" como exemplo, lá ela usa os atributos com o Thymeleaf
        ModelAndView mv = new ModelAndView("/produto/categoria");
        return mv;
    }
    
    @GetMapping("/pagemoto")
    public ModelAndView paginamoto() {
        ModelAndView mv = new ModelAndView("/produto/pageModeloMoto");
        return mv;
    }
}
