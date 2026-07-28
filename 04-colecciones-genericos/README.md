# Módulo 4: Colecciones y genéricos

<div align="justify">

[← Volver al índice general](../README.md)

</div>

## Objetivo del módulo

<div align="justify">

Dejar de manejar datos "uno por uno" en variables sueltas y aprender las estructuras de datos que vas a usar constantemente en cualquier programa real: listas ordenadas, conjuntos sin duplicados, y diccionarios clave-valor. De paso, entender **genéricos** (`<T>`) — el mecanismo que hace que `List<Cuenta>` y `List<String>` sean la misma clase por dentro, pero type-safe para cada caso.

</div>

## Proyectos

| # | Proyecto | Qué cubre |
|---|---|---|
| 01 | [list](01-list/README.md) | `List`/`ArrayList`, programar contra la interfaz, `Comparable` |
| 02 | [set](02-set/README.md) | `HashSet`/`LinkedHashSet`/`TreeSet`, `equals`/`hashCode` vs `compareTo` |
| 03 | [map](03-map/README.md) | `Map`/`HashMap`/`TreeMap`, pares clave-valor |
| 04 | [genericos](04-genericos/README.md) | Escribir tu propia clase genérica (`Repositorio<T>`) |

## Por qué siguen este orden

<div align="justify">

`List` primero, porque es la estructura más parecida a lo que ya conocías (un array, pero que crece). `Set` después, porque introduce un problema real (duplicados) que obliga a entender `equals`/`hashCode`, algo que no habías necesitado hasta ahora. `Map` reutiliza ambas ideas (las claves de un `Map` se comportan igual que los elementos de un `Set` en cuanto a unicidad). Y `genericos` cierra el módulo mostrando **por dentro** el mecanismo `<T>` que usaste sin pensarlo en los tres proyectos anteriores.

</div>
