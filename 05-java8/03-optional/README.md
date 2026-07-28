# 03 - Optional

<div align="justify">

[← Módulo 5: Java 8](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- El problema real que causa devolver `null` cuando "no hay nada que retornar".
- Cómo `Optional<T>` mueve ese error de un crash en runtime a un error de compilación.
- `orElseThrow`, y por qué pide un `Supplier` de excepción en vez de una excepción ya construida.
- Confusión clásica de sintaxis: `::` (referencia) vs `.` (llamada).

## Antes de escribir código: preguntas para pensar

1. Imagina un método que busca algo en una lista y, si no lo encuentra, hace `return null;`. Si quien lo llama olvida revisar si el resultado es `null` antes de usarlo, ¿qué pasa? ¿Por qué es un patrón peligroso en Java, aunque compile sin problema?
2. Si en cambio el método devolviera `Optional<Ciudad>` en vez de `Ciudad`, ¿qué cambia **estructuralmente**? ¿Por qué el simple hecho de que el tipo de retorno diga `Optional<Ciudad>` ya le avisa algo importante a quien llama al método, antes incluso de leer la documentación?

## Conceptos, paso a paso

<div align="justify">

**Por qué devolver `null` es peligroso: es un error silencioso y diferido.** El compilador no te avisa nada cuando escribes `resultado.getArtista()` sobre algo que podría ser `null` — compila perfecto, y el crash (`NullPointerException`) puede aparecer mucho después, en una parte del código lejana a donde realmente estaba el error.

</div>

<div align="justify">

**Lo que cambia con `Optional<T>` — no es solo un nombre, es un tipo distinto.** `Optional<Ciudad>` **no tiene** un método `getArtista()` — solo `Ciudad` lo tiene. `Optional` es una caja que envuelve a la `Ciudad` (o no envuelve nada), y esa caja te obliga a pasar primero por su propia API (`.get()`, `.orElse(...)`, `.orElseThrow(...)`, `.ifPresent(...)`) para llegar a lo de adentro. El error de "olvidé manejar el caso vacío" pasa de aparecer en **runtime**, tarde y en cualquier lugar, a aparecer en **compile-time**, inmediatamente donde lo cometiste — el mismo tipo de garantía que ya viste con las excepciones *checked* del módulo 3.

</div>

<div align="justify">

**Construir un `Optional` de forma directa, con `Stream`:**

</div>

```java
public static Optional<Ciudad> buscarPorNombre(List<Ciudad> ciudades, String nombreCiudad) {
    return ciudades.stream().filter(ciudad -> ciudad.getNombre().equals(nombreCiudad)).findFirst();
}
```

<div align="justify">

`findFirst()` ya devuelve `Optional<Ciudad>` de forma nativa — no hace falta armar `Optional.of()`/`Optional.empty()` a mano.

</div>

<div align="justify">

**`orElseThrow` pide un `Supplier`, no una excepción ya construida:**

</div>

```java
.orElseThrow(() -> new NoSuchElementException("No se encontró la ciudad."))
```

<div align="justify">

`new NoSuchElementException(...)` construye la excepción **inmediatamente**, capturando su stack trace, incluso si el `Optional` sí tiene valor y la excepción nunca se va a lanzar. Con un `Supplier` (un lambda, o `NoSuchElementException::new` como *method reference* a constructor), la excepción solo se construye si realmente hace falta — la misma idea de evaluación perezosa que ya viste con Streams.

</div>

<div align="justify">

**Confusión de sintaxis a evitar: `::` no es lo mismo que `.`.** `System.out::println(x)` es un error de compilación — `::` crea una **referencia** al método (un valor, no una ejecución), así que no tiene sentido pasarle argumentos entre paréntesis justo ahí. Para ejecutar de una, se usa `System.out.println(x)`, con punto.

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
