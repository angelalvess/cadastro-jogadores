<h1 align="center">
  Desafio Cadastro Jogadores
</h1>

Esse projeto demonstra a resolução desse [desafio](https://github.com/uolhost/test-backEnd-Java.git) que propõe a criação de um sistema de cadastro de jogadores.

## Tecnologias

- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Web](https://docs.spring.io/spring-framework/reference/web.html)
- [Jdbc Client](https://docs.spring.io/spring-boot/reference/data/sql.html#data.sql.jdbc-client)
- [Rest Client](https://docs.spring.io/spring-framework/reference/integration/rest-clients.html#rest-restclient)
- [Thymeleaf](https://docs.spring.io/spring-framework/reference/web/webmvc-view/mvc-thymeleaf.html)
- [Spring Tests](https://docs.spring.io/spring-framework/reference/testing.html)

## Funcionalidades

- [x] Cadastro de Jogador
- [x] Listagem de Jogador
- [x] Tela de Cadastro e Listagem
- [x] Validações e Tratamento de Exceções 
- [x] Teste de Integração

## Arquitetura

O projeto foi elaborado seguindo a arquitetura sugerida no desafio, conforme imagem abaixo:

![image](https://github.com/user-attachments/assets/96418ee5-0f84-45ea-92bd-42804b17a312)


Algumas mudanças poderiam melhorar ainda mais a arquitetura do projeto atual:

- [ ] Cache dos codinomes em uso (Redis)
- [ ] Frontend Apartado do Backend
- [ ] Ferramenta de Banco de Dados Corporativa
- [ ] Carregar codinomes das fontes externas
- [ ] Funcionalidades de Editar e Remover
- [ ] Suites de Teste

## Como executar

- Clonar repositório git:
```
git clone https://github.com/angelalvess/cadastro-jogadores.git
```
- Construir o projeto:
```
./mvnw clean package
```
- Executar:
```
java -jar ./target/desafio-cadastro-jogadores-0.0.1-SNAPSHOT.jar
```

A tela inicial pode ser acessada em `http://localhost:8080/cadastro-jogador`.****
