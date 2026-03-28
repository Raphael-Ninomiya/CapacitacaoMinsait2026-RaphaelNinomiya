Alterações que eu realizei de acordo com o projeto disponibilizado pelo professor Felipe Abreu.

---

# Sistema de Catálogo de Produtos e Controle de Estoque

Este projeto foi desenvolvido como parte de um processo de capacitação em desenvolvimento backend utilizando **Java e Spring Boot**. O objetivo principal é simular um sistema básico de gerenciamento de produtos semelhante aos encontrados em plataformas de e-commerce ou sistemas de gestão empresarial (ERP).

A aplicação permite organizar produtos em categorias, controlar estoque e registrar todas as movimentações realizadas no inventário. O foco do projeto está na organização em camadas, aplicação de boas práticas com Spring e implementação de regras de negócio comuns em sistemas de catálogo e inventário.

---

# Tecnologias utilizadas

* Java
* Spring Boot
* Spring Data JPA
* Hibernate
* Oracle Database
* Maven
* API REST

---

# Estrutura da aplicação

O projeto segue uma arquitetura em camadas para manter a separação de responsabilidades e facilitar manutenção e evolução do sistema.

**Controller**

Responsável por expor os endpoints da API e receber as requisições HTTP.

**Service**

Camada onde ficam as regras de negócio da aplicação.

**Repository**

Responsável pela comunicação com o banco de dados através do Spring Data JPA.

**Model**

Representação das entidades persistidas no banco de dados.

**DTO**

Objetos utilizados para controlar os dados recebidos e enviados pela API.

---

# Funcionalidades implementadas

## 1. Organização de categorias

O sistema permite cadastrar e organizar categorias de produtos, possibilitando uma estrutura hierárquica onde uma categoria pode possuir uma categoria pai.

### Regras de negócio

* Todo produto deve estar vinculado a uma categoria
* Categorias podem possuir relação pai-filho
* O nome da categoria deve ser único dentro do mesmo nível
* O nome da categoria é obrigatório

### Endpoints

GET /categories
Retorna todas as categorias cadastradas.

POST /categories
Cria uma nova categoria.

PUT /categories/{id}
Atualiza os dados de uma categoria existente.

DELETE /categories/{id}
Remove uma categoria.

---

## 2. Cadastro e gerenciamento de produtos

Produtos podem ser cadastrados e vinculados a uma categoria. O sistema permite consultar, atualizar e remover produtos.

Além disso, foi implementado controle de alteração de preços através de uma tabela de histórico.

### Histórico de preços

Sempre que o preço de um produto é alterado, o sistema registra:

* preço anterior
* novo preço
* data da alteração
* produto associado

Isso garante rastreabilidade das alterações realizadas.

---

## 3. Controle de estoque

Foi implementado um sistema simples de inventário que controla a quantidade disponível de cada produto.

Toda alteração de estoque gera um registro em uma tabela de transações, permitindo acompanhar todas as movimentações realizadas.

### Tipos de transação

Entrada
Utilizada quando há reposição de estoque.

Saída
Utilizada quando ocorre venda ou remoção de produtos.

Ajuste
Pode ser utilizado para correções de estoque.

Devolução
Utilizado quando produtos retornam ao estoque.

### Regras de negócio

* Toda movimentação gera um registro em `InventoryTransaction`
* Não é permitido realizar saída com estoque insuficiente
* O estoque do produto é atualizado automaticamente após cada transação

### Endpoints

POST /inventory/{productId}/add
Adiciona unidades ao estoque de um produto.

POST /inventory/{productId}/remove
Remove unidades do estoque de um produto.

GET /inventory/{productId}
Retorna a quantidade atual disponível em estoque.

---

# Principais entidades do sistema

**Produto**

Representa os produtos cadastrados no sistema.

Principais atributos:

* id
* nome
* descrição
* preço
* código de barras
* estoque
* categoria

---

**Categoria**

Responsável por organizar os produtos dentro do catálogo.

Principais atributos:

* id
* nome
* categoria pai

---

**InventoryTransaction**

Armazena o histórico de todas as movimentações de estoque.

Principais atributos:

* id
* produto
* quantidade
* tipo de transação
* data da movimentação

---

**HistoricoPreco**

Registra todas as alterações de preço realizadas em um produto.

Principais atributos:

* id
* produto
* preço anterior
* preço novo
* data da alteração

---

# Execução do projeto

1. Clonar o repositório

git clone <url-do-repositorio>

2. Configurar o banco de dados Oracle no arquivo `application.yml`

3. Executar o projeto utilizando Maven

mvn spring-boot:run

A aplicação será iniciada na porta configurada no projeto.

---

# Considerações finais

Este projeto foi desenvolvido com foco em consolidar conceitos importantes de desenvolvimento backend com Spring Boot, incluindo organização em camadas, modelagem de entidades, implementação de regras de negócio e construção de APIs REST.

Embora seja um projeto de estudo, a estrutura adotada permite sua evolução para funcionalidades mais completas, como gestão de pedidos, autenticação de usuários, controle de estoque mínimo e integração com sistemas externos.
