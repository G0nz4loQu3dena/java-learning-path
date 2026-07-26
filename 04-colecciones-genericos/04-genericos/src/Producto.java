import java.math.BigDecimal;

public class Producto {
    private final String codigoProducto;
    private final String nombre;
    private BigDecimal precio;
    private long stock;

    public Producto(String codigoProducto, String nombre, BigDecimal precio, long stock) {
        this.codigoProducto = codigoProducto;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
    }

    public void actualizarPrecio(BigDecimal nuevoPrecio) {
        if (nuevoPrecio.compareTo(BigDecimal.ZERO) <= 0) {
            throw new IllegalArgumentException("Solo puedes actualizar por precios positivos y mayor a cero");
        }
        this.precio = nuevoPrecio;
    }

    public void incrementarStockEn(long nuevoStock) {
        if (nuevoStock <= 0) {
            throw new IllegalArgumentException("Ingresar un stock mayor a cero");
        }
        this.stock += nuevoStock;
    }

    public void decrementarStockEn(long nuevoStock) {
        if (nuevoStock <= 0) {
            throw new IllegalArgumentException("Ingresar un stock mayor a cero");
        }
        this.stock -= nuevoStock;
    }

    @Override
    public String toString() {
        return "\nCodigo: " + this.codigoProducto + 
        "\nNombre: " + this.nombre
        + "\nPrecio: " + this.precio
        + "\nStock: " + this.stock;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Producto)) {
            return false;
        }
        Producto otroProducto = (Producto)obj;
        return this.codigoProducto.equals(otroProducto.codigoProducto);
    }

    @Override
    public int hashCode() {
        return this.codigoProducto.hashCode();
    }
}
