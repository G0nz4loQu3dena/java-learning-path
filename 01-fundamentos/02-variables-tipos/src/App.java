public class App {
    public static void main(String[] args) {
        int edad = 30;
        char letra = 'A';
        byte numero = 100;
        float peso = 70.5f;
        double altura = 1.75;
        short cantidad = 2000;
        long distancia = 100000L;
        boolean esEstudiante = true;

        // Caso: intentas asignar numero grande a un byte, se produce 
        // un error de compilación si no se realiza un casting. Y de 
        // hecho, si el valor es mayor que 127 o menor que -128, se produce
        // un desbordamiento y el valor resultante no será el esperado.
        // ---
        //int numeroGrande = 130;
        //byte b1 = (byte) numeroGrande;

        System.out.println("Edad: " + edad);
        System.out.println("Letra: " + letra);
        System.out.println("Número: " + numero);
        System.out.println("Peso: " + peso);
        System.out.println("Altura: " + altura);
        System.out.println("Cantidad: " + cantidad);
        System.out.println("Distancia: " + distancia);
        System.out.println("Es estudiante: " + esEstudiante);
    }
}
