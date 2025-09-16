package subscribers;

import events.PedidoEvent;
import events.Subscriber;

public class NotificacaoSubscriber implements Subscriber {
    @Override
    public void onEvent(PedidoEvent event) {
        System.out.println("[NOTIFICAÇÃO] Pedido " + event.getId() +
                " agora está: " + event.getStatus());
    }
}
