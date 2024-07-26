# Quarkus Task API

O **Quarkus Task API** é um serviço backend desenvolvido com o framework Quarkus. Ele fornece uma API RESTful para gerenciar tarefas, permitindo operações como criar, ler, atualizar e deletar tarefas. Este serviço é projetado para ser altamente performático e eficiente, aproveitando as capacidades nativas do Quarkus para execução rápida e baixo consumo de memória.

## Funcionalidades

- **Criação de Tarefas**: Permite a criação de novas tarefas com detalhes como título, descrição e status.
- **Leitura de Tarefas**: Recupera a lista de todas as tarefas ou uma tarefa específica por ID.
- **Atualização de Tarefas**: Atualiza os detalhes de uma tarefa existente.
- **Deleção de Tarefas**: Remove uma tarefa do sistema.

## Tecnologias Utilizadas

- **Quarkus**: Framework Java nativo para Kubernetes, otimizado para GraalVM e OpenJDK HotSpot.
- **RESTEasy**: Implementação JAX-RS para criar serviços RESTful.
- **Hibernate ORM**: Framework de mapeamento objeto-relacional para persistência de dados.

## Como Executar

### Backend (Quarkus Task API)

1. Navegue até o diretório do projeto backend.
2. Execute o comando `./mvnw quarkus:dev` para iniciar o servidor de desenvolvimento.

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.

---

# Todo App

O **Todo App** é uma aplicação frontend que consome a API do Quarkus Task API. Ele fornece uma interface de usuário intuitiva para gerenciar tarefas, permitindo que os usuários interajam com o backend de forma fácil e eficiente.

## Funcionalidades

- **Interface de Usuário**: Interface amigável para criar, visualizar, atualizar e deletar tarefas.
- **Integração com API**: Comunicação com o Quarkus Task API para realizar operações CRUD.
- **Gerenciamento de Estado**: Mantém o estado das tarefas no frontend para uma experiência de usuário fluida.

## Tecnologias Utilizadas

- **React**: Biblioteca JavaScript para construção de interfaces de usuário.
- **Axios**: Biblioteca para fazer requisições HTTP.
- **Redux**: Biblioteca para gerenciamento de estado.

## Como Executar

### Frontend (Todo App)

1. Navegue até o diretório do projeto frontend.
2. Execute o comando `npm install` para instalar as dependências.
3. Execute o comando `npm start` para iniciar o servidor de desenvolvimento.

   ## Documentação Interna

- [Documentação do Backend](quarkus-task-api/README.md)
- [Documentação do Frontend](todo-app/README.md)

## Contribuição

Contribuições são bem-vindas! Sinta-se à vontade para abrir issues e pull requests.

## Licença

Este projeto está licenciado sob a licença MIT. Consulte o arquivo `LICENSE` para mais detalhes.
