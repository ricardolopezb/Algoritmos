package Caballo;

import util.IsEmptyException;
import util.Scanner;

public class Main {
    static MovCab movCaballo;
    public static void main(String[] args) {

        movCaballo = new MovCab(3,new Tile('A',1));
        movCaballo.fillInitialStacks();
        movCaballo.getPaths(0);


    }


}
