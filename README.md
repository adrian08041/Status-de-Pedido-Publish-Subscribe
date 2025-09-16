### Status de Pedido — Publish/Subscribe (Java)

Projeto didático em Java que demonstra o padrão de arquitetura Publish/Subscribe (Pub/Sub) para notificar assinantes sobre mudanças de status de um pedido.

O sistema possui um `EventBus` simples, um contrato `Subscriber` e dois assinantes de exemplo: `LogSubscriber` e `NotificacaoSubscriber`. Eventos do tipo `PedidoEvent` carregam o identificador do pedido e o `StatusPedido` atual, e são distribuídos pelo barramento para todos os inscritos.

## Visão Geral

- **Objetivo**: Propagar atualizações de status de pedidos para vários interessados sem acoplamento direto entre produtores e consumidores.
- **Padrão**: Publish/Subscribe — produtores publicam eventos; assinantes reagem quando eventos compatíveis chegam.
- **Benefícios**: Baixo acoplamento, fácil extensão (novos assinantes ou novos tipos de eventos), código mais testável.

## Arquitetura e Fluxo

1. O produtor (ex.: `Main`) cria um `PedidoEvent` contendo `idPedido` e `StatusPedido`.
2. O `EventBus` recebe o evento e o distribui para todos os `Subscriber` registrados.
3. Cada `Subscriber` processa o evento conforme sua responsabilidade (ex.: logar, enviar notificação, etc.).

## Estrutura do Projeto

```text
.
├─ Main.java
├─ README.md
└─ Src/
   ├─ events/
   │  ├─ EventBus.java
   │  ├─ PedidoEvent.java
   │  ├─ StatusPedido.java
   │  └─ Subscriber.java
   └─ subscribers/
      ├─ LogSubscriber.java
      └─ NotificacaoSubscriber.java
```

- `EventBus`:
  - Registro/remoção de assinantes
  - Publicação e distribuição de eventos
- `Subscriber`:
  - Interface para implementação de assinantes
- `PedidoEvent`:
  - Dados do evento (ex.: `idPedido`, `status`)
- `StatusPedido`:
  - Enum de status possíveis (ex.: CRIADO, PAGO, ENVIADO, ENTREGUE…)
- `LogSubscriber` e `NotificacaoSubscriber`:
  - Implementações de exemplo de assinantes

## Pré‑requisitos

- JDK 8+ instalado (`java -version` e `javac -version` devem funcionar)

## Executando o Projeto

Você pode compilar e executar diretamente com `javac`/`java`:

```bash
mkdir -p out \
&& javac -d out Src/events/*.java Src/subscribers/*.java Main.java \
&& java -cp out Main
```

Observações:

- O caminho `Src/` diferencia maiúsculas/minúsculas conforme o sistema de arquivos.
- Em Windows PowerShell/cmd, o comando pode variar. Em caso de dúvida, rode em WSL ou ajuste os separadores.

## Exemplo (esperado) de Comportamento

- Ao publicar eventos de status, você deverá ver saídas de log no console e mensagens simulando notificações, cada uma proveniente do seu respectivo `Subscriber`.

## Como Estender

- **Adicionar um novo assinante**:

  1. Criar uma classe em `Src/subscribers/` que implemente `Subscriber`.
  2. Registrar a instância no `EventBus` (ex.: dentro de `Main`).

- **Adicionar novos tipos de eventos**:

  1. Criar uma nova classe de evento em `Src/events/`.
  2. Ajustar os `Subscriber` interessados para tratar o novo tipo.
  3. Publicar pelo `EventBus` como já é feito com `PedidoEvent`.

- **Novos status de pedido**:
  1. Incluir no enum `StatusPedido`.
  2. Ajustar lógica dos `Subscriber` que dependem de valores específicos.

## Licença

Este projeto é disponibilizado para fins educativos. Adapte livremente conforme sua necessidade.
