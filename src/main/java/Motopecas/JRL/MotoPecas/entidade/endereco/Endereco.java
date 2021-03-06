/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.endereco;

import Motopecas.JRL.MotoPecas.entidade.cliente.Cliente;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Jeferson Nolasco
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "Endereco.findByIdCliente", query = "SELECT e FROM Endereco e WHERE e.cliente = :cliente"),
    @NamedQuery(name = "Endereco.findById", query = "SELECT e FROM Endereco e WHERE e.id = :id"),
    @NamedQuery(name = "Endereco.findBySelecionado", query = "SELECT e FROM Endereco e WHERE e.selecionado = 1" + " and e.cliente = :cliente ")
    
})
@Table(name = "Endereco")
public class Endereco implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 1, name = "SELECIONADO")
    private int selecionado;
    
    @Column(length = 130, nullable = false, name = "LOGRADOURO")
    private String rua;

    @Column(length = 5, nullable = false, name = "NUMERO")
    private int numero;

    @Column(length = 80, nullable = false, name = "BAIRRO")
    private String bairro;

    @Column(length = 7, nullable = false, name = "CEP")
    private int cep;

    @Column(length = 200, nullable = false, name = "COMPLEMENTO")
    private String complemento;

    
    @ManyToOne()
    private Cliente cliente;

    public Endereco() {

    }

    public Endereco(Long id, String rua, int numero, String bairro, int cep, String complemento) {
        this.id = id;
        this.rua = rua;
        this.bairro = bairro;
        this.cep = cep;
        this.complemento = complemento;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCep(int cep) {
        this.cep = cep;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getRua() {
        return rua;
    }

    public int getNumero() {
        return numero;
    }

    public String getBairro() {
        return bairro;
    }

    public int getCep() {
        return cep;
    }

    public String getComplemento() {
        return complemento;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Endereco{" + "id=" + id + ", cliente=" + ", rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + ", cep=" + cep + ", complemento=" + complemento + '}';
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
