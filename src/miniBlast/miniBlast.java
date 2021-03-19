package miniBlast;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class miniBlast {

    public static void main(String[] args) {

        //initial testing char[]

        char[]a={'a','g','t','c','c','a','a','t', 'c', 'g', 'a', 'c', 'a', 'a'};
        char[]b={'t','c','t','c','c','a','t','g', 't', 'g', 'c', 'c', 't', 'g'};

        miniBlast(a, b);
    }

    //Prints out a BLAST report over two given DNA Base sequences.
    public static void miniBlast(char[]referenceSeq,char[]querySeq){
        ArrayList<Integer> results = getLengths(referenceSeq, querySeq); //Calls getLengths(), which returns all existing matching k-mers' lengths.

        //Prints out each kmer length.
        for (Integer result : results) {
            System.out.println("Matching k-mer with k = "+ result);
        }

        //Sums and prints total base matches
        int totalMatchSum = 0;
        for (Integer result : results) {
            totalMatchSum+=result;
        }
        System.out.println("\nTotal Matching Bases: "+totalMatchSum+"/"+referenceSeq.length);
        int percentage = (int)calculateMatch(referenceSeq,querySeq);
        System.out.println("Similarity percentage: "+percentage+"%");
    }

    //Given a coincidence, checks whether it is a k-mer or "chain", and if so, adds its length to a given array.
    private static ArrayList<Integer> getLengths(char[] array1, char[] array2){
        ArrayList<Integer> lengths = new ArrayList<>();

        int streak = 0; //amount of consecutive matches.

        for (int j = 0; j < array1.length-1; j++) {
            if(array1[j] == array2[j]){
                if(array1[j+1] == array2[j+1]){
                    streak++;
                }

                if(array1[j+1] != array2[j+1] || (j == array1.length-2 && array1[j+1] == array2[j+1])){
                    lengths.add(streak+1);
                    streak = 0;
                }

            }

        }
        return lengths;
    }

    //calculates mathematical coincidence.
    private static double calculateMatch(char[]referenceSeq,char[]querySeq){
        double matches=0;
        for (int i = 0; i < referenceSeq.length; i++) {
            if (referenceSeq[i]==querySeq[i]){
                matches++;
            }
        }
        return (matches/referenceSeq.length)*100;
    }


}
