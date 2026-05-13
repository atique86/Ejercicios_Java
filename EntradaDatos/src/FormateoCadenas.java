public class FormateoCadenas {
    public static void main(String[] args) {
        System.out.println(" *** Formateo de cadenas ***");
        var nombre = "Pedro";
        var edad = 28;
        var salario = 25648.69;

        // String format
        var mensaje = String.format("Nombre: %s, Edad: %d, Salario: $%.2f",nombre,edad,salario);
        System.out.println(mensaje);

        // Metodo printf
        System.out.printf("Nombre: %s, Edad: %d, Salario: $%.2f%n",nombre,edad,salario);
        var numeroEmpleado = 12;

        // Formateo con text block
        mensaje = """
                Detalle Persona:
                -----------
                \tNombre: %s
                \tNúmero de empleado: %04d
                \tEdad: %d años
                \tSalario: $%.2f
                """.formatted(nombre,numeroEmpleado,edad,salario);
        System.out.println(mensaje);

        // Formateo con text block y printf
        System.out.printf("""
                Detalle Persona:
                -----------
                \tNombre: %s
                \tNúmero de empleado: %04d
                \tEdad: %d años
                \tSalario: $%.2f
                """,nombre,numeroEmpleado,edad,salario);

    }
}


