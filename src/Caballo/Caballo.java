package Caballo;

import java.util.ArrayList;

public class Caballo {

    private Tile posicion;
    //ultima posicion?

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

        removeImpossibles(nextTiles);

        return nextTiles;


    }

    private void removeImpossibles(ArrayList<Tile> nextTiles) {
        for (Tile pos: nextTiles) {
            if(pos.x > 'H' || pos.x < 'A' || pos.y > 8 || pos.y < 1){
                nextTiles.remove(pos);
            }
        }
    }


    public Tile getPosicion() {
        return posicion;
    }

    public void setPosicion(Tile posicion) {
        this.posicion = posicion;
    }
}
