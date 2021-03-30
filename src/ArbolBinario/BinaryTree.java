package ArbolBinario;



public class BinaryTree<T> {


   private DoubleNode root;

   public BinaryTree() {
        this.root = null;
   }

   public BinaryTree(T element) {
        this.root = new DoubleNode(element);
   }

   public BinaryTree(DoubleNode doubleNode){
        this.root = doubleNode;
   }

   public boolean isEmpty() {
        return root.equals(null);
   }

   public BinaryTree getLeft(){
        return new BinaryTree(root.getLeft());
   }

   public BinaryTree getRight(){
        return new BinaryTree(root.getRight());
   }

   public DoubleNode getRoot() {
        return root;
   }
}
