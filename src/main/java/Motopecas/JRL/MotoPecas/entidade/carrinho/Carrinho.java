/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.carrinho;

import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import Motopecas.JRL.MotoPecas.entidade.produto.Produto;
import java.io.Serializable;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author Raul Portela
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Carrinho.findByIdCliente", query = "SELECT c FROM Carrinho c"),
    @NamedQuery(name = "Carrinho.deleteById", query = "DELETE FROM Carrinho c WHERE c.id = :idCarrinho"),
    @NamedQuery(name = "Carrinho.findByIdProduto", query = "SELECT c FROM Carrinho c WHERE c.Produto = :produto")
    
})
public class Carrinho implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Embedded
    @OneToOne
    Produto Produto;

    @Embedded
    @OneToOne
    Cliente Cliente;

    
    private int quantidade;

    public Produto getProduto() {
        return Produto;
    }

    public void setProduto(Produto Produto) {
        this.Produto = Produto;
    }
    
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

}
