# 🧾 Sistema de Controle de Estoque - P1 Java (FATEC)

Este projeto foi desenvolvido em Java como parte da prova de Linguagem de Programação Java (FATEC).  
O sistema tem como objetivo gerenciar cadastros de produtos, clientes, fornecedores e o lançamento de notas de entrada e saída, com integração ao banco de dados MySQL via JDBC.

---

## 🏗️ Estrutura do Projeto

O projeto segue uma arquitetura em camadas:

📦 sistema-compra-e-vendas
│
├── 📁 dao/                  → Classes de acesso ao banco (CRUD)
│   ├── ClienteDAO.java
│   ├── FornecedorDAO.java
│   ├── ProdutoDAO.java
│   ├── NotaDAO.java
│   └── ItemNotaDAO.java
│
├── 📁 entity/               → Entidades (modelos de dados)
│   ├── Cliente.java
│   ├── Fornecedor.java
│   ├── Produto.java
│   ├── Nota.java
│   └── ItemNota.java
│
├── 📁 util/                 → Conexão com o banco de dados
│   └── ConnectionFactory.java
│
├── 📁 view/                 → Telas (Swing)
│   ├── CadastroCliente.java
│   ├── CadastroFornecedor.java
│   ├── CadastroProduto.java
│   ├── LancamentoNota.java
│   ├── RelatorioClientes.java
│   ├── RelatorioFornecedores.java
│   ├── RelatorioProdutos.java
│   └── RelatorioNotas.java
│
└── SistemaCompraEvenda.java  → Classe principal (menu e navegação)

## ⚙️ Funcionalidades

### 🧍‍♂️ Cadastro de Clientes
- Cadastrar, listar, atualizar e excluir clientes.
- Campos: Código, Nome, Endereço, E-mail e Telefone.

### 🏭 Cadastro de Fornecedores
- Cadastrar, listar, atualizar e excluir fornecedores.
- Campos: Código, Nome, Nome Fantasia, CNPJ, Endereço, E-mail e Telefone.

### 📦 Cadastro de Produtos
- Cadastrar, listar, atualizar e excluir produtos.
- Campos: Código, Nome, Descrição, Preço de Venda e Quantidade em Estoque.

### 🧾 Lançamento de Notas (Entrada e Saída)
- Registrar entrada ou saída de produtos.
- Selecionar cliente (para saída) ou fornecedor (para entrada).
- Escolher o produto, definir quantidade e data.
- Atualiza automaticamente o estoque.
- Relatórios com filtros de Entrada, Saída e Geral.

---

## 🧩 Pré-requisitos

Antes de rodar o projeto, certifique-se de ter:

- Java JDK 8+
- NetBeans IDE
- MySQL Server
- Driver JDBC MySQL Connector

📦 Baixar o conector MySQL (necessário):  
[mysql-connector-java-8.0.18.jar](https://downloads.mysql.com/archives/c-j/)

Após o download, adicione o arquivo .jar ao Classpath do projeto:
> Clique com o botão direito no projeto → Propriedades → Bibliotecas → Adicionar JAR/Pasta → selecione o mysql-connector-java-8.0.18.jar.

---

## 🗄️ Configuração do Banco de Dados

1. Abra o MySQL Workbench ou outro cliente.
2. Crie o banco:

CREATE DATABASE p1estoque;
USE p1estoque;

CREATE TABLE cliente (
  cod_Cliente INT PRIMARY KEY,
  nome VARCHAR(100),
  endereco VARCHAR(100),
  email VARCHAR(100),
  telefone VARCHAR(20)
);

CREATE TABLE fornecedor (
  cod_fornecedor INT PRIMARY KEY,
  nome VARCHAR(100),
  nome_fantasia VARCHAR(100),
  cnpj VARCHAR(20),
  endereco VARCHAR(100),
  email VARCHAR(100),
  telefone VARCHAR(20)
);

CREATE TABLE produto (
  cod_produto INT PRIMARY KEY,
  nome VARCHAR(100),
  descricao VARCHAR(200),
  preco_venda DECIMAL(10,2),
  qtd_estoque INT
);

CREATE TABLE nota (
  cod_nota INT AUTO_INCREMENT PRIMARY KEY,
  tipo VARCHAR(10), -- Entrada ou Saída
  data DATE,
  cod_cliente INT,
  cod_fornecedor INT,
  FOREIGN KEY (cod_cliente) REFERENCES cliente(cod_Cliente),
  FOREIGN KEY (cod_fornecedor) REFERENCES fornecedor(cod_fornecedor)
);

CREATE TABLE itemnota (
  cod_item INT AUTO_INCREMENT PRIMARY KEY,
  cod_nota INT,
  cod_produto INT,
  quantidade INT,
  preco_unitario DECIMAL(10,2),
  FOREIGN KEY (cod_nota) REFERENCES nota(cod_nota),
  FOREIGN KEY (cod_produto) REFERENCES produto(cod_produto)
);

▶️ Como Executar no NetBeans

1. Abra o NetBeans


2. Vá em Arquivo → Abrir Projeto e selecione a pasta sistema-compra-e-vendas


3. Configure o driver JDBC (mysql-connector-java-8.0.18)


4. No pacote view, abra e execute:
SistemaCompraEvenda.java

O menu principal será exibido com as opções:

- Cadastro de Cliente

- Cadastro de Fornecedor

- Cadastro de Produto

- Lançamento de nota Entrada

- Lançamento de nota Saida

- Relatórios guagem dela de relatório lista os registros cadastrados no banco, com botões para:

Atualizar a lista

Voltar ao menu principal

Filtrar por tipo (no caso de notas)ficas em Swing e manipulação de banco de dados MySQL.
