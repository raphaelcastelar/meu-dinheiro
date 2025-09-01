# 💰 Meu Dinheiro — Gerenciador de Finanças Pessoais

**Desenvolvido por: Raphael e João Pedro**

## 📄 Descrição

**Meu Dinheiro** é uma ferramenta prática e intuitiva para ajudar usuários a organizarem suas finanças pessoais. O sistema permite:

- Cadastrar receitas e despesas
- Categorizar cada lançamento
- Gerar e visualizar relatórios mensais detalhados

Tudo isso para oferecer uma visão clara e eficiente de como o seu dinheiro está sendo utilizado

---

## 👥 Perfis de Acesso

- **Usuário**:  
  - Cadastro de receitas e despesas
  - Consulta de relatórios mensais
  - Organização de lançamentos por categorias

- **Administrador**:  
  - Gerenciamento do sistema e dos usuários
  - Monitoramento geral de movimentações
  - Manutenção de categorias e relatórios globais

---

## 🚀 Funcionalidades Principais

✔ Cadastro de receitas e despesas  
✔ Organização por categorias (ex.: alimentação, lazer, contas fixas, etc.)  
✔ Relatórios mensais em formato gráfico ou tabela  
✔ Gestão de usuários (perfil Administrador)  
✔ Interface amigável e responsiva

---

## ⚙️ Tecnologias Utilizadas

Linguagem: Java 17



- Framework: Spring Boot 3.x
- Template Engine: Thymeleaf
- Frontend: HTML5, CSS3, JavaScript
- Ferramentas de Build: Maven ou Gradle (conforme configuração do projeto)

---

## 📦 Como Executar o Projeto

Siga os passos abaixo para clonar, configurar e executar a aplicação localmente:

'''Pré-requisitos

+ Java Development Kit (JDK) 17 ou superior.
+ Maven 3.6+ ou Gradle 7+ (dependendo da configuração do projeto).
+ Um editor de código (ex.: IntelliJ IDEA, VS Code) ou terminal.


'''Passo a Passo

* Clone o repositório:

git clone https://github.com/seu-usuario/meu-dinheiro.git


* Entre na pasta do projeto:


cd meu-dinheiro

* Configure o banco de dados:

Crie um banco de dados PostgreSQL chamado meu_dinheiro.

* Atualize o arquivo application.properties ou application.yml em src/main/resources com as credenciais do banco:

spring.datasource.url=jdbc:postgresql://localhost:5432/meu_dinheiro
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
spring.jpa.hibernate.ddl-auto=update


Certifique-se de que as tabelas sejam criadas automaticamente (ou execute os scripts SQL, se fornecidos).



* Instale as dependências:


- Se usar Maven:
mvn clean install

- Se usar Gradle:
gradle build



* Execute a aplicação:

- Usando Maven:
mvn spring-boot:run

- Usando Gradle:
gradle bootRun

Alternativamente, importe o projeto em um IDE como IntelliJ IDEA e execute a classe principal anotada com @SpringBootApplication.



* Acesse a aplicação:

- Abra o navegador e vá para http://localhost:8080.
- Siga as instruções na interface para realizar login ou cadastrar-se (se configurado).


* Notas

Substitua https://github.com/seu-usuario/meu-dinheiro.git pelo URL real do seu repositório.
Ajuste as credenciais do banco de dados conforme seu ambiente local.
Se houver erros de dependência, verifique o arquivo pom.xml (Maven) ou build.gradle (Gradle) e execute novamente a instalação.

---

# 📚 Documentação Complementar


## Diagramas e Wireframes


### - Diagrama de Classes (ex.: UML das entidades como Expenses e Receipts).


<img width="814" height="608" alt="image" src="https://github.com/user-attachments/assets/320c1209-0c1a-4d5d-842d-f7d16715ca5b" />





### - Wireframe da Interface (ex.: layout da página de cadastro e relatórios).


## Histórias de Usuário

- Como usuário do sistema, desejo registrar minhas receitas e despesas de forma organizada, atribuindo valores, datas, categorias e descrições, para que eu consiga acompanhar meus gastos e ganhos no dia a dia. Também quero visualizar relatórios financeiros mensais que me mostrem claramente o total de entradas e saídas, meu saldo e a divisão por categorias, para entender melhor minha situação financeira e tomar decisões conscientes.

- Além disso, como administrador, preciso gerenciar os usuários do sistema, garantindo que apenas pessoas autorizadas tenham acesso, definindo permissões e mantendo a segurança da aplicação.



