package tp1_comparacion;

public class Ej2d {

    public static void main(String[] args) {
        String[]b={"santiago","ricardo","alejo","camila"};
        selectionString(b);
        for(String i: b){
            System.out.println(i);
        }
    }

    public static void bubbleString(String[] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = i+1; j <array.length ; j++) {
                if (array[i].compareTo(array[j])>0) {
                    String min = array[j];
                    String max=array[i];
                    array[i]=min;
                    array[j]=max;
                }
            }

        }

    }

    public static void insertionString(String[]array){
        String aux;
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

    public static void selectionString(String[]array){
        for (int i = array.length - 1; i > 0; i--) {
            int maxIndex = 0;
            for (int j = 0; j < i; j++) {
                if (array[j + 1].compareTo(array[maxIndex]) > 0) {
                    maxIndex = j + 1;
                }
            }
            String value=array[maxIndex];
            array[maxIndex]=array[i];
            array[i]=value;
        }
    }

}
