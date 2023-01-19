package br.com.petshop.models;

import br.com.petshop.enums.Cargo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;
import java.util.Locale;

public class Funcionario extends Pessoa{
    int id;
    Cargo cargo;
    BigDecimal salario;
    LocalDate admissao, desligamento;

     public Funcionario(int id, Cargo cargo, BigDecimal salario, LocalDate admissao, LocalDate desligamento) {
        this.id = id;
        this.cargo = cargo;
        this.salario = salario;
        this.admissao = admissao;
        this.desligamento = desligamento;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public BigDecimal getSalario() {
        return salario;
    }

    public void setSalario(BigDecimal salario) {
        this.salario = salario;
    }

    public LocalDate getAdmissao() {
        return admissao;
    }

    public void setAdmissao(LocalDate admissao) {
        this.admissao = admissao;
    }

    public LocalDate getDesligamento() {
        return desligamento;
    }

    public void setDesligamento(LocalDate desligamento) {
        this.desligamento = desligamento;
    }
}
