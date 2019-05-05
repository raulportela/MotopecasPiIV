/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.endereco;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


/**
 *
 * @author Jeferson Nolasco
 */

@Entity
public class Endereco {
    
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 130, nullable = false)
    private String rua;
    
    @Column(length = 5, nullable = false)
    private int numero;
    
    @Column(length = 80, nullable = false)
    private String bairro;
    
    @Column(length = 7, nullable = false)
    private int cep; 
    
    @Column(length = 200, nullable = false)
    private String complemento;

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

}
