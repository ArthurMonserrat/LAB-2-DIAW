---
# 🚗 VOLANTE — Sistema de Aluguel de Carros 👨‍💻

> [!NOTE]
> **LAB02 — Desenvolvimento e Integração de Aplicações Web (DIAW).** Protótipo acadêmico de locadora digital: clientes solicitam, consultam, modificam e cancelam aluguéis; agentes analisam pedidos e registram sua decisão.

<table><tr><td width="800px"><div align="justify">O <b>VOLANTE</b> simplifica a gestão de aluguel de automóveis com cadastro, autenticação e acompanhamento do pedido. Construído como atividade do 2º período de Engenharia de Software, disciplina DIAW, sob orientação do Prof. Dr. João Paulo Carneiro Aramuni, o projeto documenta o domínio com diagramas UML e separa visualização, serviços e persistência.</div></td><td><div align="center"><img src="https://img.shields.io/badge/VOLANTE-🚗-D9F536?style=for-the-badge" alt="Logo Volante"></div></td></tr></table>

---
## 🚧 Status do Projeto
![Status](https://img.shields.io/badge/Status-Protótipo_acadêmico-yellow?style=for-the-badge)
![Versão](https://img.shields.io/badge/Versão-v1.0.0-blue?style=for-the-badge)
![React](https://img.shields.io/badge/React-19-61DAFB?style=for-the-badge&logo=react&logoColor=black)
![Vite](https://img.shields.io/badge/Vite-7-646CFF?style=for-the-badge&logo=vite&logoColor=white)
![Java](https://img.shields.io/badge/Java-25-orange?style=for-the-badge&logo=openjdk)
![Spring Boot](https://img.shields.io/badge/Spring_Boot-4.0.x-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/Supabase-PostgreSQL-3ECF8E?style=for-the-badge&logo=supabase&logoColor=white)

> **Estado de validação:** código-fonte e documentação entregues. A aplicação exige um PostgreSQL configurado e **não foi implantada nem homologada em produção**. A execução integrada deve ser validada no ambiente de quem for apresentar.

---
## 📚 Índice
- [Links Úteis](#-links-úteis)
- [Sobre o Projeto](#-sobre-o-projeto)
- [Funcionalidades Principais](#-funcionalidades-principais)
- [Tecnologias Utilizadas](#-tecnologias-utilizadas)
- [Arquitetura](#-arquitetura)
- [Instalação e Execução](#-instalação-e-execução)
- [Deploy](#-deploy)
- [Estrutura de Pastas](#-estrutura-de-pastas)
- [Demonstração](#-demonstração)
- [Testes](#-testes)
- [Documentações utilizadas](#-documentações-utilizadas)
- [Autores](#-autores)
- [Contribuição](#-contribuição)
- [Agradecimentos](#-agradecimentos)
- [Licença](#-licença)

---
## 🔗 Links Úteis
* 🌐 **Repositório:** [ArthurMonserrat/LAB-2-DIAW](https://github.com/ArthurMonserrat/LAB-2-DIAW)
* 💻 **Demo online:** não hospedada (execução local conforme instruções).
* 📱 **Aplicativo Mobile:** não se aplica (projeto Web responsivo).
* 📖 **Documentação:** [Histórias do usuário](docs/historias-do-usuario.md) · [Casos de uso](docs/casos-de-uso.puml) · [Classes](docs/classes.puml) · [Pacotes](docs/pacotes.puml) · [Arquitetura](docs/arquitetura.puml) · [Modelo inicial v1](docs/versao-1-inicial.puml)
* 📄 **Modelo do professor:** [template_README.md](https://github.com/joaopauloaramuni/desenvolvimento-e-integracao-de-aplicacoes-web/blob/main/TEMPLATES/template_README.md)

---
## 📝 Sobre o Projeto
O problema é gerenciar remotamente a contratação de aluguéis, mantendo cadastro dos clientes, dados do veículo, pedidos e sua avaliação financeira. A solução disponibiliza dois perfis: **CLIENT**, que inicia e administra seus pedidos, e **AGENT**, que analisa, aprova, recusa e confirma contratos.

A aplicação implementa um catálogo visual com opções de veículos, um formulário de reserva, autenticação e painel de pedidos; a API registra dados no PostgreSQL, projetada para o banco gerenciado **Supabase**.

**Restrições do exercício:** acesso ao sistema de operações mediante login; clientes mantêm até três fontes de rendimento; cada veículo registra matrícula, ano, marca, modelo, placa e tipo de proprietário (cliente, empresa ou banco); crédito bancário opcional vinculado a um aluguel aprovado.

---
## ✨ Funcionalidades Principais
- 🔐 **Cadastro e autenticação:** login obrigatório para acessar dados e pedidos; senhas cifradas com BCrypt no banco. Cadastro público somente para CLIENT.
- 👤 **CRUD do cliente:** registro, consulta e edição de identificação, endereço, profissão, empregadores e rendimentos (máximo três); exclusão de cadastro somente sem pedidos associados, para preservar histórico.
- 🚗 **Catálogo de veículos:** marca, modelo, placa, matrícula, ano, valor diário e propriedade.
- 📅 **Pedidos:** criação, consulta do status, alteração de datas enquanto pendente e cancelamento elegível.
- ✅ **Avaliação financeira:** agente registra parecer e aprova/recusa pedidos; aprovados podem ser contratados.
- 🏦 **Crédito:** agente bancário autenticado pode associar crédito a pedido aprovado.
- 🧭 **Painel responsivo:** visão de solicitações e totais por status para cliente e agente.
- 🔒 **Autorização:** clientes só podem consultar seus próprios pedidos, agentes consultam o conjunto.

**Fluxo:** `PENDING → APPROVED → CONTRACTED`; alternativo `PENDING → REJECTED`; cancelamento permitido em `PENDING` e `APPROVED`.

---
## 🛠 Tecnologias Utilizadas
### 💻 Front-end
* **Framework/Biblioteca:** React 19 + ReactDOM.
* **Linguagem:** JavaScript JSX.
* **Estilização:** CSS responsivo sem framework.
* **Estado:** React Hooks (`useState`, `useEffect`).
* **Build:** Vite 7.
* **Ícones:** lucide-react.

### 🖥️ Back-end
* **Linguagem:** Java JDK 25.
* **Framework:** Spring Boot 4.0.2 (4.0.x).
* **Build:** Apache Maven.
* **Persistência:** Spring Data JPA / Hibernate.
* **Banco de dados:** Supabase PostgreSQL 17 (compatível com PostgreSQL local).
* **Autenticação:** Spring Security + HTTP Basic stateless + BCrypt, somente sobre HTTPS em produção.

### 📱 Mobile (Opcional)
* Não há aplicativo nativo. Layout Web adaptável a celulares.

### ⚙️ Infraestrutura & DevOps
* Banco local opcional via Docker Compose (`docker-compose.yml`).
* Sem deploy público, pipeline CI/CD ou provedor pago exigido.

---
## 🏗 Arquitetura
Padrão **MVC/serviços REST**: o React implementa a camada de apresentação; `ApiController` recebe as requisições e aplica as regras de negócio; o modelo JPA representa o domínio e os repositórios fazem o acesso ao banco. A segurança intercepta chamadas autenticadas.

| Camada | Arquivo / Função |
|---|---|
| View | `frontend/src/main.jsx` e `style.css`: telas e interações |
| Controller | `backend/.../ApiController.java`: regras e endpoints REST |
| Model | `Account`, `Income`, `Car`, `Rental`, `CreditAgreement` |
| Repository | `*Repository.java`: interface com PostgreSQL |
| Security | `SecurityConfig.java`: login, CORS, hashing e proteção de API |

### Exemplos de diagramas
| Diagrama de Arquitetura | Detalhe da Arquitetura |
|---|---|
| [Arquitetura (PlantUML)](docs/arquitetura.puml) | [Pacotes — Visão Lógica](docs/pacotes.puml) |
| **Modelo de Dados (Entidades)** | **Casos de Uso** |
| [Classes (PlantUML)](docs/classes.puml) | [Casos de uso (PlantUML)](docs/casos-de-uso.puml) |
| **Histórico de Modelos** | **Histórias do usuário** |
| [Primeira versão (PlantUML)](docs/versao-1-inicial.puml) | [Critérios de aceite](docs/historias-do-usuario.md) |

Os arquivos `.puml` são diagramas-fonte editáveis para renderização pelo [PlantUML](https://plantuml.com/). **Revisões:** v1 representa o modelo inicial simplificado e v2 apresenta o modelo final com rendimentos, crédito e estados.

### Endpoints disponíveis
| Método | Endpoint | Permissão | Finalidade |
|---|---|---|---|
| POST | `/api/auth/register` | Pública | Cadastrar cliente |
| GET | `/api/auth/me` | Autenticado | Testar login / perfil |
| GET, PUT, DELETE | `/api/clients/me` | Cliente autenticado | CRUD do próprio cadastro |
| GET | `/api/clients` | Agente | Consultar clientes |
| GET | `/api/cars` | Autenticado | Listar veículos |
| GET, POST | `/api/rentals` | Autenticado / POST cliente | Listar / criar pedidos |
| PUT, DELETE | `/api/rentals/{id}` | Cliente proprietário | Alterar / cancelar pedido |
| PATCH | `/api/rentals/{id}` | Agente | Avaliar / contratar |
| POST | `/api/rentals/{id}/credit` | Agente bancário | Associar crédito |
| GET | `/api/health` | Pública | Verificar serviço |

---
## 🔧 Instalação e Execução
### Pré-requisitos
* **Java JDK 25** e **Apache Maven 3.9+** instalados.
* **Node.js 20.19+** (recomenda-se 22 LTS) e **npm**.
* **Supabase PostgreSQL** configurado, ou PostgreSQL 17 local/Docker para testes.
* Uma conexão de Internet para instalar dependências e carregar fontes/imagens externas.

### 🔑 Variáveis de Ambiente
#### 1 Back-end (Spring Boot)
Defina as variáveis no terminal ou ambiente da IDE (veja `backend/.env.example`):

| Variável | Descrição | Exemplo local |
|---|---|---|
| `SERVER_PORT` | Porta da API | `8080` |
| `SPRING_DATASOURCE_URL` | JDBC PostgreSQL / Supabase | `jdbc:postgresql://localhost:5432/lab2` |
| `SPRING_DATASOURCE_USERNAME` | Usuário PostgreSQL | `postgres` |
| `SPRING_DATASOURCE_PASSWORD` | Senha PostgreSQL | `postgres` |
| `FRONTEND_ORIGIN` | CORS permitido | `http://localhost:5173` |
| `AGENT_USERNAME` | Login pré-provisionado do agente | `agente` |
| `AGENT_PASSWORD` | Senha do agente (definir localmente) | `senha-forte-aqui` |
| `BANK_USERNAME` | Login bancário pré-provisionado | `banco` |
| `BANK_PASSWORD` | Senha bancária (definir localmente) | `outra-senha-forte` |

**Supabase:** em Project Settings → Database, copie a string de conexão JDBC (preferencialmente endpoint de pooler compatível com o seu ambiente). Nunca publique senha no GitHub. A aplicação usa Hibernate `ddl-auto=update` para gerar as tabelas ao iniciar. Escolha uma senha robusta e conexões TLS em ambiente remoto.

#### 2 Front-end (React, Vite)
Copie `frontend/.env.example` para `frontend/.env.local`:
```ini
VITE_API_URL=http://localhost:8080/api
```

#### 3 Exemplos de Variáveis de Ambiente na Vercel
**Não aplicável à entrega:** não é obrigatório hospedar. Para eventual hospedagem, configure `VITE_API_URL=https://seu-backend.example/api` no provedor, e o back-end separadamente.

### 📦 Instalação de Dependências
```bash
git clone https://github.com/ArthurMonserrat/LAB-2-DIAW.git
cd LAB-2-DIAW/frontend
npm install
cd ../backend
mvn clean package
```
> Se você estiver executando a cópia ZIP (enquanto o upload para GitHub não é realizado), abra diretamente as pastas `frontend/` e `backend/` em vez de fazer clone.

### 💾 Inicialização do Banco de Dados (PostgreSQL)
**Opção A — Supabase:** crie um projeto Supabase e configure as três variáveis JDBC de conexão acima. O Hibernate cria/atualiza tabelas automaticamente.

**Opção B — Docker local:** na raiz do repositório:
```bash
docker compose up -d db
```
O serviço local expõe `localhost:5432` com banco `lab2` e credenciais de desenvolvimento `postgres/postgres`. **Não utilize essas credenciais em produção.**

### ⚡ Como Executar a Aplicação
#### Terminal 1: Back-end (Spring Boot)
```bash
cd backend
mvn spring-boot:run
```
API: `http://localhost:8080/api/health`.

#### Terminal 2: Front-end (React, Vite)
```bash
cd frontend
npm install
npm run dev
```
Interface: `http://localhost:5173`.

#### Execução Local Completa com Docker Compose (Incluindo Banco de Dados)
O Compose fornecido sobe **apenas o banco PostgreSQL**. A API Java e o front-end rodam nos respectivos terminais com os comandos acima. Não há configuração de contêineres para todos os serviços nesta versão.

#### Passos para build, inicialização e execução
1. Inicie o banco, local ou Supabase.
2. Configure as variáveis JDBC e as credenciais de agente/banco.
3. Suba o Spring Boot e confirme o endpoint `health`.
4. Rode `npm install && npm run dev` no front-end.
5. Cadastre um cliente na tela de entrada e realize login.
6. Crie um pedido; faça login como agente em outro navegador para avaliar.

---
## 🚀 Deploy
O deploy não é obrigatório e **não foi realizado**. Para publicar futuramente:
```bash
cd frontend && npm run build
cd ../backend && mvn clean package
```
Hospede os arquivos `frontend/dist` em um host estático; execute o JAR Spring Boot em um serviço compatível com Java 25; configure `VITE_API_URL`, `FRONTEND_ORIGIN` e JDBC do Supabase. Exija HTTPS, ajuste CORS e evite enviar credenciais em texto claro.

---
## 📂 Estrutura de Pastas
```text
.
├── frontend/
│   ├── index.html
│   ├── package.json
│   ├── vite.config.js
│   ├── .env.example
│   └── src/
│       ├── main.jsx          # Interface React completa
│       └── style.css         # Identidade visual e responsividade
├── backend/
│   ├── pom.xml               # Maven / Java 25 / Spring Boot 4.0.x
│   ├── .env.example
│   └── src/main/
│       ├── resources/application.properties
│       └── java/br/edu/diaw/locadora/
│           ├── LocadoraApplication.java
│           ├── ApiController.java
│           ├── SecurityConfig.java
│           ├── Account.java / Income.java / Car.java
│           ├── Rental.java / CreditAgreement.java
│           └── *Repository.java
├── docs/
│   ├── historias-do-usuario.md
│   ├── casos-de-uso.puml
│   ├── classes.puml
│   ├── pacotes.puml
│   ├── arquitetura.puml
│   └── versao-1-inicial.puml
├── docker-compose.yml
├── CONTRIBUTING.md
├── LICENSE
├── .gitignore
└── README.md
```

---
## 🎥 Demonstração
### 📱 Aplicativo Mobile
**Não aplicável:** projeto Web com layout responsivo.

### 🌐 Aplicação Web
Telas previstas: **Início e catálogo**, **Login / Cadastro**, **Meu painel**, **Minhas reservas**, **Avaliação de pedidos para agente**, **Dados cadastrais**.

**Roteiro da demonstração:**
1. Abra a página inicial e filtre a frota.
2. Crie o cadastro e faça login.
3. Selecione um veículo, datas e confirme a solicitação.
4. No painel, acompanhe o pedido `Em análise`.
5. Entre como agente e altere o status para `Aprovado`.
6. Retorne ao cliente para consultar a mudança.

> Imagens de interface e GIFs **não incluídos**, pois não houve execução de navegador registrada nesta entrega. Não há links de demonstração fictícios.

### 💻 Exemplo de Saída no Terminal (para Back-end, API, CLI)
```bash
curl http://localhost:8080/api/health
# Resposta esperada: {"status":"ok","system":"VOLANTE"}

curl -u usuario:senha http://localhost:8080/api/cars
# Resposta esperada: JSON com os automóveis cadastrados
```

---
## 🧪 Testes
### Testes Unitários e de Integração
```bash
cd backend
mvn test
```
**Cobertura:** o código-fonte inclui as rotas e verificações, mas ainda não possui uma suíte dedicada de testes unitários; executar `mvn test` não substitui uma homologação de fluxos.

### Testes End-to-End (E2E)
**Procedimento manual recomendado:** cadastrar cliente; validar login incorreto; criar e listar pedido; impedir acesso de cliente A ao pedido de B; alterar/cancelar pedido; efetuar revisão com agente; verificar limite de três rendimentos.

### Limitações conhecidas
- Protótipo acadêmico, sem pagamento real, assinatura de contrato ou recuperação de senha.
- As fotos dos veículos vêm do Unsplash; dependem da disponibilidade do serviço.
- Autenticação HTTP Basic com senha na sessão do navegador é adequada somente para **demonstração local protegida**; para produção, implementar sessão segura ou tokens de curta duração.
- Catálogo e registros de agentes são provisionados pelo back-end; a tela de UI não cadastra agentes.
- O crédito bancário tem endpoint mas não possui tela própria no front-end.
- Os modelos são versões de desenvolvimento e podem ser ajustados conforme feedback docente.

---
## 🔗 Documentações utilizadas
* [React](https://react.dev/reference/react)
* [Vite](https://vite.dev/guide/)
* [Spring Boot](https://docs.spring.io/spring-boot/reference/)
* [Spring Security](https://docs.spring.io/spring-security/reference/)
* [Supabase Database](https://supabase.com/docs/guides/database)
* [PlantUML](https://plantuml.com/)
* [Template oficial do professor](https://github.com/joaopauloaramuni/desenvolvimento-e-integracao-de-aplicacoes-web/blob/main/TEMPLATES/template_README.md)

---
## 👥 Autores
| 👤 Nome | 🖼️ Foto | :octocat: GitHub | 💼 LinkedIn | 📤 Gmail |
|---|---|---|---|---|
| Arthur Monserrat | Não informado | [ArthurMonserrat](https://github.com/ArthurMonserrat) | Não informado | Não informado |

---
## 🤝 Contribuição
Faça um fork, crie uma branch, registre sua mudança com commit descritivo e abra um pull request. Consulte [CONTRIBUTING.md](CONTRIBUTING.md) para detalhes.

---
## 🙏 Agradecimentos
* [PUC Minas](https://www.pucminas.br/) e ao **Prof. Dr. João Paulo Carneiro Aramuni**, pela proposta do laboratório e template de documentação.
* Comunidades e documentações oficiais de Java, Spring, React, PostgreSQL e PlantUML.

---
## 📄 Licença
Este projeto é disponibilizado sob a **[Licença MIT](LICENSE)** para fins educacionais.
