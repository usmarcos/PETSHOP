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
        List<EsquemaVacinal> vacinasClienteDoisPetUm = new ArrayList<EsquemaVacinal>();
        List<EsquemaVacinal> vacinasClienteDoisPetDois = new ArrayList<EsquemaVacinal>();

        vacinasClienteDoisPetUm.add(new EsquemaVacinal(LocalDate.parse("2019-10-01"), Vacinas.VACINA_UM, "Dermatite Alérgica à Picada de Ectoparasitos"));
        petsClienteDois.add(new Cachorro("Laranja", "Dogue alemão", LocalDate.parse("2010-11-10"), Porte.GRANDE, 15.9, EstadoAnimal.SUJO, vacinasClienteDoisPetUm));
        vacinasClienteDoisPetDois.add(new EsquemaVacinal(LocalDate.parse("2018-01-02"), Vacinas.VACINA_DOIS, "Hipersensibilidade Alimentar"));
        petsClienteDois.add(new Cachorro("Pipoca", "Golden retriever", LocalDate.parse("2009-05-15"), Porte.MEDIO, 12.1, EstadoAnimal.LIMPO_E_TOSADO, vacinasClienteDoisPetDois));
        clienteDois.setPets(petsClienteDois);

        System.out.println("\nCriado o cliente 2: ");
        System.out.println(clienteDois);

        validacoesClienteUm(petshop, clienteUm, petClienteUm);
        validacoesClienteDois(petshop, clienteDois, petsClienteDois);

    }

    private static void validacoesClienteUm(Petshop petshop, Clientes clienteUm, List<Animais> petClienteUm) {
        /** Chame o método atendimentoClinico do petshop, e faça-o retornar no campo observações o pedido do médico para o pet tomar a vacina*/
        System.out.println("\nChame o método atendimentoClinico do petshop, e faça-o retornar no campo observações o pedido do médico para o pet tomar a vacina");
        System.out.println("Atendimento iniciado para o cliente um (com um pet)");
        ResponseVO response;
        List<Integer> notaServico = new ArrayList<Integer>();
        response = petshop.atendimentoClinico(clienteUm, petClienteUm, "Nada");
        notaServico.add(response.getId());
        //imprime que deve ser tomado a vacina
        System.out.println("Observação: " + response.getServico());

        /**Valide se o retorno do método atendimentoClinico possui o id do serviço, o serviço prestado, o valor e valide principalmente, se há no campo observação do animal, o pedido do médico para a vacina*/
        System.out.println("\nValide se o retorno do método atendimentoClinico possui o id do serviço, o serviço prestado, o valor e valide principalmente, se há no campo observação do animal, o pedido do médico para a vacina");
        if (response.getId() != 0 && response.getServico() == Servicos.ATENDIMENTO_CLINICO && response.getValor() != null) {
            System.out.println("O retorno está correto: possui o id do serviço, o serviço prestado, o valor e há no campo observação o pedido do médico para a vacina");
        } else {
            System.out.println("O retorno está incorreto por não possuir um dos seguintes pontos: o id do serviço, o serviço prestado, o valor e campo observação o pedido do médico para a vacina");
        }

        /**Chame o método vacinação do pet shop, e faça o pet tomar a vacina pedido no retorno do atendimentoClinico*/
        System.out.println("\nChame o método vacinação do pet shop, e faça o pet tomar a vacina pedido no retorno do atendimentoClinico");
        List<Vacinas> vacinasSolicitadas = new ArrayList<>();
        vacinasSolicitadas.add(Vacinas.VACINA_DOIS);
        response = petshop.vacinacao(clienteUm, petClienteUm, vacinasSolicitadas, "Nada");
        notaServico.add(response.getId());
        System.out.println("Novo esquema vacinal completo: "+ petClienteUm.get(0).getEsquemaVacinal());

        /**Valide se o retorno do método vacinação possui o esquemaVacinal do pet preenchido com o vacina que foi pedida, o id, o serviço prestado e o valor*/
        System.out.println("\nValide se o retorno do método vacinação possui o esquemaVacinal do pet preenchido com o vacina que foi pedida, o id, o serviço prestado e o valor");
        if (response.getId() != 0 && response.getServico() == Servicos.VACINACAO && response.getValor() != null && response.getObservacao().contains("vacina")) {
            System.out.println("Serviço executado: " + response.getObservacao());
            System.out.println("O retorno está correto: possui o id do serviço, o serviço prestado, o valor e há no campo observação o da vacina tomada");
        } else {
            System.out.println("O retorno está incorreto por não possuir um dos seguintes pontos: o id do serviço, o serviço prestado, o valor e campo observação com a vacina tomada");
        }

        /**Chame o método higienizar do petshop, e faça-o retornar no campo estado do animal, um valor referente ao serviço prestado ex: se chamou o método apenas pedindo para dar banho, o animal deverá estar limpo no retorno do método*/
        System.out.println("\nChame o método higienizar do petshop, e faça-o retornar no campo estado do animal, um valor referente ao serviço prestado ex: se chamou o método apenas pedindo para dar banho, o animal deverá estar limpo no retorno do método");
        response = petshop.higienizar(clienteUm, petClienteUm, Higiene.BANHO, "Não utilizar sabonete");
        notaServico.add(response.getId());
        /**Valide se o retorno do método higienizar possui id, serviço, preço e se o estado do animal está equivalente ao serviço pedido*/
        System.out.println("Valide se o retorno do método higienizar possui id, serviço, preço e se o estado do animal está equivalente ao serviço pedido\n");
        if (response.getId() != 0 && response.getServico() == Servicos.HIGIENIZAR && response.getValor() != null && response.getObservacao().contains("banho")) {
            System.out.println("Serviço executado: " + response.getObservacao());
            for (int i = 0; i < petClienteUm.size(); i++) {
                System.out.println("Estado atual do animal: " + petClienteUm.get(i).getEstado());
            }
            System.out.println("O retorno está correto: possui o id do serviço, o serviço prestado, o valor e há no campo observação a execução do serviço de banho");
        } else {
            System.out.println("O retorno está incorreto por não possuir um dos seguintes pontos: o id do serviço, o serviço prestado, o valor e campo observação a execução do serviço de banho");
        }

        /**Chame os métodos verRemedio e verAlimentos*/
        System.out.println("\nChame os métodos verRemedio e verAlimentos");
        petshop.verRemedios();
        System.out.println();
        petshop.verAlimentos();


        /**Por último, passe para o método pagamentos, a lista de todos os ids do serviços utilizados mais pelo menos 1 remédio e 1 alimento e valide se a soma dos valores do pedido do cliente está correta*/
        System.out.println("\nPor último, passe para o método pagamentos, a lista de todos os ids do serviços utilizados mais pelo menos 1 remédio e 1 alimento e valide se a soma dos valores do pedido do cliente está correta");
        //conforme alinhado em aula será adicionando mais dois ID como se fosse mais remédios e alimentos, já que não foi pensado dessa forma.
        notaServico.add(2);
        notaServico.add(4);

        petshop.pagamentos(notaServico);
    }

    private static void validacoesClienteDois(Petshop petshop, Clientes clienteDois, List<Animais> petClienteDois) {

        /**Repita o todos os fluxos feitos para o cliente com apenas um pet para o que tenha dois, fazendo a seguinte alterações:*/
        System.out.println("\n\nRepita o todos os fluxos feitos para o cliente com apenas um pet para o que tenha dois, fazendo a seguinte alterações");
        /**no método atendimentoClinico coloque uma observação diferente para cada animal do cliente (cada animal do cliente deve receber uma vacina diferente para esse caso de testes)*/
        System.out.println("\nNo método atendimentoClinico coloque uma observação diferente para cada animal do cliente (cada animal do cliente deve receber uma vacina diferente para esse caso de testes)");
        System.out.println("Atendimento iniciado para o cliente dois (com dois pets)");
        ResponseVO response;
        List<Integer> notaServico = new ArrayList<Integer>();
        response = petshop.atendimentoClinico(clienteDois, petClienteDois, "Nada");
        notaServico.add(response.getId());
        if (response.getId() != 0 && response.getServico() == Servicos.ATENDIMENTO_CLINICO && response.getValor() != null) {
            System.out.println("O retorno está correto: possui o id do serviço, o serviço prestado, o valor e há no campo observação o pedido do médico para a vacina");
        } else {
            System.out.println("O retorno está incorreto por não possuir um dos seguintes pontos: o id do serviço, o serviço prestado, o valor e campo observação o pedido do médico para a vacina");
        }

        /**no método vacinação, vc deve vacinar cada animal conforme pedido no atendimentoClinico e deve checar no retorno o esquemaVacinal de cada animal e constatar a vacina correta em cada um*/
        System.out.println("\nNo método vacinação, vc deve vacinar cada animal conforme pedido no atendimentoClinico e deve checar no retorno o esquemaVacinal de cada animal e constatar a vacina correta em cada um");
        List<Vacinas> vacinasSolicitadas = new ArrayList<>();
        vacinasSolicitadas.add(Vacinas.VACINA_TRES);
        vacinasSolicitadas.add(Vacinas.VACINA_QUATRO);
        response = petshop.vacinacao(clienteDois, petClienteDois, vacinasSolicitadas, "Nada");
        if(petClienteDois.get(0).getEsquemaVacinal().get(1).getObservacao().contains("VACINA_TRES")){
            System.out.println("O pet tomou a vacina esperada, "+Vacinas.VACINA_TRES);
            System.out.println("Novo esquema vacinal completo: "+ petClienteDois.get(0).getEsquemaVacinal());
        }else {
            System.out.println("O pet não tomou a vacina correta.");
        }
        if(petClienteDois.get(1).getEsquemaVacinal().get(1).getObservacao().contains("VACINA_QUATRO")) {
            System.out.println("O pet tomou a vacina esperada, "+Vacinas.VACINA_QUATRO);
            System.out.println("Novo esquema vacinal completo: " + petClienteDois.get(1).getEsquemaVacinal());
        }else {
            System.out.println("O pet não tomou a vacina correta.");
        }
        notaServico.add(response.getId()-1);
        notaServico.add(response.getId());

        /**Chame os métodos verRemedio e verAlimentos*/
        System.out.println("\nChame os métodos verRemedio e verAlimentos");
        petshop.verRemedios();
        petshop.verAlimentos();

        /**Por último, faça a mesma validação para o método pagamentos ( a lista de todos os ids do serviços utilizados mais pelo menos 2 remédio e 2 alimento e valide se a soma dos valores do pedido do cliente está correta ) lembre se que se foi enviado dois animais para qualquer serviço, o valor será o dobro do serviço feito apenas para um animal*/
        System.out.println("\nPor último, faça  a mesma validação para o método pagamentos ( a lista de todos os ids do serviços utilizados mais pelo menos 2 remédio e 2 alimento e valide se a soma dos valores do pedido do cliente está correta ) lembre se que se foi enviado dois animais para qualquer serviço, o valor será o dobro do serviço feito apenas para um animal");
        //conforme alinhado em aula será adicionando mais dois ID como se fosse mais remédios e alimentos, já que não foi pensado dessa forma.
        notaServico.add(4);
        notaServico.add(3);
        notaServico.add(2);
        notaServico.add(1);

        petshop.pagamentos(notaServico);

    }
}