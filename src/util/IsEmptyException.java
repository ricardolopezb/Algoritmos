package util;

public class IsEmptyException extends Exception {
    public IsEmptyException(){
        super("Your stack/queue is empty");
    }
}
