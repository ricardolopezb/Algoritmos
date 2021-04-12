package Caballo;

import util.IsEmptyException;
import util.Scanner;

public class Main {
    static MovimientoDeCaballo movCaballo;
    public static void main(String[] args) {

        // funciona el showstacks

        movCaballo = new MovimientoDeCaballo(3, new Tile('A', 1));
        movCaballo.addPositionsToStack(1);

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n-----------------------------------");

        movCaballo.addPositionsToStack(2);
        //movCaballo.addPositionsToStack(3);
        try{
            movCaballo.showStacks();
        } catch(IsEmptyException e){
            e.getMessage();
        }



        /*Caballo cab = new Caballo(new Tile('B', 3));
        System.out.println(cab.getNextTiles());




         */

        /*



        while(true){

            //cuando se pregunte la cant de saltos, se inicializa movCaballo.

           int choice = Scanner.getInt("negachivo");

            //ver posibles posiciones
            //elegir posicion
            //SALIR
            switch (choice){
                case 1:
                    movCaballo.mover()
                    break;

                case 2:
                    movCaballo.showStacks(); //printear el contenido de cada pila
                    break;



                    case 3:
                    System.exit(0);
                    break;
            }

        }*/

    }


}
