/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.cliente;

import Motopecas.JRL.MotoPecas.entidade.cartao.Cartao;
import Motopecas.JRL.MotoPecas.entidade.endereco.Endereco;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;

/**
 *
 * @author Jeferson Nolasco
 */
@Entity
public class Cliente implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 12, nullable = false)
    private String senha;

    @Column(length = 50, nullable = false)
    private String nome;

    @Column(length = 100, nullable = false)
    private String sobrenome;

    @Column(length = 11, nullable = false)
    private Integer telefone;

    @Column(length = 100, nullable = false)
    private String cpf;

   @Column(nullable = false)
    private boolean disponivel;

    @Column(nullable = false, insertable = true, updatable = false)
    private LocalDateTime dataNascimento;

    @Column(length = 100, nullable = false)
    private boolean sexo;
    
                        
  @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "CLIENTE_ENDERECO",
            joinColumns = @JoinColumn(name = "ID_CLIENTE"),
            inverseJoinColumns = @JoinColumn(name = "ID_ENDERECO")
    )
   private List<Endereco> endereco  = new ArrayList<>();
   
   @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "CLIENTE_CARTAO",
            joinColumns = @JoinColumn(name = "ID_CLIENTE"),
            inverseJoinColumns = @JoinColumn(name = "ID_CARTAO")
    )
    private Set<Cartao> cartoes;
   
  
    public Cliente() {

    }

    public Cliente(Long id, String email, String senha, String nome, String sobrenome, Integer telefone, String cpf, boolean sexo, LocalDateTime dataNascimento, boolean disponivel) {
        this.id = id;
        this.email = email;
        this.senha = senha;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
        this.disponivel = disponivel;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public boolean getSexo() {
        return sexo;
    }

    public void setSexo(boolean sexo) {
        this.sexo = sexo;
    }

    public LocalDateTime getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDateTime dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public boolean isDisponivel() {
        return disponivel;
    }

    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

//    public Endereco getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(Endereco endereco) {
//        this.endereco = endereco;
//    }
//
//    public CartaoDeCredito getCartaoDeCredito() {
//        return cartaoDeCredito;
//    }
//
//    public void setCartaoDeCredito(CartaoDeCredito cartaoDeCredito) {
//        this.cartaoDeCredito = cartaoDeCredito;
//    }
    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", email=" + email + ", senha=" + senha + ", nome=" + nome + ", sobrenome=" + sobrenome + ", telefone=" + telefone + ", cpf=" + cpf + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", disponivel=" + disponivel + '}';
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }
}
