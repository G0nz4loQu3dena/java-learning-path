# Módulo 5: Java 8

<div align="justify">

[← Volver al índice general](../README.md)

</div>

## Objetivo del módulo

<div align="justify">

Java 8 (2014) fue la actualización más grande en la historia del lenguaje hasta ese momento — introdujo un estilo de programación distinto al que se usó en los módulos anteriores: en vez de solo dar instrucciones paso a paso, puedes **describir el comportamiento como un valor** (una función que le pasas a otro método) y encadenar transformaciones sobre colecciones de forma declarativa. Este módulo cubre las tres piezas centrales de ese cambio.

</div>

## Proyectos

| # | Proyecto | Qué cubre |
|---|---|---|
| 01 | [lambdas-referencias](01-lambdas-referencias/README.md) | Interfaces funcionales, expresiones lambda, los 4 tipos de *method references*, `Comparator` externo |
| 02 | [streams](02-streams/README.md) | `Stream` como pipeline perezoso: `filter`, `map`, `collect` |
| 03 | [optional](03-optional/README.md) | `Optional<T>` para evitar `NullPointerException` de forma segura, forzada por el compilador |

## Nota sobre el dominio

<div align="justify">

A diferencia de los módulos 2, 3 y 4 (que reutilizan siempre `Cuenta`), este módulo usa un dominio nuevo por proyecto (`Pelicula`, `Cancion`, `Ciudad`) — es deliberado, para practicar aplicando los mismos conceptos sobre contextos distintos, en vez de memorizar solo sobre el dominio bancario.

</div>

## Orden recomendado

<div align="justify">

En orden. `streams` necesita entender `Predicate`/`Function` de `lambdas-referencias` primero (`filter` recibe un `Predicate`, `map` recibe un `Function`). `optional` se apoya en la misma idea de "tipo que fuerza a manejar un caso en compile-time" que ya viste con excepciones *checked* en el módulo 3.

</div>
