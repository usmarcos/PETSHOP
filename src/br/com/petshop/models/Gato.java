package br.com.petshop.models;

import br.com.petshop.enums.EstadoAnimal;
import br.com.petshop.enums.Porte;

import java.time.LocalDate;
import java.util.List;

public class Gato extends Animais{
    String tipo = "Gato";
    public Gato() {

    }

    public Gato(String nome, String raca, LocalDate nascimento, Porte porte, double peso, EstadoAnimal estado, List<EsquemaVacinal> vacinas) {
        this.nome = nome;
        this.raca = raca;
        this.nascimento = nascimento;
        this.porte = porte;
        this.peso = peso;
        this.estado = estado;
        this.esquemaVacinal = vacinas;
    }

    public String getTipo() {
        return tipo;
    }
}
