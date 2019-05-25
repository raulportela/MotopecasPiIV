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
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Raul Portela
 */

@Repository
public class ProdutoRepository{
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public List<Produto> findAll(Integer offset, Integer qtd){
        Query jpqlQuery = entityManager.createNamedQuery("Produto.findAll")
                .setFirstResult(offset).setMaxResults(qtd);
        return jpqlQuery.getResultList();
    }
    
    @Transactional
    public Produto findById(Long id){
        Query jpqlQuery = entityManager.createNamedQuery("Produto.findById").setParameter("idProduto",id);
        Produto produto = (Produto) jpqlQuery.getSingleResult();
        return produto;
    }
}
