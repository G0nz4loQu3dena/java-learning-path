# 01 - Lambdas y Referencias a Métodos

<div align="justify">

[← Módulo 5: Java 8](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- Qué es una interfaz funcional, y por qué es el requisito exacto que hace posible un lambda.
- Sintaxis de lambda, usando `Comparator` como primer ejemplo real.
- Los 4 tipos de *method references* (`::`).
- Las interfaces funcionales base de `java.util.function`: `Function`, `Predicate`, `Consumer`, `Supplier`.

## Antes de escribir código: preguntas para pensar

1. `Comparator<T>` tiene varios métodos, pero solo **uno** sin implementación: `compare(T, T)`. ¿Por qué crees que Java exige que una interfaz tenga **exactamente un** método abstracto para poder usarse con la sintaxis de lambda? Si tuviera dos métodos abstractos con la misma cantidad de parámetros, ¿por qué seguiría sin funcionar, aunque en teoría "se pudiera distinguir"?
2. Compara estas dos formas de lo mismo:
   ```java
   // Clase anónima (antes de Java 8)
   Comparator<Cuenta> porSaldo = new Comparator<Cuenta>() {
       @Override
       public int compare(Cuenta a, Cuenta b) {
           return a.getSaldoDisponible().compareTo(b.getSaldoDisponible());
       }
   };
   // Lambda (Java 8+)
   Comparator<Cuenta> porSaldo = (a, b) -> a.getSaldoDisponible().compareTo(b.getSaldoDisponible());
   ```
   ¿Qué es exactamente **igual** entre ambas (de qué tipo termina siendo `porSaldo`), y qué es solo **azúcar sintáctica** (más corto, mismo resultado)?

## Conceptos, paso a paso

<div align="justify">

**Interfaz funcional = interfaz con exactamente un método abstracto.** Un lambda es solo "un pedacito de código: estos parámetros, este cuerpo" — no dice a qué método pertenece. Java lo infiere mirando el tipo de la variable: si esa interfaz tiene **un solo** método sin implementar, no hay ambigüedad posible sobre qué estás rellenando. Si tuviera dos métodos abstractos — incluso con firmas distintas — Java **no** intenta adivinar cuál: la regla es simple y absoluta ("exactamente uno"), en parte porque los parámetros del lambda suelen no llevar tipo explícito (`(a, b) -> ...`, sin decir que son `Cuenta`) — Java necesita saber primero cuál método implementa para poder inferir esos tipos, así que no puede haber ambigüedad de antemano.

</div>

<div align="justify">

**Comparable vs Comparator — repaso de la diferencia de "dónde vive":** `Comparable` (módulo 4) se implementa **dentro** de la clase (`Cuenta implements Comparable<Cuenta>`) — un único orden natural. `Comparator` es un objeto **externo e independiente**, que armas por fuera y le "prestas" a un método como `Collections.sort(lista, comparator)` — puedes tener tantos `Comparator` distintos como necesites, sin tocar la clase.

</div>

<div align="justify">

**Encadenando un `Comparator` con lambdas:**

</div>

```java
Comparator<Pelicula> porCalificacionYAnio = Comparator
        .comparing(Pelicula::getCalificacion)
        .reversed()
        .thenComparing(Pelicula::getAnioEstreno, Comparator.reverseOrder());
```

- `Comparator.comparing(extractor)` — construye el criterio principal, a partir de una función que extrae la clave de comparación.
- `.reversed()` — invierte el orden de un `Comparator` ya construido.
- `.thenComparing(...)` — agrega un criterio de desempate, solo se usa si el anterior dio empate. Es el mismo `if (comparacionA != 0) { return comparacionA; } return comparacionB;` que se escribió a mano en `Comparable` del módulo 4, pero declarativo.

<div align="justify">

**Los 4 tipos de *method references* — solo la variante "a un método de instancia de un tipo arbitrario" (`Pelicula::getCalificacion`) se usa arriba, pero hay 4:**

</div>

| Tipo | Sintaxis | Ejemplo |
|---|---|---|
| Método de instancia de un objeto **arbitrario** de un tipo | `Clase::metodoInstancia` | `Pelicula::getCalificacion` |
| Método **estático** | `Clase::metodoEstatico` | `Integer::parseInt` |
| Método de instancia de un objeto **particular ya existente** | `instancia::metodo` | `System.out::println` |
| **Constructor** | `Clase::new` | `ArrayList::new` |

<div align="justify">

**Las 4 interfaces funcionales base de `java.util.function`** — `Comparator` es solo un ejemplo entre muchas interfaces funcionales; estas 4 son de propósito general y las vas a usar constantemente (sobre todo en el siguiente proyecto, Streams):

</div>

| Interfaz | Recibe | Devuelve | Analogía |
|---|---|---|---|
| `Function<T, R>` | `T` | `R` | una máquina traductora |
| `Predicate<T>` | `T` | `boolean` | un guardia de seguridad (pasa / no pasa) |
| `Consumer<T>` | `T` | nada | una acción (ej. imprimir) |
| `Supplier<T>` | nada | `T` | una fábrica de valores |

<div align="justify">

**Cuidado con no confundir `::` con `.`:** `System.out::println` (con `::`) **no ejecuta nada** — es una referencia, un valor. `System.out.println(x)` (con `.`) sí ejecuta el método ahora mismo. Escribir `System.out::println(x)` es un error de compilación — mezclar ambas sintaxis no tiene sentido.

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
