import java.util.Date;
import java.math.BigDecimal;

public class CuentaBancaria {
    private String nombreTitular;
    private String numeroCuenta;
    private String numeroCuentaCci;
    private BigDecimal saldoDisponible;
    private Date fechaCreacion;

    public CuentaBancaria(String nombreTitular, String numeroCuenta, String numeroCuentaCci, BigDecimal saldoDisponible, Date fechaCreacion) {
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
