🛒 Sistema de Controle de Estoque

Esse é sistema simples e eficiente para gerenciar produtos, controlar quantidades e valores de mercadorias. 
---

🎯 Objetivo do Projeto

Este sistema foi criado como uma introdução ao desenvolvimento de software de gestão utilizando Java. É perfeito para aprender conceitos como CRUD, integração com banco de dados e construção de interfaces gráficas.


Funcionalidades

📦 Cadastro de Produtos: Adicione novos produtos ao estoque com nome, quantidade e valor.

🗑️ Remoção de Produtos: Exclua itens quando esgotados ou descontinuados.

🔄 Atualização de Estoque: Ajuste as quantidades disponíveis de produtos.

🔍 Consulta de Produtos: Visualize informações detalhadas dos produtos cadastrados.

---

🛠️ Tecnologias Utilizadas

- **Java**: Linguagem de programação principal do projeto.
- **MySQL**: Banco de dados para armazenar informações do estoque.
- **JDBC**: Interface de conexão entre Java e MySQL.

---

## 📥 Instalação

### Pré-requisitos

- [Java 8 ou superior](https://www.java.com/pt-BR/download/) instalado.
- [MySQL](https://dev.mysql.com/downloads/) configurado.

### Passos para Instalar

1. Clone o repositório:
 ```
    git clone https://github.com/username/sistema-de-estoque.git
 ```
2. Configure o banco de dados:
   
Acesse o MySQL e crie o banco de dados e as tabelas:
```
CREATE DATABASE estoque;

CREATE TABLE produtos (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  quantidade INT NOT NULL,
  valor DECIMAL(10, 2) NOT NULL
);
````

Execute o sistema:

🖥️ Uso

1. No momento, é possivel fazer a utilização do sistema através do Postman.
   
URL: http://localhost:8080/api/produtos

Campo de utilização: Body e raw.

Utilize JSON

3. Adicionar Produtos: Preencha o formulário com nome, quantidade e valor. (POST)

5. Consultar Produtos: Navegue pelos itens cadastrados. (GET)
   
6. Atualizar Estoque: Edite a quantidade de qualquer item. (PUT)
   
7. Remover Produtos: Elimine itens que não fazem mais parte do estoque. (DELETE)

💡 Inspiração

Este projeto é ideal para praticar:

1. CRUD (Create, Read, Update, Delete)

2. Integração com banco de dados

Desenvolvido  por Walck isaac.
