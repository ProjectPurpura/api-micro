# API de Microsserviços do Purpura 💜
![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Apache Maven](https://img.shields.io/badge/Apache%20Maven-C71A36?style=for-the-badge&logo=Apache%20Maven&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Redis](https://img.shields.io/badge/redis-%23DD0031.svg?style=for-the-badge&logo=redis&logoColor=white)
![Render](https://img.shields.io/badge/Render-%46E3B7.svg?style=for-the-badge&logo=render&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white)
![Bruno – API Client](https://img.shields.io/badge/bruno-apiclient-007396?style=for-the-badge&logo=bruno&logoColor=white)
![Swagger](https://img.shields.io/badge/-Swagger-%23Clojure?style=for-the-badge&logo=swagger&logoColor=white)

Essa API tem o propósito de conectar com outras APIs e prover serviços fora dos centrados diretamente ao banco de dados.

## O que ela faz? 📝
1. Validações (Cep)
2. Geração de Imagens QR Code para mock do pagamento via pix

## Como ver o Swagger 🧪

Para ver o Swagger da API (produção), basta acessar o endereço: [https://api-micro-latest.onrender.com/swagger-ui.html](https://api-micro-latest.onrender.com/)


## Tecnologias utilizadas 👩‍💻
- **Java 21**
  - **Maven**
  - **Spring Boot 3.5.4**
  - **Spring WebClient**
  - **Lombok**
  - **OpenAPI Swagger**
- **Docker** para deploy
- **Redis** para cache

## Como usar a API 📖
### Rodando localmente 💻
#### Passo 1: Certifique-se de ter as seguintes tecnologias instaladas:
- Java 21 (OpenJDK)
- Maven
- Docker

#### Passo 2: Clone o repositório
```bash
https://github.com/PurPuraAmbiental/api-micro.git
```

#### Passo 3: Execute o seguinte comando para construir a API:
```bash
mvn clean install
```

#### Passo 4: Rode a API
```bash
mvn spring-boot:run
```

### Rodando usando o docker 🐳
#### Passo 1: Certifique-se de ter as seguintes tecnologias instaladas:
- Docker

#### Passo 2: Clone o repositório
```bash
https://github.com/PurPuraAmbiental/api-micro.git
```

#### Passo 3: Construa a imagem do docker


> **OBS:** A API deve estar rodando localmente e o serviço do docker também
> 

## Autores 💃

Feito com 💜 por:
- Felipe Fernandes dos Santos Oliveira (Backend, java, testes)
- Emilio Stuart Palumbo (esteira de deploy)