/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.repository.venda;

import Motopecas.JRL.MotoPecas.entidade.venda.ItemVenda;
import Motopecas.JRL.MotoPecas.entidade.venda.Venda;
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
public class VendaRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public void saveVenda(Venda venda){
        if(venda != null){
            if (venda.getItensVenda() != null) {
                entityManager.persist(venda);
            }
        }
    }
    
    @Transactional
    public List<ItemVenda> findCarrinhoByCliente(Long idCliente){
        Query jpqlQyery = entityManager.createNamedQuery("ItemVenda.findByCliente").setParameter("idCliente",idCliente);
        return jpqlQyery.getResultList();
    } 
    
    public void deleteCarrinho(Long idCliente){
        Query jpqlQyery = entityManager.createNamedQuery("ItemVenda.delete").setParameter("idCliente", idCliente);
        entityManager.clear();
    }

    public Venda findByNotaFiscal(String pedido) {
        Query jpqlQuery = entityManager.createNamedQuery("Venda.findByNotaFiscal").setParameter("notaFiscal",pedido);
        Venda venda = (Venda) jpqlQuery.getSingleResult();
        return venda;
    }
}
