/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.cartao;

import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

/**
 *
 * @author Luana
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Cartao.findByIdCliente", query = "SELECT c FROM Cartao c WHERE c.cliente = :cliente"),
    @NamedQuery(name = "Cartao.findById", query = "SELECT c FROM Cartao c WHERE c.id = :id"),
    @NamedQuery(name = "Cartao.findBySelecionado", query = "SELECT c FROM Cartao c WHERE c.selecionado = 1" + " and c.cliente = :cliente ")
})
@Table(name = "Cartao")
public class Cartao implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "BANDEIRA")
    private String bandeira;
    
    @Column(name = "NOME")
    private String nomeTitular;
    
    @Column(name = "NUMERO")
    private String numeroCartao;
    
    @Column(name = "VALIDADE")
    private String dataValidade;
    
    @Column(name = "CODIGO")
    private int codSeguranca;
    
    @Column(name = "PARCELA")
    private int parcela;
    
    @Column(length = 1, name = "SELECIONADO")
    private int selecionado;

    @ManyToOne()
    private Cliente cliente;
    
    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public int getCodSeguranca() {
        return codSeguranca;
    }

    public void setCodSeguranca(int codSeguranca) {
        this.codSeguranca = codSeguranca;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getParcela() {
        return parcela;
    }

    public void setParcela(int parcela) {
        this.parcela = parcela;
    }

    public String getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(String dataValidade) {
        this.dataValidade = dataValidade;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getSelecionado() {
        return selecionado;
    }

    public void setSelecionado(int selecionado) {
        this.selecionado = selecionado;
    }
    
}
