package numerosRomanos;

import java.util.ArrayList;

import util.Scanner;


public class RomanNumberConverter {
    public static void main(String[] args) {

        while(true) {
            String inputNumber = Scanner.getString("Numero: ");

            if(Integer.parseInt(inputNumber) <= 0 ||Integer.parseInt(inputNumber) > 999){
                System.out.println("El numero debe estar entre 1 y 999");
                System.out.println("----------------------");
                continue;
            }

            if (inputNumber.length() == 1) {
                System.out.println("Valor: " + getValueByLetter(inputNumber.charAt(0)));
            } else {

                System.out.println("Valor: " + getValueByString(inputNumber));
            }
            System.out.println("----------------------");
        }

    }


    public static int getValueByString(String romanNumber){
        romanNumber = romanNumber.toUpperCase();
        ArrayList<Character> characters = getArrayFromString(romanNumber);
        int suma = 0;
        for(int i = 0; i < characters.size()-1; i++){
            int myValue = getValueByLetter(characters.get(i));
            int nextValue = getValueByLetter(characters.get(i+1));

            if(myValue >= nextValue){
                suma += myValue;
            }
            else{
                suma -= myValue;
            }
        }
        return suma + getValueByLetter(characters.get(characters.size()-1));
    }

    private static ArrayList<Character> getArrayFromString(String romanNumber) {
        ArrayList<Character> toReturn = new ArrayList<>();
        for (int i = 0; i < romanNumber.length() ; i++) {
            toReturn.add(romanNumber.charAt(i));
        }
        return toReturn;
    }

    public static int getValueByLetter(Character character) {
        character = Character.toUpperCase(character);
        switch (character) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
        }
        return 0;
    }




}
