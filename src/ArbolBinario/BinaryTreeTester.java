package ArbolBinario;

import org.junit.Assert;
import org.junit.Test;

public class BinaryTreeTester {


    BinaryTree<Integer> left = new BinaryTree<Integer>(2,new BinaryTree<Integer>(4), new BinaryTree<Integer>(5));
    BinaryTree<Integer> right = new BinaryTree<Integer>(3,new BinaryTree<Integer>(6), new BinaryTree<Integer>(7));
    BinaryTree<Integer> rightNull = new BinaryTree<Integer>(3,new BinaryTree<Integer>(6), new BinaryTree<Integer>());
    BinaryTree<Integer> binaryTreeFull = new BinaryTree<Integer>(1,left,right);
    BinaryTree<Integer> binaryTreeInFull = new BinaryTree<Integer>(1,left,rightNull);
    BinaryTreeApi<Integer> binaryTreeApi = new BinaryTreeApi<>();

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
}
