# 📌 API de Usuários

API REST desenvolvida com **Spring Boot** para gerenciamento de usuários, autenticação e autorização utilizando **JWT**, com persistência em **PostgreSQL**, versionamento de banco via **Flyway** e documentação automática com **Swagger (OpenAPI)**.

Este projeto tem como objetivo aplicar boas práticas de backend, segurança, arquitetura REST e preparação para ambientes reais.

---

## 🚀 Tecnologias Utilizadas

- Java 21
- Spring Boot 3
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA (Hibernate)
- PostgreSQL
- Flyway
- Swagger / OpenAPI (SpringDoc)
- Maven

---

## 📂 Funcionalidades

- ✅ Cadastro de usuários
- ✅ Login com autenticação JWT
- ✅ Proteção de rotas com Spring Security
- ✅ API Stateless
- ✅ Migrações automáticas de banco com Flyway
- ✅ Documentação interativa com Swagger

---

## 🔐 Autenticação (JWT)

A API utiliza **JWT** para autenticação.

### Fluxo de autenticação:
1. Usuário realiza login
2. API retorna um token JWT
3. O token deve ser enviado no header das requisições protegidas

### Header obrigatório:

---

## 📑 Documentação Swagger

Após iniciar a aplicação, acesse:
http://localhost:8084/swagger-ui/index.html


No Swagger é possível:
- Visualizar todos os endpoints
- Testar requisições

---

## 🧪 Exemplos de Endpoints

### 🔹 Cadastro de Usuário

**POST** `/auth/register`

📥 Request Body:
```json
{
  "name": "Luiz Felipe",
  "email": "luiz@email.com",
  "password": "123456"
}
{
  "id": 1,
  "name": "Luiz Felipe",
  "email": "luiz@email.com"
}
🔹 Login

POST /auth/login

📥 Request Body:

{
  "email": "luiz@email.com",
  "password": "123456"
}
{
  "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9..."
}
