package br.com.petshop.vo;

import br.com.petshop.enums.Servicos;
import br.com.petshop.models.Clientes;

import java.math.BigDecimal;

public class ResponseVO {
    int id;
    Servicos servico;
    BigDecimal valor;
    Clientes cliente;
    String observacao;

    public ResponseVO() {

    }

    public ResponseVO(int id, Servicos servico, BigDecimal valor, Clientes cliente, String observacao) {
        this.id = id;
        this.servico = servico;
        this.valor = valor;
        this.cliente = cliente;
        this.observacao = observacao;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Servicos getServico() {
        return servico;
    }

    public void setServico(Servicos servico) {
        this.servico = servico;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public Clientes getCliente() {
        return cliente;
    }

    public void setCliente(Clientes cliente) {
        this.cliente = cliente;
    }

    public String getObservacao() {
        return observacao;
    }
    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }
}
