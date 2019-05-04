/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.cliente;

import java.io.Serializable;
import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Jeferson Nolasco
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Cliente.findAll", query = "SELECT c FROM Cliente c"),
    
})
public class Cliente implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codCliente;
    
    @Column (length = 100, nullable = false)
    private String email;
    
    @Column (length = 50, nullable = false)
    private String senha;
    
    @Column (length = 50, nullable = false)
    private String nome;
    
    @Column (length = 100, nullable = false)
    private String sobrenome;
    
    @Column (length = 11, nullable = false)
    private Integer telefone;
    
    @Column (length = 100, nullable = false)
    private String cpf;
    
    @Column (length = 10, nullable = false)
    private String sexo;
    
    @Column(nullable = false, insertable = true, updatable = false)
    private LocalDate dataNascimento;
    
    @Column (length = 100, nullable = false)
    private boolean disponivel;
    
    
    private Endereco endereco;
    
    
    private CartaoDeCredito cartaoDeCredito;

    
    
    
    
    
    
    public Long getCodCliente() {
        return codCliente;
    }

    public void setCodCliente(Long codCliente) {
        this.codCliente = codCliente;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public Integer getTelefone() {
        return telefone;
    }

    public void setTelefone(Integer telefone) {
        this.telefone = telefone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public CartaoDeCredito getCartaoDeCredito() {
        return cartaoDeCredito;
    }

    public void setCartaoDeCredito(CartaoDeCredito cartaoDeCredito) {
        this.cartaoDeCredito = cartaoDeCredito;
    }


}
