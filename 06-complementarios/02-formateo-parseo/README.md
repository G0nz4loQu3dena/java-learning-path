# 02 - Formateo y Parseo

<div align="justify">

[← Módulo 6: Temas complementarios](../README.md)

</div>

## ¿Qué vas a aprender aquí?

- `DateTimeFormatter` — controlar cómo se ve una fecha como texto, más allá del ISO por defecto.
- `Locale` — cómo se decide el idioma de los nombres (meses, días) al formatear.
- Parsear: convertir texto de vuelta a una fecha, la dirección inversa de formatear.

## Antes de escribir código: preguntas para pensar

1. `LocalDate.toString()` siempre da el formato ISO (`2003-06-20`). Si quisieras mostrar `20/06/2003` o `June 20, 2003`, ¿crees que `LocalDate` tiene métodos propios para cada estilo, o Java usa un objeto completamente separado? Piensa en la misma lógica que ya viste con `Comparable` vs `Comparator` en el módulo 4 y 5: un criterio "de fábrica" adentro de la clase, vs un objeto externo e intercambiable.
2. Si formateas la misma fecha en español (`"20 de junio de 2003"`) y en inglés (`"June 20, 2003"`), ¿qué decide esa diferencia de idioma — es algo que `LocalDate` ya trae adentro, o es información que tú le entregas por fuera, al momento de formatear?

## Conceptos, paso a paso

<div align="justify">

**`LocalDate` no sabe formatearse a sí misma en distintos estilos — por diseño.** Por dentro es solo tres números (año, mes, día); no tiene idea de "cómo debería verse" en texto, más allá de su único `toString()` fijo. Java no le agrega un método por cada estilo posible — en cambio, existe una clase **separada**, `DateTimeFormatter`, cuyo único trabajo es saber convertir una fecha a texto (o texto a fecha) según un patrón:

</div>

```java
DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
String texto = miFecha.format(formato);  // "20/06/2003"
```

<div align="justify">

La fecha aporta los datos crudos; el formateador aporta la "receta" de cómo acomodarlos. Es el mismo principio de separar responsabilidades que ya viste con `Comparable` (criterio interno) vs `Comparator` (objeto externo, intercambiable) — en vez de que `LocalDate` cargue con infinitas variantes de formato adentro, Java la mantiene simple y deja que objetos externos hagan ese trabajo.

</div>

<div align="justify">

**El idioma (`Locale`) tampoco vive dentro de la fecha — se lo das al formateador:**

</div>

```java
DateTimeFormatter formatoIngles = DateTimeFormatter.ofPattern("MMMM d, yyyy", Locale.ENGLISH);
String texto = miFecha.format(formatoIngles);  // "June 20, 2003"
```

<div align="justify">

Como `LocalDate` es solo números, no "sabe" ningún idioma. Cuando el patrón incluye un **nombre** (`MMMM` = nombre completo del mes), alguien tiene que decir en qué idioma buscarlo — eso es exactamente lo que aporta `Locale`, entregado al formateador, no a la fecha.

</div>

<div align="justify">

**Desglose de un patrón, por ejemplo `"MMMM d, yyyy"`:**

</div>
- `MMMM` — nombre completo del mes (`MM` sería `"06"`, `MMM` sería la abreviación `"Jun"`) — depende del `Locale`.
- `d` — día sin cero a la izquierda (`dd` sí lo agregaría para días de un dígito).
- `,` — literal, se copia tal cual.
- `yyyy` — año con 4 dígitos.

<div align="justify">

**Parsear — la dirección contraria, texto → fecha:**

</div>

```java
LocalDate fecha = LocalDate.parse("25/12/2010", formato);
```

<div align="justify">

`LocalDate.parse(texto, formateador)` va en sentido opuesto a `.format()`: en vez de partir de una fecha y obtener texto, partes de un texto y obtienes una fecha. Usa el **mismo** `DateTimeFormatter` en ambas direcciones — sabe tanto escribir como leer ese patrón. Si el texto no calza con el patrón esperado, lanza `DateTimeParseException` en tiempo de ejecución.

</div>

## Cómo compilar y ejecutar

```bash
javac src/*.java -d out
java -cp out App
```
