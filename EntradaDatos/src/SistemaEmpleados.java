import java.util.Scanner;

public class SistemaEmpleados {
    public static void main(String[] args) {
        System.out.println(" **** Sistema de empleados ****");
        var consola = new Scanner(System.in);

        // Nombre del empleado
        System.out.print("Nombre del empleado: ");
        var nombre = consola.nextLine();

        // Edad del empleado
        System.out.print("Edad del empleado: ");
        var edad = Integer.parseInt(consola.nextLine());

        // Salario del emleado
        System.out.print("Salario del empleado: ");
        var salario = Double.parseDouble(consola.nextLine());

        // Es jefe de departamento
        System.out.print("¿Es jefe de departamento? (true/false): ");
        var esJefeDepartamento = Boolean.parseBoolean(consola.nextLine());

        // Imprimir los valores capturados
        System.out.println("\n +++ Datos del empleado +++");
        System.out.println("\tNombre del empleado: " + nombre);
        System.out.println("\tEdad del empleado: " + edad + " años");
        System.out.printf("\tSalario del empleado: $ %.2f%n", salario);
        System.out.println("\t¿Es jefe de departamento? (true/false): " + esJefeDepartamento);
    }
}
