public class App {
    public static void main(String[] args) {
        int resultado = suma(5, 10);
        int resultado2 = suma(5, 10, 15);
        System.out.println("La suma de dos números es: " + resultado);
        System.out.println("La suma de tres números es: " + resultado2);
    }

    // Metodo 1: Suma de dos numeros
    public static int suma(int num1, int num2) {
        return num1 + num2;
    }

    // Metodo 2: Suma de tres numeros (overloading)
    public static int suma (int num1, int num2, int num3) {
        return num1 + num2 + num3;
    }
}
