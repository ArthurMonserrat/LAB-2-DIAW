# Histórias do usuário — LAB02

| ID | Como | Quero | Para | Critério de aceite |
|---|---|---|---|---|
| HU01 | Visitante | Criar conta com dados pessoais | Acessar o sistema | Login único e senha protegida |
| HU02 | Cliente | Entrar na conta | Proteger meus dados | API exige autenticação |
| HU03 | Cliente | Atualizar meus dados e até 3 rendimentos | Manter informações corretas | CRUD com validação de limite |
| HU04 | Cliente | Consultar os carros | Escolher um veículo | Ver marca, modelo, placa e valor |
| HU05 | Cliente | Solicitar aluguel | Registrar meu interesse | Pedido nasce PENDING |
| HU06 | Cliente | Consultar meus pedidos | Saber o status | Só visualizo pedidos próprios |
| HU07 | Cliente | Modificar ou cancelar pedido | Corrigir meu planejamento | Alteração apenas pendente; cancelamento controlado |
| HU08 | Agente | Analisar, aprovar ou recusar pedidos | Avaliar viabilidade financeira | Parecer e responsável registrados |
| HU09 | Agente | Confirmar contrato | Formalizar aprovação | Transição APPROVED → CONTRACTED |
| HU10 | Banco | Vincular crédito ao contrato | Registrar financiamento | Apenas agente bancário em pedido aprovado |

## Revisões de modelagem
- **v1 — levantamento inicial:** cliente, agente, automóvel e aluguel.
- **v2 — refinamento final:** rendimentos como coleção (limite 3), controle de status, crédito bancário e separação da camada de persistência.
- **Adaptação:** para execução da demonstração sem serviço externo de identidade, senha com BCrypt + HTTP Basic (apenas sobre HTTPS em produção). Os usuários de agente são provisionados por variáveis de ambiente.
