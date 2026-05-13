public class TiposDatos {
    public static void main(String[] args) {
        // Tipos de datos en Java
        // Enteros (valor por defecto es 0)
        byte tipoByte = 127;
        System.out.println("tipoByte = " + tipoByte);
        short tipoShort = 32000;
        System.out.println("tipoShort = " + tipoShort);
        int tipoEntero = 2147483645;
        System.out.println("tipoEntero = " + tipoEntero);
        long tipoLong = 987654321098765432L;
        System.out.println("tipoLong = " + tipoLong);

        // Tipo punto flotante (Valor por defecto es 0.0)
        float tipoFloat = 3.14F; // F o f para indicar que es tipo float
        System.out.println("tipoFloat = " + tipoFloat); 
        double tipoDouble = 3.141516D; // D o d para indicar que es tipo double
        System.out.println("tipoDouble = " + tipoDouble);

        // Caracter (Valor por defecto es '\u0000' equivalente a 0)
        char tipoChar = 'T'; // Juego de caracteres Unicode
        System.out.println("tipoChar = " + tipoChar);
        tipoChar = 65; // 65 es la letra 'A' en el juego de caracteres Unicode
        System.out.println("tipoChar = " + tipoChar);
        tipoChar = '@';
        System.out.println("tipoChar = " + tipoChar);

        // Booleano (Valor por defecto es false)
        boolean tipoBoolean = true;
        System.out.println("tipoBoolean = " + tipoBoolean);
        tipoBoolean = false;
        System.out.println("tipoBoolean = " + tipoBoolean);

        // Tipos Object o Referencia (Valor por defecto es null / No hay referencia)
        String tipoCadena = null;
        System.out.println("tipoCadena = " + tipoCadena);
        tipoCadena = "Juan Perez Ossa";
        System.out.println("tipoCadena = " + tipoCadena);
    }
}
