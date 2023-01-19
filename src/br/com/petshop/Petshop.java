package br.com.petshop;

import br.com.petshop.enums.Higiene;
import br.com.petshop.enums.Servicos;
import br.com.petshop.enums.Vacinas;
import br.com.petshop.models.*;
import br.com.petshop.vo.ResponseVO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

public class Petshop extends Pessoa {
    String cnpj;
    Endereco endereco;

    public ResponseVO higienizar(Clientes cliente, List<Animais> animal, Higiene higiene, String observacao) {
        ResponseVO response = null;
        switch (higiene) {
            case BANHO:
                response = new ResponseVO(2, Servicos.HIGIENIZAR, new BigDecimal("20"), cliente, "nada");
                break;
        }
        return response;
    }

    public ResponseVO atendimentoClinico(Clientes cliente, List<Animais> animal, String observacao) {
        ResponseVO response = new ResponseVO();

        /**Chame o método atendimentoClinico do petshop, e faça-o retornar no campo observações o pedido do médico para o pet tomar a vacina 2*/
        System.out.println("Chame o método atendimentoClinico do petshop, e faça-o retornar no campo observações o pedido do médico para o pet tomar a vacina 2");
        //retorna pro primeiro cliente que deve tomar vacina
        Vacinas esquema = null;
//        vacina.forEach(EsquemaVacinal ->
//              vacina.get(1).getVacina());
        for (int i = 0; i < animal.size(); i++) {
            //se tiver uma vacina sem a 2 ele manda tomar vacina
            if (animal.get(i).getEsquemaVacinal().get(i).getVacina() == null) {
                response.setId(cliente.getId());
                response.setServico(Servicos.ATENDIMENTO_CLINICO);
                response.setValor(BigDecimal.valueOf(55));
                response.setCliente(cliente);
                response.setObservacao("O pet " + animal.get(i).getNome() + " precisa tomar vacina 2.");
            }
        }
        return response;
    }

    public ResponseVO vacinacao(Clientes cliente, List<Animais> animal, List<Vacinas> vacina, String observacao) {
        ResponseVO response = new ResponseVO();
        for (int i = 0; i < cliente.getPets().size(); i++) {
            if (vacina.get(i).equals(Vacinas.VACINA_DOIS)){
                //varre todos os pets, na vacina verifico o esquema vacinal do pet, dentro do esquema pego a vacina e verifico se é nula, se for eu insiro a nova vacina
                //if (animal.get(i).getEsquemaVacinal().get(i).getVacina() == null) {
                animal.get(i).getEsquemaVacinal().set(i, new EsquemaVacinal(LocalDate.parse("2020-05-05"), vacina.get(i), "O animal tomou a "+vacina.get(i)+" conforme orientação médica"));
                System.out.println("Nova vacina do pet " + animal.get(i).getEsquemaVacinal());
                //gerando o serviço
                response.setId(cliente.getId());
                response.setServico(Servicos.VACINACAO);
                response.setValor(BigDecimal.valueOf(150));
                response.setCliente(cliente);
                response.setObservacao("O pet " + animal.get(i).getNome() + " tomou a "+vacina.get(i)+" conforme orientação médica");
            }
        }
        return response;
    }

    public void verAlimentos() {
    }

    public void verRemedios() {
    }

    public void pagamentos(List<Integer> itens) {

    }

}
