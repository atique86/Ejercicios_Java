public class SentenciaIfElseIf {
    public static void main(String[] args) {
        var edad = 10;
        if (edad >= 18) {
            System.out.println("Eres mayor de edad");
        } else if (edad >= 13) {
            System.out.println("Eres un adolescente");
        } else { // edad >= 0 y edad < 13
            System.out.println("Eres un niño");
        }
    }
}