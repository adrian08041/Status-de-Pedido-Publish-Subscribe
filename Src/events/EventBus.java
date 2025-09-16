package events;

import java.util.ArrayList;
import java.util.List;

public class EventBus {
    private final List<Subscriber> subscribers = new ArrayList<>();

    public void subscribe(Subscriber subscriber) {
        subscribers.add(subscriber);
    }

    public void publish(PedidoEvent event) {
        for (Subscriber s : subscribers) {
            s.onEvent(event);
        }
    }
}
