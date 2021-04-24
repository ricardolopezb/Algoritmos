package ArbolBinarioDeBusqueda;

import java.util.ArrayList;
import ArbolBinario.BinaryTreeApi;

public class memoryManager {


    public memoryManager() {
    }

    public void transport(BinarySearchTree<Organism> tree, ArrayList<Organism> list) throws BSTException {

        for (int i = 0; i < list.size(); i++) {
            tree.insert(list.get(i));
        }

    }

    public void eliminate(BinarySearchTree<Organism> tree, String code) throws BSTException, IncompatibleCode {
        Organism organism=new Organism(code,null,null,0,0);
        tree.delete(organism);
    }

    public void inform(BinarySearchTree<Organism> tree){
        BinaryTreeApi api=new BinaryTreeApi();
        int size=api.size(tree);
        System.out.println();
        System.out.println("**************************************************************************+");
        System.out.println("There are "+size+" organisms in memory.");
        System.out.println("This is a list of all the organisms ordered by level:");

        ArrayList<Organism> perLevel = new ArrayList<>();

        api.perLevel(tree,perLevel);

        for (int i = 0; i < perLevel.size(); i++) {
            System.out.println(perLevel.get(i).getCode());
        }
    }

    public void getInfo(BinarySearchTree<Organism> tree,Organism organism){
        System.out.println();
        if (tree.exists(organism)){
            System.out.println("Organism information:");
            System.out.println("Code: "+organism.getCode());
            System.out.println("Type: "+organism.getType());
            System.out.println("Description: "+organism.getDescription());
            System.out.println("Size: "+organism.getSize()[0]+""+organism.getSize()[1]);

        }else{
            System.out.println("The organism does not exist");
        }

    }

    }





