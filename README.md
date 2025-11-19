📚 **Library Management API**

Um sistema moderno para gerenciamento de editoras dentro de uma biblioteca. Construído com Spring Boot, seguindo boas práticas de arquitetura, organização e padronização REST — ideal para escalabilidade, manutenção e uso profissional.


🎯 **Objetivo do Projeto**

Este sistema fornece um conjunto de endpoints REST para realizar operações de CRUD de Editoras (Publishers), permitindo que bibliotecas integrem, registrem e administrem seus fornecedores de livros de maneira eficiente.


🧩 **Principais Funcionalidades**

📥 Criar uma nova editora

📄 Listar todas as editoras

✏️ Atualizar uma editora existente

🗑️ Deletar uma editora pelo ID

🔒 Validação com anotações @NonNull / @Nonnull

🧹 Padrões REST limpos e organizados

🗂️ Separação clara entre Controller, Repository e Entity


🧱 **Arquitetura da Aplicação**

O projeto segue uma estrutura limpa e escalável:

src/main/java
 └── com
     ├── controllers
     │     └── PublisherController.java
     ├── entities
     │     └── Publisher.java
     └── repositories
           └── PublisherRepository.java
           

🔌 **Endpoints da API**
▶️ Base URL
/api/Library

📥 Criar Editora
POST /api/Library
Recebe um JSON de Publisher
Valida com @NonNull

📄 Listar Editoras
GET /api/Library

✏️ Atualizar Editora
PUT /api/Library/{id}
Atualiza name, address, cnpj e phone.

🗑️ Deletar Editora
DELETE /api/Library/{id}
Remove uma editora com base no seu identificador único (id).


🏗️ **Tecnologias Utilizadas**

☕ Java 17+

🌱 Spring Boot

🏛️ Spring Data JPA

💾 Hibernate

🗄️ Banco relacional (MySQL)


🛠️ **Como Rodar o Projeto**
1️⃣ Clonar o repositório
git clone https://github.com/seu-usuario/seu-repositorio.git

2️⃣ Entrar no diretório
cd seu-repositorio

3️⃣ Executar

Via terminal:

./mvnw spring-boot:run

Ou

Via IDE (IntelliJ / VSCode / Eclipse)


🧪 **Testando a API**

Você pode utilizar ferramentas como:

🔍 Postman

⚡ Thunder Client

🌐 Insomnia

Ou acessar diretamente via navegador quando for GET.


📦 **Modelo Publisher**
Campo	       Tipo	             Exemplo
id	         Long	                1
name	      String	       "Penguin Books"
address	    String	        "Rua A, 123"
cnpj	      String	     "12.345.678/0001-90"
phone	      String	      "(11) 99999-9999"


🚀 **Pontos Fortes do Projeto**

Arquitetura limpa e alinhada ao padrão Spring

Código enxuto, legível e organizado

Fácil de manter e escalar

Responsabilidade bem distribuída por camadas

Ideal para portfolio profissional

📌 **Possíveis Melhorias Futuras**

✔️ Implementar DTOs para desacoplar entidades da API

✔️ Adicionar validação com @Valid e Bean Validation

✔️ Implementar Swagger/OpenAPI

✔️ Criar autenticação JWT

✔️ Adicionar testes unitários e de integração

✔️ Criar relacionamento: Publisher → Books


🧑‍💻 **Autores**
Daniel Dias;
João Guilhereme;
José Gabriel;
Miguel Ferreira;

