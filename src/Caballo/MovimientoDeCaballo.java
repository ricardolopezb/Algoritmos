package Caballo;


import util.DynamicStack;

import java.util.Stack;

public class MovimientoDeCaballo {

    private final char[] letras = {'A','B','C','D','E','F','G','H'};
    private Caballo caballo;
    private int cantidadDeMovimientos;
    DynamicStack<Tile>[] stacks;

    public MovimientoDeCaballo(int saltos, Tile posInicial) {

        this.cantidadDeMovimientos = saltos;
        this.stacks = new DynamicStack[saltos];
        this.caballo = new Caballo(posInicial);

    }

    public void mover(int n){

    }

    public int getCantidadDeMovimientos() {
        return cantidadDeMovimientos;
    }


    //printea el contenido de cada pila.
    public void displayStacks() {
    }
}
