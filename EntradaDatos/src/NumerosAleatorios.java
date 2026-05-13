import java.util.Random;

public class NumerosAleatorios {
    public static void main(String[] args) {
        System.out.println(" **** Números aleatorios ****");
        var random = new Random();

        // Generar un número aleatorio de 0 a 9
        var numeroAleatorio = random.nextInt(10);
        System.out.println("numeroAleatorio entre 0 y 9 = " + numeroAleatorio);

        // Generar un número aleatorio de 0 a 9
        var numeroAleatorioDos = random.nextInt(10)+1;
        System.out.println("numeroAleatorioDos entre 1 y 10 = " + numeroAleatorioDos);

        // Generar un número flotante entre 0.0 y 1.0
        var flotanteAleatorio = random.nextFloat();
        System.out.println("flotanteAleatorio = " + flotanteAleatorio);

        // Simular el lanzamiento de un dado (entre 1 y 6)
        var dado = random.nextInt(6) + 1;
        System.out.println("dado = " + dado);
    }
}
