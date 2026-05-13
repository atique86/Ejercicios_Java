package curso.presentacion;

import curso.datos.EstudianteDAO;
import curso.dominio.Estudiante;

import java.util.Scanner;

public class SistemaEstudiantesApp {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);

        // Se crea una instancia de la clase servicio
        var estudianteDao = new EstudianteDAO();
        while (!salir){
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, estudianteDao);
            } catch (Exception e) {
                System.out.println("Ocurrió un error al ejecutar la operación: " + e.getMessage());
            }
            System.out.println();
        } // Fin While
    }

    private static void mostrarMenu() {
        System.out.print("""
                **** Sistema de Estudiantes ****
                1. Listar Estudiantes
                2. Buscar Estudiante
                3. Agregar Estudiante
                4. Modificar Estudiante
                5. Eliminar Estudiante
                6. Salir
                Elija una opción:\s""");
    }

    private static boolean ejecutarOpciones(Scanner consola, EstudianteDAO estudianteDAO){
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> { // Listar estudiantes
                System.out.println("Listado de estudiantes: ");
                var estudiantes = estudianteDAO.listarEstudiantes();
                estudiantes.forEach(System.out::println);
            }
            case 2 -> { // Buscar estudiante por Id
                System.out.print("Introduzca el Id del estudiante a buscar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudiante);
                if(encontrado){
                    System.out.println("Estudiante encontrado: " + estudiante);
                }else {
                    System.out.println("Estudiante con Id " + estudiante.getIdEstudiante() + ", no encontrado.");
                }
            }
            case 3 -> { // Agregar estudiante
                System.out.println(" --- Agregar estudiante --- ");
                System.out.print("Nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Apellido: ");
                var apellido = consola.nextLine();
                System.out.print("Telefono: ");
                var telefono = consola.nextLine();
                System.out.print("Email: ");
                var email = consola.nextLine();
                var nuevoEstudiante = new Estudiante(nombre, apellido, telefono, email);
                var agregado = estudianteDAO.insertarEstudiante(nuevoEstudiante);
                if (agregado) {
                    System.out.println("Estudiante agregado: " + nuevoEstudiante);
                } else {
                    System.out.println("Error al agregar el estudiante: " + nuevoEstudiante);
                }
            }
            case 4 -> { // Modificar estudiante
                System.out.println(" --- Modificar estudiante ----");
                System.out.print("Id del estudiante a modificar: ");
                var idEstudiante = Integer.parseInt(consola.nextLine());
                var estudianteId = new Estudiante(idEstudiante);
                var encontrado = estudianteDAO.buscarEstudiantePorId(estudianteId);
                if (encontrado) {
                    System.out.println("Estudiante encontrado: " + estudianteId);
                    System.out.print("Nombre: ");
                    var nombre = consola.nextLine();
                    System.out.print("Apellido: ");
                    var apellido = consola.nextLine();
                    System.out.print("Teléfono: ");
                    var telefono = consola.nextLine();
                    System.out.print("Email: ");
                    var email = consola.nextLine();
                    var estudianteModificado = new Estudiante(idEstudiante, nombre, apellido, telefono, email);
                    var modificado = estudianteDAO.modificarEstudiante(estudianteModificado);
                    if (modificado) {
                        System.out.println("Estudiante modificado: " + estudianteModificado);
                    } else {
                        System.out.println("Error al modificar el estudiante: " + estudianteModificado);
                    }
                } else{
                    System.out.println("Estudiante con Id " + estudianteId.getIdEstudiante() + ", no encontrado.");
                }
            }
            case 5 -> {
                System.out.println(" --- Eliminar estudiante ----");
                System.out.print("Ingrese el Id del estudiante a eliminar: ");
                var estudianteId = Integer.parseInt(consola.nextLine());
                var estudiante = new Estudiante(estudianteId);
                var eliminado = estudianteDAO.eliminarEstudiante(estudiante);
                if (eliminado) {
                    System.out.println("Estudiante eliminado: " + estudianteId);
                } else {
                    System.out.println("Error al eliminar el estudiante: " + estudianteId);
                }
            }
            case 6 -> {
                System.out.println("Saliendo del Sistema ...");
                salir = true;
            }
            default -> System.out.println("Opción no valida. Intente nuevamente.");
        }
        return salir;
    }
}
