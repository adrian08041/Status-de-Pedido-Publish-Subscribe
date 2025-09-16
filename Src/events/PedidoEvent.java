package events;

import java.time.LocalDateTime;

public class PedidoEvent {
    private final String id;
    private final StatusPedido status;
    private final LocalDateTime timestamp;

    public PedidoEvent(String id, StatusPedido status) {
        this.id = id;
        this.status = status;
        this.timestamp = LocalDateTime.now();
    }

    public String getId() {
        return id;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
