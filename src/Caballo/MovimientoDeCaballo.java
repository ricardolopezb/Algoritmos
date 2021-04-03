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

    //todo arreglarlo
    public void backtrack(int index) {
        if (index > saltos - 1) return;
        String path = initialPos.toString();
        for (int i = 0; i < stacks.length - index; i++) {
            path = path + " - " + stacks[i].peek().toString();
        }

        while (!stacks[stacks.length - index].isEmpty()) {
            System.out.println(path + " - " + stacks[stacks.length - index].peek().toString());
            try {
                stacks[stacks.length - index].pop();
            } catch (IsEmptyException e) {
                e.getMessage();
            }
        }
        try {
            stacks[stacks.length - index - 1].pop();
        } catch (IsEmptyException e) {
            e.getMessage();
        }

        fillStacks(saltos - index);
        backtrack(index + 1);

    }

    public void fillInitialStacks() {
        fillStacks(0);
    }

    public void fillStacks(int index) {
        if (index == saltos) return;
        else {
            ArrayList<Tile> posPosibles = caballo.getNextTiles();
            for (Tile tile : posPosibles) {
                stacks[index].stack(tile);
            }
            caballo.setPosicion(stacks[index].peek());
            fillStacks(index + 1);
        }
    }

    public int getCantidadDeMovimientos() {
        return this.saltos;
    }

    public void addPositionsToStack(Tile tile, int stackPos) {
        Caballo caballo = new Caballo(tile);
        ArrayList<Tile> possibleTiles = caballo.getNextTiles();
        for (Tile droga : possibleTiles) {
            stacks[stackPos].stack(droga);
        }
    }
    public void getPaths(){
        getPaths(saltos-1);
    }

    public void getPaths(int index) {


        String path = initialPos.toString();
        for (int i = 0; i < stacks.length - 1; i++) {
            path = path + " - " + stacks[i].peek().toString();
        }

        while (!stacks[stacks.length - 1].isEmpty()) {
            System.out.println(path + " - " + stacks[stacks.length - 1].peek().toString());
            try {
                stacks[stacks.length - 1].pop();
            } catch (IsEmptyException e) {
                e.getMessage();
            }

        }
        try {
            stacks[stacks.length - index].pop();
        } catch (IsEmptyException e) {
            e.getMessage();
        }
        if (stacks[stacks.length - index].peek() == null) return;
        addPositionsToStack(stacks[stacks.length - index].peek(), stacks.length - 1);
        index++;
        getPaths(index);


    }
}
