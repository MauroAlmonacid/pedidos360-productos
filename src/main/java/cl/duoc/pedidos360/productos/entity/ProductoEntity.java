package cl.duoc.pedidos360.productos.entity;

import jakarta.persistence.*;

@Entity // Le dice a Spring que esta clase representa una tabla en la base de datos
@Table(name = "productos")
public class ProductoEntity {

    @Id // Clave primaria
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Autoincremental
    private Long id;

    @Column(nullable = false)
    private String nombre;

    private String categoria;
    private double precio;
    private int stock;

    // Constructor vacío obligatorio para JPA
    public ProductoEntity() {}

    public ProductoEntity(String nombre, String categoria, double precio, int stock) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.precio = precio;
        this.stock = stock;
    }

    // Getters y Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) { this.precio = precio; }
    public int getStock() { return stock; }
    public void setStock(int stock) { this.stock = stock; }
}