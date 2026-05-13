public class OperadoresAsignacion {
    public static void main(String[] args) {
        System.out.println(" **** Operadores de asignación **** ");
        // Asignación simple =
        var numero = 10;
        int numero2;
        numero2 = 15;
        System.out.println("numero = " + numero);
        System.out.println("numero2 = " + numero2);

        // +=
        numero += 7;
        System.out.println("numero = " + numero); // numero = numero + 7

        // *=
        numero *= 2;
        System.out.println("numero = " + numero); // numero = numero * 2

        // Asignación de variables multiples
        int a = 10, b = 15, c = 20;
        System.out.printf("a = %d, b = %d, c = %d",a,b,c);

    }
}
