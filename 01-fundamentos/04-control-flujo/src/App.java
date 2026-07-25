public class App {
    public static void main(String[] args) {
        // P1: Control de flujo con if, else if y else. Obteniendo
        // resultado según la nota obtenida.
        int nota = 85;
        char resultado;

        if (nota >= 90 && nota <= 100) {
            resultado = 'A';
        } else if (nota >= 80 && nota < 90) {
            resultado = 'B';
        } else if (nota >= 70 && nota < 80) {
            resultado = 'C';
        } else  {
            resultado = 'D';
        }

        System.out.println("La nota es: " + resultado);

        // P2: Control de flujo con switch. Obteniendo
        // resultado según dia de la semana.
        int diaSemana = 3;
        String dia;

        switch (diaSemana) {
            case 1:
                dia = "Lunes";
                break;
            case 2:
                dia = "Martes";
                break;
            case 3:
                dia = "Miércoles";
                break;
            case 4:
                dia = "Jueves";
                break;
            case 5:
                dia = "Viernes";
                break;
            case 6:
                dia = "Sábado";
                break;
            case 7:
                dia = "Domingo";
                break;
            default:
                dia = "Día no válido";
        }

        System.out.println("El día de la semana es: " + dia);

        // P3: Control de flujo con bucles. Imprimiendo los números del 1 al 5.
        for (int i = 1; i <= 5; i++) {
            System.out.print(i + " ");
        }

        // P4: Control de flujo con bucles while. Sumar numeros del 1 al 10 usando
        // un contador e imprimir el total final.
        int suma = 0;
        int contador = 1;

        while (contador <= 10) {
            suma += contador;
            contador++;
        }
        System.out.println("\nLa suma de los números del 1 al 10 es: " + suma);

        // P5: Control de flujo con bucles do-while. Imprimiendo "Hola" aunque la 
        // condición sea falsa.
        int numero = 0;
        do {
            System.out.println("Hola");
            numero++;
        } while (numero < 0);

    }
}
