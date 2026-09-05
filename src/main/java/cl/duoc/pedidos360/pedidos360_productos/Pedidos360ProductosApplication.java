package cl.duoc.pedidos360.pedidos360_productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Clase principal de arranque del microservicio de productos.
 *
 * Se amplía el paquete base de escaneo a "cl.duoc.pedidos360" para que Spring
 * detecte los controladores y modelos que viven en el paquete
 * "cl.duoc.pedidos360.productos.*", que es hermano (no hijo) del paquete
 * raíz generado automáticamente por Spring Initializr.
 */
@SpringBootApplication(scanBasePackages = "cl.duoc.pedidos360")
public class Pedidos360ProductosApplication {

	public static void main(String[] args) {
		SpringApplication.run(Pedidos360ProductosApplication.class, args);
	}

}
