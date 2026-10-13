package cl.duoc.pedidos360.productos.dto;

import java.util.List;

/**
 * Evento publicado por el microservicio de pedidos cuando se crea una orden.
 * Este microservicio lo consume para descontar el stock de cada producto.
 */
public class EventoPedidoCreado {

    private Long idOrden;
    private String clienteEmail;
    private Double total;
    private List<ItemDTO> items;

    public EventoPedidoCreado() {
    }

    public EventoPedidoCreado(Long idOrden, String clienteEmail, Double total, List<ItemDTO> items) {
        this.idOrden = idOrden;
        this.clienteEmail = clienteEmail;
        this.total = total;
        this.items = items;
    }

    public Long getIdOrden() {
        return idOrden;
    }

    public void setIdOrden(Long idOrden) {
        this.idOrden = idOrden;
    }

    public String getClienteEmail() {
        return clienteEmail;
    }

    public void setClienteEmail(String clienteEmail) {
        this.clienteEmail = clienteEmail;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public List<ItemDTO> getItems() {
        return items;
    }

    public void setItems(List<ItemDTO> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "EventoPedidoCreado{idOrden=" + idOrden + ", clienteEmail='" + clienteEmail
                + "', total=" + total + ", items=" + items + '}';
    }
}
