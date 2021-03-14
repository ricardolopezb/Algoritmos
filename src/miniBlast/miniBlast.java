package miniBlast;

public class miniBlast {

    public static void main(String[] args) {
        char[]a={'c','g','t','c','c','t','g','t'};
        char[]b={'c','g','t','t','g','t','c','c'};

        System.out.println(calculateMatch(a,b)+"%");
    }

    public static double calculateMatch(char[]referenceSeq,char[]querySeq){
        double matches=0;
        for (int i = 0; i < referenceSeq.length; i++) {
            if (referenceSeq[i]==querySeq[i]){
                matches++;
            }
        }
        return (matches/referenceSeq.length)*100;
    }

    /*public static String checkConsecutive(char[]referenceSeq,char[]querySeq){
        int matchStreak=0;
        for (int i = 0; i < referenceSeq.length-1; i++) {
            if (referenceSeq[i]==querySeq[i] && referenceSeq[i+1]==querySeq[i+1]){
                matchStreak++;
            }
        }
    }*/
}
