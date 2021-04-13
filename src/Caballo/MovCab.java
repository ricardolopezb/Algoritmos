package Caballo;

import util.IsEmptyException;
import util.StaticStack;

public class MovCab {

    /**NOTA: TRABAJAR DESDE EL QUE ESTA EN KBALLO O */

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

    public void getPaths(){

        while(!stacks[stacks.length-1].isEmpty()){
            printPath();
            try {
                stacks[stacks.length-1].pop();
            }catch (IsEmptyException e){e.getMessage();}
        }

        droga(1);
        getPaths();



    }




    private void droga(int index){
        if (index == saltos) System.exit(2);
        if (!stacks[saltos-index].isEmpty()){
            Tile[] temp = new Caballo(stacks[saltos-index].peek()).getNextTiles();

            for (int i = 0; i < temp.length; i++) {
                stacks[saltos-index+1].stack(temp[i]);
            }
            try{
                stacks[saltos-index].pop();
            }catch (IsEmptyException e){
                e.getMessage();
            }

            return;
        }
        else {
             droga(index+1);
        }
    }

    private void findAndFillEmptyStack(){
        int n = 0;
        for (int i=0; i < stacks.length; i++) {
            if (stacks[i].isEmpty()) n = i;
        }
        Tile temp = stacks[n-1].peek();
        metodoRecursivo(n,temp);
    }

    private boolean isEmptyStack(){
        for (int i=0; i < stacks.length; i++) {
            if (stacks[i].isEmpty()) return true;
        }
        return false;
    }

    public void metodoRecursivo(int n,Tile temp){
        if (n > saltos) return;

        Tile[] aux = new Caballo(temp).getNextTiles();

        for (int i = 0; i < aux.length; i++) {
            stacks[n].stack(aux[i]);
        }

        temp = stacks[n].peek();
        metodoRecursivo(n+1,temp);
    }

    //todo Printea los stacks. Arreglar despues
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
            toReturn += " - "+stacks[i].peek().toString();
            } else{
                return;
            }
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
