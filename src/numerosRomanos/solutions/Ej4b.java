package numerosRomanos.solutions;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Ej4b {

    public static void main(String args[]){
        Map<Integer, String > centenas = new HashMap<>();
        centenas.put(0,"");
        centenas.put(1 , "C ");
        centenas.put(2, "CC");
        centenas.put(3, "CCC");
        centenas.put(4, "CD");
        centenas.put(5, "D");
        centenas.put(6, "DC");
        centenas.put(7, "DCC");
        centenas.put(8, "DCCC");
        centenas.put(9, "CM");

        Map<Integer, String> decenas = new HashMap<>();
        decenas.put(0, "");
        decenas.put(1 , "X ");
        decenas.put(2, "XX");
        decenas.put(3, "XXX");
        decenas.put(4, "XL");
        decenas.put(5, "L");
        decenas.put(6, "LX");
        decenas.put(7, "LXX");
        decenas.put(8, "LXX");
        decenas.put(9, "XL");

        Map<Integer, String> unidades = new HashMap<>();
        unidades.put(0,"");
        unidades.put(1, "I");
        unidades.put(2, "II");
        unidades.put(3, "III");
        unidades.put(4, "IV");
        unidades.put(5, "V");
        unidades.put(6, "VI");
        unidades.put(7, "VII");
        unidades.put(8, "VIII");
        unidades.put(9, "IX");

        Scanner keyboard = new Scanner(System.in);
        System.out.println("Enter number you want to transform");
        int number = keyboard.nextInt();
        int centena = number/100;
        int decena = (number%100) / 10;
        int unidad = (number%10) /1;

        String resultado = centenas.get(centena) + decenas.get(decena) + unidades.get(unidad);

        System.out.println(resultado);

    }
}
