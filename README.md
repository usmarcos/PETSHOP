# PETSHOP
<p>Petshop 947  

<p>Registros:
<p>Veterinário
<p>Cliente Animal (dentro da classe colocar o dono)
<p>Tosador
<p>Atendentes
<p>Produtos e serviços
<p>ResponseVO higienizar(Cliente cliente, List<Animal> animais, Higiene higiene, String observacao); // retornar o id do servico, o nome dele, o valor e a classe cliente
<p>ResponseVO atendimentoClinico(Cliente cliente, List<Animal> animais, String observacao); // retornar resultado do atendimento no campo Observação do próprio animal além do id do servico, o nome dele, o valor e a classe cliente
<p>ResponseVO vacinacao(Cliente cliente, List<Animal> animais, List<Vacinas> vacina, String observacao) //Só pode receber uma vacina por animal e deve retornar o id do servico, o nome dele, o valor e a classe cliente
<p>void verRemedios() //imprimir todos os itens de remédios
<p>void verAlimentos() //imprimir todos os itens de alimentos
<p>Centro financeiro
<p>void pagamento(List<int> itens) //Imprime a nota fiscal, dar um sout no valor total da compra 


<p>Main -> será a nossa classe de testes

<p>Projeto final:
<p>	Após ter construído o nosso projeto se baseando no diagrama de classe feito em aula, é hora de testá-lo, na sua classe main, que aqui, utilizaremos ela para validar os retornos dos métodos, faça o seguinte:
<p>Crie o objeto Petshop
<p>Crie no mínimo dois cliente, com pelo menos um deles tendo mais do que um pet
<p>Testes com o cliente que tem apenas um pet:
<p>Chame o método atendimentoClinico do petshop, e faça-o retornar no campo observações o pedido do médico para o pet tomar a vacina X
<p>Valide se o retorno do método atendimentoClinico possui o id do serviço, o serviço prestado, o valor e valide principalmente, se há no campo observação do animal, o pedido do médico para a vacina
<p>Chame o método vacinação do pet shop, e faça o pet tomar a vacina pedido no retorno do atendimentoClinico
<p>Valide se o retorno do método vacinação possui o esquemaVacinal do pet preenchido com o vacina que foi pedida, o id, o serviço prestado e o valor 
<p>Chame o método higienizar do petshop, e faça-o retornar no campo estado do animal, um valor referente ao serviço prestado ex: se chamou o método apenas pedindo para dar banho, o animal deverá estar limpo no retorno do método
<p>Valide se o retorno do método higienizar possui id, serviço, preço e se o estado do animal está equivalente ao serviço pedido
<p>Chame os métodos verRemedio e verAlimentos
<p>Por último, passe para o método pagamentos, a lista de todos os ids do serviços utilizados mais pelo menos 1 remédio e 1 alimento e valide se a soma dos valores do pedido do cliente está correta

<p>Testes com o cliente que tem dois ou mais pets:
<p>repita o todos os fluxos feitos para o cliente com apenas um pet para o que tenha dois, fazendo a seguinte alterações:
<p>no método atendimentoClinico coloque uma observação diferente para cada animal do cliente (cada animal do cliente deve receber uma vacina diferente para esse caso de testes)
<p>no método vacinação, vc deve vacinar cada animal conforme pedido no atendimentoClinico e deve checar no retorno o esquemaVacinal de cada animal e constatar a vacina correta em cada um
<p>Chame os métodos verRemedio e verAlimentos
<p>Por último, faça  a mesma validação para o método pagamentos ( a lista de todos os ids do serviços utilizados mais pelo menos 2 remédio e 2 alimento e valide se a soma dos valores do pedido do cliente está correta ) lembre se que se foi enviado dois animais para qualquer serviço, o valor será o dobro do serviço feito apenas para um animal

<p>Problemas: 
<p>criação de listas dos produtos remedio e alimentos
<p>padronização dos ids preços 
