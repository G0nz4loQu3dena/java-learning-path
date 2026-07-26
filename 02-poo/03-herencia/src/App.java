import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        // Cuenta de Ahorro
        CuentaAhorro cuentaAhorro = new CuentaAhorro(
                "Juan Pérez",
                "1234567890",
                new BigDecimal("1000.00"),
                new BigDecimal("0.05")
        );
        System.out.println(cuentaAhorro);

        cuentaAhorro.depositar(new BigDecimal("200.00"));
        System.out.println("Saldo después del depósito: " + cuentaAhorro.getSaldoDisponible());

        BigDecimal interesGenerado = cuentaAhorro.aplicarInteres();
        System.out.println("Interés generado: " + interesGenerado);
        System.out.println("Saldo después de aplicar interés: " + cuentaAhorro.getSaldoDisponible());

        try {
            cuentaAhorro.retirar(new BigDecimal("5000.00"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado en CuentaAhorro: " + e.getMessage() + "\n");
        }

        // Cuenta Corriente
        CuentaCorriente cuentaCorriente = new CuentaCorriente(
                "María López",
                "0987654321",
                new BigDecimal("1000.00"),
                new BigDecimal("500.00")
        );
        System.out.println(cuentaCorriente);

        cuentaCorriente.retirar(new BigDecimal("1500.00"));
        System.out.println("Saldo después del retiro: " + cuentaCorriente.getSaldoDisponible());

        try {
            cuentaCorriente.retirar(new BigDecimal("1.00"));
        } catch (IllegalArgumentException e) {
            System.out.println("Error esperado en CuentaCorriente: " + e.getMessage() + "\n");
        }

    }
}
