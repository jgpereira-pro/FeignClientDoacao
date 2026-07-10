# 🤝 Microsserviço de Doações (Spring Boot & OpenFeign)

## 💻 Sobre o Projeto
Esta é uma API RESTful desenvolvida em **Java com Spring Boot**, construída sob a ótica da **Arquitetura de Microsserviços**. O escopo principal da aplicação é o gerenciamento de Doações, mas o seu grande diferencial técnico é a comunicação síncrona com outros microsserviços.

Para resolver a necessidade de buscar os dados do "Doador" (que residem em outro serviço/API), o projeto implementa o **Spring Cloud OpenFeign**. O Feign Client permite a criação de clientes HTTP declarativos, abstraindo a complexidade de fazer requisições manuais e tornando o código muito mais limpo e legível.

## 🚀 Tecnologias Utilizadas
* **Java** - Linguagem base.
* **Spring Boot** - Framework para criação ágil do microsserviço.
* **Spring Cloud OpenFeign** - Para comunicação síncrona declarativa entre microsserviços.
* **Spring Data JPA** - Para persistência de dados no banco de dados relacional.
* **Maven** - Para gerenciamento de dependências e *build*.

## 🛠️ Funcionalidades
* **Gestão de Doações:** Endpoints REST para criação, listagem e controle de doações (`DoacaoController`).
* **Comunicação Inter-serviços:** Consumo automatizado da API externa de Doadores utilizando a interface `DoadorClient`.
* **Mapeamento de Dados Externos:** Conversão automática das respostas da API externa em DTOs internos (`DoadorResponseDTO`, `DoadorRequestDTO`).
* **Persistência Segura:** Uso do `DoacaoRepository` para salvar as informações de forma isolada, respeitando os limites do domínio de Doação.

## ⚙️ Arquitetura e Estrutura de Pastas
O projeto aplica o padrão de separação em camadas (N-Tier) com forte uso do padrão DTO:

* `/client/DoadorClient.java`: Interface declarativa do Feign para realizar requisições HTTP ao microsserviço de Doadores.
* `/controller/DoacaoController.java`: Exposição da API REST para os clientes consumirem as operações de doação.
* `/dto/doacao/` e `/dto/doador/`: Objetos de transferência (*Data Transfer Objects*) separando estritamente os dados que entram (`RequestDTO`) e os que saem (`ResponseDTO`).
* `/entity/Doacao.java`: O modelo de domínio e entidade mapeada para o banco de dados.
* `/service/DoacaoService.java`: Camada de regras de negócio, que orquestra as chamadas ao repositório local e ao `DoadorClient`.
* `/repository/DoacaoRepository.java`: Interface de acesso ao banco de dados estendendo o JPA.

## 🏁 Como Executar o Projeto

**Pré-requisitos:** [Java Development Kit (JDK 17+)](https://adoptium.net/) instalado. É necessário também que a API de Doadores (consumida pelo Feign) esteja no ar para testes completos de integração.

1.Clone o repositório:

git clone [https://github.com/SEU-USUARIO/](https://github.com/SEU-USUARIO/)[NOME-DO-REPOSITORIO].git

2.Acesse a pasta do projeto:

cd [NOME-DO-REPOSITORIO]

3.Execute a aplicação utilizando o Maven Wrapper:

No Linux/macOS:
./mvnw spring-boot:run

No Windows:
mvnw.cmd spring-boot:run
