package subscribers;

import events.PedidoEvent;
import events.Subscriber;

import java.time.format.DateTimeFormatter;

public class LogSubscriber implements Subscriber {
    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");

    @Override
    public void onEvent(PedidoEvent event) {
        String timestamp = event.getTimestamp().format(formatter);
        System.out.println("🕒 [LOG]         → Pedido " + event.getId() +
                " alterado para: " + event.getStatus() +
                " em " + timestamp + "\n");
    }
}
