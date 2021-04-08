package Caballo;

import util.Scanner;

public class Main {
    static MovimientoDeCaballo movCaballo;
    public static void main(String[] args) {


        movCaballo = new MovimientoDeCaballo(3, new Tile('A', 1));
        movCaballo.fillInitialStacks();
        movCaballo.showStacks();
        System.out.println("\n");
        movCaballo.getPaths();


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
