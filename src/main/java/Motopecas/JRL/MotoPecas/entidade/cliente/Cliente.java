/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.cliente;

import Motopecas.JRL.MotoPecas.SecurityConfig;
import Motopecas.JRL.MotoPecas.entidade.acesso.Papel;
import Motopecas.JRL.MotoPecas.entidade.cartao.Cartao;
import Motopecas.JRL.MotoPecas.entidade.endereco.Endereco;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author Jeferson Nolasco
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Cliente.findById", query = "SELECT c FROM Cliente c WHERE c.id = :idCliente")
    
})

public class Cliente implements Serializable, UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100, nullable = false)
    private String email;

    @Column(length = 12, nullable = false)
    private String hashsenha;
    
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

    // '1'== Masculino
    // '0'== Feminino
    @Column(length = 100, nullable = false)
    private boolean sexo;
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY ,cascade = javax.persistence.CascadeType.ALL)
    private List<Endereco> endereco;
    
    @OneToMany(mappedBy = "cliente", fetch = FetchType.LAZY, cascade = javax.persistence.CascadeType.ALL)
    private List<Cartao> cartao;
    
    @OneToOne
    @JoinColumn(name="papel_id")
    private Papel papel;  
    
    
    public Cliente() {

    }

    public Cliente(Long id, String email, String senhaAberta, String nome, String sobrenome, Integer telefone, String cpf, boolean disponivel, LocalDateTime dataNascimento, boolean sexo, List<Endereco> endereco, List<Cartao> cartao, Papel papel) {
        this.id = id;
        this.email = email;
        setHashsenha(senhaAberta);
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.telefone = telefone;
        this.cpf = cpf;
        this.disponivel = disponivel;
        this.dataNascimento = dataNascimento;
        this.sexo = sexo;
        this.endereco = endereco;
        this.cartao = cartao;
        this.papel = papel;
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

    @Override
    public String toString() {
        return "Cliente{" + "id=" + id + ", email=" + email + ", senha=" + getHashsenha() + ", nome=" + nome + ", sobrenome=" + sobrenome + ", telefone=" + telefone + ", cpf=" + cpf + ", sexo=" + sexo + ", dataNascimento=" + dataNascimento + ", disponivel=" + disponivel + '}';
    }

    public List<Endereco> getEndereco() {
        return endereco;
    }

    public void setEndereco(List<Endereco> endereco) {
        this.endereco = endereco;
    }

    public List<Cartao> getCartao() {
        return cartao;
    }

    public void setCartao(List<Cartao> cartao) {
        this.cartao = cartao;
    }

    public String getHashsenha() {
        return hashsenha;
    }

    public final void setHashsenha(String senhaAberta ) {
        this.hashsenha = 
                SecurityConfig.bcryptPasswordEncoder()
                           .encode(senhaAberta);
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPassword() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getUsername() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAccountNonExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isAccountNonLocked() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isCredentialsNonExpired() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEnabled() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public Papel getPapel() {
        return papel;
    }

    public void setPapel(Papel papel) {
        this.papel = papel;
    }

}
