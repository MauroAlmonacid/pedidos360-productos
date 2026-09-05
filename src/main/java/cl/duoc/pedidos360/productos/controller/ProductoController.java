package cl.duoc.pedidos360.productos.controller;

import cl.duoc.pedidos360.productos.entity.ProductoEntity;
import cl.duoc.pedidos360.productos.repository.ProductoRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productos")
@CrossOrigin(origins = "*")
public class ProductoController {

    private final ProductoRepository productoRepository;

    // Inyección de dependencias por constructor del repositorio
    public ProductoController(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @GetMapping
    public List<ProductoEntity> listarProductos() {
        return productoRepository.findAll(); // Consulta directa a la base de datos
    }
}