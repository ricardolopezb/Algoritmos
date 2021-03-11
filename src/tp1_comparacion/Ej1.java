package tp1_comparacion;

public class Ej1 {

    public static <T> int seqSearchIndex(Comparable<T>[] array, Comparable<T> objectToLookUp){
        for (int i = 0; i < array.length; i++) {
            if(array[i].compareTo((T) objectToLookUp) == 0) {
                return i;
            }

        }
        return -1;
    }

    public static <T> int binarySearchIndex(Comparable<T>[] array, Comparable<T> objectToLookUp){
        int min = 0;
        int max = array.length-1;
        int middle = (min+max)/2;

        while(min <= max){
            if(objectToLookUp.compareTo((T)array[middle]) == 0){
                return middle;
            }
            else if(objectToLookUp.compareTo((T)array[middle]) < 0){
                max = middle-1;
            }
            else{
                min = middle+1;
            }

            middle = (min+max)/2;

        }
        return -1;
    }






}
