import java.util.Date;
import java.math.BigDecimal;

public class CuentaBancaria {
    private final String nombreTitular;
    private final String numeroCuenta;
    private final String numeroCuentaCci;
    private BigDecimal saldoDisponible;
    private final Date fechaCreacion;

    public CuentaBancaria(String nombreTitular, String numeroCuenta, String numeroCuentaCci, BigDecimal saldoDisponible, Date fechaCreacion) {
        
        if (nombreTitular == null || nombreTitular.isEmpty()) {
            throw new IllegalArgumentException("El nombre del titular no puede ser nulo o vacío");
        }

        if (numeroCuenta == null || numeroCuenta.isEmpty()) {
            throw new IllegalArgumentException("El número de cuenta no puede ser nulo o vacío");
        }

        if (numeroCuentaCci == null || numeroCuentaCci.isEmpty()) {
            throw new IllegalArgumentException("El número de cuenta CCI no puede ser nulo o vacío");
        }

        if (fechaCreacion == null) {
            throw new IllegalArgumentException("La fecha de creación no puede ser nula");
        }

        if (saldoDisponible == null || saldoDisponible.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("El saldo disponible no puede ser nulo o negativo");
        }
        
        this.nombreTitular = nombreTitular;
        this.numeroCuenta = numeroCuenta;
        this.numeroCuentaCci = numeroCuentaCci;
        this.saldoDisponible = saldoDisponible;
        this.fechaCreacion = fechaCreacion;
    }

    public boolean depositar(BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) > 0) {
            saldoDisponible = saldoDisponible.add(monto);
            return true;
        }
        return false;
    }

    public boolean retirar(BigDecimal monto) {
        if (monto.compareTo(BigDecimal.ZERO) > 0 && saldoDisponible.compareTo(monto) >= 0) {
            saldoDisponible = saldoDisponible.subtract(monto);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "CuentaBancaria{" +
                "nombreTitular='" + nombreTitular + '\'' +
                ", numeroCuenta='" + numeroCuenta + '\'' +
                ", numeroCuentaCci='" + numeroCuentaCci + '\'' +
                ", saldoDisponible=" + saldoDisponible +
                ", fechaCreacion=" + fechaCreacion +
                '}';
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNumeroCuentaCci() {
        return numeroCuentaCci;
    }

    public BigDecimal getSaldoDisponible() {
        return saldoDisponible;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }
}
