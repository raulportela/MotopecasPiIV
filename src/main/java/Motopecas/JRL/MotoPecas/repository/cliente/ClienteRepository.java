/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.repository.cliente;

import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
    
    @Transactional
    public Cliente findById(Long id) {
        Query jpqlQyery = entityManager.createNamedQuery("Cliente.findById").setParameter("idCliente",id);
        Cliente cliente= (Cliente) jpqlQyery.getSingleResult();
        return cliente;
    }
    
    @Transactional
    public Cliente findByEmail(String email) {
        Query jpqlQyery = entityManager.createNamedQuery("Cliente.findByEmail").setParameter("email",email);
        Cliente cliente= (Cliente) jpqlQyery.getSingleResult();
        return cliente;
    }
    
    @Transactional
    public List <Cliente> findAll(){
        Query jpqlQuery = entityManager.createNamedQuery("Cliente.findAll");
        List<Cliente> clientes =  jpqlQuery.getResultList();
        return clientes;
    }
    
}
