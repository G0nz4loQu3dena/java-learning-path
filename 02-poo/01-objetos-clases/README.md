# 01 - Objetos y Clases

<div align="justify">

[← Módulo 2: POO](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- La diferencia entre una **clase** (el molde) y un **objeto** (algo hecho con ese molde).
- Cómo se define una clase con atributos y métodos propios.
- El constructor: el método especial que arma un objeto nuevo.

## Antes de escribir código: preguntas para pensar

1. Piensa en la palabra "clase" como si fuera el molde de una galleta, y "objeto" como cada galleta individual hecha con ese molde. Si `CuentaBancaria` es la clase, ¿qué sería `cuenta1` en el código? ¿Puede haber más de un objeto hecho a partir de la misma clase, al mismo tiempo, con datos distintos cada uno?
2. Este proyecto define un método `depositar(BigDecimal monto)` **dentro** de la clase `CuentaBancaria`, no como una función suelta en `App.java`. ¿Por qué crees que tiene sentido que el comportamiento de "depositar dinero" viva pegado a los datos de la cuenta (`saldoDisponible`), en vez de estar separado?

## Conceptos, paso a paso

<div align="justify">

**Una clase es un molde — describe qué datos y qué comportamiento va a tener cada objeto que crees a partir de ella**, pero no es, en sí misma, ningún dato concreto:

</div>

```java
public class CuentaBancaria {
    private String nombreTitular;
    private String numeroCuenta;
    private BigDecimal saldoDisponible;
    // ...
}
```

<div align="justify">

Estas líneas **no** crean ninguna cuenta bancaria real — solo definen que *cualquier* `CuentaBancaria` que exista va a tener un titular, un número de cuenta y un saldo.

</div>

<div align="justify">

**Un objeto es una instancia concreta de esa clase**, con valores reales, creada con la palabra `new`:

</div>

```java
CuentaBancaria cuenta1 = new CuentaBancaria("Juan Perez", "1234567890", "0987654321", new BigDecimal("1000.00"), new Date());
```

<div align="justify">

Aquí sí existe algo concreto en memoria: una cuenta con titular `"Juan Perez"` y saldo `1000.00`. Podrías crear `cuenta2`, `cuenta3`, cada una con sus propios datos, todas hechas desde el mismo molde `CuentaBancaria` — igual que puedes hornear muchas galletas distintas (con distinto relleno) usando el mismo molde.

</div>

<div align="justify">

**El constructor** es un método especial, con el mismo nombre que la clase y sin tipo de retorno, que se ejecuta automáticamente cada vez que usas `new`:

</div>

```java
public CuentaBancaria(String nombreTitular, String numeroCuenta, String numeroCuentaCci, BigDecimal saldoDisponible, Date fechaCreacion) {
    this.nombreTitular = nombreTitular;
    this.numeroCuenta = numeroCuenta;
    // ...
}
```

<div align="justify">

Su trabajo es tomar los datos que le pasas y guardarlos en los atributos del objeto que se está creando. La palabra `this` se refiere **al objeto que se está construyendo en este momento** — `this.nombreTitular = nombreTitular;` significa *"el atributo `nombreTitular` de este objeto en particular = el valor que me pasaron como parámetro"*.

</div>

<div align="justify">

**Por qué el comportamiento vive dentro de la clase, junto a los datos:** `depositar()` necesita leer y modificar `saldoDisponible`. Si `depositar` fuera una función suelta afuera, tendrías que pasarle el saldo actual como parámetro cada vez, y devolver el saldo nuevo para que alguien más lo guarde — mucho más propenso a errores que dejar que el propio objeto sea responsable de mantener su estado consistente. Esta idea — juntar datos y comportamiento en la misma unidad — es la base de todo lo que viene en este módulo.

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
