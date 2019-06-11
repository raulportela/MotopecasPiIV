/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.repository.cartao;

import Motopecas.JRL.MotoPecas.entidade.cartao.Cartao;
import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
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
public class CartaoRepository {

    @PersistenceContext
    private EntityManager entityManager;

    @Transactional
    public void save(Cartao c) {
        //Salvar cartao
        entityManager.persist(c);
    }

    @Transactional
    public void deletar(Cartao c) {
        //Deletar cartao
        entityManager.remove(c);
    }

//     @Transactional
//    public Cartao findByIdCliente(Cliente cliente) {
//        Query jpqlQyery = entityManager.createNamedQuery("Cartao.findByIdCliente").setParameter("cliente", cliente);
//        Cartao Cartao = (Cartao) jpqlQyery.getSingleResult();
//        return Cartao;
//    }
    
    @Transactional
    public List<Cartao> findByIdCliente(Cliente cliente) {
        Query jpqlQuery = entityManager.createNamedQuery("Cartao.findByIdCliente").setParameter("cliente", cliente);
        List<Cartao> listCartao= jpqlQuery.getResultList();
        return listCartao;
    }

    @Transactional
    public void desativarSelecionado() {
        Cartao cartao = null;
        Query jpqlQyery = entityManager.createNamedQuery("Cartao.findBySelecionado");
        try {
            cartao = (Cartao) jpqlQyery.getSingleResult();
        } catch (Exception e) {
            return;
        } catch (Throwable t) {
            return;
        }
        if (cartao != null) {
            cartao.setSelecionado(0);
            save(cartao);
        }

    }

    @Transactional
    public void alterById(Long id) {
        Query jpqlQyery = entityManager.createNamedQuery("Cartao.findById").setParameter("id", id);

        //Esse metodo altera a seleção do cartão, caso exista algum selecionado.
        desativarSelecionado();

        //Esse cartao é o que vou marcar como selecionado
        Cartao cartaoSelecionar = (Cartao) jpqlQyery.getSingleResult();
        cartaoSelecionar.setSelecionado(1);
        save(cartaoSelecionar);
    }
}
