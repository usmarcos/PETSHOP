package br.com.petshop.models;

import br.com.petshop.enums.Vacinas;

import java.time.LocalDate;

public class EsquemaVacinal{
    LocalDate data;
    Vacinas vacina;
    String observacao;

    public EsquemaVacinal() {
    }

    public EsquemaVacinal(LocalDate data, Vacinas vacina, String observacao) {
        this.data = data;
        this.vacina = vacina;
        this.observacao = observacao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public Vacinas getVacina() {
        return vacina;
    }

    public void setVacina(Vacinas vacina) {
        this.vacina = vacina;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    @Override
    public String toString() {
        return "\nEsquemaVacinal{" +
                "data=" + data +
                ", vacina=" + vacina +
                ", observacao='" + observacao + '\'' +
                '}';
    }
}
