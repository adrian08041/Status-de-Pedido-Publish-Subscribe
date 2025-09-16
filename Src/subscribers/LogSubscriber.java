package subscribers;

import events.PedidoEvent;
import events.Subscriber;

public class LogSubscriber implements Subscriber {
    @Override
    public void onEvent(PedidoEvent event) {
        System.out.println("[LOG] Pedido " + event.getId() +
                " alterado para: " + event.getStatus() +
                " em " + event.getTimestamp());
    }
}
