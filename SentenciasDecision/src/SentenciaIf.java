public class SentenciaIf {
    public static void main(String[] args) {
        // Uso de la sentencia If
        var edad = 10;
        if (edad >= 18)  {
            System.out.println("Eres mayor de edad");
        }
        else {
            System.out.println("Eres menor de edad");
        }

        // Operador ternario
        System.out.println("\n **** Operador ternario **** ");
        String mensaje = edad >= 18 ? "Eres mayor de edad" : "Eres menor de edad";
        System.out.println(mensaje);
    }
}