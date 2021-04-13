package Caballo;

import util.IsEmptyException;
import util.Scanner;

public class Main {
    static MovCab movCaballo;
    public static void main(String[] args) {

        /*
        todo arreglar showStacks()
        todo arreglar que no se rompa el menu, ej que metan Z6 en la posicion o que pongan 6 como opcion
        todo ver como hacer para que no se acabe el programa desps de mostrar los movs. Tiene que ver con el System.exit(2) en el metodo refillStacks

         */



        while(true){
            System.out.println("-------- Chess Horse Moves --------\n");
            System.out.println("\t1. See possible moves");
            System.out.println("\t2. See stacks' content");
            System.out.println("\t3. Exit\n");

            int choice = Scanner.getInt("--> ");

            switch (choice){
                case 1:
                    System.out.println("\n\nInput starting position (e.g. A1)\n");
                    String pos = Scanner.getString("--> ");
                    System.out.println("\n\nInput the number of moves desired (max 5)\n");
                    int jumps = Scanner.getInt("--> ");

                    char posX = pos.charAt(0);
                    int posY = Integer.parseInt((String)pos.substring(1));
                    System.out.println("\n\n");
                    movCaballo = new MovCab(jumps,new Tile(posX,posY));
                    movCaballo.fillInitialStacks();
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
