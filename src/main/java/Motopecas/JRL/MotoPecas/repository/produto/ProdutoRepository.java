/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.repository.produto;

import Motopecas.JRL.MotoPecas.controller.produto.ProdutoController;
import Motopecas.JRL.MotoPecas.entidade.produto.Produto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Raul Portela
 */


public interface ProdutoRepository extends JpaRepository<Produto, Long> {
    
    /*
    Produto findProdutoAll();
    
    Produto findProdutoById(Long id);
    
    Produto findByCategoria(List<Integer> idCategoria);
    
    Produto findByMarca(String marca);

    public List<Produto> findAll(int offset, int qtd);

    public void save(ProdutoController produto);

    public void delete(Long id);
    */
}
