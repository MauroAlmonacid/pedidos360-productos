package cl.duoc.pedidos360.pedidos360_productos;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(scanBasePackages = "cl.duoc.pedidos360")
// Le ordena a Spring buscar repositorios JPA en todos los paquetes del proyecto:
@EnableJpaRepositories(basePackages = "cl.duoc.pedidos360")

@EntityScan(basePackages = "cl.duoc.pedidos360")
public class Pedidos360ProductosApplication {

    public static void main(String[] args) {
        SpringApplication.run(Pedidos360ProductosApplication.class, args);
    }
}