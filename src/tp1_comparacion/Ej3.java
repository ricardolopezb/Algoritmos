package tp1_comparacion;

public class Ej3 {

    public static void main(String[] args) {
        String[] a = {"B", "F", "H", "T","U","Z"};
        String[] b = {"A","D", "G", "R","S","V", "X", "Y"};

        // c = {"A","B","D","F","G","H","R","S","T","U","V","X","Y","Z"};

        Object[]c = mergeArrays(a, b);

        for (Object s : c) {
            System.out.print((String)s);

        }
    }


    public static <T> T[] mergeArrays(Comparable<T>[] a, Comparable<T>[] b){
        T[] c = (T[]) new Object[a.length + b.length];

        int indexC = 0;
        /* Variable to keep track of the value of k, given that it must be reset to its last value when it's for loop hits a break statement. */
        int tempK = 0;

        for (int j = 0; j < a.length ; j++) {
            if(indexC == c.length){
                break;
            }

            for (int k = tempK; k < b.length; k++) {
                if(a[j].compareTo((T) b[k]) < 0){
                    c[indexC] = (T) a[j];
                    a[j] = null;
                    indexC++;
                    tempK = k;
                    break; //To increment the index of a
                }
                else if(a[j].compareTo((T) b[k]) == 0){
                    c[indexC] = (T) a[j];
                    b[k] = null;
                }
                else{
                    c[indexC] = (T) b[k];
                    b[k] = null;
                    indexC++;
                }
            }
        }

        /*Once one of the arrays is empty, the remaining elements in the other array are added to c*/
        if(isEmpty(a)){
            for (int j = 0; j < b.length ; j++) {
                if(b[j] != null){
                    c[indexC] = (T) b[j];
                    indexC++;
                }
            }
        } else{
            for (int j = 0; j < a.length ; j++) {
                if(a[j] != null){
                    c[indexC] = (T) a[j];
                    indexC++;
                }
            }
        }

        return c;

    }

    public static <T> boolean isEmpty(T[] array){
        for (T item: array) {
            if(item != null) return false;
        }
        return true;
    }

}
