# Sonda em Marte
Projeto para movimentação de uma sonda em marte.

## Considerações e Suposições
Primeiro modelo na qual tentei introduzir foi o de que uma terceira classe fosse responsável por "orquestrar" as
sondas em marte, dizendo quando elas deveriam se movimentar.

Após perceber que isso infringia o encapsulamento e o princípio "Tell, Don't Ask", decidi adotar outro modelo.

Para que fosse possível criar a situação de colisão dentro de marte foi necessário que marte
recebesse o comando de movimento e rotação das sondas.

Marte deve descobrir qual a próxima posição a sonda estará para determinar se a colisão pode acontecer, alterando a posição somente se não puder acontecer.
A Rosa dos Ventos é um Enum pois não deve mudar e deve conhecer seus lados irmãos (possibilitando adição de outros ventos mais precisos, caso seja necessário)

Sondas devem ter nomes, assim como no caso das [primeiras sondas](https://www.nasa.gov/centers/jpl/education/spaceprobe-20100225.html) da União Soviética e Estados Unidos (ex: Sputnik 1, Explorer 1, etc.)

A abstração do controller foi de Planeta, facilitando o cadastro do recurso marte.

Ao tentar modificar um recurso que não esteja relacionado a marte deve retornar erro.

Marte deve ser obrigatóriamente criado antes das Sondas.

Não foi considerado concorrência ao alterar o estado de marte.

## Instalando e Executando o Projeto

### Pré-requisitos
* OpenJDK/OracleJDK 1.8+
* Apache Maven 3.6+

### Compilando e Executando
Para compilar o projeto, basta executar o seguinte comando na raiz:  
`mvn clean install` 

Para executar o projeto, basta executar o seguinte comando na raiz:  
`java -jar target/SondaMarte-1.0.0.jar`
