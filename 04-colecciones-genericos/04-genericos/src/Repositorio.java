import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

public class Repositorio<T> {
    private List<T> datos = new ArrayList<>();

    public void save(T dato) {
        datos.add(dato);
    }

    public boolean remove(T elemento) {
        return datos.remove(elemento);
    }

    public boolean update(T viejoElemento, T nuevoElemento) {
        int indice = datos.indexOf(viejoElemento);
        if (indice == -1) {
            return false;
        }
        datos.set(indice, nuevoElemento);
        return true;
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(datos);
    }
}
