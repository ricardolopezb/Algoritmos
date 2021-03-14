package tp1_comparacion;

public class Ej2eg {

    public static void main(String[] args) {
        String[]b={"santiago","ricardo","alejo","camila"};
       selectionRecursive(b,0);
        for(String i: b){
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

    public static <T> void selectionRecursive(Comparable<T>[]array,int index){
        if(index>= array.length-1)
            return;
        int minindex=index;
        for (int i = index+1; i < array.length ; i++) {
            if(array[i].compareTo((T)array[minindex]) < 0){
                minindex=i;
            }
        }
        Comparable temp=array[index];
        array[index]=array[minindex];
        array[minindex]=temp;
        selectionRecursive(array,index+1);
    }
}
