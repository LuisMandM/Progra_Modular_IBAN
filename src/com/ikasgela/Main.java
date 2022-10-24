package com.ikasgela;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        /*NOTA PARA EL PROFESOR:
         * Las Funciones de conversion de codigo y la de creacion de indices las cree previo a que me dijera que
         * solo tomara en cuenta IBANes de españa por lo tanto lo estaba haciendo antes para todos
         * como en principio funcionan las deje y use.
         *
         * Sé que me dijo que no programara mas de lo que me piden pero antes de que me hiciera la aclaracion
         * fue la manera mas optima que pense para comparar las letras de los IBAN.
         *
         * */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String entrada;

        do {
            System.out.print("Escriba el número de IBAN a confirmar: ");
            entrada = br.readLine().replaceAll(" ", "");
            entrada = entrada.toUpperCase();

            if (entrada.equals("FIN")) {
                System.out.println("Programa Terminado");
            } else {

                String cod_verficacion = entrada.substring(0, 4);
                String entrada_cut = entrada.substring(4);

                cod_verficacion = conversionCodigo(cod_verficacion);

                entrada_cut += cod_verficacion;

                BigInteger iban = new BigInteger(entrada_cut);
                BigInteger divisor = new BigInteger("97");

                BigInteger modulo = iban.remainder(divisor);

                if (modulo.equals(BigInteger.ONE)) {
                    System.out.println("IBAN valido");
                } else {
                    System.out.println("IBAN Invalido");
                }
            }

        } while (!entrada.equals("FIN"));


    }


    public static String conversionCodigo(String codigo) {

        StringBuilder cod_convertido = new StringBuilder();
        Map<String, String> indices;
        indices = crearIndice();

        char[] letras = codigo.substring(0, 2).toCharArray();
        String num = codigo.substring(2);

        for (char letra : letras) {
            String digito = String.valueOf(letra);
            digito = indices.get(digito);
            cod_convertido.append(digito);
        }

        cod_convertido.append(num);

        return cod_convertido.toString();
    }

    public static HashMap<String, String> crearIndice() {

        HashMap<String, String> indices = new HashMap<>();
        indices.put("A", "10");
        indices.put("B", "11");
        indices.put("C", "12");
        indices.put("D", "13");
        indices.put("E", "14");
        indices.put("F", "15");
        indices.put("G", "16");
        indices.put("H", "17");
        indices.put("I", "18");
        indices.put("J", "19");
        indices.put("K", "20");
        indices.put("L", "21");
        indices.put("M", "22");
        indices.put("N", "23");
        indices.put("O", "24");
        indices.put("P", "25");
        indices.put("Q", "26");
        indices.put("R", "27");
        indices.put("S", "28");
        indices.put("T", "29");
        indices.put("U", "30");
        indices.put("V", "31");
        indices.put("W", "32");
        indices.put("X", "33");
        indices.put("Y", "34");
        indices.put("Z", "35");

        return indices;
    }
}
