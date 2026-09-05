package cl.duoc.pedidos360.productos.model;

/**
 * Modelo de dominio que representa un producto del catálogo de Pedidos360.
 *
 * Se implementa como un {@code record} (tipo inmutable) por dos razones clave:
 * 1. La seguridad se valida en el borde (AWS API Gateway + Azure Entra ID), por lo
 *    que el microservicio solo necesita un modelo de transporte simple e inmutable.
 * 2. La inmutabilidad hace que el objeto sea thread-safe y que Jackson lo serialice
 *    a JSON sin configuración adicional ni setters expuestos.
 *
 * @param id        Identificador único del producto.
 * @param nombre    Nombre comercial del producto.
 * @param categoria Categoría a la que pertenece (ej: "Computación").
 * @param precio    Precio unitario del producto.
 * @param stock     Cantidad de unidades disponibles en inventario.
 */
public record Producto(
        Long id,
        String nombre,
        String categoria,
        double precio,
        int stock
) {
}