package br.com.petshop.models;

import java.util.List;

public class Clientes extends Pessoa{
    int id;
    List <Animais> pets;

    public Clientes() {
    }

    public Clientes(int id, List<Animais> pets) {
        this.id = id;
        this.pets = pets;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Animais> getPets() {
        return pets;
    }

    public void setPets(List<Animais> pets) {
        this.pets = pets;
    }

    @Override
    public String toString() {
        return "Clientes{" +
                "id=" + id +
                ", pets=" + pets +
                ", \nnome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", email='" + email + '\'' +
                ", telefone='" + telefone + '\'' +
                ", endereco=" + endereco +
                '}';
    }
}
