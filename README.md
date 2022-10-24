Escribe una función que [verifique](http://iban.es/verificacion.html) la validez del IBAN de una cuenta bancaria, como por ejemplo `ES98 2038 5778 9830 0076 0236`.

Ponla a prueba desde el programa principal pidiendo números de cuenta al usuario hasta que escriba FIN:

```
IBAN: ES98 2038 5778 9830 0076 0236 
  Ok.
IBAN: ES10 0049 2377 7724 1499 9916
  Error.
IBAN: fin
  Programa terminado.
```

## Sugerencias

Aprovecha las funciones disponibles en la clase [String](https://docs.oracle.com/javase/8/docs/api/java/lang/String.html) para manipular el texto que recibes del usuario. Por ejemplo `trim()`, `substring()` o `replaceAll()` pueden ser útiles en este caso.
