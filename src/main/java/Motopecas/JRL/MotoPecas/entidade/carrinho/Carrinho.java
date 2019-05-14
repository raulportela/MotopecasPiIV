/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.carrinho;

import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import Motopecas.JRL.MotoPecas.entidade.produto.Produto;
import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author Raul Portela
 */

@Entity
public class Carrinho implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Embedded
    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "CARRINHO_PRODUTO",
            joinColumns = @JoinColumn(name = "ID_CARRINHO"),
            inverseJoinColumns = @JoinColumn(name = "ID_PRODUTO")
    )
    private List <Produto> produto;
            
   
  
    private Cliente cliente ;
    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
  
}
