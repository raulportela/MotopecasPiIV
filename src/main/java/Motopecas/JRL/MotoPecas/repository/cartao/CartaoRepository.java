/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.repository.cartao;

import Motopecas.JRL.MotoPecas.entidade.cartao.Cartao;
import Motopecas.JRL.MotoPecas.repository.endereco.*;
import Motopecas.JRL.MotoPecas.entidade.endereco.Endereco;
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

    @Transactional
    public Cartao findByIdCliente(Long id) {
        Query jpqlQyery = entityManager.createNamedQuery("Cartao.findByIdCliente").setParameter("idCliente", id);
        Cartao cartao = (Cartao) jpqlQyery.getSingleResult();
        return cartao;
    }

}