package ArbolBinarioDeBusqueda;

import java.awt.*;
import java.util.ArrayList;

public class DataTransporter {


    public DataTransporter() {
    }

    public void transport(BinarySearchTree<Organism> tree, ArrayList<Organism> list) throws BSTException {

        for (int i = 0; i < list.size(); i++) {
            tree.insert(list.get(i));
        }

    }




}
