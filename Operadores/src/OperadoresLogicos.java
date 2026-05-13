public class OperadoresLogicos {
    public static void main(String[] args) {
        System.out.println(" **** Operadores Lógicos **** ");
        boolean a = true, b = false;
        System.out.printf("""
                Valores iniciales:
                a = %b
                b = %b
                """,a,b);

        // Operador lógico AND
        var resultado = a && b;
        System.out.println("resultado a && b = " + resultado);

        // Operador lógico OR
        resultado = a || b;
        System.out.println("resultado a || b = " + resultado);

        // Operador lógico NOT
        resultado = !a;
        System.out.println("resultado !a = " + resultado);
    }
}
