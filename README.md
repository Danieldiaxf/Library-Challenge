📚 **Library API — Sistema de Gerenciamento de Biblioteca**

API desenvolvida em Java + Spring Boot, estruturada para gerenciar Authors, Books e Publishers com operações completas de CRUD e arquitetura organizada.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**1. Visão Geral do Projeto**

Sistema REST que implementa o gerenciamento básico de uma biblioteca, permitindo cadastro, consulta, atualização e remoção de livros, autores e editoras.

O objetivo da API é fornecer uma base sólida para estudos de arquitetura, boas práticas e organização de código, seguindo padrões profissionais utilizados na indústria.

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**2. Arquitetura e Design**

A API é estruturada seguindo princípios de separação de responsabilidades, garantindo clareza, organização e extensibilidade.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

📦 Estrutura de Pacotes
entities/

Contém os modelos principais da aplicação (Book, Author, Publisher)
Cada classe utiliza anotações de validação e mapeamento JPA.

controllers/

Expõe os endpoints REST.
Responsáveis por receber solicitações HTTP e interagir com os repositórios.

repositories/

Interfaces JPA com comunicação direta ao banco de dados.

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**3. Stack Tecnológica**

| Categoria                   | Tecnologia                  | Justificativa                                                |
| --------------------------- | --------------------------- | ------------------------------------------------------------ |
| **Framework Base**          | Spring Boot 3 / Java 17     | Produtividade, robustez e convenções modernas.               |
| **Persistência**            | Spring Data JPA / Hibernate | Simplificação no acesso aos dados e suporte completo ao ORM. |
| **Banco de Dados**          | H2 / PostgreSQL             | H2 para testes rápidos; PostgreSQL para produção/estudos.    |
| **Validações**              | Jakarta Validation          | Garantia da integridade dos dados da API.                    |
| **Documentação (Opcional)** | Springdoc / Swagger UI      | Facilita visualização dos endpoints.                         |
| **Utilitários**             | Lombok (opcional)           | Redução de código boilerplate.                               |

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**4. Funcionalidades**

✅ Authors

Cadastro de autores

Listagem geral

Atualização parcial

Exclusão por ID

✅ Books

Registro de livros com nome, ano e ISBN

Associação opcional a uma editora

Atualização

Remoção por ID

Consulta geral

✅ Publishers

Cadastro de editoras

Listagem total

Atualização de dados

Exclusão por ID

-------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**5. Endpoints Principais**

| Entidade      | Método | Rota                | Função         |
| ------------- | ------ | ------------------- | -------------- |
| **Author**    | POST   | `/api/author`       | Salvar autor   |
|               | GET    | `/api/author`       | Listar todos   |
|               | DELETE | `/api/author/{id}`  | Deletar        |
|               | PUT    | `/api/author/{id}`  | Atualizar      |
| **Book**      | POST   | `/api/library`      | Salvar livro   |
|               | GET    | `/api/library`      | Listar todos   |
|               | DELETE | `/api/library/{id}` | Deletar        |
|               | PUT    | `/api/library/{id}` | Atualizar      |
| **Publisher** | POST   | `/api/Library`      | Salvar editora |
|               | GET    | `/api/Library`      | Listar todas   |
|               | DELETE | `/api/Library/{id}` | Deletar        |
|               | PUT    | `/api/Library/{id}` | Atualizar      |


------------------------------------------------------------------------------------------------------------------------------------------------------------------------


**6. Como Executar**

# Clonar o projeto
git clone <link-do-repositorio>

# Entrar na pasta
cd library-api

# Rodar o projeto
mvn spring-boot:run,

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**7. Melhorias Futuras**

Adicionar autenticação e controle de acesso

Documentação via Swagger

DTOs com MapStruct

Tratamento global de exceções (ExceptionHandler)

Paginação, filtros e ordenação

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**8. Pontos Fortes do Projeto**

Arquitetura limpa e alinhada ao padrão Spring

Código enxuto, legível e organizado

Fácil de manter e escalar

Responsabilidade bem distribuída por camadas

Ideal para portfolio profissional

------------------------------------------------------------------------------------------------------------------------------------------------------------------------

**9. Autores**

 - Daniel Dias.
 - João Guilherme.
 - José Gabriel.
 - Miguel Ferreira.
