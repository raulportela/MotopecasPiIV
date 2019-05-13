


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.repository.carrinho;

import Motopecas.JRL.MotoPecas.entidade.carrinho.Carrinho;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
    public void save(Carrinho carrinho){
        if(carrinho != null){
            entityManager.persist(carrinho);
        }
    }
}
