# 🏦 Simulador de Empréstimo Bancário - Java SE

Este projeto é um sistema de análise de crédito desenvolvido para validar propostas de empréstimo com base na margem consignável do utilizador. O foco principal é a aplicação de conceitos rigorosos de Programação Orientada a Objetos (POO), tratamento de exceções e a transição de armazenamento volátil para persistência de dados real.

## 🛠️ Tecnologias e Ambiente

* **Linguagem:** Java (JDK 21)
* **Base de Dados:** PostgreSQL 🐘
* **IDE:** IntelliJ IDEA
* **Sistema Operativo:** Linux Mint 🌿
* **Controle de Versão:** Git (Padrão Conventional Commits)

## 🚀 Roadmap de Evolução

* [x] Estrutura básica em Java e POO.
* [x] Lógica de negócio e validação em memória (Cálculo de Margem).
* [ ] Integração com PostgreSQL via JDBC (Em andamento) 🛠️
* [ ] Implementação do Padrão DAO para Persistência de Dados.
* [ ] Transição para Spring Boot (Criação de API REST).

## 🔍 Destaques Técnicos

* **Arquitetura de Conexão:** Implementação de uma fábrica de conexões estática com gerenciamento de credenciais via arquivos `.properties` externos.
* **Rigor Matemático:** Utilização de `BigDecimal` para garantir precisão absoluta em cálculos financeiros, evitando erros de arredondamento de tipos flutuantes.
* **Encapsulamento:** Separação clara de responsabilidades entre pacotes (Model, Util, Test).
* **Tratamento de Erros:** Implementação de fluxos `try-with-resources` para garantir o fechamento de recursos e gestão de exceções SQL.

---