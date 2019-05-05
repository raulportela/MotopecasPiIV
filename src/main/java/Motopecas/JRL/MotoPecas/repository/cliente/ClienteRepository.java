/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.repository.cliente;

import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luana
 */
@Repository
public class ClienteRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public void save(Cliente c ){
            //Salvar cliente
        if(c.getId() == null){
            entityManager.persist(c);
        }else{
            //Editar Cliente
            entityManager.merge(c);
        }
    }
    
}
