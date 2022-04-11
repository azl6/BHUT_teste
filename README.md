![spring](https://user-images.githubusercontent.com/80921933/162512277-0f7d51a7-ecbb-4187-95b8-99837e309c0b.png)
# Teste técnico - BHUT

>Status: Finalizado ✔️

## Tecnologias usadas:

+ Java 11
+ Spring Framework
+ Bean Validation
+ Docker
+ MySQL
+ Prometheus 
+ Grafana
+ Junit

## Como rodar a aplicação?

+ 1- Clone o projeto para o diretório desejado
+ 2- Abra um terminal (git bash, de preferência) na raiz do projeto
+ 3- Execute os seguintes comandos:
```
mvn clean install
mvn clean package
docker-compose up -d
```

+ 4- Rode a aplicação com o IntelliJ
+ 5- Acesse os endpoints da aplicação, via `localhost:8080/api/{endpointDesejado}`

## Acesso a tabela log

Como o ambiente da aplicação sobe via docker-compose, o MySQL é um contêiner, e para acessar a tabela `log`, deve-se executar os seguintes comandos:

<b>IMPORTANTE:</b> Caso esteja utilizando o Git Bash, substitua o primeiro comando por `winpty docker exec -it mysql mysql -uroot -proot`
```
docker exec -it mysql mysql -uroot -proot
use teste_bhut;
select * from log;
```
![tabelalog](https://user-images.githubusercontent.com/80921933/162645502-2ceb6a57-1bd6-48d9-a493-9fa6e6de5a00.png)


## Features

+ <b>Validações de entrada:</b> Ao tentar realizar uma entrada com dados inválidos ou incompletos, o projeto retorna, precisamente, onde está o problema, por meio de uma lista de exceções personalizadas.

![exceptions](https://user-images.githubusercontent.com/80921933/162630779-51abab25-eb3a-470d-8a22-fb3afeb2f714.png)

+ <b>Utilização do @Transactional:</b> A utilização do `@Transactional` é de suma importância em casos onde, por alguma regra de negócio, a transação do banco de dados não deve ser finalizada. A anotação é responsável pela execução do rollback, e evita a inserção/atualização/deleção de dados que, a priori, não deveriam ser modificados quando o fluxo de dados é interrompido.

![transactional](https://user-images.githubusercontent.com/80921933/162644227-60b4b0b0-098e-4127-9c7f-91e8d9202c22.png)

+ <b>Subindo o ambiente via docker-compose:</b> Todo o ambiente da aplicação sobe via docker-compose. Pode-se, também, subir o app inteiro, fato que facilita o deploy em produção. Além disso, são disponibilizadas portas para aplicações de observabilidade, como:

  `localhost:3000` - Grafana <br>
  `localhost:9090` - Prometheus
  
+ <b>Testes unitários:</b> A fim de exemplificar a importância dos testes unitários, fiz um exemplo simples, de modo a garantir a integridade da função.

![testesunitarios](https://user-images.githubusercontent.com/80921933/162644744-a7113518-0e12-4ca2-892a-fbb413c56655.png)

+ <b>Ferramentas de observabilidade:</b> O Grafana é uma ferramenta que, com o auxílio do Prometheus, gera dados importantes para verificarmos a saúde da nossa API. Por meio dela, podemos verificar, por exemplo, quantos erros foram gerados em um determinado endpoint, e, dessa forma, facilitar a vida do programador na busca por erros, ou até mesmo a otimizar endpoints falhos.

![grafana](https://user-images.githubusercontent.com/80921933/162645200-dbff2fc7-2326-41cc-8113-4a31310ee62f.png)

## Pontos a melhorar

+ Por algum motivo, não consegui receber o id gerado no MongoDB da BHUT em minha resposta do POST. Desta forma, a tabela `log` fica com as colunas "null". Tentei outras alternativas para realizar a requisição, como o Spring Webflux, mas, infelizmente, não consegui resolver esse problema.
+ Os testes podem ser mais abrangentes, para garantir a qualidade do código como um todo.
