package util;


import ArbolBinario.BinaryTreeApi;
import ArbolBinarioDeBusqueda.AVLTree.AVLTree;
import ArbolBinarioDeBusqueda.BSTException;
import ArbolBinarioDeBusqueda.BinarySearchTree;
import ArbolBinarioDeBusqueda.IntegerList;
import ArbolBinarioDeBusqueda.RedBlackTree.RedBlackTree;
import org.junit.Test;

import java.util.Random;

public class MainTest {

   static IntegerList randoms= new IntegerList();


    public static void main(String[] args) {
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        AVLTree<Integer> avlTree = new AVLTree<>();
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        BinaryTreeApi<Integer> binaryTreeApi = new BinaryTreeApi<>();
        for (int i = 0; i < randoms.size(); i++) {
            redBlackTree.insert(randoms.list()[i]);
            try {
                if (!binarySearchTree.exists(randoms.list()[i]))binarySearchTree.insert(randoms.list()[i]);
            } catch (BSTException e) {
                e.printStackTrace();
            }

        }


        for (int i = 1; i < 11; i++) {
            if (!avlTree.exists(i))avlTree.insert(i);
        }

        System.out.println(redBlackHeight(redBlackTree));
        System.out.println(avlHeight(avlTree));
        System.out.println(binaryTreeApi.height(binarySearchTree));

    }

    @Test
    public void construccionRedBlack(){ //Tiempo promedio de 10 experiencias = 5.9ms


        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        for (int i = 0; i < randoms.size(); i++) {
            redBlackTree.insert(randoms.list()[i]);
        }


    }
    @Test
    public void construccionAVL(){//Tiempo promedio de 10 experiencias = 6.5ms


        AVLTree<Integer> avlTree = new AVLTree<>();
        for (int i = 0; i < randoms.size(); i++) {
           if (!avlTree.exists(randoms.list()[i]))avlTree.insert(randoms.list()[i]);
        }

    }
    @Test
    public void construccionBST(){ //Tiempo promedio de 10 experiencias = 14ms

        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();
        for (int i = 0; i < randoms.size(); i++) {
            try {

                if (!binarySearchTree.exists(randoms.list()[i]))binarySearchTree.insert(randoms.list()[i]);


            } catch (BSTException e) {
                e.printStackTrace();
            }
        }

    }

    public static int redBlackHeight(RedBlackTree<Integer> redBlackTree){

        if (redBlackTree.isEmpty()){
            return -1;
        }
        try {
            return 1 + Math.max(redBlackHeight(redBlackTree.getLeft()),redBlackHeight(redBlackTree.getRight()));
        }catch (NullPointerException e){}
        return -1;
    }

    public static int avlHeight(AVLTree<Integer> avlTree){

            return avlTree.height(avlTree.getRoot());

    }





}
