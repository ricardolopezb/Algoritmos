package tp1_comparacion;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;


public class tester {

    int[]a=Ej2abc.generateRandomIntArray(10);
    int[]b=Ej2abc.bubbleInt(a);

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
