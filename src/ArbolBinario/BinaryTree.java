package ArbolBinario;




public class BinaryTree<T> {


   private DoubleNode<T> root;

    public BinaryTree() {
        this.root = null;
    }

    public BinaryTree(T element) {
        this.root = new DoubleNode(element);
   }

   public BinaryTree(DoubleNode doubleNode){
        this.root = doubleNode;
   }

   public BinaryTree(T element, BinaryTree<T> leftTree, BinaryTree<T> rightTree){
       this.root = new DoubleNode<T>(element, leftTree.root, rightTree.root);
   }


   public boolean isEmpty() {
        return root == null;
   }

   public BinaryTree getLeft(){
        return new BinaryTree(root.getLeft());
   }

   public BinaryTree getRight(){
        return new BinaryTree(root.getRight());
   }

   public T getRoot() {
        return root.getData();
   }
}
