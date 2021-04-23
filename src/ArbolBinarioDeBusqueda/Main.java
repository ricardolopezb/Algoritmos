package ArbolBinarioDeBusqueda;

import ArbolBinario.BinaryTreeApi;

import java.util.ArrayList;

/*******************************************************************************************
 *
 * Author/s = Catalini Camila, Demitropulos Alejo, Encina Santiago, Lopez Bonaguro, Ricardo
 *
 * *****************************************************************************************/


public class Main {


    public static void main(String[] args) {
        ArrayList<Organism> list = new ArrayList<>();

        Organism organism1 = new Organism("AAAAA","ALejochan","alejochan",15,23);
        Organism organism2 = new Organism("BBBBB","Camichan","kmichan",45,45);
        Organism organism3 = new Organism("CCCCC","rikichan","rikichan",48,48);
        Organism organism4 = new Organism("Alejo","rikichan","rikichan",48,48);
        Organism organism5 = new Organism("Santi","rikichan","rikichan",48,48);

        list.add(organism2);
        list.add(organism3);
        list.add(organism1);
        list.add(organism5);
        list.add(organism4);

        BinarySearchTree<Organism> tree = new BinarySearchTree<>();
        DataTransporter dataTransporter = new DataTransporter();

        try {
            dataTransporter.transport(tree,list);
        }catch (BSTException e){
            e.getMessage();
        }

        BinaryTreeApi binaryTreeApi = new BinaryTreeApi();

        ArrayList<Organism> perLevel = new ArrayList<>();

        binaryTreeApi.perLevel(tree,perLevel);

        for (int i = 0; i < perLevel.size(); i++) {
            System.out.println(perLevel.get(i).getCode());
        }
    }



}
