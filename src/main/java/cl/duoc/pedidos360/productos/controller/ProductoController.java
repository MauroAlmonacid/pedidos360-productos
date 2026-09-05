package cl.duoc.pedidos360.productos.controller;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.pedidos360.productos.model.Producto;

/**
 * Controlador REST del catálogo de productos.
 *
 * Expone endpoints sin seguridad local a propósito: la autenticación y
 * autorización ya fueron validadas en el borde por AWS API Gateway con
 * Azure Entra ID como IDaaS, por lo que aquí solo nos encargamos de
 * serializar/deserializar JSON.
 */
@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*") // Permite consumo directo desde el frontend (SPA) en desarrollo.
public class ProductoController {

    /**
     * GET /productos
     *
     * Retorna un catálogo de prueba en memoria como JSON. Este listado simula
     * la salida de un repositorio/BD para validar el contrato de la API antes
     * de conectar una capa de persistencia real.
     *
     * @return lista de productos de ejemplo.
     */
    @GetMapping
    public List<Producto> listarProductos() {
        return List.of(
                new Producto(1L, "Notebook Lenovo Legion", "Computación", 549990.0, 12),
                new Producto(2L, "Mouse Inalámbrico Logitech", "Accesorios", 12990.0, 60),
                new Producto(3L, "Monitor Samsung 24 pulgadas", "Computación", 159990.0, 8)
        );
    }
}