package Caballo;

import java.util.ArrayList;

public class Caballo {

    private Tile posicion;


    public Caballo() {
        this.posicion = new Tile();
    }

    public Caballo(Tile tile){
        this.posicion = tile;
    }

    public ArrayList<Tile> getNextTiles(){
        ArrayList<Tile> nextTiles = new ArrayList<>();
        char xPos = posicion.x;
        int yPos = posicion.y;

        nextTiles.add(new Tile((char)(xPos+2), yPos+1));
        nextTiles.add(new Tile((char)(xPos+2), yPos-1));
        nextTiles.add(new Tile((char)(xPos-2), yPos+1));
        nextTiles.add(new Tile((char)(xPos-2), yPos-1));


        nextTiles.add(new Tile((char)(xPos+1), yPos+2));
        nextTiles.add(new Tile((char)(xPos+1), yPos-2));
        nextTiles.add(new Tile((char)(xPos-1), yPos+2));
        nextTiles.add(new Tile((char)(xPos-1), yPos-2));



        return removeImpossibles(nextTiles);


    }
    // todo cambiar arraylist por arrays
    private ArrayList<Tile> removeImpossibles(ArrayList<Tile> nextTiles) {
        for (int i = 0; i<nextTiles.size();i++) {
            if(nextTiles.get(i).x > 'H' || nextTiles.get(i).x < 'A' || nextTiles.get(i).y > 8 || nextTiles.get(i).y < 1){
                nextTiles.set(i, null);
            }
        }

        ArrayList<Tile> temp = new ArrayList<Tile>();
        for (Tile tile: nextTiles) {
            if(tile != null){
                temp.add(tile);
            }
        }
        return temp;
    }


    public Tile getPosicion() {
        return posicion;
    }

    public void setPosicion(Tile posicion) {
        this.posicion = posicion;
    }
}
