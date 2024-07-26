# Quarkus Task API

Este projeto utiliza o Quarkus, o Supersônico Subatômico Framework Java.

## Introdução

A Quarkus Task API é uma aplicação RESTful para gerenciar tarefas. Ela permite criar, atualizar, listar e deletar tarefas. A aplicação utiliza Quarkus, Hibernate ORM, e PostgreSQL.

## Configuração do Ambiente de Desenvolvimento

### Pré-requisitos

- JDK 11+
- Maven 3.6.3+
- Docker

### Executando o Banco de Dados de Desenvolvimento com Docker

Para executar o banco de dados de desenvolvimento localmente, utilize o seguinte comando Docker:

```sh
docker run -it --name task-dev -p 5433:5432 -e POSTGRES_DB=task-dev -e POSTGRES_USER=task-dev -e POSTGRES_PASSWORD=task-dev -d postgres:12
```

### Executando a Aplicação em Modo de Desenvolvimento

Para executar a aplicação em modo de desenvolvimento, que permite live coding, utilize:

```sh
./mvnw quarkus:dev
```

## Empacotando e Executando a Aplicação

### Executando o Banco de Dados Localmente com Docker

Para executar o banco de dados localmente, utilize o seguinte comando Docker:

```sh
docker run -it --name task-db -p 5432:5432 -e POSTGRES_DB=task -e POSTGRES_USER=task -e POSTGRES_PASSWORD=task -d postgres:12
```

### Empacotando a Aplicação

Para empacotar a aplicação, utilize:

```sh
./mvnw package
```

Isso produzirá o arquivo executável `quarkus-task-api-1.0.1-runner.jar` no diretório `/target` com as dependências copiadas para o diretório `target/lib`.

### Executando a Aplicação Empacotada

A aplicação pode ser executada utilizando:

```sh
java -jar target/quarkus-task-api-1.0.1-runner.jar
```

### Criando um `uber-jar`

Para criar um `uber-jar`, utilize:

```sh
./mvnw clean package -Dquarkus.package.uber-jar=true
```

## Criando um Executável Nativo

Você pode criar um executável nativo utilizando:

```sh
./mvnw package -Pnative
```

Ou você pode utilizar Docker para construir o executável nativo utilizando:

```sh
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

Você pode então executar o binário:

```sh
./target/quarkus-task-api-1.0.1-runner
```

Para mais informações sobre como construir executáveis nativos, consulte [Building a Native Executable](https://quarkus.io/guides/building-native-image-guide).