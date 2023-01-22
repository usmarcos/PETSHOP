package br.com.petshop;

import br.com.petshop.enums.EstadoAnimal;
import br.com.petshop.enums.Higiene;
import br.com.petshop.enums.Servicos;
import br.com.petshop.enums.Vacinas;
import br.com.petshop.models.*;
import br.com.petshop.vo.ResponseVO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class Petshop {

    static List<Remedio> remedioList = criarListaRemedios();
    static List<Alimento> alimentoList = criarListaAlimento();
    static List<ResponseVO> responseList = new ArrayList<>();
    String cnpj;
    Endereco endereco;
    static int contId = 1;

    public ResponseVO higienizar(Clientes cliente, List<Animais> animal, Higiene higiene, String observacao) {
        ResponseVO response = new ResponseVO();
        switch (higiene) {
            case BANHO:
                for (Animais animais : animal) {
                    animais.setEstado(EstadoAnimal.LIMPO);
                    response.setId(contId++);
                    response.setServico(Servicos.HIGIENIZAR);
                    response.setValor(BigDecimal.valueOf(35));
                    response.setCliente(cliente);
                    response.setObservacao("O pet " + animais.getNome() + " tomou banho.");
                    responseList.add(response);
                }
                break;
            case TOSA:
                for (Animais a : animal) {
                    a.setEstado(EstadoAnimal.TOSADO);
                    response.setId(contId++);
                    response.setServico(Servicos.HIGIENIZAR);
                    response.setValor(BigDecimal.valueOf(65));
                    response.setCliente(cliente);
                    response.setObservacao("O pet " + a.getNome() + " foi tosado.");
                    responseList.add(response);
                }
                break;
            case BANHO_TOSA:
                for (Animais a : animal) {
                    a.setEstado(EstadoAnimal.LIMPO_E_TOSADO);
                    response.setId(contId++);
                    response.setServico(Servicos.HIGIENIZAR);
                    response.setValor(BigDecimal.valueOf(100));
                    response.setCliente(cliente);
                    response.setObservacao("O pet " + a.getNome() + " tomou banho e foi tosado.");
                    responseList.add(response);
                }
                break;
            default:
                response.setObservacao("Solicitação inválida");
                responseList.add(response);
        }
        System.out.println(response.getObservacao());
        return response;
    }

    public ResponseVO atendimentoClinico(Clientes cliente, List<Animais> animal, String observacao) {
        ResponseVO response = new ResponseVO();
        for (Animais a : animal) {
            List<EsquemaVacinal> esquemaVacinal = a.getEsquemaVacinal();
            for (EsquemaVacinal vacinaAnimal : esquemaVacinal) {
                if (vacinaAnimal.getVacina() == null) {
                    response.setObservacao("O pet " + a.getNome() + " precisa tomar vacina " + Vacinas.VACINA_DOIS);
                } else if (vacinaAnimal.getVacina().ordinal() < Vacinas.values().length - 1) {
                    response.setObservacao("O pet " + a.getNome() + " precisa tomar vacina " + Vacinas.values()[vacinaAnimal.getVacina().ordinal() + 1]);
                }
                response.setId(contId++);
                response.setServico(Servicos.ATENDIMENTO_CLINICO);
                response.setValor(BigDecimal.valueOf(55));
                response.setCliente(cliente);
                //adiciona o objeto gerado para uma lista, para que não se perca (como se fosse o banco de dados).
                responseList.add(response);
                System.out.println("Observação do médico: " + response.getObservacao());
            }
        }
        return response;
    }

    public ResponseVO vacinacao(Clientes cliente, List<Animais> animal, List<Vacinas> vacina, String observacao) {
        ResponseVO response = new ResponseVO();
        for (int i = 0; i < animal.size(); i++) {
            List<EsquemaVacinal> novoEsquemaVacinal = new ArrayList<>(animal.get(i).getEsquemaVacinal());
            novoEsquemaVacinal.add(new EsquemaVacinal(LocalDate.now(), vacina.get(i), "O animal tomou a " + vacina.get(i) + " conforme orientação médica"));
            animal.get(i).setEsquemaVacinal(novoEsquemaVacinal);
            // animal.get(i).getEsquemaVacinal().add(new EsquemaVacinal(LocalDate.now(), vacina.get(i), "O animal tomou a " + vacina.get(i) + " conforme orientação médica"));
            response.setId(contId++);
            response.setServico(Servicos.VACINACAO);
            response.setValor(BigDecimal.valueOf(150));
            response.setCliente(cliente);
            response.setObservacao("O pet " + animal.get(i).getNome() + " tomou a " + vacina.get(i) + " conforme orientação médica");
            responseList.add(response);
        }
        return response;
    }

    public static List<Remedio> criarListaRemedios() {
        Remedio remedio1 = new Remedio(1, "Zoetis Apoquel Tratamento Dermatológico para Cães", BigDecimal.valueOf(209.90));
        Remedio remedio2 = new Remedio(2, "Nexgard Spectra De 7,6 A 15Kg Antipulgas E Carrapatos Para Cães", BigDecimal.valueOf(100.90));
        Remedio remedio3 = new Remedio(3, "Vermífugo Milbemax C - De 5kg a 25 kg", BigDecimal.valueOf(47.12));
        Remedio remedio4 = new Remedio(4, "Credeli Antipulgas e Carrapatos 225mg - 5,5 a", BigDecimal.valueOf(195.90));

        return Arrays.asList(remedio1, remedio2, remedio3, remedio4);
    }

    public static List<Alimento> criarListaAlimento() {
        Alimento alimento1 = new Alimento(1, "Ração Comida Cães 100% Natural Úmida C/ 1 Pote 535g", BigDecimal.valueOf(29.99));
        Alimento alimento2 = new Alimento(2, "Alimento PremieR Super Premium Nutrição Clínica", BigDecimal.valueOf(361.00));
        Alimento alimento3 = new Alimento(3, "Alimento Golden Premium Especial Formula", BigDecimal.valueOf(164.99));
        Alimento alimento4 = new Alimento(4, "Comida Úmida Natural A Quinta Light Para Cães Obesos 300g", BigDecimal.valueOf(74.94));

        return Arrays.asList(alimento1, alimento2, alimento3, alimento4);
    }

    public void verAlimentos() {
        alimentoList.forEach(alimento -> System.out.println(alimento));
    }

    public void verRemedios() {
        remedioList.forEach(remedio -> System.out.println(remedio));
    }

    //como o método pagamento também trata de remétidos e alimentos precisei acrescentar mais dois parâmetros para poder calcular.
    public void pagamentos(List<Integer> itens) {
        /** Havia montado com 3 lista, mas como orientação de aula fiz hardcode*/
        BigDecimal valor = BigDecimal.ZERO;
        int quantServicos = 0;
        int remedio = 0, remedio2 = 0;
        int alimento = 0, alimento2 = 0;

        if (itens.size() == 5) {
            quantServicos = itens.size() - 2;
            remedio = itens.get(2);
            alimento = itens.get(3);
        } else if (itens.size() == 8) {
            quantServicos = itens.size() - 4;
            remedio = itens.get(4);
            remedio2 = itens.get(5);
            alimento = itens.get(6);
            alimento2 = itens.get(7);

        }
        //imprimindo a nota
        System.out.println("--------------------------------------------------------");
        System.out.println("----- NOTA DE PAGAMENTO -----");
        for (int i = 0; i < quantServicos; i++) {
            System.out.println("Serviço: " + responseList.get(i).getServico() + " - Valor: R$ " + responseList.get(i).getValor() + " reais");
            //somando os valores
            valor = valor.add(responseList.get(i).getValor());
        }
        for (int i = 0; i < remedioList.size(); i++) {
            if (remedioList.get(i).getId() == remedio || remedioList.get(i).getId() == remedio2) {
                System.out.println("Remédio: " + remedioList.get(i).getNome() + " - Valor: R$ " + remedioList.get(i).getPreco() + " reais");
                //somando os valores
                valor = valor.add(remedioList.get(i).getPreco());
            }
        }
        for (int i = 0; i < alimentoList.size(); i++) {
            if (alimentoList.get(i).getId() == alimento || alimentoList.get(i).getId() == alimento2) {
                System.out.println("Alimento: " + alimentoList.get(i).getNome() + " - Valor: R$ " + alimentoList.get(i).getPreco() + " reais");
                //somando os valores
                valor = valor.add(alimentoList.get(i).getPreco());
            }
        }
        System.out.println("--------------------------------------------------------");
        System.out.println("Valor total da nota: R$ " + valor + " reais");
        System.out.println("--------------------------------------------------------");
        contId = 1;
        responseList.clear();
    }

}
