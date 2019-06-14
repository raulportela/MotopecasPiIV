/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.venda;

import Motopecas.JRL.MotoPecas.entidade.produto.Produto;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Raul Portela
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "ItemVenda.findAll", query = "SELECT iv FROM ItemVenda iv")
})
@Table(name = "ItemVenda")
public class ItemVenda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "VENDAID")
    private Long id;

    @Column(nullable = false, name = "QUANTIDADE")
    private int quantidade;

    @Embedded
    @OneToOne
    Produto Produto;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public Produto getProduto() {
        return Produto;
    }

    public void setProduto(Produto Produto) {
        this.Produto = Produto;
    }

}
