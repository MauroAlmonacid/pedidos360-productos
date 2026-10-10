package cl.duoc.pedidos360.productos.controller;

import cl.duoc.pedidos360.productos.entity.ProductoEntity;
import cl.duoc.pedidos360.productos.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/productos")
public class ProductoController {

    private final ProductoRepository productoRepository;

    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    // Endpoint que entregará la lista completa de productos
    @GetMapping
    public List<ProductoEntity> listarProductos() {
        return productoRepository.findAll();
    }
}