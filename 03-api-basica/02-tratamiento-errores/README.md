# 02 - Tratamiento de Errores

<div align="justify">

[← Módulo 3: API básica](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- `try` / `catch` / `finally`, y exactamente cuándo se ejecuta cada bloque.
- La diferencia real entre excepciones *checked* y *unchecked* — no es una regla arbitraria, es sobre la jerarquía de clases.
- Crear tu propia excepción *checked* y ver al compilador exigirte manejarla.

## Antes de escribir código: preguntas para pensar

1. Ya usaste `throw new IllegalArgumentException(...)` varias veces en el módulo 2, y el compilador **nunca** te obligó a rodear esas llamadas con `try/catch`. Si en cambio trabajaras con `FileReader` (que puede lanzar `IOException`), el compilador **sí** te obligaría a manejarlo. ¿Qué diferencia de fondo habrá entre estas dos excepciones para que Java sea permisivo con una y estricto con la otra?
2. ¿`finally` se ejecuta siempre, haya o no haya excepción? ¿Y si hay un `return` dentro del `try` — el `finally` corre antes o después de que el método efectivamente retorne?

## Conceptos, paso a paso

<div align="justify">

**La jerarquía que decide si una excepción es *checked* o *unchecked*:**

</div>

```
Throwable
├── Error                    (fallos de JVM, no se manejan normalmente)
└── Exception
    ├── RuntimeException     ← UNCHECKED (y todo lo que herede de aquí)
    └── (todo lo demás)      ← CHECKED
```

<div align="justify">

Si una excepción hereda de `RuntimeException` (directa o indirectamente), es **unchecked** — el compilador no exige nada (`IllegalArgumentException extends RuntimeException`, por eso nunca te pidió `try/catch`). Si hereda de `Exception` sin pasar por `RuntimeException`, es **checked** — el compilador exige `try/catch` o declarar `throws` (`IOException extends Exception`).

</div>

<div align="justify">

**El motivo de diseño, no solo la regla mecánica:** las *checked* representan condiciones **externas y esperables** (un archivo puede no existir) que un programa bien escrito debería anticipar. Las *unchecked* representan, en general, **errores de programación** (un argumento inválido, un índice fuera de rango) — Java no te obliga a envolver cada llamada "por si metiste un bug", porque la solución a un bug es corregirlo, no atraparlo en todos lados.

</div>

<div align="justify">

**`try` / `catch` / `finally`:**

</div>

```java
try {
    return 1;
} finally {
    System.out.println("Bloque finally");
}
```

<div align="justify">

`finally` se ejecuta **siempre**, haya excepción o no — incluso si hay un `return` dentro del `try`. La secuencia real: Java evalúa el `return 1`, **guarda** ese valor temporalmente, ejecuta el `finally` completo, y **recién después** retorna el valor guardado. Por eso `finally` es el lugar ideal para liberar recursos (cerrar un archivo, una conexión): tienes la garantía de que corre pase lo que pase. (Gotcha a evitar: si el propio `finally` tiene un `return`, ese gana y descarta silenciosamente el del `try` — nunca pongas `return` dentro de un `finally`.)

</div>

<div align="justify">

**Crear tu propia excepción checked:**

</div>

```java
public class FondosInsuficientesException extends Exception {
    public FondosInsuficientesException(String message) {
        super(message);
    }
}
```

<div align="justify">

Extiende `Exception` directamente (no `RuntimeException`), así que es checked. Cualquier método que la lance necesita `throws FondosInsuficientesException` en su firma — y esa obligación **se propaga**: quien llame a ese método también necesita manejarla o volver a declararla, hasta que alguien finalmente la capture con `catch`.

</div>

<div align="justify">

**Nota de compilación real que te vas a topar:** si tu proyecto tiene varios archivos `.java` (por ejemplo `App.java` y `FondosInsuficientesException.java`), `javac src/App.java` por sí solo **no** compila — el compilador solo procesa el archivo que le diste, y no encuentra `FondosInsuficientesException`. Usa `javac src/*.java` para compilar todos los archivos del proyecto juntos.

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
