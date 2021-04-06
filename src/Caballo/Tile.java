package Caballo;

public class Tile {

    char x;
    int y;

    public Tile(char x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tile(){
        this.x = 'A';
        this.y =1;
    }

    public String toString(){
        return String.valueOf(x)+String.valueOf(y);
    }





}
