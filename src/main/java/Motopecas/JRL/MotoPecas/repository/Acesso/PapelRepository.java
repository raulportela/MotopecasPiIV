/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.repository.Acesso;

import Motopecas.JRL.MotoPecas.entidade.acesso.Papel;
import Motopecas.JRL.MotoPecas.repository.cliente.*;
import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Luana
 */
@Repository
public class PapelRepository {
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Transactional
    public void save(Papel p ){
            //Salvar Papel
            entityManager.persist(p);
    }
    
}
