/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.categoria;

import Motopecas.JRL.MotoPecas.entidade.produto.Produto;
import java.io.Serializable;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


/**
 *
 * @author Raul Portela
 */
@Entity
public class Categoria implements Serializable {
    
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    int id;

    @Column(length = 15, nullable = true)
    String nome;
    
    @ManyToMany(mappedBy = "categorias", fetch = FetchType.LAZY)
    private Set<Produto> produtos;

    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

}
