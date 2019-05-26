/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.venda;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Raul Portela
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Venda.findByNotaFiscal", query = "SELECT v FROM Venda v WHERE v.notaFiscal = :notaFiscal")
    
})
public class Venda implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(precision = 6, scale = 2, nullable = false)
    private BigDecimal valorTotal;

    @Column(precision = 7, nullable = false)
    private String notaFiscal;

    @Column(precision = 7, nullable = false)
    private Long idCliente;

    private int parcelas;
    
    private LocalDate dataCompra;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinTable(
            name = "VENDA_ITEMVENDA",
            joinColumns = @JoinColumn(name = "ID_VENDA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ITEMVENDA")
    )
    private List<ItemVenda> itensVenda = new ArrayList<>();

    public List<ItemVenda> getItensVenda() {
        return itensVenda;
    }

    public void setItensVenda(List<ItemVenda> itensVenda) {
        this.itensVenda = itensVenda;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getData() {
        return dataCompra;
    }

    public void setData(LocalDate data) {
        this.dataCompra = data;
    }
    
    public void setId(Long id) {
        this.id = id;
    }

    public String getNotaFiscal() {
        return notaFiscal;
    }

    public void setNotaFiscal(String notaFiscal) {
        this.notaFiscal = notaFiscal;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Long idCliente) {
        this.idCliente = idCliente;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }

}
