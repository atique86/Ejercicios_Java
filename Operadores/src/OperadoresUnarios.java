public class OperadoresUnarios {
    public static void main(String[] args) {
        System.out.println(" **** Operadores Unarios **** ");
        int a = 3, b = -2, resultado = 0;
        var c = true;

        // Operador unario +
        resultado = +a;
        System.out.println("resultado +a = " + resultado);

        // Operador unario -
        resultado = -a;
        System.out.println("resultado -a = " + resultado);

        // Operador unario incremento ++
        // Pre incremento
        a = 3;
        resultado = ++a;
        System.out.println("resultado ++a = " + resultado);
        // Post incremento
        a = 3;
        resultado = a++;
        System.out.println("resultado a++ = " + resultado);
        System.out.println("a este momento se incrementa = " + a);
        // Operador unario decremento --
        // Pre decremento
        b = -2;
        resultado = --b;
        System.out.println("resultado --b = " + resultado);
        // Post decremento
        b = -2;
        resultado = b--;
        System.out.println("resultado b-- = " + resultado);
        System.out.println("a este momento se decrementa = " + b);

    }
}
