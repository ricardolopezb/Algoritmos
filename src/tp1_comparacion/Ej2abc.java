package tp1_comparacion;

public class Ej2abc {

    public static void main(String[] args) {
        int[]a=generateRandomIntArray(4);
        selectionInt(a);
        for (int i : a) {
            System.out.println(i);
        }


    }
        /*El bubble sort consiste en comparar pares de elementos consecutivos en un array e intercambiarlos en caso de no estar ordenados.
        * Esta accion se repite hasta que todos los elementos esten ordenados*/
    public static void bubbleInt(int[]array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if (array[i]>array[j]) {
                    int min = array[j];
                    int max=array[i];
                    array[i]=min;
                    array[j]=max;
                }
                }

            }
        }

        /*El insertion sort consiste en partir desde el segundo elemento del arreglo, evaluarlo con el de la posicion anterior(de acuerdo al
        criterio de ordenamiento) y en caso de incumplir este criterio intercambiarlos.A diferencia del bubble sort, se intercambia cada elemento
        las veces que sea necesaria hasta que el criterio de ordenamiento se cumpla. */

    public static void insertionInt(int[]array){
        int aux;
        for (int i = 1; i < array.length; i++) {
            aux=array[i];
            int j=i-1;
            while(j>=0 && aux<array[j]){
                array[j+1]=array[j];
                j--;
            }
            array[j+1]=aux;
        }
    }

        /*se define un indice de particion en la ultima posicion del arreglo. Se busca, desde la primera posicion, al elemento que deberia estar
        * en la ultima posicion de acuerdo al criterio elegido. Una vez se lo encuentra, se lo manda al final, y el indice de particion disminuye
        * una unidad, hasta alzanzar la primera posicion.*/
    public static void selectionInt(int[]array){//{10,4,6,3,12}
        for (int i = array.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 0; j < i; j++) {
                if (array[j + 1] > array[maxIndex]) {
                    maxIndex = j + 1;
                }
            }
            int value=array[maxIndex];
            array[maxIndex]=array[i];
            array[i]=value;
        }
    }

    public static int[] generateRandomIntArray(int n){
        int[] array=new int[n];
        for (int i = 0; i < n; i++) {
            array[i]= (int)( Math.random()*100);
        }
        return array;
    }



}



