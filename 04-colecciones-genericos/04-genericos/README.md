# 04 - Genéricos

<div align="justify">

[← Módulo 4: Colecciones y genéricos](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- Escribir tu propia clase genérica (`Repositorio<T>`), en vez de solo consumir las que ya vienen en Java (`List<T>`, `Set<T>`, `Map<K,V>`).
- Por qué `<T>` te da seguridad de tipos, sin duplicar código por cada tipo de dato distinto.
- Evitar una fuga de encapsulación al exponer una colección interna hacia afuera.

## Antes de escribir código: preguntas para pensar

1. Ya usaste `List<Cuenta>` y `List<String>` — la misma clase `ArrayList`, funcionando con tipos completamente distintos, de forma segura (el compilador no te deja meter un `String` en una `List<Cuenta>`). Si tuvieras que escribir una clase `Repositorio` que guarde y gestione objetos de **cualquier tipo** (no solo `Cuenta`, también `Producto`, o lo que sea), ¿cómo la escribirías sin tener que duplicar la clase entera por cada tipo distinto?
2. Si tu `Repositorio<T>` tiene un método `getAll()` que retorna la lista interna **directamente** (`return datos;`), ¿qué problema ves? Piensa en qué podría hacer quien reciba esa lista con ella.

## Conceptos, paso a paso

<div align="justify">

**`<T>` es un parámetro de tipo** — un "comodín" que se reemplaza por un tipo concreto cuando usas la clase, decidido por el compilador según cómo la instancies:

</div>

```java
public class Repositorio<T> {
    private List<T> datos = new ArrayList<>();

    public void save(T dato) {
        datos.add(dato);
    }

    public List<T> getAll() {
        return Collections.unmodifiableList(datos);
    }
}
```

```java
Repositorio<Producto> repositorioProductos = new Repositorio<Producto>();
repositorioProductos.save(producto1);  // OK
repositorioProductos.save("texto");    // ¡no compila! T ya quedó fijado como Producto
```

<div align="justify">

Una sola clase `Repositorio` sirve para `Producto`, `Cuenta`, o cualquier otro tipo, **con seguridad de tipos en cada caso** — sin escribir `RepositorioProducto`, `RepositorioCuenta`, etc. por separado.

</div>

<div align="justify">

**La fuga de encapsulación que se evita con `Collections.unmodifiableList`:** si `getAll()` retornara `datos` directamente, quien reciba esa lista podría hacer `lista.add(...)` o `lista.clear()` desde **afuera** del repositorio, modificando el estado interno sin pasar por `save()`/`remove()`/`update()` — rompiendo cualquier control que el repositorio quisiera imponer. `Collections.unmodifiableList(datos)` devuelve una **vista de solo lectura**: cualquier intento de modificarla desde afuera (`.add()`, `.remove()`) lanza `UnsupportedOperationException`. Importante: sigue siendo una **vista** sobre la misma lista interna, no una copia — si el repositorio cambia por dentro (vía `save`/`update`/`remove`), esos cambios **sí** se reflejan en cualquier lista que ya hayas obtenido con `getAll()`.

</div>

<div align="justify">

**`equals()`/`hashCode()` importan aquí también:** `Repositorio.update()` y `remove()` usan `datos.indexOf(elemento)` por dentro, que depende de `equals()` para encontrar el elemento correcto. Por eso `Producto` sobrescribe `equals()`/`hashCode()` usando `codigoProducto` como identidad de negocio — la misma idea que ya viste con `Cuenta` en `02-set`.

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
