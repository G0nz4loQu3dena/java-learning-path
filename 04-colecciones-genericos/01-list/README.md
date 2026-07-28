# 01 - List

<div align="justify">

[← Módulo 4: Colecciones y genéricos](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- `List<T>` como interfaz, y `ArrayList` como una de sus implementaciones.
- Por qué se programa contra la interfaz (`List<Cuenta>`) y no contra la implementación concreta (`ArrayList<Cuenta>`).
- La diferencia interna entre `ArrayList` y `LinkedList`.
- `Comparable<T>` para darle a una clase un orden "natural", usado por `Collections.sort()`.
- Cómo Java pasa objetos como parámetros (pass-by-value de la referencia).

## Antes de escribir código: preguntas para pensar

1. `List<Cuenta> cuentas = new ArrayList<Cuenta>();` — la variable se declara con el tipo **interfaz** (`List`), aunque el objeto real sea un `ArrayList`. ¿Qué ventaja práctica da esto? Piensa qué pasaría si mañana quisieras cambiar la implementación por otra.
2. `List` tiene dos implementaciones principales, `ArrayList` (arreglo redimensionable por dentro) y `LinkedList` (nodos enlazados). Si necesitas acceder muy seguido a un elemento por índice (`lista.get(500)`), ¿cuál sería más eficiente, y por qué, pensando en cómo está organizada la memoria en cada caso?
3. Si intentas `Collections.sort(cuentas)` sobre una `List<Cuenta>`, y `Cuenta` no implementa ninguna interfaz de orden, ¿qué crees que pasa — ordena por algún criterio por defecto, o directamente no compila?

## Conceptos, paso a paso

<div align="justify">

**Programar contra la interfaz, no contra la implementación:** todo el código que usa `cuentas` (`.add()`, `.get()`, iterar con for-each) solo conoce el contrato de `List` — nunca le importa si por dentro hay un `ArrayList` o un `LinkedList`. Si mañana cambias `new ArrayList<>()` por `new LinkedList<>()`, ninguna otra línea del programa necesita cambiar. Es el mismo principio que ya viste con `Cuenta cuenta = new CuentaCorriente(...)` en el módulo 2.

</div>

<div align="justify">

**`ArrayList` vs `LinkedList`, la diferencia real:** `ArrayList` usa un arreglo por dentro (memoria contigua) — acceder por índice (`get(500)`) es **O(1)**, cálculo directo de dirección de memoria. `LinkedList` es una cadena de nodos, cada uno apuntando al siguiente — llegar al elemento 500 significa recorrer nodo por nodo, **O(n)**.

</div>

<div align="justify">

**`Comparable<T>` — dale a tu clase un orden "natural":**

</div>

```java
public class Cuenta implements Comparable<Cuenta> {
    @Override
    public int compareTo(Cuenta otraCuenta) {
        return this.saldoDisponible.compareTo(otraCuenta.saldoDisponible);
    }
}
```

<div align="justify">

La firma real de `Collections.sort` es `<T extends Comparable<? super T>> void sort(List<T> list)` — el compilador **exige**, vía este *bound* genérico, que `T` implemente `Comparable`. Sin eso, no compila (no es un comportamiento indefinido en runtime, es un error de compilación). El contrato: negativo si `this` va antes, cero si son iguales en el criterio, positivo si va después.

</div>

<div align="justify">

**Un detalle sutil de acceso:** dentro de `compareTo(Cuenta otraCuenta)`, puedes leer `otraCuenta.saldoDisponible` directamente aunque sea `private`, porque en Java la privacidad es **a nivel de clase, no de instancia** — cualquier método de `Cuenta` puede tocar el `private` de cualquier objeto `Cuenta`, no solo de `this`. Esto es distinto a lo que viste con subclases en herencia, donde `private` sí bloqueaba el acceso.

</div>

<div align="justify">

**Pass-by-value de la referencia:** cuando pasas `cuentas` a un método (`imprimirCuentas(cuentas)`), Java copia el **valor de la referencia**, no el objeto. Terminas con dos variables distintas (en distintos stack frames) apuntando al **mismo** objeto en memoria. Por eso, si dentro del método haces `cuentas.add(...)` (mutar), el cambio es visible afuera; pero si haces `cuentas = new ArrayList<>();` (reasignar la variable local), no afecta a la variable original de afuera.

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
