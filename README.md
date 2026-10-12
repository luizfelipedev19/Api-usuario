API de Usuários
API REST desenvolvida com Spring Boot para gerenciamento de usuários, autenticação e autorização com JWT. Utiliza PostgreSQL para persistência, Flyway para versionamento do banco de dados e Swagger (OpenAPI) para documentação dos endpoints.
O projeto tem como objetivo aplicar boas práticas de desenvolvimento backend, segurança e arquitetura REST.
Tecnologias utilizadas
- Java 21
- Spring Boot 3
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA (Hibernate)
- PostgreSQL
- Flyway
- Swagger / OpenAPI (SpringDoc)
- Maven
Funcionalidades
- Cadastro de usuários.
- Login com autenticação JWT.
- Proteção de rotas com Spring Security.
- Autenticação stateless, sem manutenção de sessões no servidor.
- Migrações automáticas do banco de dados com Flyway.
- Documentação interativa com Swagger.
Autenticação
A API utiliza JWT para autenticar requisições aos endpoints protegidos.
Fluxo de autenticação
1. O usuário envia suas credenciais ao endpoint de login.
2. A API valida as credenciais e retorna um token JWT.
3. O cliente envia o token no cabeçalho Authorization das requisições protegidas.
Cabeçalho obrigatório
Authorization: Bearer <token_jwt>
Documentação Swagger
Após iniciar a aplicação, acesse:
Documentação Swagger
A interface permite visualizar os endpoints documentados e testar requisições.
Exemplos de endpoints
Cadastro de usuário
POST /auth/register
Corpo da requisição:
{
  "name": "Luiz Felipe",
  "email": "luiz@email.com",
  "password": "123456"
}
Exemplo de resposta:
{
  "id": 1,
  "name": "Luiz Felipe",
  "email": "luiz@email.com"
}
Login
POST /auth/login
Corpo da requisição:
{
  "email": "luiz@email.com",
  "password": "123456"
}
Exemplo de resposta:
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
