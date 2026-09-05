package cl.duoc.pedidos360.productos.repository;

import cl.duoc.pedidos360.productos.entity.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Interfaz que hereda los métodos CRUD automáticos (findAll, save, findById)
@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long> {
}