package Caballo;

import util.IsEmptyException;
import util.Stack.StaticStack;

public class MovCab {

    private StaticStack<Tile>[] stacks;
    private int saltos;

    public MovCab(int saltos, Tile initialPos) {
        this.stacks = new StaticStack[saltos + 1];
        this.saltos = saltos;

        initializeStacks();
        stacks[0].stack(initialPos);
    }


    public void fillInitialStacks() {
        for (int i = 1; i < stacks.length; i++) {
            Caballo caballoAuxiliar = new Caballo(stacks[i-1].peek());
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

        refillStacks(1);
        getPaths();
    }


    private void refillStacks(int index){
        if (index == saltos) System.exit(2);
        if (!stacks[saltos-index].isEmpty()){
            try{
                stacks[saltos-index].pop();
            }catch (IsEmptyException e){
                e.getMessage();
            }
            Tile[] temp = {};
            if(stacks[saltos-index].peek() != null) {
                temp = new Caballo(stacks[saltos - index].peek()).getNextTiles();
            }

            for (int i = 0; i < temp.length; i++) {
                stacks[saltos-index+1].stack(temp[i]);
            }


            return;
        }
        else {
             refillStacks(index+1);
        }
    }


    public void showStacks() {
        for (int i = 0; i < stacks.length; i++) {
            System.out.println("Stack " + (i+1));
            printStack(stacks[i]);
            System.out.println("\n");
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


    private void initializeStacks() {
        for (int i = 0; i < stacks.length; i++) {
            stacks[i] = new StaticStack<>();
        }
    }


    public void printStack(StaticStack<Tile> stack) {
        Tile temp = null;

        if(!stack.isEmpty())
        {
            temp = stack.peek();
            try{
                stack.pop();
            } catch (IsEmptyException e){
                e.getMessage();
            }
            System.out.println("\t"+temp);
            printStack(stack);
        }
        stack.stack(temp);
    }

}
