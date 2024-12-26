# SocialMedia

Este é um projeto desenvolvido para aprofundar o aprendizado em desenvolvimento de aplicações web utilizando Spring Boot, com foco em explorar as diferenças entre bancos de dados relacionais e NoSQL. O projeto foi desenvolvido utilizando MongoDB como banco de dados NoSQL, visando compreender as peculiaridades de sua integração com o Spring Boot.

## Objetivo

O objetivo principal deste projeto foi continuar o aprendizado no desenvolvimento de aplicações web, utilizando o Spring Boot como framework backend e experimentando um SGBD NoSQL, no caso, o MongoDB.
## Tecnologias Utilizadas

- **Java 21**
- **Spring Boot**
  - Spring Data MongoDB
  - Spring Web
- **MongoDB**
- **Maven** (como gerenciador de dependências)
- **Postman** (para testes das APIs)
- **IntelliJ IDEA** (como IDE principal)

## Estrutura do Projeto

O projeto foi estruturado com os seguintes pacotes principais:

### Pacote `domain`

- **User:** Representa os usuários da aplicação, com atributos como `id`, `name`, `email` e lista de `posts`.
- **Post:** Representa as postagens feitas pelos usuários, contendo atributos como `id`, `title`, `date`, `body`, `author` (um `AuthorDTO`) e lista de `comments`.

### Pacote `dto`

- **UserDTO:** Objeto de transferência de dados para representar usuários sem expor detalhes internos.
- **AuthorDTO:** Utilizado para representar autores em `Post` e `CommentDTO`.
- **CommentDTO:** Representa comentários associados a postagens, contendo autor, data e texto do comentário.

### Pacote `repository`

Contém interfaces para acesso aos dados, utilizando `MongoRepository` para interação com o banco MongoDB:
- `UserRepository`
- `PostRepository`

### Pacote `service`

Contém as regras de negócio da aplicação:
- **UserService:** Responsável por operações relacionadas a usuários (CRUD, conversão de DTO para entidade, etc.).
- **PostService:** Responsável por operações relacionadas a postagens (busca por título, busca completa, etc.).

### Pacote `resource`

Contém os controladores REST para expor as APIs:
- **UserResource:** Disponibiliza endpoints para CRUD de usuários e listagem de posts de um usuário específico.
- **PostResource:** Disponibiliza endpoints para busca de postagens por ID, título e critérios de busca avançados.

### Pacote `config`

- **Instantiation:** Classe responsável por popular o banco de dados MongoDB com dados iniciais para testes e validações.

### Pacote `resources.exception`

Gerencia o tratamento de exceções personalizadas:
- **ResourceExceptionHandler:** Captura exceções como `ObjectNotFoundException` e retorna respostas apropriadas para o cliente.
- **StandardError:** Modelo padrão de resposta de erro.

### Pacote `service.exception`

- **ObjectNotFoundException:** Exceção personalizada para lidar com objetos não encontrados.

## Funcionalidades

- CRUD completo de usuários.
- Associação de postagens a usuários.
- Busca de postagens por:
  - Título.
  - Termos em corpo e título, com filtros de datas (busca completa).

## Endpoints

### Usuários

- **GET /users**: Retorna todos os usuários.
- **GET /users/{id}**: Retorna um usuário específico por ID.
- **POST /users**: Insere um novo usuário.
- **PUT /users/{id}**: Atualiza os dados de um usuário existente.
- **DELETE /users/{id}**: Remove um usuário por ID.
- **GET /users/{id}/posts**: Retorna todas as postagens de um usuário específico.

### Postagens

- **GET /posts/{id}**: Retorna uma postagem específica por ID.
- **GET /posts/titlesearch?text=**: Retorna postagens cujo título contém o texto informado.
- **GET /posts/fullsearch?text=&minDate=&maxDate=**: Realiza uma busca completa por postagens com base em texto e intervalos de data.

## Instanciação Inicial

A classe `Instantiation` popula o banco de dados com:
- Usuários fictícios (Maria Brown, Alex Green, Bob Grey).
- Postagens associadas a Maria, com comentários feitos por Alex e Bob.


