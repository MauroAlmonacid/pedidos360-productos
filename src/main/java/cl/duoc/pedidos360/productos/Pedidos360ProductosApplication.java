package cl.duoc.pedidos360.productos; // Ahora vive en la raíz del microservicio

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// Al situarse en 'cl.duoc.pedidos360.productos', Spring Boot escanea
// automáticamente todos sus paquetes hijos: controller, entity, model y repository
@SpringBootApplication
public class Pedidos360ProductosApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pedidos360ProductosApplication.class, args);
    }
}