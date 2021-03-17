package tp1_comparacion;

public class Ej2abc {

    /*para poder utilizar los tests y asi medir los tiempos, nos vimos forzados a hacer que los metodos devuelvan un arreglo ordenado
    en lugar de hacerlo void, y ordenar el existente.
     */


        /*El bubble sort consiste en comparar pares de elementos consecutivos en un array e intercambiarlos en caso de no estar ordenados.
        * Esta accion se repite hasta que todos los elementos esten ordenados*/
    public static int[] bubbleInt(int[]array){
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
        return array;
    }

        /*El insertion sort consiste en partir desde el segundo elemento del arreglo, evaluarlo con el de la posicion anterior(de acuerdo al
        criterio de ordenamiento) y en caso de incumplir este criterio intercambiarlos.A diferencia del bubble sort, se intercambia cada elemento
        las veces que sea necesaria hasta que el criterio de ordenamiento se cumpla. */
    public static int[] insertionInt(int[]array){
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
        return array;
    }

        /*se define un indice de particion en la ultima posicion del arreglo. Se busca, desde la primera posicion, al elemento que deberia estar
        * en la ultima posicion de acuerdo al criterio elegido. Una vez se lo encuentra, se lo manda al final, y el indice de particion disminuye
        * una unidad, hasta alzanzar la primera posicion.*/
    public static int[] selectionInt(int[]array){
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
        return array;
    }

        /*En la clase tester medimos los tiempos  que cada algoritmo tarda en ordenar un arreglo de n elementos. Los datos obtenidos tras relizar
        * 10 repeticiones con el mismo tipo de sort,(primero con n=10, luego n=50, y finalmente n=100) y luego promediarlos, son los siguientes:
        * bubble sort:4.0ms
        * insertion sort:4.1ms
        * slection sort:3.2ms
        * El selection sort es el mas veloz de acuerdo a los datos obtenidos en nuestra experimentacion. El bubble sort y el insertion sort poseen
        * una velocidad muy similar, sin embargo el bubble es un poco mas lento.*/
    public static int[] generateRandomIntArray(int n){
        int[] array=new int[n];
        for (int i = 0; i < n; i++) {
            array[i]= (int)( Math.random()*100);
        }
        return array;
    }



}



