/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.repository.venda;

import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
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
        Venda venda = null;
        try {
            venda = (Venda) jpqlQuery.getSingleResult();
        } catch (Exception e) {
            return null;
        } catch (Throwable t){
            return null;
        }
        return venda;
    }
    
    public List<Venda> findByIdCliente(Cliente cliente){
        Query jpqlQuery = entityManager.createNamedQuery("Venda.findByIdCliente").setParameter("idCliente", cliente.getId());
        return jpqlQuery.getResultList();
    }

}
