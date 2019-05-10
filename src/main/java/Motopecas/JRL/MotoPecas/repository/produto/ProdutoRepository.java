/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.repository.produto;

import Motopecas.JRL.MotoPecas.entidade.produto.Produto;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Raul Portela
 */

@Repository
public class ProdutoRepository{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    public List<Produto> findAll(Integer offset, Integer qtd){
        Query jpqlQuery = entityManager.createNamedQuery("Produto.findAll")
                .setFirstResult(offset).setMaxResults(qtd);
        return jpqlQuery.getResultList();
    }
    
    public Produto findById(Long id){
        Query jpqlQyery = entityManager.createNamedQuery("Produto.findById").setParameter("idProduto",id);
        Produto produto = (Produto) jpqlQyery.getSingleResult();
        return produto;
    }
}
