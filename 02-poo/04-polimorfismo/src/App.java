import java.util.List;
import java.util.ArrayList;
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        // Lista de cuentas
        List<Cuenta> cuentas = new ArrayList<Cuenta>();

        // Cuenta de Ahorro
        Cuenta cuentaAhorro = new CuentaAhorro(
                "Juan Pérez",
                "1234567890",
                new BigDecimal("1000.00"),
                new BigDecimal("0.05")
        );

        // Cuenta Corriente
        Cuenta cuentaCorriente = new CuentaCorriente(
                "María López",
                "0987654321",
                new BigDecimal("1000.00"),
                new BigDecimal("500.00")
        );

        // Agregar cuentas a la lista, acepta instancias de CuentaAhorro y 
        // CuentaCorriente porque ambas heredan de Cuenta
        cuentas.add(cuentaAhorro);
        cuentas.add(cuentaCorriente);

        // Iterar sobre la lista de cuentas y realizar operaciones 
        for (Cuenta cuenta : cuentas) {
            // 1) Mostrar información de la cuenta
            System.out.println(cuenta);

            // 2) Intentar retirar un monto de 1500.00
            try {
                cuenta.retirar(new BigDecimal("1500.00"));
                System.out.println("Se retiró de " + cuenta.getNumeroCuenta() + " el monto de 1500.00");
            } catch (IllegalArgumentException e) {
                System.out.println("No se pudo retirar de " + cuenta.getNumeroCuenta() + ": " + e.getMessage());
            }

            // 3) Aplicar intereses si es una cuenta de ahorro
            if (cuenta instanceof CuentaAhorro cuentaAhorroVerificada) {
                cuentaAhorroVerificada.aplicarInteres();
            }
            
            // 4) Mostrar información de la cuenta después de las operaciones
            System.out.println(cuenta + "\n");
        }
    }
}
