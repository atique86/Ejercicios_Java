public class IndicesCadena {
    public static void main(String[] args) {
        // Manejo de indices de una cadena
        var cadena1 = "Hola Mundo";

        // Recuperar el primer caracter de la cadena
        var primerCaracter = cadena1.charAt(0);
        System.out.println("primerCaracter = " + primerCaracter);
        // Recuperar el último caracter de la cadena
        var ultimoCaracter = cadena1.charAt(9);
        System.out.println("ultimoCaracter = " + ultimoCaracter);
        // Recuperar el caracter 'M'
        var caracterM = cadena1.charAt(5);
        System.out.println("caracterM = " + caracterM);
    }
}
