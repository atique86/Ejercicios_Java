import java.util.Scanner;
import java.util.Random;

public class GeneradorIDUnico {
    public static void main(String[] args) {
        var consola = new Scanner(System.in);
        var random = new Random();
        System.out.println(" **** Sistema Generador de ID Unico");
        System.out.print("¿Cuál es su nombre?: ");
        var nombre = consola.nextLine();
        System.out.print("¿Cuál es su apellido?: ");
        var apellido = consola.nextLine();
        System.out.print("¿Cual es su año de nacimiento?(YYYY): ");
        var anioNacimiento = consola.nextLine();

        var nombreAbreviado = nombre.trim().substring(0,2).toUpperCase();
        var apellidoAbreviado = apellido.trim().substring(0,2).toUpperCase();
        var anioAbreviado = anioNacimiento.trim().substring(2,4);
        var numeroAleatorio = random.nextInt(9999)+1;
        //var numeroAleatorio = 2;
        
        //var salida = nombreAbreviado+apellidoAbreviado+anioAbreviado+numeroAleatorio;
        //System.out.println("salida = " + salida);

        // Formateo con text block
        var mensaje = """
                Hola %s:
                \tSu nuevo número de identificación (ID) generado por el sistema es:
                \t%s%s%s%04d
                ¡Felicidades!
                """.formatted(nombre,nombreAbreviado,apellidoAbreviado,anioAbreviado,numeroAleatorio);
        System.out.println(mensaje);
    }
}
