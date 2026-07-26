import java.math.BigDecimal;

public class App {
    public static void main(String[] args) {
        Repositorio<Producto> repositorioProductos = new Repositorio<Producto>();

        Producto producto1 = new Producto(
            "PRODPAPA", "Papa Dorada", new BigDecimal("3.50"), 20);
        repositorioProductos.save(producto1);

        Producto producto2 =  new Producto(
            "PRODCAMOTE", "Camote", new BigDecimal("5.50"), 15);
        repositorioProductos.save(producto2);

        var productos = repositorioProductos.getAll();

        // Iteracion de la lista de productos ANTES de modificaciones
        System.out.println("\nLista de productos ANTES de modificaciones:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }

        Producto nuevoProducto = new Producto(
                "PRODPAPA",
                "Papa Yungai",
                new BigDecimal("4.50"),
                30);

        repositorioProductos.update(producto1, nuevoProducto);

        // Descomentar la linea posterior en caso desear ver el caso eliminando un 
        // producto existente:
        //repositorioProductos.remove(producto2);

        // Iteracion de la lista de productos DESPUES de modificaciones
        System.out.println("\nLista de productos DESPUES de modificaciones:");
        for (Producto producto : productos) {
            System.out.println(producto);
        }
    }
}
