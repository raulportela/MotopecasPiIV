/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.controller.produto;

import Motopecas.JRL.MotoPecas.entidade.Categoria.Categoria;
import Motopecas.JRL.MotoPecas.entidade.produto.Produto;
import Motopecas.JRL.MotoPecas.repository.categoria.CategoriaRepository;
import Motopecas.JRL.MotoPecas.repository.produto.ProdutoRepository;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
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

/**
 *
 * @author Raul Portela
 */
@Controller
@RequestMapping("/mv/produto")
public class ProdutoController {

    @GetMapping("/categoria")
    public ModelAndView carrinho() {
        ModelAndView mv = new ModelAndView("/produto/categoria");
        return mv;
    }
    
    @GetMapping("/especificacao")
    public ModelAndView confirmacao() {
        ModelAndView mv = new ModelAndView("/produto/especificacao");
        return mv;
    }
    
    @GetMapping("/pagemoto")
    public ModelAndView paginamoto() {
        ModelAndView mv = new ModelAndView("/produto/pageModeloMoto");
        return mv;
    }
    
    //Metodos adicionados do projeto do professor 
    /*
    @Autowired
    private ProdutoRepository produtoRepository;
    
    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public ModelAndView listar(
            @RequestParam(name = "offset", defaultValue = "0") int offset,
            @RequestParam(name = "qtd", defaultValue = "100") int qtd,
            @RequestParam(name = "idsCat", required = false) List<Integer> idsCat) {
        List<Produto> resultados;
        if (idsCat != null && !idsCat.isEmpty()) {
            // Busca pelos IDs das categorias informadas
            resultados = (List<Produto>) produtoRepository.findByCategoria(idsCat);
        } else {
            // Lista todos os produtos usando paginacao
            resultados = produtoRepository.findAll(offset, qtd);
        }
        return new ModelAndView("produto/lista").addObject("produtos", resultados);
    }
    @Transactional
    @GetMapping("/novo")
    public ModelAndView adicionarNovo() {
        return new ModelAndView("produto/formulario")
                .addObject("produto", new ProdutoController());
    }
    @Transactional
    @GetMapping("/{id}/editar")
    public ModelAndView editar(@PathVariable("id") Long id) {
        Produto prod = produtoRepository.findProdutoById(id);
        
        if (prod.getCategorias() != null && !prod.getCategorias().isEmpty()) {
            Set<Integer> idsCategorias = new HashSet<>();
            for (Categoria cat : prod.getCategorias()) {
                idsCategorias.add(cat.getId());
            }
            prod.setIdsCategorias(idsCategorias);
        }
        return new ModelAndView("produto/formulario")
                .addObject("produto", prod);
    }
    @Transactional
    @PostMapping("/salvar")
    public ModelAndView salvar(
            @ModelAttribute("produto") ProdutoController produto, 
            /*BindingResult bindingResult, RedirectAttributes redirectAttributes) {
        if (produto.getIdsCategorias() != null && 
                !produto.getIdsCategorias().isEmpty()) {
            Set<Categoria> categoriasSelecionadas = new HashSet<>();
            for (Integer idCat : produto.getIdsCategorias()) {
                Categoria cat = categoriaRepository.findById(idCat);
                categoriasSelecionadas.add(cat);
                cat.setProdutos(new HashSet<>(Arrays.asList(produto)));
            }
            produto.setCategorias(categoriasSelecionadas);
        }
        produtoRepository.save(produto);
        redirectAttributes.addFlashAttribute("mensagemSucesso", 
                "Produto " + produto.getNome() + " salvo com sucesso");
        return new ModelAndView("redirect:/produto");
    }
    @Transactional
    @PostMapping("/{id}/remover")
    public ModelAndView remover(@PathVariable("id") Long id, RedirectAttributes redirectAttributes) {
        produtoRepository.delete(id);
        redirectAttributes.addFlashAttribute("mensagemSucesso", 
                "Produto ID " + id + " removido com sucesso");
        return new ModelAndView("redirect:/produto");
    }

    @ModelAttribute("categorias")
    public List<Categoria> getCategorias() {
        return categoriaRepository.findAll();
    }

    private List<Integer> getIdsCategorias() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setCategorias(Set<Categoria> categoriasSelecionadas) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private String getNome() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
*/
}
