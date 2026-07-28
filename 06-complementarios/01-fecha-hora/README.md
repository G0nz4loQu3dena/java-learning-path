# 01 - Fecha y Hora

<div align="justify">

[← Módulo 6: Temas complementarios](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- `LocalDate`, `LocalTime`, `LocalDateTime` — las clases modernas de Java para fechas y horas.
- Por qué son inmutables, y por qué eso importa especialmente para fechas.
- Por qué no tienen constructor público, y qué es un *static factory method*.
- Por qué Java separa fecha y hora en clases distintas en vez de una sola.

## Antes de escribir código: preguntas para pensar

1. Ya sabes que `String` y `BigDecimal` son inmutables. La API vieja de Java (`java.util.Date`) **no** lo era, y eso causó años de bugs reales. ¿Crees que `LocalDate` (la API moderna, de Java 8) es mutable o inmutable? ¿Por qué la inmutabilidad es especialmente importante para representar fechas — piensa en un caso como una auditoría, donde una fecha no debería poder cambiarse silenciosamente.
2. Java no te da una sola clase que siempre cargue fecha **y** hora juntas — te da `LocalDate` (solo fecha), `LocalTime` (solo hora), `LocalDateTime` (ambas). Piensa en una fecha de cumpleaños, o en "la tienda abre a las 9:00 todos los días". ¿Por qué sería un problema si Java te obligara a cargar hora en cada fecha (o fecha en cada hora), aunque en ese caso no tenga sentido?

## Conceptos, paso a paso

<div align="justify">

**`LocalDate` es completamente inmutable — igual que `String`/`BigDecimal`.** Todos sus métodos "modificadores" (`plusDays()`, `minusMonths()`, `withYear()`) devuelven un objeto **nuevo**, nunca tocan el original. `fecha.plusDays(5);` sin reasignar no hace nada útil — el mismo error conceptual que `String.concat()` sin reasignar. Dos motivos de peso para esto: (1) auditorías y trazabilidad — una fecha compartida no puede ser modificada silenciosamente por una parte del código sin que las demás se enteren; (2) *thread-safety* — un objeto inmutable puede compartirse entre distintas partes del programa (o distintos hilos) sin riesgo de que uno lo modifique mientras otro lo lee.

</div>

<div align="justify">

**No hay `new LocalDate()` — usa métodos estáticos de fábrica:**

</div>

```java
LocalDate fecha = LocalDate.of(2003, 6, 20);   // año, mes, día
LocalTime hora = LocalTime.of(14, 30);          // hora, minuto
LocalDateTime fechaHora = LocalDateTime.of(fecha, hora);
LocalDate hoy = LocalDate.now();                // la fecha actual del sistema
```

<div align="justify">

Toda la API `java.time` sigue este patrón (*static factory method*) en vez de constructores — la ventaja es que el **nombre del método comunica la intención** (`.now()` te dice exactamente qué obtienes; con un constructor `new LocalDate()` no sabrías si te da hoy, una fecha vacía, o algo indefinido).

</div>

<div align="justify">

**Por qué existen tres clases separadas — modelado semántico correcto:** el motivo real no es ahorrar memoria (la diferencia sería insignificante) — es que **el tipo debe representar exactamente el concepto que existe**. Si Java te obligara a usar `LocalDateTime` siempre, una fecha de cumpleaños necesitaría una hora inventada (¿medianoche? ¿mediodía?) que no representa nada real, y cualquier código que lea ese dato podría, por error, tratar esa hora falsa como información válida. Con `LocalDate` (solo fecha), el compilador **elimina esa posibilidad de raíz** — ni siquiera puedes preguntarle la hora a un `LocalDate`, porque el método no existe ahí.

</div>

<div align="justify">

**El formato por defecto al imprimir (`toString()`) es ISO-8601:** `LocalDate` → `AAAA-MM-DD`; `LocalTime` → `HH:mm` (omite segundos si son `0`); `LocalDateTime` → ambos unidos con `T` (parte del estándar, no un error tipográfico). Para otros formatos, ver el siguiente proyecto (`02-formateo-parseo`).

</div>

<div align="justify">

**Cuidado con los literales `int` con cero a la izquierda:** `LocalTime.of(6, 0, 03)` — el `03` es un literal **octal**, no decimal (aunque aquí da el mismo valor, `3`). Un literal como `09` directamente **no compilaría** (`9` no es un dígito octal válido). Evita ceros a la izquierda en literales `int` salvo que sea intencional.

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
