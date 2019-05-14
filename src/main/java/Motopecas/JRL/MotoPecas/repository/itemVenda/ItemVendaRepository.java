


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.repository.itemVenda;

import Motopecas.JRL.MotoPecas.entidade.venda.ItemVenda;
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
public class ItemVendaRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public List<ItemVenda> findAll(Integer offset, Integer qtd){
        Query jpqlQuery = entityManager.createNamedQuery("ItemVenda.findAll")
                .setFirstResult(offset).setMaxResults(qtd);
        return jpqlQuery.getResultList();
    }
    
    @Transactional
    public void save(ItemVenda itemVenda){
        if(itemVenda != null){
            entityManager.persist(itemVenda);
        }
    }
}
