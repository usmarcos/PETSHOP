package br.com.petshop.models;

import br.com.petshop.enums.EstadoAnimal;
import br.com.petshop.enums.Porte;

import java.time.LocalDate;
import java.util.List;

public  abstract class Animais{
    String nome, raca;
    LocalDate nascimento;
    Porte porte;
    double peso;
    EstadoAnimal estado;
    //alterei o nome para ficar mais claro, já que dentro do esquema tem a vacina
    List <EsquemaVacinal> esquemaVacinal;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getRaca() {
        return raca;
    }

    public void setRaca(String raca) {
        this.raca = raca;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public void setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
    }

    public Porte getPorte() {
        return porte;
    }

    public void setPorte(Porte porte) {
        this.porte = porte;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public EstadoAnimal getEstado() {
        return estado;
    }

    public void setEstado(EstadoAnimal estado) {
        this.estado = estado;
    }

    public List<EsquemaVacinal> getEsquemaVacinal() {
        return esquemaVacinal;
    }

    public void setEsquemaVacinal(List<EsquemaVacinal> esquemaVacinal) {
        this.esquemaVacinal = esquemaVacinal;
    }

    @Override
    public String toString() {
        return "\nAnimais{" +
                "nome='" + nome + '\'' +
                ", raca='" + raca + '\'' +
                ", nascimento=" + nascimento +
                ", porte=" + porte +
                ", peso=" + peso +
                ", estado=" + estado +
                ", vacinas=" + esquemaVacinal +
                '}';
    }
}
