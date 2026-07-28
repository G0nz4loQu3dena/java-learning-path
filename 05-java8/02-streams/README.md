# 02 - Streams

<div align="justify">

[← Módulo 5: Java 8](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- Qué **es** realmente un `Stream` — no es una colección, no copia nada.
- Evaluación perezosa (*lazy evaluation*): la diferencia entre operaciones intermedias y terminales.
- Encadenar `filter` + `map` + `collect` en un solo pipeline.
- Un método genérico con `Consumer<T>` — la misma idea que ya existe en `List.forEach()`.

## Antes de escribir código: preguntas para pensar

1. `peliculas.stream().filter(pelicula -> pelicula.esExcelente())` — ¿qué crees que **es** exactamente ese `.stream()`? ¿Una copia nueva de tu `List`, o algo distinto? Piensa qué pasaría con la memoria si tuvieras una lista de un millón de elementos y la "copiaras" cada vez que filtras algo.
2. Si escribes esa línea de arriba y **no le agregas nada más** (ningún `.collect()`, `.forEach()`, etc.), ¿crees que en ese momento realmente se filtra algo? ¿O no pasa nada todavía?

## Conceptos, paso a paso

<div align="justify">

**Un `Stream` no es una colección — es un pipeline.** No copia los datos de tu `List`; es una vista/envoltorio delgado que va a leer los elementos originales uno por uno, **solo cuando algo lo dispare**. Piensa en una línea de ensamblaje: `filter()` es una estación que dice "solo dejo pasar lo que cumple esta condición", pero la cinta no se mueve sola.

</div>

<div align="justify">

**Evaluación perezosa (*lazy*) — el "botón de arranque" es la operación terminal.** Las operaciones intermedias (`filter`, `map`, `sorted`) **no ejecutan nada** por sí solas — solo describen pasos del pipeline y devuelven **otro `Stream`**, no un resultado. Recién cuando agregas una **operación terminal** (`.collect(...)`, `.forEach(...)`, `.count()`) se ejecuta todo el pipeline de una vez, elemento por elemento:

</div>

```java
// Solo arma el plan — NO ejecuta nada todavía
Stream<Pelicula> planeado = peliculas.stream().filter(Pelicula::esExcelente);

// AHORA sí se ejecuta todo, de principio a fin
List<Pelicula> excelentes = planeado.collect(Collectors.toList());
```

<div align="justify">

**Un pipeline encadenado, no pasos separados con `collect()` a mitad de camino:**

</div>

```java
List<String> titulosMuyReproducidos = canciones
        .stream()
        .filter(cancion -> cancion.getReproducciones() > 1_500_000_000L)
        .map(Cancion::getTitulo)
        .collect(Collectors.toList());
```

<div align="justify">

`filter` recibe un `Predicate<Cancion>` (¿pasa o no pasa?), `map` recibe un `Function<Cancion, String>` (transforma cada elemento a otra cosa) — las mismas interfaces funcionales del proyecto anterior. **Cortar el pipeline con un `.collect()` intermedio y luego hacer `map` sobre la lista ya coleccionada, en vez de encadenar todo junto, es un error común**: si haces `map` sobre la lista **original** (sin filtrar) en vez de sobre el resultado ya filtrado, terminas transformando elementos que nunca debiste incluir.

</div>

<div align="justify">

**Un método genérico con `Consumer<T>`, reinventando algo que ya existe:**

</div>

```java
public static <T> void imprimirElementos(List<T> elementos, Consumer<T> accion) {
    for (T elemento : elementos) {
        accion.accept(elemento);
    }
}
```

<div align="justify">

El `<T>` (genérico, módulo 4) hace que sirva para cualquier tipo de lista; `Consumer<T>` deja que quien llama decida **qué hacer** con cada elemento, sin que este método lo sepa de antemano. Dato curioso: esto es exactamente lo que ya trae `List.forEach(Consumer<T>)` desde Java 8 — en código real, `canciones.forEach(System.out::println)` hace lo mismo sin necesidad de escribir el método propio.

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
