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

    public Tile[] getNextTiles(){
        Tile[] nextTiles = new Tile[8];
        char xPos = posicion.x;
        int yPos = posicion.y;

        nextTiles[0] = (new Tile((char)(xPos+2), yPos+1));
        nextTiles[1] = (new Tile((char)(xPos+2), yPos-1));
        nextTiles[2] = (new Tile((char)(xPos-2), yPos+1));
        nextTiles[3] = (new Tile((char)(xPos-2), yPos-1));


        nextTiles[4] = (new Tile((char)(xPos+1), yPos+2));
        nextTiles[5] = (new Tile((char)(xPos+1), yPos-2));
        nextTiles[6] = (new Tile((char)(xPos-1), yPos+2));
        nextTiles[7] = (new Tile((char)(xPos-1), yPos-2));



        return removeImpossibles(nextTiles);


    }

    private Tile[] removeImpossibles(Tile[] nextTiles) {
        for (int i = 0; i < nextTiles.length; i++) {
            if(nextTiles[i].x > 'H' || nextTiles[i].x < 'A' || nextTiles[i].y > 8 || nextTiles[i].y < 1){
                nextTiles[i] = null;
            }
        }
        int nonNulls = 0;
        for (Tile tile: nextTiles) {
            if(tile != null){
                nonNulls++;
            }
        }
        Tile[] temp = new Tile[nonNulls];
        int i = 0;
        for (Tile tile: nextTiles) {
            if(tile != null){
                temp[i] = tile;
                i++;
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
