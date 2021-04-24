package metrovias;

public class MainTest {
    public static void main(String[] args) {
        int i = 0;
        int oneCounter = 0;
        int zeroCounter = 0;

        while(i<100000){
            if((int)Math.floor(Math.random()*((1)-0+1)+0) == 0){
                zeroCounter++;
            } else{
                oneCounter++;
            }
            i++;
        }

        System.out.println("Ceros: " + zeroCounter);
        System.out.println("Unos: " + oneCounter);
    }
}
