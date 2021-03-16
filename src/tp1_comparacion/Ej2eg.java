package tp1_comparacion;

public class Ej2eg {

    public static void main(String[] args) {
        Integer[]b={8,10,5,9};
        selectionRecursive(b);
        for(int i: b){
            System.out.println(i);
        }
    }

    public static <T> void bubbleT(Comparable<T>[]array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if (array[i].compareTo((T)array[j])>0) {
                    Comparable min = array[j];
                    Comparable max=  array[i];
                    array[i]=  min;
                    array[j]=  max;
                }
            }

        }
    }

    public static <T> void insertionT(Comparable <T> []array){
        Comparable aux;
        for (int i = 1; i < array.length; i++) {
            aux=array[i];
            int j=i-1;
            while(j>=0 && aux.compareTo(array[j])<0){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=aux;
        }
    }

    public static <T> void selectionT(Comparable<T>[]array){
        for (int i = array.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 0; j < i; j++) {
                if(array[j+1].compareTo((T)array[maxIndex]) > 0){
                    maxIndex = j + 1;
                }
            }
            Comparable value=array[maxIndex];
            array[maxIndex]=array[i];
            array[i]=value;
        }
    }

    public static <T> void selectionRecursive(Comparable<T>[]array){
        selectionRecursiveAux(array, array.length-1);
    }

    /*Auxiliary method that provides more parameters (index) so the recursive method of selection sort can be made*/
    private static <T> void selectionRecursiveAux(Comparable<T>[]array,int index){

        /*Cutting condition*/
        if (index == -1) return;

        /*Searches for the index of the maximum value in the interval*/
        int maxIndex = getMaxIndex(array,index,0,0);

        /*Switches the values*/
        Comparable temp=array[index];
        array[index]=array[maxIndex];
        array[maxIndex]=temp;
        /*Calls himself again removing one unit in the index so the process can be done again in a smaller interval*/
        selectionRecursiveAux(array,index-1);

    }
    /*Searches for the maximum index in the interval so than the max value can be modified by the value at the max index*/
    private static <T> int getMaxIndex(Comparable<T>[] array, int index, int maxIndex, int recursiveIndex){

        /*Cutting condition*/
        if (recursiveIndex == index) return maxIndex;

        /*Compares if the element at the recursive index +1 position is greater than the element at maxIndex, if it is true it switches them*/
        if (array[recursiveIndex + 1].compareTo((T) array[maxIndex])>0){
            maxIndex = recursiveIndex + 1;

        }
        /*Calls himself again adding one unit to the recursiveIndex so it can check the next value*/
        return getMaxIndex(array,index,maxIndex,recursiveIndex+1);
    }
}
