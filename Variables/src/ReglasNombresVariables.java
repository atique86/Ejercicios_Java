public class ReglasNombresVariables {
    public static void main(String[] args) {
        String nombreCompleto = "Pedro Pablo Pérez";
        System.out.println("nombreCompleto = " + nombreCompleto);

        String NombreCompleto = "Pedro Pablo Pérez 2"; // Correcto, pero no sigue las buenas prácticas (no usar mayúscula inicial)
        System.out.println("NombreCompleto = " + NombreCompleto);

        // String nombre-completo = "Juan"; // Incorrecto: los guiones no son válidos en nombres de variables

        String nombre_cliente = "Pablo"; // Correcto, pero se recomienda usar camelCase (nombreCliente)

        String _apellido = "González"; // Correcto, aunque el uso de guiones bajos iniciales se reserva para convenciones específicas
        String $apellido = "Martínez"; // Correcto, aunque el uso de '$' se reserva típicamente para código generado o variables especiales

        int totPzs = 10; //Correcto, pero no aplica las buenas prácticas
        int totalPiezas = 10; //Correcto y cumple con las buenas prácticas

        boolean casado = true; // Correcto, pero se puede mejorar
        boolean esCasado = true; // Correcto y aplica buenas prácticas
    }
}
