import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        // Lista de cuentas
        List<Cuenta> cuentas = new ArrayList<Cuenta>();

        // Cuenta de Ahorro
        Cuenta cuentaAhorro1 = new CuentaAhorro(
                "Juan Pérez",
                "1234567890",
                new BigDecimal("1000.00"),
                new BigDecimal("0.05")
        );

        Cuenta cuentaAhorro2 = new CuentaAhorro(
                "Ana Gómez",
                "1122334455",
                new BigDecimal("2000.00"),
                new BigDecimal("0.03")
        );

        // Cuenta Corriente
        Cuenta cuentaCorriente1 = new CuentaCorriente(
                "María López",
                "0987654321",
                new BigDecimal("1000.00"),
                new BigDecimal("500.00")
        );

        Cuenta cuentaCorriente2 = new CuentaCorriente(
                "Carlos Sánchez",
                "5566778899",
                new BigDecimal("500.00"),
                new BigDecimal("300.00")
        );

        // Agregar cuentas a la lista, acepta instancias de CuentaAhorro y 
        // CuentaCorriente porque ambas heredan de Cuenta
        cuentas.add(cuentaAhorro1);
        cuentas.add(cuentaAhorro2);
        cuentas.add(cuentaCorriente1);
        cuentas.add(cuentaCorriente2);

        // Imprimir cuentas antes de ordenar
        System.out.println("Cuentas antes de ordenar:");
        imprimirCuentas(cuentas);

        Collections.sort(cuentas);

        // Imprimir cuentas después de ordenar
        System.out.println("\nCuentas después de ordenar por saldo disponible:");
        imprimirCuentas(cuentas);
    }

    public static void imprimirCuentas(List<Cuenta> cuentas) {
        for (Cuenta cuenta : cuentas) {
            System.out.println(cuenta);
        }
    }
}
