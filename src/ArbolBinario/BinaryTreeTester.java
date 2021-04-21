package ArbolBinario;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BinaryTreeTester {


    static BinaryTree<Integer> left = new BinaryTree<Integer>(2,new BinaryTree<Integer>(4), new BinaryTree<Integer>(5));
    static BinaryTree<Integer> right = new BinaryTree<Integer>(3,new BinaryTree<Integer>(6), new BinaryTree<Integer>(7));
    static BinaryTree<Integer> rightNull = new BinaryTree<Integer>(3,new BinaryTree<Integer>(6),new BinaryTree<>());
    static BinaryTree<Integer> binaryTreeFull = new BinaryTree<Integer>(1,left,right);
    static BinaryTree<Integer> binaryTreeInFull = new BinaryTree<Integer>(1,left,rightNull);
    static BinaryTreeApi<Integer> binaryTreeApi = new BinaryTreeApi<>();

    static BinaryTree<Integer> left2 = new BinaryTree<>(4,new BinaryTree<>(1), new BinaryTree<>(3));
    static BinaryTree<Integer> right2 = new BinaryTree<>(6,new BinaryTree<>(5), new BinaryTree<>(7));
    static BinaryTree<Integer> binaryTreeFullMixed = new BinaryTree<>(2, left2,right2);

    static BinaryTree<Integer> left3 = new BinaryTree<>(6,new BinaryTree<>(4),new BinaryTree<>(3));
    static BinaryTree<Integer> right3 = new BinaryTree<>(5,new BinaryTree<>(2),new BinaryTree<>(1));
    static BinaryTree<Integer> binaryTreeStable = new BinaryTree<>(7,left3,right3);

    static BinaryTree<Integer> binaryTreeManco = new BinaryTree<>(1,left,new BinaryTree<>(22));

    static BinaryTree<Integer> binaryTreeFull2 = new BinaryTree<>(1,left,right);

    static BinaryTree<Integer> arbolvacio = new BinaryTree<>();
    static BinaryTree<Integer> arbolvacio2 = new BinaryTree<>();
    static BinaryTree<Integer> arbolInVacio = new BinaryTree<>(2);
    static BinaryTree<Integer> arbolInVacio2 = new BinaryTree<>(2);
    static BinaryTree<Integer> arbolInVacio3 = new BinaryTree<>(3);



    @Test
    public void sizeTest(){
        Assert.assertEquals(7,binaryTreeApi.size(binaryTreeFull));
        Assert.assertEquals(6,binaryTreeApi.size(binaryTreeInFull));
    }

    @Test
    public void weightTest(){
        Assert.assertEquals(7,binaryTreeApi.weight(binaryTreeFull));
        Assert.assertEquals(6,binaryTreeApi.weight(binaryTreeInFull));
    }

    @Test
    public void leavesNumberTest(){
        Assert.assertEquals(4,binaryTreeApi.leavesNumber(binaryTreeFull));
        Assert.assertEquals(3,binaryTreeApi.leavesNumber(binaryTreeInFull));
    }

    @Test
    public void occurrencesTest(){
        Assert.assertEquals(1,binaryTreeApi.occurrences(binaryTreeFull,7));
        Assert.assertEquals(0,binaryTreeApi.occurrences(binaryTreeInFull,7));
    }

    @Test
    public void elementsPerLevelTeste(){
        Assert.assertEquals(4,binaryTreeApi.elementsPerLevel(binaryTreeFull,2));
        Assert.assertEquals(3,binaryTreeApi.elementsPerLevel(binaryTreeInFull,2));
    }

    @Test
    public void heightTest(){
        Assert.assertEquals(2,binaryTreeApi.height(binaryTreeFull));
        Assert.assertEquals(2,binaryTreeApi.height(binaryTreeInFull));
    }

    @Test
    public void sumTest(){
        Assert.assertEquals(28,binaryTreeApi.sum(binaryTreeFull));
        Assert.assertEquals(21,binaryTreeApi.sum(binaryTreeInFull));
    }

    @Test
    public void sumx3Test(){
        Assert.assertEquals(9,binaryTreeApi.sumx3(binaryTreeFull));
        Assert.assertEquals(9,binaryTreeApi.sumx3(binaryTreeInFull));
    }

   @Test
    public void equalsTest(){
        Assert.assertEquals(false, binaryTreeApi.equals(binaryTreeFull,binaryTreeInFull));
        Assert.assertEquals(true, binaryTreeApi.equals(binaryTreeFull,binaryTreeFull));
        Assert.assertEquals(true, binaryTreeApi.equals(binaryTreeInFull,binaryTreeInFull));
        Assert.assertEquals(true, binaryTreeApi.equals(binaryTreeFull, binaryTreeFull2));
        Assert.assertEquals(true, binaryTreeApi.equals(arbolvacio,arbolvacio2));
        Assert.assertEquals(true, binaryTreeApi.equals(arbolInVacio,arbolInVacio2));
        Assert.assertEquals(false, binaryTreeApi.equals(arbolvacio,arbolInVacio3));
        Assert.assertEquals(false, binaryTreeApi.equals(arbolInVacio,arbolInVacio3));
    }

    @Test
    public void areIsomorphicsTest(){
        Assert.assertEquals(false, binaryTreeApi.areIsomorphics(binaryTreeFull,binaryTreeInFull));
        Assert.assertEquals(true, binaryTreeApi.areIsomorphics(binaryTreeFull,binaryTreeFull));
        Assert.assertEquals(true, binaryTreeApi.areIsomorphics(binaryTreeInFull,binaryTreeInFull));
    }

    @Test
    public void similarTest(){
        Assert.assertEquals(false, binaryTreeApi.similar(binaryTreeFull,binaryTreeInFull));
        Assert.assertEquals(true, binaryTreeApi.similar(binaryTreeFull,binaryTreeFull));
        Assert.assertEquals(true, binaryTreeApi.similar(binaryTreeInFull,binaryTreeInFull));
        Assert.assertEquals(true, binaryTreeApi.similar(binaryTreeFull,binaryTreeFullMixed));
    }

    @Test
    public void isFullTest(){
        Assert.assertEquals(true,binaryTreeApi.isFull(binaryTreeFull));
        Assert.assertEquals(false,binaryTreeApi.isFull(binaryTreeInFull));
        Assert.assertEquals(true,binaryTreeApi.isFull(binaryTreeFullMixed));
    }

    @Test
    public void isCompleteTest(){
        Assert.assertEquals(true,binaryTreeApi.isComplete(binaryTreeFull));
        Assert.assertEquals(false,binaryTreeApi.isComplete(binaryTreeInFull));
        Assert.assertEquals(true,binaryTreeApi.isComplete(binaryTreeFullMixed));
    }

    @Test
    public void isStableTest(){
        Assert.assertEquals(true,binaryTreeApi.isStable(binaryTreeStable));
        Assert.assertEquals(false,binaryTreeApi.isStable(binaryTreeInFull));
        Assert.assertEquals(false,binaryTreeApi.isStable(binaryTreeFull));
        Assert.assertEquals(false,binaryTreeApi.isStable(binaryTreeFullMixed));
    }

    @Test
    public void occuresInTest(){
        Assert.assertEquals(true,binaryTreeApi.occurresIn(binaryTreeFull,binaryTreeInFull.getLeft()));
        Assert.assertEquals(true,binaryTreeApi.occurresIn(binaryTreeFull,binaryTreeFull));
        Assert.assertEquals(true,binaryTreeApi.occurresIn(binaryTreeInFull,binaryTreeInFull));
        Assert.assertEquals(false,binaryTreeApi.occurresIn(binaryTreeFull,binaryTreeFullMixed));
        Assert.assertEquals(true,binaryTreeApi.occurresIn(binaryTreeFullMixed,binaryTreeFullMixed));
        Assert.assertEquals(false,binaryTreeApi.occurresIn(binaryTreeInFull,binaryTreeFull));
        Assert.assertEquals(true,binaryTreeApi.occurresIn(binaryTreeStable,binaryTreeStable));
        Assert.assertEquals(false,binaryTreeApi.occurresIn(binaryTreeStable,binaryTreeFull));
    }

    @Test
    public void frontierTest(){
        ArrayList<Integer> frontierFull = new ArrayList<>();
        ArrayList<Integer> frontierInFull = new ArrayList<>();
        ArrayList<Integer> frontierFullMixed = new ArrayList<>();
        ArrayList<Integer> frontierStable = new ArrayList<>();
        frontierFull.add(4);
        frontierFull.add(5);
        frontierFull.add(6);
        frontierFull.add(7);
        frontierInFull.add(4);
        frontierInFull.add(5);
        frontierInFull.add(6);
        frontierFullMixed.add(1);
        frontierFullMixed.add(3);
        frontierFullMixed.add(5);
        frontierFullMixed.add(7);
        frontierStable.add(4);
        frontierStable.add(3);
        frontierStable.add(2);
        frontierStable.add(1);
        Assert.assertEquals(true,frontierFull.equals(binaryTreeApi.frontier(binaryTreeFull)));
        Assert.assertEquals(true,frontierInFull.equals(binaryTreeApi.frontier(binaryTreeInFull)));
        Assert.assertEquals(true,frontierFullMixed.equals(binaryTreeApi.frontier(binaryTreeFullMixed)));
        Assert.assertEquals(true,frontierStable.equals(binaryTreeApi.frontier(binaryTreeStable)));
        Assert.assertEquals(false,frontierFull.equals(binaryTreeApi.frontier(binaryTreeInFull)));
        Assert.assertEquals(false,frontierFullMixed.equals(binaryTreeApi.frontier(binaryTreeStable)));
    }

    @Test
    public void inorderTest(){
        ArrayList<Integer> inorderFull = new ArrayList<>();
        inorderFull.add(4);
        inorderFull.add(2);
        inorderFull.add(5);
        inorderFull.add(1);
        inorderFull.add(6);
        inorderFull.add(3);
        inorderFull.add(7);
        ArrayList<Integer> inorderTest = new ArrayList<>();
        binaryTreeApi.inorder(binaryTreeFull,inorderTest);
        Assert.assertEquals(true,inorderFull.equals(inorderTest));
    }

    @Test
    public void preorderTest(){
        ArrayList<Integer> preorderFull = new ArrayList<>();
        preorderFull.add(1);
        preorderFull.add(2);
        preorderFull.add(4);
        preorderFull.add(5);
        preorderFull.add(3);
        preorderFull.add(6);
        preorderFull.add(7);
        ArrayList<Integer> preorderTest = new ArrayList<>();
        binaryTreeApi.preorder(binaryTreeFull,preorderTest);
        Assert.assertEquals(true,preorderFull.equals(preorderTest));
    }

    @Test
    public void postorderTest(){
        ArrayList<Integer> postorderFull = new ArrayList<>();
        postorderFull.add(4);
        postorderFull.add(5);
        postorderFull.add(2);
        postorderFull.add(6);
        postorderFull.add(7);
        postorderFull.add(3);
        postorderFull.add(1);
        ArrayList<Integer> postorderTest = new ArrayList<>();
        binaryTreeApi.postorder(binaryTreeFull,postorderTest);
        Assert.assertEquals(true,postorderFull.equals(postorderTest));
    }

    @Test
    public void perLevelTest(){
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Integer> perLevel = new ArrayList<>();
        binaryTreeApi.perLevel(binaryTreeFull,perLevel);
        for (int i = 1; i <= 7; i++) {
            list.add(i);
        }
        Assert.assertEquals(true,list.equals(perLevel));
    }


}
