import events.*;
import subscribers.*;

public class Main {
    public static void main(String[] args) {
        EventBus bus = new EventBus();

        // Inscrevendo subscribers
        bus.subscribe(new NotificacaoSubscriber());
        bus.subscribe(new LogSubscriber());

        // Publicando eventos (mudanças no status do pedido)
        bus.publish(new PedidoEvent("123", StatusPedido.CRIADO));
        bus.publish(new PedidoEvent("123", StatusPedido.PAGAMENTO_APROVADO));
        bus.publish(new PedidoEvent("123", StatusPedido.ENVIADO));
        bus.publish(new PedidoEvent("123", StatusPedido.ENTREGUE));
    }
}
