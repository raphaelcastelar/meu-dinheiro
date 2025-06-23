# 📑 Requisitos Básicos de Negócio — Meu Dinheiro

## 📌 1. Área de Negócio e Contexto

**Meu Dinheiro** é um sistema de gerenciamento de finanças pessoais desenvolvido para ajudar indivíduos a controlar suas receitas, despesas e obter uma visão clara de sua saúde financeira.  

O objetivo principal é simplificar o registro e a organização de entradas e saídas de dinheiro, permitindo ao usuário planejar melhor seu orçamento e tomar decisões financeiras mais conscientes.

**Principais necessidades atendidas:**

- ✅ **Planejamento Financeiro:** Controle das receitas e despesas mensais.
- ✅ **Organização:** Categorizar gastos e receitas, oferecendo relatórios claros.
- ✅ **Visualização:** Geração de relatórios gráficos e tabelas para análise do orçamento.
- ✅ **Acompanhamento:** Visão do saldo disponível, despesas recorrentes e evolução financeira.

---

## 📌 2. Principais Funcionalidades

O sistema **Meu Dinheiro** oferecerá as seguintes funcionalidades principais:

### 👤 **Cadastro de Usuários**
- Registro de novos usuários com nome, e-mail e senha.
- Autenticação de usuários já cadastrados.

### ➕ **Cadastro de Receitas**
- Registro de receitas com:
  - Valor
  - Data de recebimento
  - Categoria (ex.: salário, bônus, outros)
  - Descrição opcional

### ➖ **Cadastro de Despesas**
- Registro de despesas com:
  - Valor
  - Data de pagamento
  - Categoria (ex.: alimentação, transporte, lazer, contas fixas)
  - Descrição opcional

### 🗂️ **Organização por Categorias**
- Criação e gerenciamento de categorias de receitas e despesas.

### 📊 **Relatórios Financeiros**
- Relatórios mensais com:
  - Total de receitas e despesas
  - Gráficos de distribuição por categoria
  - Saldo final do período
- Filtros por período e categoria.

### 🛠️ **Gestão de Perfis**
- **Usuário:**
  - Acesso a registro e consulta de receitas/despesas.
  - Visualização de relatórios.
- **Administrador:**
  - Gerenciamento de usuários.
  - Acompanhamento geral do sistema.
  - Manutenção de categorias globais.

---

## 📌 3. Restrições e Premissas

- 🔒 O sistema deve ser seguro, exigindo autenticação para acesso aos dados.
- 👥 Cada usuário só visualiza suas próprias informações financeiras.
- 🔑 O administrador não modifica dados financeiros individuais — apenas gerencia usuários e categorias.

---

## 📌 4. Requisitos Funcionais

| Código | Descrição |
|--------|------------|
| **RF01** | Permitir o cadastro de usuários. |
| **RF02** | Permitir o login/autenticação de usuários. |
| **RF03** | Permitir o registro de receitas. |
| **RF04** | Permitir o registro de despesas. |
| **RF05** | Permitir a organização por categorias. |
| **RF06** | Gerar relatórios mensais com informações consolidadas. |
| **RF07** | Permitir filtragem de relatórios por período e categorias. |
| **RF08** | Permitir a gestão de usuários pelo administrador. |
| **RF09** | Proteger os dados individuais dos usuários. |

