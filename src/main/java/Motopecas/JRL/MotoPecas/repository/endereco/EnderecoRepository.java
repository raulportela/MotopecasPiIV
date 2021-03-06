/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.repository.endereco;

import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import Motopecas.JRL.MotoPecas.entidade.endereco.Endereco;
import java.util.List;
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
public class EnderecoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Endereco e) {
        //Salvar endereco
        if (e.getId() == null) {
            entityManager.persist(e);
        } else {
            //Editar endereco
            entityManager.merge(e);
        }
    }

    @Transactional
    public List <Endereco> findByIdCliente(Cliente cliente) {
        Query jpqlQyery = entityManager.createNamedQuery("Endereco.findByIdCliente").setParameter("cliente", cliente);
       List <Endereco> listEndereco =  jpqlQyery.getResultList();
        return listEndereco;
    }

    @Transactional
    public Endereco findBySelecionado() {
        Query jpqlQyery = entityManager.createNamedQuery("Endereco.findBySelecionado");
        Endereco endereco = (Endereco) jpqlQyery.getSingleResult();
        endereco.setSelecionado(0);
        save(endereco);
        return endereco;
    }

    @Transactional
    public void desativarSelecionado(Cliente cliente) {
       Endereco endereco  = null;
        Query jpqlQyery = entityManager.createNamedQuery("Endereco.findBySelecionado").setParameter("cliente", cliente);
        try {
            endereco = (Endereco) jpqlQyery.getSingleResult();
        } catch (Exception e) {
            return;
        } catch (Throwable t) {
            return;
        }
        if (endereco != null) {
            endereco.setSelecionado(0);
            save(endereco);
        }

    }

    @Transactional
    public void alterById(Long id, Cliente cliente) {
        
        Query jpqlQyery = entityManager.createNamedQuery("Endereco.findById").setParameter("id", id);

        //Esse endereco é o que estava selecionado e eu vou tirar o selecionado dele.
        desativarSelecionado(cliente);

        //Esse endereco é o que vou marcar como selecionado
        Endereco enderecoSelelecionar = (Endereco) jpqlQyery.getSingleResult();
        enderecoSelelecionar.setSelecionado(1);
        save(enderecoSelelecionar);
    }

    public List<Endereco> findByAll(Cliente cliente) {
        Query jpqlQuery = entityManager.createNamedQuery("Endereco.findByIdCliente").setParameter("cliente", cliente);
        List<Endereco> listEndereco = jpqlQuery.getResultList();
        return listEndereco;
    }

}
