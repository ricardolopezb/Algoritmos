package tp1_comparacion;

public class Ej3 {

    public static void main(String[] args) {
        String[] a = {"B", "F", "H", "T","U","Z"};
        String[] b = {"A","D", "G","H", "R","S","V", "X", "Y"};

        // c = {A, B, D  F G H R S T U, V, X Y, Z}

        Object[]c = mergeArrays(a, b);

        for (Object s : c) {
            System.out.println((String)s);

        }
    }




    public static <T> T[] mergeArrays(Comparable<T>[] a, Comparable<T>[] b){
        T[] c = (T[]) new Object[a.length + b.length]; //creamos el nuevo array C


        int i = 0; //indice de c
        int tempK = 0; //una variable para guardar el valor de k, como un checkpoint, en caso de tener que saltar al siguiente indice de a, porque se reinicia el for de k y arrancaria en 0 otra vez.



        for (int j = 0; j < a.length ; j++) {
            if(i == c.length){
                break;
            }

            for (int k = tempK; k < b.length; k++) {
                if(a[j].compareTo((T) b[k]) < 0){ //si deben estar repetidos, ponemos un = en el <0 y sacar el else if
                    c[i] = (T) a[j];
                    a[j] = null;
                    i++;
                    tempK = k;
                    break; //para pasar al siguiente indice de a
                }
                else if(a[j].compareTo((T) b[k]) == 0){
                    c[i] = (T) a[j];
                    b[k] = null;
                }
                else{
                    c[i] = (T) b[k];
                    b[k] = null;
                    i++;
                }
            }
        }

        //Una vez que un array esta vacio, agrego los que quedan del otro en el array c. isEmpty() chequea si el array esta vacio.
        if(isEmpty(a)){
            for (int j = 0; j < b.length ; j++) {
                if(b[j] != null){
                    c[i] = (T) b[j];
                    i++;
                }
            }
        } else{
            for (int j = 0; j < a.length ; j++) {
                if(a[j] != null){
                    c[i] = (T) a[j];
                    i++;
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
