import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class ListadoPersonasApp {
    public static void main(String[] args) {
        Scanner consola = new Scanner(System.in);
        // Definimos la lista fuera del ciclo while
        List<Persona> personas = new ArrayList<>();
        // Empezamos con el menú
        var salir = false;
        while (!salir){
            mostrarMenu();
            try{
                salir = ejecutarOperacion(consola, personas);
            } catch (Exception e) {
                System.out.println("Ocurrió un error: " + e.getMessage());
            }
            System.out.println();
        }
    }

    private static void mostrarMenu(){
        System.out.println("""
                **** Listado Personas App ****
                1. Agregar persona
                2. Listar personas
                3. Salir
                """);
        System.out.print("Ingrese la opción: ");

    }

    private static boolean ejecutarOperacion(Scanner consola, List<Persona> personas) {
        var opcion = Integer.parseInt(consola.nextLine());
        var salir = false;
        // Revisamos la opción proporcionada
        switch (opcion){
            case 1 ->{
                System.out.print("Ingrese el nombre: ");
                var nombre = consola.nextLine();
                System.out.print("Ingrese el teléfono: ");
                var telefono = consola.nextLine();
                System.out.print("Ingrese el email: ");
                var email = consola.nextLine();
                // Crear objeto persona
                var persona = new Persona(nombre,telefono,email);
                // Lo agregamos a la lista de persona
                personas.add(persona);
                System.out.println("Persona agregada");
                System.out.println("La lista de personas tiene " + personas.size() + " elementos");
            }// Fin caso 1
            case 2 ->{ // Listar persona
                System.out.println("Listado de personas");
                // Mejora usando lambda y metodo de referencia
                //personas.forEach((persona) -> System.out.println(persona));
                personas.forEach(System.out::println);
            }
            case 3 ->{
                System.out.println("Hasta pronto ...");
                salir = true;
            }
            default -> System.out.println("Opción erronea: " + opcion);
        } // Fin switch
        return salir;
    }
}