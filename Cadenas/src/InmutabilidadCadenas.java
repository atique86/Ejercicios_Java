public class InmutabilidadCadenas {
    public static void main(String[] args) {
        // Inmutabilidad de cadenas
        var cadena1 = "Hola";
        System.out.println("cadena1 = " + cadena1);
        var cadena2 = cadena1; // No se pierde la referencia al objeto creado inicialmente
        cadena1 = "Adios";
        System.out.println("cadena1 modificada = " + cadena1);
        System.out.println("cadena2 = " + cadena2);
    }
}
