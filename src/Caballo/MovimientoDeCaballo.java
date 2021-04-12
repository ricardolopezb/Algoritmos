package Caballo;


import org.hamcrest.core.Is;
import util.StaticStack;
import util.IsEmptyException;

import java.util.ArrayList;



/**
 * TODO crear metodo para mostrar los stacks
 *
 * TODO sistematizar el agregado de tiles a los prox. stacks
 *
 *
 * **/


public class MovimientoDeCaballo {

    private Caballo caballo;
    private int saltos;
    StaticStack<Tile>[] stacks;
    private Tile initialPos;

    public MovimientoDeCaballo(int saltos, Tile posInicial) {
        this.saltos = saltos;
        this.stacks = new StaticStack[saltos+1];//1 posicion mas de salto por el teorema de la mano derecha de alejo
        for (int i = 0; i <= saltos; i++) {
            this.stacks[i] = new StaticStack<Tile>();
        }
        stacks[0].stack(posInicial);
        caballo = new Caballo(posInicial);
        this.initialPos = posInicial;

    }

    public void showStacks() throws IsEmptyException{
        for (int i = 0; i < stacks.length; i++) {
            System.out.println("Stack " + (i+1));
            Tile[] tilesInStack = new Tile[stacks[i].size()];
            for (int j = 0; j <= stacks[i].size(); j++) {
                tilesInStack[j] = stacks[i].peek();
                stacks[i].pop();
            }

            for (Tile tile: tilesInStack) {
                if(tile == null) break;
                System.out.println(tile.toString());
            }
            for (int j = 0; j < tilesInStack.length; j++) {
                stacks[i].stack(tilesInStack[j]);
            }
            System.out.println("\n");




        }
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
    //  0  1  2  3

    public void addPositionsToStack(int stackPos) {


        for (int i = stackPos; i <= saltos; i++) {
            if(!stacks[i].isEmpty()) stacks[i].empty();
            //try {
            //    if (i != stackPos) stacks[i - 1].pop();
            //} catch (IsEmptyException e){
            //    e.getMessage();
            //}
        }

        for (int i = stackPos; i <= saltos; i++) {

            Caballo caballoAux = new Caballo(stacks[i-1].peek());
            //try{
            //    stacks[i-1].pop();
            //} catch (IsEmptyException e){
            //    e.getMessage();
            //}

            Tile[] tilesAux = caballoAux.getNextTiles();

            for (int j = 0; j < tilesAux.length; j++) {
                stacks[i].stack(tilesAux[j]);
            }
            //try {
            //    stacks[i-1].pop();
            //} catch (IsEmptyException e){
            //    e.getMessage();
            //}

        }
    }



}
