package Caballo;

import util.IsEmptyException;
import util.Scanner;

public class Main {
    static MovCab movCaballo;
    public static void main(String[] args) {

        /*

        todo arreglar que no se rompa el menu, ej que metan Z6 en la posicion o que pongan 6 como opcion


         */

        System.out.println("-------- Chess Horse Moves --------\n");

        System.out.println("\nInput starting position (e.g. A1)\n");
        String pos = Scanner.getString("--> ");
        pos = pos.toUpperCase();

        while (pos.charAt(0)>'H' || (Integer.valueOf(pos.substring(1))<0||Integer.valueOf(pos.substring(1))>8)){
            System.out.println("\nInput starting position (e.g. A1)\n");
            pos = Scanner.getString("--> ");
            pos = pos.toUpperCase();
        }

        System.out.println("\n\nInput the number of moves desired (max 5)\n");
        int jumps = Scanner.getInt("--> ");
        System.out.println("\n\n");

        while(jumps<1 || jumps>5){
            System.out.println("\n\nInput the number of moves desired (max 5)\n");
            jumps = Scanner.getInt("--> ");
            System.out.println("\n\n");
        }

        while(true){
            System.out.println("-------- Chess Horse Moves --------\n");

            char posX = pos.charAt(0);
            int posY = Integer.parseInt(pos.substring(1));
            movCaballo = new MovCab(jumps, new Tile(posX,posY));
            movCaballo.fillInitialStacks();

            System.out.println("\t1. See possible moves");
            System.out.println("\t2. See stacks' content");
            System.out.println("\t3. Exit\n");

            int choice = Scanner.getInt("--> ");

            switch (choice){
                case 1:
                    movCaballo.getPaths();
                    break;
                case 2:
                    movCaballo.showStacks();
                    break;
                case 3:
                    System.exit(0);

            }



        }

    }

}
