import java.math.BigDecimal;
import java.math.RoundingMode;

public class App {
    public static void main(String[] args) {

        try {
            BigDecimal resultado = dividir(10, 0);
            System.out.println("Resultado: " + resultado);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("La operación ha finalizado." + "\n");
        }

        boolean fondosSuficientes = false;
        try {
            fondosSuficientes = consultarFondos(new BigDecimal("100.00"), new BigDecimal("150.00"));
        } catch (FondosInsuficientesException e) {
            System.out.println(e.getMessage());
        } finally {
            System.out.println("La consulta de fondos ha finalizado.");
        }
        System.out.println("Fondos suficientes: " + fondosSuficientes);
    }

    public static BigDecimal dividir(int a, int b) {
        if (b == 0) {
            throw new IllegalArgumentException("El divisor no puede ser cero.");
        }
        return BigDecimal.valueOf(a).divide(BigDecimal.valueOf(b), RoundingMode.HALF_UP);
    }

    public static boolean consultarFondos(BigDecimal saldo, BigDecimal monto) throws FondosInsuficientesException {
        if (saldo.compareTo(monto) < 0) {
            throw new FondosInsuficientesException("Fondos insuficientes para realizar la operación.");
        }
        return true;
    }
}
