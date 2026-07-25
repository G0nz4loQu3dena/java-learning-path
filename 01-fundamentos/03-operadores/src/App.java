public class App {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;

        // Operadores aritméticos
        System.out.println("Suma: " + (a + b));
        System.out.println("Resta: " + (a - b));
        System.out.println("Multiplicación: " + (a * b));
        System.out.println("División: " + (a / b));
        System.out.println("Módulo: " + (a % b));

        // Operadores de asignación
        boolean verdadero = true, falso = false;
        System.out.println("Verdadero && Falso: " + (verdadero && falso));
        System.out.println("Verdadero || Falso: " + (verdadero || falso));
        System.out.println("Negación de Verdadero: " + (!verdadero));
        System.out.println("Negación de Falso: " + (!falso));

        // Operador ternario
        System.out.println("Operador ternario: " + (a > b ? "a es mayor que b" : "a es menor o igual que b"));
    }
}
