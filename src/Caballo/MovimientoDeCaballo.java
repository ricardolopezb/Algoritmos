package Caballo;


import util.DynamicStack;
import util.IsEmptyException;

import java.util.ArrayList;


public class MovimientoDeCaballo {

    private Caballo caballo;
    private int saltos;
    DynamicStack<Tile>[] stacks;
    private Tile initialPos;

    public MovimientoDeCaballo(int saltos, Tile posInicial) {
        this.saltos = saltos;
        this.stacks = new DynamicStack[saltos+1];//1 posicion mas de salto por el teorema de la mano derecha de alejo
        for (int i = 0; i <= saltos; i++) {
            this.stacks[i] = new DynamicStack<Tile>();
        }
        stacks[0].stack(posInicial);
        caballo = new Caballo(posInicial);
        this.initialPos = posInicial;

    }
    /*
    //todo ARRGELAR
    public void showStacks() {
        DynamicStack<Tile>[] temp = new DynamicStack[stacks.length];


        for (DynamicStack stack : temp) {
            System.out.println("Stack\n");
            while (!stack.isEmpty()) {
                System.out.println(stack.peek());
                try {
                    stack.pop();
                } catch (IsEmptyException e) {
                    e.getMessage();
                }

            }
            System.out.println("\n");
        }
    }*/

    public void showPath(int index){



    }

    public void addPositionsToStack(int stackPos) {

        try {
            for (int i = stackPos; i <= saltos; i++) {
                stacks[i].empty();
            }
        }catch (IsEmptyException e){
            System.out.println(e.getMessage());
        }



        for (int i = stackPos; i <= saltos; i++) {

            Caballo caballoAux = new Caballo(stacks[i-1].peek());
            Tile[] tilesAux = caballoAux.getNextTiles();

            for (int j = 0; j < tilesAux.length; j++) {
                        stacks[i].stack(tilesAux[j]);
            }
        }
    }



}
