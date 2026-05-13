import java.util.Scanner;

public class CalculadoraApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        while (continuar) {
            // Mostramos el menú de opciones
            mostrarMenu();
            System.out.print("Operación a realizar: ");
            try {
                var operacion = Integer.parseInt(scanner.nextLine());

                if (operacion >= 1 && operacion <= 4) {
                    ejecutarCalculo(operacion, scanner);
                } else if (operacion == 5) { // Salir
                    System.out.println("Hasta pronto ...");
                    continuar = false; // Terminar el bucle
                } else {
                    System.out.println("Opción es errónea: " + operacion);
                }
            } catch (NumberFormatException e) {
                System.out.println("Error: Entrada inválida. Por favor, ingrese un número.");
            } catch (ArithmeticException e) {
                System.out.println("Error: " + e.getMessage());
            } catch (Exception e) { // Captura genérica para otros errores inesperados
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
            if (continuar) {
                System.out.println(); // Línea en blanco para separar iteraciones del menú
            }
        } // Fin While
        scanner.close(); // Cerrar el scanner al finalizar
    } // Fin Main

    /**
     * Muestra el menú de opciones de la calculadora.
     */
    public static void mostrarMenu() {
        System.out.println(" **** Aplicación Calculadora **** ");
        // Se utiliza un bloque de texto (Java 15+) para el menú multi-línea
        System.out.println("""
                1. Suma
                2. Resta
                3. Multiplicación
                4. División
                5. Salir
                """);
    }

    /**
     * Lee un operando (número entero) desde la consola.
     * @param scanner El objeto Scanner para leer la entrada.
     * @param mensaje El mensaje a mostrar al usuario para solicitar el operando.
     * @return El número entero ingresado por el usuario.
     * @throws NumberFormatException si la entrada no es un entero válido.
     */
    public static double leerOperando(Scanner scanner, String mensaje) {
        System.out.print(mensaje);
        return Double.parseDouble(scanner.nextLine());
    }

    /**
     * Ejecuta la operación aritmética seleccionada.
     * Solicita los operandos y muestra el resultado.
     * @param tipoOperacion El número que identifica la operación (1:Suma, 2:Resta, 3:Mult, 4:Div).
     * @param scanner El objeto Scanner para leer los operandos.
     * @throws NumberFormatException si los operandos no son enteros válidos.
     * @throws ArithmeticException si se intenta dividir por cero.
     */
    public static void ejecutarCalculo(int tipoOperacion, Scanner scanner) {
        var operandoUno = leerOperando(scanner, "Proporcione el primer operando: ");
        var operandoDos = leerOperando(scanner, "Proporcione el segundo operando: ");

        switch (tipoOperacion) {
            case 1 -> { // Suma
                var resultado = operandoUno + operandoDos;
                System.out.println("Resultado suma: " + resultado);
            }
            case 2 -> { // Resta
                var resultado = operandoUno - operandoDos;
                System.out.println("Resultado resta: " + resultado);
            }
            case 3 -> { // Multiplicación
                var resultado = operandoUno * operandoDos;
                System.out.println("Resultado multiplicación: " + resultado);
            }
            case 4 -> { // División
                if (operandoDos == 0) {
                    // Lanzar una excepción para que sea capturada por el manejador en main
                    throw new ArithmeticException("No se puede dividir por cero.");
                }
                // La división de enteros trunca el resultado (ej. 5 / 2 = 2).
                // Si se desea división con decimales, se debería hacer un cast:
                // double resultado = (double) operandoUno / operandoDos;
                var resultado = operandoUno / operandoDos;
                System.out.println("Resultado división: " + resultado);
            }
            // No se necesita un 'default' aquí porque la validación de 'tipoOperacion' (1-4)
            // se realiza antes de llamar a este método.
        }
    }
}