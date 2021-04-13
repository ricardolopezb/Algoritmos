package Caballo;

import util.IsEmptyException;
import util.StaticStack;

public class MovCab {

    private Caballo caballo;
    private StaticStack<Tile>[] stacks;
    private int saltos;
    private Tile initialPos;

    public MovCab(int saltos, Tile initialPos) {
        this.caballo = new Caballo(initialPos);
        this.stacks = new StaticStack[saltos + 1];
        this.saltos = saltos;
        this.initialPos = initialPos;

        initializeStacks();
        stacks[0].stack(initialPos);
    }

    /*Inicializa los stacks con su contenido inicial, es decir con las posicones del camina inicial*/
    public void fillInitialStacks() {
        for (int i = 1; i < stacks.length; i++) {
            Caballo caballoAuxiliar = new Caballo(stacks[i - 1].peek());
            Tile[] nextTiles = caballoAuxiliar.getNextTiles();
            for (int j = 0; j < nextTiles.length; j++) {
                stacks[i].stack(nextTiles[j]);
            }
        }
    }

    public void getPaths(int indexToPop){

        if (indexToPop==saltos) return;

        while (!stacks[saltos-indexToPop].isEmpty()){
            printPath();
            try {
                stacks[saltos-indexToPop].pop();
            }catch (IsEmptyException e){
                e.getMessage();
            }
        }

        try {
            stacks[saltos-indexToPop-1].pop();
        }catch (IsEmptyException e){
            e.getMessage();
        }
        fillStackWithNexPosition();
        getPaths(indexToPop+1);

    }

    private void fillStackWithNexPosition(Tile tile, int index) {
        int n = 0;
        Tile[] nextPositions = new Caballo(tile).getNextTiles();
        while (n<index){
            Tile temp = nextPositions[]
            Tile[] aux = new Caballo();
        }

    }

    //Printea los stacks. Arreglar despues
    public void showStacks() {

        for (int i = 0; i < stacks.length; i++) {
            System.out.print("\nStacks " + (i + 1) + "\n");
            StaticStack<Tile> aux = new StaticStack<>();
            for (int j = 0; j < stacks[i].size(); j++) {
                if (stacks[i].peek() != null) {
                    System.out.print(stacks[i].peek().toString() + "\n");
                    Tile temp = stacks[i].peek();
                    aux.stack(temp);
                    try {
                        stacks[i].pop();
                    } catch (IsEmptyException e) {
                        e.getMessage();
                    }
                }
            }
            stacks[i] = aux;
        }

    }


    private void printPath(){
        String toReturn ="\n"+stacks[0].peek().toString();
        for (int i = 1; i < stacks.length; i++) {
            if (stacks[i].peek()!=null){
            toReturn += " - "+stacks[i].peek().toString();}
        }
        System.out.println(toReturn);
    }





































    /**NO TOCAR*/
    private void initializeStacks() {

        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new StaticStack<>();
        }
    }
}
