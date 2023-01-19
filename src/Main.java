import br.com.petshop.Petshop;
import br.com.petshop.enums.*;
import br.com.petshop.models.*;
import br.com.petshop.vo.ResponseVO;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * Não é necessário criar inputs, criar direto no método.
     */
    public static void main(String[] args) {
        /**Criando empregados*/
        Funcionario veterinario = new Funcionario(0, Cargo.VETERINARIO, BigDecimal.valueOf(8500.00), LocalDate.parse("2022-05-05"), null);
        Funcionario tosador = new Funcionario(1, Cargo.TOSADOR, BigDecimal.valueOf(2500.00), LocalDate.parse("2022-05-05"), null);
        Funcionario atendentes = new Funcionario(2, Cargo.RECPCIONISTA, BigDecimal.valueOf(1900.00), LocalDate.parse("2022-05-05"), null);

        Petshop petshop = new Petshop();


        /**Crie no mínimo dois cliente, com pelo menos um deles tendo mais do que um pet*/
        System.out.println("Crie no mínimo dois cliente, com pelo menos um deles tendo mais do que um pet");
        //Novo cliente
        Clientes clienteUm = new Clientes();
        clienteUm.setId(1);
        clienteUm.setNome("Juvenal");
        clienteUm.setCpf("119.115.235-58");
        clienteUm.setEmail("juvenal@teste.com");
        clienteUm.setTelefone("21-978485658");
        clienteUm.setEndereco(new Endereco("Avenida do Contorno", "Centro", "Apto 18", "36.600-000", "Bicas", "MG", "Nada", 15));
        //Novo pet
        List<Animais> petClienteUm = new ArrayList<Animais>();
        List<EsquemaVacinal> vacinaClienteUm = new ArrayList<EsquemaVacinal>();

        vacinaClienteUm.add(new EsquemaVacinal(null, null, "Nada"));
        petClienteUm.add(new Gato("Jojo", "Siamês", LocalDate.parse("2015-12-01"), Porte.PEQUENO, 8.5, EstadoAnimal.LIMPO, vacinaClienteUm));
        clienteUm.setPets(petClienteUm);

        System.out.println("Criado o cliente 1: ");

        System.out.println(clienteUm);

        //Cliente dois com dois pets
        Clientes clienteDois = new Clientes();
        clienteDois.setId(2);
        clienteUm.setNome("Joana");
        clienteUm.setCpf("003.180.584-54");
        clienteUm.setEmail("joana@teste.com");
        clienteUm.setTelefone("21-32713582");
        clienteUm.setEndereco(new Endereco("Rua Pedro Gomes", "Aratuba", "Apto 180", "26.600-000", "Paracambi", "RJ", "Próximo ao mercado", 1855));

        List<Animais> petsClienteDois = new ArrayList<Animais>();
        List<EsquemaVacinal> vacinasClienteDois = new ArrayList<EsquemaVacinal>();

        vacinasClienteDois.add(new EsquemaVacinal(LocalDate.parse("2019-10-01"), Vacinas.VACINA_TRES, "Dermatite Alérgica à Picada de Ectoparasitos"));
        petsClienteDois.add(new Cachorro("Laranja", "Dogue alemão", LocalDate.parse("2010-11-10"), Porte.GRANDE, 15.9, EstadoAnimal.SUJO, vacinaClienteUm));
        vacinasClienteDois.add(new EsquemaVacinal(LocalDate.parse("2018-01-02"), Vacinas.VACINA_QUATRO, "Hipersensibilidade Alimentar"));
        petsClienteDois.add(new Cachorro("Pipoca", "Golden retriever", LocalDate.parse("2009-05-15"), Porte.MEDIO, 12.1, EstadoAnimal.LIMPO_E_TOSADO, vacinaClienteUm));
        clienteDois.setPets(petsClienteDois);

        System.out.println("\nCriado o cliente 2: ");
        System.out.println(clienteDois);

        /** Chame o método atendimentoClinico do petshop, e faça-o retornar no campo observações o pedido do médico para o pet tomar a vacina*/
        System.out.println("\nChame o método atendimentoClinico do petshop, e faça-o retornar no campo observações o pedido do médico para o pet tomar a vacina");
        //System.out.println(clienteUm);
        //System.out.println(clienteDois);
        System.out.println("Atendimento iniciado para o cliente um (com um pet)");
        ResponseVO response;
        response = petshop.atendimentoClinico(clienteUm, petClienteUm, "Nada");
        //imprime que deve ser tomado a vacina
        System.out.println("Observação: " + response.getServico());

        /**Valide se o retorno do método atendimentoClinico possui o id do serviço, o serviço prestado, o valor e valide principalmente, se há no campo observação do animal, o pedido do médico para a vacina*/
        System.out.println("\nValide se o retorno do método atendimentoClinico possui o id do serviço, o serviço prestado, o valor e valide principalmente, se há no campo observação do animal, o pedido do médico para a vacina");
        if (response.getId() != 0 && response.getServico() == Servicos.ATENDIMENTO_CLINICO && response.getValor() != null && response.getObservacao().contains("vacina")) {
            System.out.println("Observação do médico: " + response.getObservacao());
            System.out.println("O retorno está correto: possui o id do serviço, o serviço prestado, o valor e há no campo observação o pedido do médico para a vacina");
        } else {
            System.out.println("O retorno está incorreto por não possuir um dos seguintes pontos: o id do serviço, o serviço prestado, o valor e campo observação o pedido do médico para a vacina");
        }

        /**Chame o método vacinação do pet shop, e faça o pet tomar a vacina pedido no retorno do atendimentoClinico*/
        System.out.println("\nChame o método vacinação do pet shop, e faça o pet tomar a vacina pedido no retorno do atendimentoClinico");
        List<Vacinas> vacinasSolicitadas = new ArrayList<>();
        vacinasSolicitadas.add(Vacinas.VACINA_DOIS);
        response = petshop.vacinacao(clienteUm, petClienteUm, vacinasSolicitadas, "Nada");

        /**Valide se o retorno do método vacinação possui o esquemaVacinal do pet preenchido com o vacina que foi pedida, o id, o serviço prestado e o valor*/
        System.out.println("\nValide se o retorno do método vacinação possui o esquemaVacinal do pet preenchido com o vacina que foi pedida, o id, o serviço prestado e o valor");
        if (response.getId() != 0 && response.getServico() == Servicos.VACINACAO && response.getValor() != null && response.getObservacao().contains("vacina")) {
            System.out.println("Serviço executado: " + response.getObservacao());
            System.out.println("O retorno está correto: possui o id do serviço, o serviço prestado, o valor e há no campo observação o pedido do médico para a vacina");
        } else {
            System.out.println("O retorno está incorreto por não possuir um dos seguintes pontos: o id do serviço, o serviço prestado, o valor e campo observação com a vacina tomada");
        }

        /**Chame o método higienizar do petshop, e faça-o retornar no campo estado do animal, um valor referente ao serviço prestado ex: se chamou o método apenas pedindo para dar banho, o animal deverá estar limpo no retorno do método*/
        System.out.println("\nChame o método higienizar do petshop, e faça-o retornar no campo estado do animal, um valor referente ao serviço prestado ex: se chamou o método apenas pedindo para dar banho, o animal deverá estar limpo no retorno do método");

    }
}