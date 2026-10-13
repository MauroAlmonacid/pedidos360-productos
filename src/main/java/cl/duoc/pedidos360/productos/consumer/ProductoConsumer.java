package cl.duoc.pedidos360.productos.consumer;

import cl.duoc.pedidos360.productos.dto.EventoPedidoCreado;
import cl.duoc.pedidos360.productos.dto.ItemDTO;
import cl.duoc.pedidos360.productos.entity.ProductoEntity;
import cl.duoc.pedidos360.productos.repository.ProductoRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * Consumidor que escucha la cola "cola.productos" y descuenta el stock
 * de cada producto incluido en el evento de pedido creado.
 */
@Component
public class ProductoConsumer {

    private static final Logger log = LoggerFactory.getLogger(ProductoConsumer.class);

    private final ProductoRepository productoRepository;

    public ProductoConsumer(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @RabbitListener(queues = "cola.productos")
    public void recibirPedido(EventoPedidoCreado evento) {
        log.info(">>> [PRODUCTOS] Evento recibido. Orden ID: {} - Cliente: {}",
                evento.getIdOrden(), evento.getClienteEmail());

        if (evento.getItems() == null || evento.getItems().isEmpty()) {
            log.warn(">>> [PRODUCTOS] La orden {} no contiene items. Nada que descontar.",
                    evento.getIdOrden());
            return;
        }

        for (ItemDTO item : evento.getItems()) {
            Optional<ProductoEntity> productoOpt = productoRepository.findById(item.getIdProducto());

            if (productoOpt.isEmpty()) {
                log.warn(">>> [PRODUCTOS] Producto ID {} no existe en la BD. Se omite.",
                        item.getIdProducto());
                continue;
            }

            ProductoEntity producto = productoOpt.get();
            int stockAnterior = producto.getStock();
            int nuevoStock = stockAnterior - item.getCantidad();

            producto.setStock(nuevoStock);
            productoRepository.save(producto);

            log.info(">>> [PRODUCTOS] Descontando stock para el producto ID: {} Stock anterior: {} Nuevo stock: {}",
                    producto.getId(), stockAnterior, nuevoStock);
        }
    }
}
