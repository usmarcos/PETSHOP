package br.com.petshop.utils;

import br.com.petshop.models.Alimento;
import br.com.petshop.models.Remedio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class CriarListas {

    public List<Remedio> criarListaRemedios() {
        List<Remedio> remedios = new ArrayList<>();
        remedios.add(new Remedio(1, "Zoetis Apoquel Tratamento Dermatológico para Cães", BigDecimal.valueOf(209.90)));
        remedios.add(new Remedio(2, "Nexgard Spectra De 7,6 A 15Kg Antipulgas E Carrapatos Para Cães", BigDecimal.valueOf(100.90)));
        remedios.add(new Remedio(3, "Vermífugo Milbemax C - De 5kg a 25 kg", BigDecimal.valueOf(47,12)));
        remedios.add(new Remedio(4, "Credeli Antipulgas e Carrapatos 225mg - 5,5 a", BigDecimal.valueOf(195,90)));
        return remedios;
    }
    public void imprimirRemedios(){
        List <Remedio> remedios = criarListaRemedios();
        System.out.println(remedios);
    }

    public List<Alimento> criarAlimentos() {
        List<Alimento> alimentos = new ArrayList<>();
        alimentos.add(new Alimento(1, "Ração Comida Cães 100% Natural Úmida C/ 1 Pote 535g", BigDecimal.valueOf(29.99)));
        alimentos.add(new Alimento(2, "Alimento PremieR Super Premium Nutrição Clínica", BigDecimal.valueOf(361.00)));
        alimentos.add(new Alimento(3, "Ração Úmida Pet Delícia Papinha De Frango Cães Filhotes 320g", BigDecimal.valueOf(25.96)));
        alimentos.add(new Alimento(4, "Alimento Golden Premium Especial Formula", BigDecimal.valueOf(164.99)));
        alimentos.add(new Alimento(5, "Comida Úmida Natural A Quinta Light Para Cães Obesos 300g", BigDecimal.valueOf(74.94)));
        return alimentos;
    }
    public void imprimirAlimentos(){
        List <Alimento> alimentos = criarAlimentos();
        System.out.println(alimentos);
    }
}
