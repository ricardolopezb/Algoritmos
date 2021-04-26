package metrovias;

public class Ticket {
    private static int codeReference = 10000;
    private int price = 100;
    private Passenger passenger;
    private int code;
    //tiempo de atencion - tiempo de llegada del pasajero
    public Ticket(Passenger passenger) {
        this.passenger = passenger;
        code = codeReference;
        codeReference++;
        checkCode();

    }

    public float getWaitTime(){
        return passenger.getWaitTime();
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public static int getCodeReference() {
        return codeReference;
    }

    public static void setCodeReference(int codeReference) {
        Ticket.codeReference = codeReference;
    }

    public int getPrice() {
        return price;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    private static void checkCode(){
        if (codeReference==100000) codeReference = 0;
    }

    public String toString(){
        return "Passenger: "+getPassenger().toString() +"\tTicket code: "+getCode()+"\tTicket price: "+getPrice()+"$"+"\tPassenger wait time: "+getPassenger().getWaitTime()+" seconds.";
    }
}
