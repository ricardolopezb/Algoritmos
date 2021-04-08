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
        this.stacks = new DynamicStack[saltos];
        for (int i = 0; i < saltos; i++) {
            this.stacks[i] = new DynamicStack<Tile>();
        }
        this.caballo = new Caballo(posInicial);
        this.initialPos = posInicial;

    }

    //todo arreglar formato
    public void showStacks() {
        DynamicStack<Tile>[] temp = stacks;

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
    }

  

    public int getCantidadDeMovimientos() {
        return this.saltos;
    }

    public void addPositionsToStack(Tile tile, int stackPos) {
        Caballo caballo = new Caballo(tile);
        ArrayList<Tile> possibleTiles = caballo.getNextTiles();
        for (Tile t : possibleTiles) {
            stacks[stackPos].stack(t);
        }
    }

}
