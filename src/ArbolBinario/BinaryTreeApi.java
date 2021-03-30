package ArbolBinario;

import java.util.ArrayList;

public class BinaryTreeApi<T>  {

    /** LISTO */
    public int weight(BinaryTree<T> tree) {
        return size(tree);
    }
    /** LISTO */
    public int size(BinaryTree<T> tree) {
        if (tree.isEmpty()) return 0;
        return 1 + size(tree.getLeft()) + size(tree.getRight());
    }
    //pensarlo para sacar duda
    public int height(BinaryTree<T> tree){
        if (tree.isEmpty() || (tree.getLeft().isEmpty() && tree.getRight().isEmpty())) return 0;
        if (tree.getLeft().isEmpty() && !tree.getRight().isEmpty()) return 1+ height(tree.getRight());
        if (!tree.getLeft().isEmpty() && tree.getRight().isEmpty()) return 1+ height(tree.getLeft());
        return 1+ height(tree.getLeft()) + height(tree.getRight());
    }
    /** LISTO */
    public int fullNodes(BinaryTree<T> tree) {
        if (tree.isEmpty()) return 0;
        if (!tree.getLeft().isEmpty() && !tree.getRight().isEmpty()) return 1 + fullNodes(tree.getLeft()) + fullNodes(tree.getRight());
        return fullNodes(tree.getLeft()) + fullNodes(tree.getRight());
    }
    /** LISTO */
    public int completeNodes(BinaryTree<T> tree) {
        if (tree.isEmpty()) return 0;
        if (tree.getLeft().isEmpty()) return completeNodes(tree.getRight());
        if (tree.getRight().isEmpty()) return completeNodes(tree.getLeft());
        return 1 + completeNodes(tree.getLeft()) + completeNodes(tree.getRight());
    }
    /*checkear el isfull, creo que esta pensar que pasa si tiene uno lleno y el otro no, pero si no pasa todas las condicioneses pq estan llenos los nodos id y raiz**/
    public boolean isFull(BinaryTree<T> tree) {
        if (tree.isEmpty()) return false;
        if ((tree.getLeft().isEmpty() && !tree.getRight().isEmpty()) || (!tree.getLeft().isEmpty() && tree.getRight().isEmpty())) return false;
        if (!tree.isEmpty() && tree.getLeft().isEmpty() && tree.getRight().isEmpty()) return true;
        return true && isFull(tree.getLeft()) && isFull(tree.getRight());
    }
    /*puede ser lo mismo que is full, checkear*/
    public boolean isComplete(BinaryTree<T> tree) {
        return isFull(tree);
    }
    /*pensar pq pueden tener el mismo size sin tener nodos completos, pensar todos los casos posibles del isfull*/
    public boolean isStable(BinaryTree<T> tree) {
        return isFull(tree.getLeft()) && isFull(tree.getRight());
    }
    /** LISTO */
    public int ocurrences(BinaryTree<T> tree, T element) {
        if (tree.isEmpty()) return 0;
        if (tree.getRoot().equals(element)) return 1 + ocurrences(tree.getLeft(),element) + ocurrences(tree.getRight(), element);
        else return ocurrences(tree.getLeft(), element) + ocurrences(tree.getRight(), element);
    }
    /** LISTO */
    public boolean happensTree(BinaryTree<T> a, BinaryTree<T> b) {
        if(a.isEmpty() || b.isEmpty()) return false;
        if (areEquals(a,b)) return true;
        return areEquals(a.getLeft(),b) || areEquals(a.getRight(),b);
    }
    /** LISTO */
    public void preorder(BinaryTree<T> tree){
        if (!tree.isEmpty()){
            System.out.println(tree.getRoot().getData());
            preorder(tree.getLeft());
            preorder(tree.getRight());
        }
    }
    /** LISTO */
    public void preorder(BinaryTree<T> tree, ArrayList<T> traversal){
        if (!tree.isEmpty()){
            traversal.add((T) tree.getRoot().getData());
            preorder(tree.getLeft(),traversal);
            preorder(tree.getRight(),traversal);
        }
    }
    /** LISTO */
    public void inorder(BinaryTree<T> tree){
        if(!tree.isEmpty()){
            inorder(tree.getLeft());
            System.out.println(tree.getRoot().getData());
            inorder(tree.getRight());
        }
    }
    /** LISTO */
    public void inorder(BinaryTree<T> tree, ArrayList<T> traversal){
        if (!tree.isEmpty()){
            inorder(tree.getLeft(), traversal);
            traversal.add((T) tree.getRoot().getData());
            inorder(tree.getRight(),traversal);
        }
    }
    /** LISTO */
    public void postorder(BinaryTree<T> tree){
        if (!tree.isEmpty()){
            postorder(tree.getLeft());
            postorder(tree.getRight());
            System.out.println(tree.getRoot().getData());
        }
    }
    /** LISTO */
    public void postorder(BinaryTree<T> tree, ArrayList<T> traversal){
        if (!tree.isEmpty()){
        postorder(tree.getLeft(),traversal);
        postorder(tree.getRight(),traversal);
        traversal.add((T) tree.getRoot().getData());
        }
    }

    public void perLevel(BinaryTree<T> tree){}

    public void perLevel(BinaryTree<T> tree, ArrayList<T> traversal){}
    /**Checkear*/
    public boolean areEquals(BinaryTree<T> a, BinaryTree<T> b) {
        if (!a.getRoot().equals(b.getRoot()))return false;
        if (a.getRoot().equals(b.getRoot()) && a.getRight().isEmpty() && a.getLeft().isEmpty() && b.getRight().isEmpty() && b.getLeft().isEmpty()) return true;
        return true && areEquals(a.getLeft(), b.getLeft()) && areEquals(a.getRight(), b.getRight());
    }

    public boolean areIsomorphics(BinaryTree<T> a, BinaryTree<T> b) {
        return false;
    }

    public void showFrontier(BinaryTree<T> tree) {

    }

    public ArrayList<T> frontier(BinaryTree<T> tree, T element) {
        return null;
    }
}
