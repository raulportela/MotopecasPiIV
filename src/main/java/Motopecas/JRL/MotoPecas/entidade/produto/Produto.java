/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.produto;   

import Motopecas.JRL.MotoPecas.entidade.categoria.Categoria;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Raul Portela
 */

@Entity
@NamedQueries({
    @NamedQuery(name = "Produto.findAll", query = "SELECT p FROM Produto p"),
    @NamedQuery(name = "Produto.findById", query = "SELECT p FROM Produto p WHERE p.id = :idProduto")
})
@Table(name = "Produto")
public class Produto implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(length = 40, nullable = false, name = "NOME")
    private String nome;
    
    @Column(length = 200, nullable = false, name = "DESCRICAO")
    private String descricao;
    
    @Column(length = 5, nullable = true, name = "PRECO")
    private double valor;

    @Column(length = 15, nullable = false, name = "COR")
    private String cor;
    
    //falar com a rapa do back, sobre definir ids em uma categoria de moto e puxar na hora de cadastrar peças, é isso kkkkk
    //private int tipoDaMoto;
    
    @Column(length = 4, nullable = false, name = "ESTOQUE")
    private int quantidade;
    
    @Column(length = 2, nullable = false, name = "TAMANHO")
    private String tamanho;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "produto_categoria",
        joinColumns = @JoinColumn(name = "id_produto"),
        inverseJoinColumns = @JoinColumn(name = "id_categoria"))
    private Set<Categoria> categorias ;
    
    @Column(name = "CATEGORIA")
    private String categoria;
    
    @Column(name = "DATAENTRADA")
    private LocalDateTime dataCadastro;
    
    @Column(name = "IMAGEM")
    private Byte imagem[];

    public Byte[] getImagem() {
        return imagem;
    }

    public void setImagem(Byte[] imagem) {
        this.imagem = imagem;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
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

    //public int getTipoDaMoto() {
    //   return tipoDaMoto;
    //}

    //public void setTipoDaMoto(int tipoDaMoto) {
    //    this.tipoDaMoto = tipoDaMoto;
    //}

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public void setCategorias(Set<Categoria> categorias) {
        this.categorias = categorias;
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

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    
    
    
}
