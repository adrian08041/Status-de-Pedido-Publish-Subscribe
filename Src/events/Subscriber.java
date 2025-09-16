package events;

public interface Subscriber {
    void onEvent(PedidoEvent event);
}
