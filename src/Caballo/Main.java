package Caballo;

import util.IsEmptyException;
import util.Scanner;

public class Main {
    static MovCab movCaballo;
    public static void main(String[] args) {

        movCaballo = new MovCab(3,new Tile('D',5));
        movCaballo.fillInitialStacks();
        movCaballo.getPaths();


    }


}
