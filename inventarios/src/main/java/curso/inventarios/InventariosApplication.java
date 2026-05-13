package curso.inventarios;

import curso.inventarios.modelo.Producto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class InventariosApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventariosApplication.class, args);

		// Prueba Lombok
		Producto producto = new Producto();
		producto.setDescripcion("Monitor");
		producto.setPrecio(1000.0);
		producto.setExistencia(10);
		System.out.println(producto);
	}

}
