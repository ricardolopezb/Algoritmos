package Caballo;
import util.StaticStack;
import util.IsEmptyException;

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

        //Elimina el los datos del stack para volver a llenarlos y no usar datos que ya fueron usados
        for (int i = stackPos; i <= saltos; i++) {
            if(!stacks[i].isEmpty()) stacks[i].empty();
            //try {
            //    if (i != stackPos) stacks[i - 1].pop();
            //} catch (IsEmptyException e){
            //    e.getMessage();
            //}
        }
        //Por cada stack los posibles movimientos del caballo del peek
        for (int i = stackPos; i <= saltos; i++) {

            Caballo caballoAux = new Caballo(stacks[i-1].peek());
            /*try{
                stacks[i-1].pop();
            } catch (IsEmptyException e){
                e.getMessage();
            }*/

            Tile[] tilesAux = caballoAux.getNextTiles();

            for (int j = 0; j < tilesAux.length; j++) {
                stacks[i].stack(tilesAux[j]);
            }
            /*try {
                stacks[i-1].pop();
            } catch (IsEmptyException e){
                e.getMessage();
            }*/

        }
    }

    private String pathToString(){
        String toReturn =stacks[0].toString();
        for (int i = 1; i < stacks.length; i++) {
            toReturn = " - "+stacks[i].toString();
        }
        return toReturn;
    }


    //index == cantidad de saltos


    public void getAllPaths(int index){
        System.out.print("droga");

        if (index<0) return;

        while(!stacks[index].isEmpty()){
            System.out.print("paco");
            Tile[] tops = new Tile[stacks.length];
            for (int i = 0; i < tops.length; i++) {
                if (stacks[i].peek() != null) tops[i] = stacks[i].peek();
            }
            printPath(tops);
            try {
                stacks[index].pop();
            }catch (IsEmptyException e){
                e.getMessage();
            }
        }

        try {
            stacks[index-1].pop();
        }catch (IsEmptyException e){
            e.getMessage();
        }

        Tile next = stacks[stacks.length-2].peek();
        if(next == null) getAllPaths(index-1); //invocar metodo sobre el anterior
        Tile[] nextTiles = new Caballo(next).getNextTiles();
        stackTiles(stacks[stacks.length-1], nextTiles);

    }

    public void stackTiles(StaticStack stack, Tile[] tiles){
        for (int i = 0; i < tiles.length; i++) {
            stack.stack(tiles[i]);
        }
    }

    public void printPath(Tile[] tiles){
        String toPrint = "";

        for (int i = 0; i < tiles.length-1; i++) {
            toPrint = toPrint + tiles[i].toString() +" - ";
        }
        toPrint = toPrint + tiles[tiles.length-1].toString();


        System.out.println(toPrint);
    }

    public void fillInitialStacks() {
        fillStacks(1);
    }

    public void fillStacks(int index) {
        if (index == saltos);
        else {
            Tile[] posPosibles = caballo.getNextTiles();
            for (Tile tile : posPosibles) {
                stacks[index].stack(tile);
            }
            caballo.setPosicion(stacks[index].peek());
            fillStacks(index + 1);
        }
    }

/**METODO AUXILIAR PARA POPEAR EL TOPE DEL ANTERIOR AL N PARA PODER SEGUIR CON LOS CAMINOS, guardar en que stacke stamos con un entero*/





}
