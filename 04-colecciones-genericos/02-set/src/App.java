import java.util.List;
import java.util.ArrayList;
import java.util.Set;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;
import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        List<Cuenta> cuentas = new ArrayList<>();

        cuentas.add(
                new CuentaAhorro("Juan Pérez", "1234567890",
                        new BigDecimal("1000.00"),
                        new BigDecimal("0.05")));
        cuentas.add(
                new CuentaAhorro("Ana Gómez", "1122334455",
                        new BigDecimal("2000.00"),
                        new BigDecimal("0.03")));
        cuentas.add(
                new CuentaCorriente("María López", "0987654321",
                        new BigDecimal("1000.00"),
                        new BigDecimal("500.00")));
        cuentas.add(
                new CuentaCorriente("Carlos Sánchez", "5566778899",
                        new BigDecimal("500.00"),
                        new BigDecimal("300.00")));

        // Extraer números de cuenta a las tres implementaciones de Set
        Set<String> numerosHash = new HashSet<>();
        Set<String> numerosLinked = new LinkedHashSet<>();
        Set<String> numerosTree = new TreeSet<>();

        for (Cuenta cuenta : cuentas) {
            numerosHash.add(cuenta.getNumeroCuenta());
            numerosLinked.add(cuenta.getNumeroCuenta());
            numerosTree.add(cuenta.getNumeroCuenta());
        }

        System.out.println("HashSet (sin orden garantizado): " + numerosHash);
        System.out.println("LinkedHashSet (orden de inserción): " + numerosLinked);
        System.out.println("TreeSet (orden natural/alfabético): " + numerosTree);

        // Prueba de unicidad: intentar agregar un número de cuenta repetido
        System.out.println("\nPrueba de duplicados");

        // Ya existe en la lista
        boolean agregado = numerosHash.add("1234567890");
        System.out.println("¿Se agregó el duplicado '1234567890'? " + agregado);
        System.out.println("Tamaño del HashSet tras el intento: " + numerosHash.size());

        // Gotcha: Set<Cuenta> en vez de Set<String> 
        System.out.println("\nGotcha: HashSet<Cuenta>");

        // Dos objetos DISTINTOS en memoria, pero representan la MISMA cuenta real
        // (mismo titular, mismo numeroCuenta, mismo saldo)
        Cuenta cuentaOriginal = new CuentaAhorro("Juan Pérez", "1234567890", new BigDecimal("1000.00"), new BigDecimal("0.05"));
        Cuenta cuentaDuplicada = new CuentaAhorro("Juan Pérez", "1234567890", new BigDecimal("1000.00"), new BigDecimal("0.05"));

        Set<Cuenta> cuentasHash = new HashSet<>();
        cuentasHash.add(cuentaOriginal);
        cuentasHash.add(cuentaDuplicada);
        System.out.println("Tamaño esperado: 1 (misma cuenta real) | Tamaño real: " + cuentasHash.size());

        System.out.println("\nGotcha: TreeSet<Cuenta>");

        // Dos cuentas de clientes DISTINTOS, que casualmente tienen el mismo saldo
        Cuenta cuentaJuan = new CuentaAhorro("Juan Pérez", "1234567890", new BigDecimal("1000.00"), new BigDecimal("0.05"));
        Cuenta cuentaMaria = new CuentaCorriente("María López", "0987654321", new BigDecimal("1000.00"), new BigDecimal("500.00"));

        Set<Cuenta> cuentasTree = new TreeSet<>();
        cuentasTree.add(cuentaJuan);
        cuentasTree.add(cuentaMaria);
        System.out.println("Tamaño esperado: 2 (clientes distintos) | Tamaño real: " + cuentasTree.size());
    }
}
