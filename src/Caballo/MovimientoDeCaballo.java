package Caballo;


import util.DynamicStack;

import java.util.Stack;

public class MovimientoDeCaballo {

    private final char[] letras = {'A','B','C','D','E','F','G','H'};

    private int cantidadDeMovimientos;
    DynamicStack<Tile>[] stacks;

    public MovimientoDeCaballo(int n) {

        this.cantidadDeMovimientos = n;
        this.stacks = new DynamicStack[n];

    }

    public void proximoMovimiento(Caballo caballo){

    }

    public int getCantidadDeMovimientos() {
        return cantidadDeMovimientos;
    }


}
