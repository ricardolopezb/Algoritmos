package tp1_comparacion;

import org.testng.annotations.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


public class tester {

    private int[]a=Ej2abc.generateRandomIntArray(10);
    private int[]b=Ej2abc.bubbleInt(a);
    private String[] c = {"santiago","ricardo","camila","alejo"};
    private String[] d = {"alejo","camila","ricardo","santiago"};
    private Integer[] e = {8,10,5,9};
    private Integer[] f = {5,8,9,10};
    private String[] g = {"B", "F", "H", "T","U","Z"};
    private String[] h = {"A","D", "G", "R","S","V", "X", "Y"};
    private String[] i = {"A","B","D","F","G","H","R","S","T","U","V","X","Y","Z"};

    @Test
    public void bubbleIntTest(){
        assertArrayEquals(b,Ej2abc.bubbleInt(a));
    }

    @Test
    public void insertionIntTest(){
        assertArrayEquals(b,Ej2abc.insertionInt(a));
    }

    @Test
    public void selectionIntTest(){
        assertArrayEquals(b,Ej2abc.selectionInt(a));
    }

    @Test
    public void bubbleStringTest(){
        Ej2d.bubbleString(c);
        assertArrayEquals(d,c);
    }

    @Test
    public void insertionStringTest(){
        Ej2d.insertionString(c);
        assertArrayEquals(d,c);
    }

    @Test
    public void selectionStringTest(){
        Ej2d.selectionString(c);
        assertArrayEquals(d,c);
    }

    @Test
    public void bubbleTTest(){
        Ej2eg.bubbleT(c);
        Ej2eg.bubbleT(e);
        assertArrayEquals(d,c);
        assertArrayEquals(e,f);
    }

    @Test
    public void insertionTTest(){
        Ej2eg.insertionT(c);
        Ej2eg.insertionT(e);
        assertArrayEquals(d,c);
        assertArrayEquals(e,f);
    }

    @Test
    public void selectionTTest(){
        Ej2eg.selectionT(c);
        Ej2eg.selectionT(e);
        assertArrayEquals(d,c);
        assertArrayEquals(e,f);
    }

    @Test
    public void selectionTRecursiveTest(){
        Ej2eg.selectionRecursive(c);
        Ej2eg.selectionRecursive(e);
        assertArrayEquals(d,c);
        assertArrayEquals(e,f);
    }

    @Test
    public void mergeTest(){
        Object[] j = Ej3.mergeArrays(g,h);
       assertArrayEquals(i,j);

    }



}
