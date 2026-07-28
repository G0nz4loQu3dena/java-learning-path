# 03 - Map

<div align="justify">

[← Módulo 4: Colecciones y genéricos](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- `Map<K, V>`: pares clave-valor, en vez de una simple lista de elementos.
- `HashMap` vs `TreeMap` — mismo contrato, distinto orden de iteración (la misma idea que ya viste con `HashSet`/`TreeSet`, aplicada a las **claves**).
- Recorrer un `Map` con `Map.Entry`.

## Antes de escribir código: preguntas para pensar

1. En una `List<Cuenta>`, para encontrar una cuenta específica tendrías que recorrer toda la lista comparando el `numeroCuenta` uno por uno. Un `Map<String, Cuenta>` te deja buscar **directamente** por `numeroCuenta`. ¿Qué relación ves entre las **claves** de un `Map` y los elementos de un `Set` que ya conoces — por qué crees que ambos exigen que sus elementos/claves sean únicos?
2. Si guardas las mismas cuentas en un `HashMap<String, Cuenta>` y en un `TreeMap<String, Cuenta>`, usando el `numeroCuenta` como clave, ¿esperarías el mismo orden al recorrerlas? ¿Por qué sí o por qué no, pensando en lo que ya sabes de `HashSet` vs `TreeSet`?

## Conceptos, paso a paso

<div align="justify">

**Un `Map<K, V>` asocia claves (`K`) con valores (`V`)**, y — igual que un `Set` — **no permite claves duplicadas** (si guardas dos veces con la misma clave, la segunda sobrescribe a la primera; el valor no se duplica).

</div>

```java
Map<String, Cuenta> mapaCuentas = new HashMap<>();
mapaCuentas.put(cuenta.getNumeroCuenta(), cuenta);
```

<div align="justify">

**La conexión con `Set`:** por dentro, las claves de un `Map` se comportan exactamente igual que los elementos de un `Set` — un `HashMap` usa `equals()`/`hashCode()` de la clave para decidir si ya existe; un `TreeMap` usa `compareTo()` (o un `Comparator`). Es la misma mecánica del proyecto `02-set`, aplicada ahora a las claves en vez de a los elementos directamente. Como aquí la clave es `String` (que ya tiene `equals`/`hashCode`/`compareTo` bien alineados), no aparece el gotcha que sí viste con `Cuenta`.

</div>

<div align="justify">

**Recorrer un `Map` — con `Map.Entry`:**

</div>

```java
for (Map.Entry<String, Cuenta> entry : mapa.entrySet()) {
    System.out.println("Clave: " + entry.getKey() + ", Valor: " + entry.getValue());
}
```

<div align="justify">

`entrySet()` te da una vista del mapa como un conjunto de pares clave-valor (`Map.Entry`), cada uno con `getKey()` y `getValue()`.

</div>

<div align="justify">

**`HashMap` vs `TreeMap` — mismo contrato, distinto orden:** al igual que con `Set`, `HashMap` no garantiza ningún orden de iteración (organiza por `hashCode()` de la clave), mientras que `TreeMap` mantiene las claves **siempre ordenadas** (usando el orden natural de `String`, que es alfabético).

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
