package ArbolBinario;

import java.util.ArrayList;

public class BinaryTreeApi<T>  {

    /**-------------------------------------- TREE INFO -------------------------------------------------*/

    public int weight(BinaryTree<T> tree) {
        return size(tree);
    }


    public int size(BinaryTree<T> tree) {
        if (tree.isEmpty()) return 0;
        return 1 + size(tree.getLeft()) + size(tree.getRight());
    }


    public int leavesNumber(BinaryTree<T> tree){
        if (tree.isEmpty()) return 0;
        if (tree.getLeft().isEmpty() && tree.getRight().isEmpty()) return 1;
        return leavesNumber(tree.getLeft()) + leavesNumber(tree.getRight());
    }


    public int occurrences(BinaryTree<T> tree, T element) {
        if (tree.isEmpty()) return 0;
        if (tree.getRoot().equals(element)) return 1 + occurrences(tree.getLeft(),element) + occurrences(tree.getRight(), element);
        else return occurrences(tree.getLeft(), element) + occurrences(tree.getRight(), element);
    }


    public int elementsPerLevel(BinaryTree<T> tree, int level){
        if (tree.isEmpty()) return 0;
        if (level == 0) return 1;
        return elementsPerLevel(tree.getLeft(),level-1) + elementsPerLevel(tree.getRight(),level-1);
    }


    public int height(BinaryTree<T> tree){
        if (tree.isEmpty()) return -1;
        return 1 + Math.max(height(tree.getLeft()) , height(tree.getRight()));
    }


    public int fullNodes(BinaryTree<T> tree) {
        if (tree.isEmpty()) return 0;
        if (!tree.getLeft().isEmpty() && !tree.getRight().isEmpty()) return 1 + fullNodes(tree.getLeft()) + fullNodes(tree.getRight());
        return fullNodes(tree.getLeft()) + fullNodes(tree.getRight());
    }


    public boolean completeTree(BinaryTree<T> tree) {
     return false;
    }


    /**-------------------------------------------- OPERATIONS ------------------------------------------------*/


    public int sum(BinaryTree<Integer> tree){
        if (tree.isEmpty()) return 0;
        return tree.getRoot() + sum(tree.getLeft()) + sum(tree.getRight());
    }

    public int sumx3(BinaryTree<Integer> tree){
        if (tree.isEmpty()) return 0;
        if (tree.getRoot() % 3 == 0) return tree.getRoot() + sumx3(tree.getLeft()) + sumx3(tree.getRight());
        return sumx3(tree.getLeft()) + sumx3(tree.getRight());
    }

    /**Arreglar*/
    public boolean equals(BinaryTree<T> a, BinaryTree<T> b) {
       return true;
    }

    public boolean areIsomorphics(BinaryTree<T> a, BinaryTree<T> b) {
        if (a.isEmpty() && b.isEmpty()) return true;
        if (a.getLeft().isEmpty() && b.getLeft().isEmpty()) return true && areIsomorphics(a.getRight(),b.getRight());
        if (a.getRight().isEmpty() && b.getRight().isEmpty()) return true && areIsomorphics(a.getLeft(),b.getLeft());
        if (!a.getRight().isEmpty() && !b.getRight().isEmpty() && !a.getLeft().isEmpty() && !b.getLeft().isEmpty()) return true && areIsomorphics(a.getRight(),b.getRight()) && areIsomorphics(a.getLeft(),b.getLeft());
        return false;
    }


    public boolean similar(BinaryTree<T> a, BinaryTree<T> b){
        ArrayList<T> aElements = new ArrayList<>();
        ArrayList<T> bElements = new ArrayList<>();
        inorder(a,aElements);
        inorder(b,bElements);
        return aElements.containsAll(bElements) && bElements.containsAll(aElements);
    }

    /**Sumatoria de 2^i*/
    public boolean isFull(BinaryTree<T> tree) {
     return size(tree) == Math.pow(2,height(tree)+1)-1;
    }


