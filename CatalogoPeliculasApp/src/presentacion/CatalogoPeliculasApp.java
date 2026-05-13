package presentacion;

import servicio.IServicioPeliculas;
import servicio.ServicioPeliculasArchivo;
import servicio.ServicioPeliculasLista;
import dominio.Pelicula;

import java.util.Scanner;

public class CatalogoPeliculasApp {
    public static void main(String[] args) {
        System.out.println("Bienvenido al catalogo de películas");
        var salir = false;
        var consola = new Scanner(System.in);

        // Agregamos la implementación del servicio
        // IServicioPeliculas servicioPeliculas = new ServicioPeliculasLista();
        IServicioPeliculas servicioPeliculas = new ServicioPeliculasArchivo();
        while (!salir) {
            try {
                mostrarMenu();
                salir = ejecutarOpciones(consola, servicioPeliculas);
            }
            catch (NumberFormatException e) {
                System.out.println("Error: Debe ingresar un número válido.");
            }
            catch (Exception e){
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
            System.out.println();
        } // Fin Whle
    }

    private static void mostrarMenu(){
        System.out.println("""
                **** Catalogo de Películas ****
                1. Agregar película
                2. Listar películas
                3. Buscar película
                4. Salir
                """);
    }

    private static boolean ejecutarOpciones(Scanner consola, IServicioPeliculas servicioPeliculas){
        System.out.print("Ingrese la opción deseada: ");
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opcion){
            case 1 -> {
                System.out.print("Introduzca el nombre de la película: ");
                var nombrePelicula = consola.nextLine().trim();
                if (nombrePelicula.isEmpty()) {
                    System.out.println("Error: El nombre no puede estar vacío.");
                } else {
                    servicioPeliculas.agregarPelicula(new Pelicula(nombrePelicula));
                }
            }
            case 2 -> servicioPeliculas.listarPeliculas();
            case 3 ->{
                System.out.print("Ingrese el nombre de la película a buscar: ");
                var buscar = consola.nextLine().trim();
                if (buscar.isEmpty()) {
                    System.out.println("Error: Debe ingresar un nombre para buscar.");
                } else {
                    servicioPeliculas.buscarPelicula(new Pelicula(buscar));
                }
            }
            case 4 ->{
                System.out.println("Hasta pronto ...");
                salir = true;
            }
            default -> System.out.println("Opción no reconocida: " + opcion);
        }
        return salir;
    }
}
