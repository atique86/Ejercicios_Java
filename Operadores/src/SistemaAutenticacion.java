import java.util.Scanner;

public class SistemaAutenticacion {
    public static void main(String[] args) {
        System.out.println(" **** Sistema de Autenticación **** ");
        var consola = new Scanner(System.in);
        // Constante de usuario y contraseña
        final var USUARIO = "adminuser";
        final var CONTRASENA = "789";

        // Solicitar datos al usuario
        System.out.print("¿Cuál es su usuario?: ");
        var usuario = consola.nextLine().trim();
        System.out.print("¿Cuál es su contraseña?: ");
        var contrasena = consola.nextLine().trim();

        // Comparar datos
        var datosCorrectos = usuario.equals(USUARIO) && contrasena.equals(CONTRASENA);
        System.out.println("¿Datos son correctos?: " + datosCorrectos);

    }
}
