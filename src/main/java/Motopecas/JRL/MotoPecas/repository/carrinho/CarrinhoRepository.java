/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.repository.carrinho;

import Motopecas.JRL.MotoPecas.entidade.carrinho.Carrinho;
import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
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
public class CarrinhoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Carrinho carrinho) {
        if (carrinho.getId() != null) {
            entityManager.persist(carrinho);
        } else {
            entityManager.merge(carrinho);
        }
    }

    @Transactional
    public List<Carrinho> findCarrinhoByIdCliente(Long idCliente) {
        Query jpqlQuery = entityManager.createNamedQuery("Carrinho.findByIdCliente");
        List<Carrinho> listaCarrinho= jpqlQuery.getResultList();
        return listaCarrinho;
    }
}
