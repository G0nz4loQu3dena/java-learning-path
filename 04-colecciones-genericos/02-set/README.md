# 02 - Set

<div align="justify">

[← Módulo 4: Colecciones y genéricos](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- Qué garantiza un `Set`, y qué mecanismo usa cada implementación para garantizarlo.
- `HashSet`, `LinkedHashSet`, `TreeSet` — mismo contrato (sin duplicados), distinto criterio interno y distinto orden de iteración.
- El gotcha real de tener `equals`/`hashCode` desalineados de `compareTo` en la misma clase — provocado y corregido con código de verdad, no solo en teoría.

## Antes de escribir código: preguntas para pensar

1. ¿Qué imprime esto, y por qué?
   ```java
   Set<String> numeros = new HashSet<>();
   numeros.add("123456789");
   numeros.add("123456789");
   System.out.println(numeros.size());
   ```
2. `HashSet`, `LinkedHashSet` y `TreeSet` garantizan las tres "sin duplicados", pero dan resultados en **orden distinto** al iterarlas. Si insertas `"C", "A", "B"` en ese orden, ¿qué orden esperarías de cada una? (Pista: los nombres no son arbitrarios — "Hash", "Linked", "Tree" describen la estructura de datos interna.)

## Conceptos, paso a paso

<div align="justify">

**Las tres implementaciones, y qué estructura usa cada una por dentro:**

</div>

- **`HashSet`** — tabla hash (organiza por `hashCode()`). **No garantiza ningún orden** al iterar.
- **`LinkedHashSet`** — un `HashSet` más una lista enlazada que recuerda el orden de inserción. Iterando, obtienes exactamente el orden en que agregaste los elementos.
- **`TreeSet`** — árbol binario balanceado. Iterando, obtienes los elementos **siempre ordenados** (por `Comparable`, o por un `Comparator` que le pases al constructor).

<div align="justify">

**Cómo decide cada una si algo es "duplicado":**

</div>
- `HashSet`/`LinkedHashSet` usan **`equals()` + `hashCode()`** — primero agrupan por `hashCode()`, y dentro del mismo grupo confirman con `equals()`.
- `TreeSet` usa **exclusivamente `compareTo()`** — ignora `equals()`/`hashCode()` por completo.

<div align="justify">

**El gotcha real, provocado con código en este proyecto:** si una clase (`Cuenta`) implementa `Comparable` (ordenando por `saldoDisponible`) pero **no** sobrescribe `equals()`/`hashCode()` (usa los de `Object`, que comparan identidad de memoria), aparecen dos bugs opuestos:

</div>

1. **`HashSet<Cuenta>` no deduplica cuentas idénticas.** Dos objetos `Cuenta` distintos en memoria, pero con los mismos datos (mismo `numeroCuenta`), se tratan como elementos **diferentes** — porque `Object.equals()` compara identidad, no contenido. Tamaño esperado `1`, tamaño real `2`.
2. **`TreeSet<Cuenta>` fusiona cuentas que en realidad son distintas.** Dos `Cuenta` de clientes diferentes que casualmente tienen el **mismo saldo** dan `compareTo() == 0`, y `TreeSet` las trata como duplicadas — **descarta una silenciosamente**, sin excepción ni aviso. Tamaño esperado `2`, tamaño real `1`.

<div align="justify">

**El arreglo — alinear ambos criterios con el mismo dato de identidad de negocio (`numeroCuenta`):**

</div>

```java
@Override
public boolean equals(Object obj) {
    if (this == obj) return true;
    if (!(obj instanceof Cuenta)) return false;
    Cuenta otraCuenta = (Cuenta) obj;
    return this.numeroCuenta.equals(otraCuenta.numeroCuenta);
}

@Override
public int hashCode() {
    return numeroCuenta.hashCode();
}
```

<div align="justify">

Y en `compareTo()`, agregar un desempate por `numeroCuenta` cuando el saldo coincide, para que dos cuentas distintas con el mismo saldo **nunca** den `compareTo() == 0`:

</div>

```java
@Override
public int compareTo(Cuenta otraCuenta) {
    int comparacionSaldo = this.saldoDisponible.compareTo(otraCuenta.saldoDisponible);
    if (comparacionSaldo != 0) {
        return comparacionSaldo;
    }
    return this.numeroCuenta.compareTo(otraCuenta.numeroCuenta);
}
```

<div align="justify">

**La lección general:** `Comparable` (`compareTo`) responde *"¿quién va primero?"* — es sobre **orden**. `equals`/`hashCode` responden *"¿son la misma cosa?"* — es sobre **identidad**. Java no las alinea automáticamente; si tu clase implementa ambas, es tu responsabilidad que usen el mismo criterio de "qué hace que dos objetos sean el mismo".

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
