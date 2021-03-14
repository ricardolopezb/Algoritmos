package tp1_comparacion;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class tester {

    int[]a={3,1,2};
    int[]b={1,2,3};

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
}