    public boolean isComplete(BinaryTree<T> tree) {
        if (tree.isEmpty()) return false;
        if ((tree.getLeft().isEmpty() && !tree.getRight().isEmpty()) || (!tree.getLeft().isEmpty() && tree.getRight().isEmpty())) return false;
        if (!tree.isEmpty() && tree.getLeft().isEmpty() && tree.getRight().isEmpty()) return true;
        return true && isComplete(tree.getLeft()) && isComplete(tree.getRight());
    }

    public boolean isStable(BinaryTree<Integer> tree) {
        if (tree.isEmpty()) return true;
        if (tree.getRight().isEmpty() && tree.getLeft().isEmpty()) return true;
        if (((int) tree.getRight().getRoot() > (int) tree.getRoot()) || ((int) tree.getLeft().getRoot() > (int) tree.getRoot())) return false;
        return isStable(tree.getRight()) && isStable(tree.getLeft());
    }

    /**Arreglar*/
    public boolean occurresIn(BinaryTree<T> a, BinaryTree<T> b) {
        if (a.isEmpty() || b.isEmpty()) return false;
        if (a.equals(b)) return true;
        if (size(a)>size(b)) return occurresIn(a.getLeft(),b) || occurresIn(a.getRight(),b);
        else return occurresIn(b.getLeft(),a) || occurresIn(b.getRight(),a);
    }


    public void showFrontier(BinaryTree<T> tree) {
        if (tree.isEmpty()) return;
        if (tree.getLeft().isEmpty() && tree.getRight().isEmpty()) System.out.println(tree.getRoot());
        showFrontier(tree.getLeft());
        showFrontier(tree.getRight());
    }

    public ArrayList<T> frontier(BinaryTree<T> tree){
        ArrayList<T> toReturn = new ArrayList<>();
        frontierAuxiliar(tree,toReturn);
        return toReturn;
    }

    public void frontierAuxiliar(BinaryTree<T> tree, ArrayList<T> frontier) {
        if (!tree.isEmpty()){
        if (tree.getLeft().isEmpty() && tree.getRight().isEmpty()) frontier.add((T) tree.getRoot());
        frontierAuxiliar(tree.getLeft(),frontier);
        frontierAuxiliar(tree.getRight(),frontier);
        }
    }



    /**--------------------------------------------- ORDENAR --------------------------------------------------*/

    public void preorder(BinaryTree<T> tree){
        if (!tree.isEmpty()){
            System.out.println(tree.getRoot());
            preorder(tree.getLeft());
            preorder(tree.getRight());
        }
    }


    public void preorder(BinaryTree<T> tree, ArrayList<T> traversal){
        if (!tree.isEmpty()){
            traversal.add((tree.getRoot()));
            preorder(tree.getLeft(),traversal);
            preorder(tree.getRight(),traversal);
        }
    }


    public void inorder(BinaryTree<T> tree){
        if(!tree.isEmpty()){
            inorder(tree.getLeft());
            System.out.println(tree.getRoot());
            inorder(tree.getRight());
        }
    }


    public void inorder(BinaryTree<T> tree, ArrayList<T> traversal){
        if (!tree.isEmpty()){
            inorder(tree.getLeft(), traversal);
            traversal.add((T) tree.getRoot());
            inorder(tree.getRight(),traversal);
        }
    }


    public void postorder(BinaryTree<T> tree){
        if (!tree.isEmpty()){
            postorder(tree.getLeft());
            postorder(tree.getRight());
            System.out.println(tree.getRoot());
        }
    }


    public void postorder(BinaryTree<T> tree, ArrayList<T> traversal){
        if (!tree.isEmpty()){
        postorder(tree.getLeft(),traversal);
        postorder(tree.getRight(),traversal);
        traversal.add(tree.getRoot());
        }
    }

    /**revisar*/
    public void perLevel(BinaryTree<T> tree){
        if (!tree.isEmpty()){
            System.out.println(tree.getRoot());
            System.out.println(tree.getLeft().getRoot());
            System.out.println(tree.getRight().getRoot());
            perLevel(tree.getLeft().getLeft());
            perLevel(tree.getLeft().getRight());
            perLevel(tree.getRight().getLeft());
            perLevel(tree.getRight().getRight());

        }

    }


    public void perLevel(BinaryTree<T> tree, ArrayList<T> traversal){}
}
