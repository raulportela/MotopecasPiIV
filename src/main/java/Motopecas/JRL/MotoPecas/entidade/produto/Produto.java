/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.produto;   

import Motopecas.JRL.MotoPecas.entidade.Categoria.Categoria;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Raul Portela
 */

@Entity
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 40, nullable = false)
    private String nome;
    
    @Column(length = 200, nullable = false)
    private String descricao;
    
    @Column(length = 15, nullable = false)
    private String cor;
    
    //falar com a rapa do back, sobre definir ids em uma categoria de moto e puxar na hora de cadastrar peças, é isso kkkkk
    private int tipoDaMoto;
    
    @Column(length = 4, nullable = false)
    private int quantidade;
    
    @Column(length = 2, nullable = false)
    private float tamanho;
    
    //aqui vai puxar de outra coisa do banco 
    private int[] categoria;
    
    
    private LocalDateTime dataCadastro;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public int getTipoDaMoto() {
        return tipoDaMoto;
    }

    public void setTipoDaMoto(int tipoDaMoto) {
        this.tipoDaMoto = tipoDaMoto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public float getTamanho() {
        return tamanho;
    }

    public void setTamanho(float tamanho) {
        this.tamanho = tamanho;
    }

    public int[] getCategoria() {
        return categoria;
    }

    public void setCategoria(int[] categoria) {
        this.categoria = categoria;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Set<Categoria> getCategorias() {
        return null;
    }

    public void setIdsCategorias(Set<Integer> idsCategorias) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
}
