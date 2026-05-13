package curso.estudiantes;

import curso.estudiantes.modelo.Estudiante;
import curso.estudiantes.servicio.EstudianteServicio;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServicio estudianteServicio;

	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	String ln = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicación ...");
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info("Aplicación finalizada");
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info(ln + "Ejecutando el método run ..." + ln);
		var salir = false;
		var consola = new Scanner(System.in);
		while(!salir){
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(ln);
		} // Fin While
	}

	private void mostrarMenu(){
		logger.info(ln);
		logger.info("""
				****  Sistema de Estudiantes  ****
				1. Listar Estudiantes
				2. Buscar Estudiante por ID
				3. Agregar Estudiante
				4. Modificar Estudiante
				5. Eliminar Estudiante
				6. Salir
				Elija una opción:\s""");
	}


	private boolean ejecutarOpciones(Scanner consola){
		var salir = false;
		var opcion = consola.nextInt();
		switch(opcion){
			case 1 -> { // Listar Estudiantes
				logger.info(ln + "Listando Estudiantes ..." + ln);
				List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach( estudiante -> logger.info(estudiante.toString() + ln));
			}
			case 2 ->{ // Buscar Estudiante por ID
				logger.info("Introduzca el Id del estudiante a buscar: ");
				var idEstudiante = Integer.parseInt(consola.next());
				var estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					logger.info("Estudiante encontrado: " + estudiante + ln);
				} else {
					logger.info("Estudiante no encontrado con Id: " + idEstudiante + ln);
				}
			}
			case 3 -> { // Agregar Estudiante
				logger.info(ln + "Agregando Estudiante ..." + ln);
				logger.info("Nombre: ");
				var nombre = consola.nextLine();
				logger.info("Apellido: ");
				var apellido = consola.nextLine();
				logger.info("Teléfono: ");
				var telefono = consola.next();
				logger.info("Email: ");
				var email = consola.next();
				// Crear objeto Estudiante sin el Id
				var estudiante = new Estudiante();
				estudiante.setNombre(nombre);
				estudiante.setApellido(apellido);
				estudiante.setTelefono(telefono);
				estudiante.setEmail(email);
				estudianteServicio.guardarEstudiante(estudiante);
				logger.info("Estudiante guardado: " + estudiante + ln);
			}
			case 4 -> { // Modificar Estudiante
				logger.info(ln + "Modificando Estudiante ..." + ln);
				logger.info("Introduzca el Id del estudiante a modificar: ");
				var idEstudiante = Integer.parseInt(consola.next());
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					logger.info("Nombre: ");
					var nombre = consola.nextLine();
					logger.info("Apellido: ");
					var apellido = consola.nextLine();
					logger.info("Teléfono: ");
					var telefono = consola.next();
					logger.info("Email: ");
					var email = consola.next();
					estudiante.setNombre(nombre);
					estudiante.setApellido(apellido);
					estudiante.setTelefono(telefono);
					estudiante.setEmail(email);
					estudianteServicio.guardarEstudiante(estudiante);
					logger.info("Estudiante modificado: " + estudiante + ln);
				} else {
					logger.info("Estudiante no encontrado con Id: " + idEstudiante + ln);
				}
			}
			case 5 -> { // Eliminar Estudiante
				logger.info("Eliminando Estudiante ..." + ln);
				logger.info("Introduzca el Id del estudiante a eliminar: ");
				var idEstudiante = Integer.parseInt(consola.next());
				Estudiante estudiante = estudianteServicio.buscarEstudiantePorId(idEstudiante);
				if(estudiante != null){
					estudianteServicio.eliminarEstudiante(estudiante);
					logger.info("Estudiante eliminado: " + estudiante + ln);
				} else {
					logger.info("Estudiante no encontrado con Id: " + idEstudiante + ln);
				}
			}
			case 6 -> {
					logger.info("Hasta pronto ..." + ln + ln);
					salir = true;
					consola.close();
			}
			default -> logger.info("Opción no valida. Intente de nuevo" + ln);
		}
		return salir;
	}
}
