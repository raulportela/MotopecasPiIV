/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Motopecas.JRL.MotoPecas.entidade.cliente;

/**
 *
 * @author Luana
 */
public class CartaoDeCredito {
    
    private String bandeira;
    private String nomeTitular;
    private Integer numeroCartao;
    private int mesValdiade;
    private int ano;
    private int codSeguraca;
    private int parcelas;

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

    public Integer getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(Integer numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public int getMesValdiade() {
        return mesValdiade;
    }

    public void setMesValdiade(int mesValdiade) {
        this.mesValdiade = mesValdiade;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getCodSeguraca() {
        return codSeguraca;
    }

    public void setCodSeguraca(int codSeguraca) {
        this.codSeguraca = codSeguraca;
    }

    public int getParcelas() {
        return parcelas;
    }

    public void setParcelas(int parcelas) {
        this.parcelas = parcelas;
    }
    
    
    
    
    
}
