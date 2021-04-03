package Caballo;

public class Caballo {

    private Tile posicion;

    public Caballo() {
        this.posicion = new Tile();
    }

    public Caballo(Tile tile){
        this.posicion = tile;
    }

    public Tile getPosicion() {
        return posicion;
    }

    public void setPosicion(Tile posicion) {
        this.posicion = posicion;
    }
}
