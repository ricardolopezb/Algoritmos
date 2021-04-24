package metrovias;

import util.DynamicQueue;
import util.IsEmptyException;
import util.StaticStack;


/**
 *
 * todo terminar punto 1, ver como sacar la media de tiempo por booth LISTORTI
 *
 * todo armar la simulacion LISTORTI
 *
 * todo mostrar elementos en las pilas LISTORTI
 *
 * todo PONER EL LAMBDA EN LAS BOOTHS
 * todo ARREGLAR EL SHOW BOOTHS AUNQUE NO ES ENCESARIO
 *
 * Tema de la media del tiempo, agregar una variable privada en booths y esta se la pasas en el constructor del station, y hacer un metodo que sea set lambda para darselas a las booths o cunado las creamos las instanciamos con eso variable y ya esta.
 */

public class Station {
    private Booth[] booths;
    private StaticStack<Ticket> ticketStack;
    private DynamicQueue<Passenger> currentPassengers;

    public Station(int boothNum, float lambda) {
        this.booths = new Booth[boothNum];
        for (int i = 0; i < booths.length; i++) {
            booths[i] = new Booth(lambda);
        }
        this.ticketStack = new StaticStack<>();
        this.currentPassengers = new DynamicQueue<>();
    }

    public Station(int boothNum) {
        this.booths = new Booth[boothNum];
        for (int i = 0; i < booths.length; i++) {
            booths[i] = new Booth(1);
        }
        this.ticketStack = new StaticStack<>();
        this.currentPassengers = new DynamicQueue<>();
    }

    public void collectBoothTickets() throws IsEmptyException {
        for (Booth booth: booths) {
            while(!booth.getLocalTickets().isEmpty()){
                ticketStack.stack(booth.getLocalTickets().peek());
                booth.getLocalTickets().pop();
            }
        }
    }

    public int getBoothRevenue(int boothPos){
        return booths[boothPos].getRevenue();
    }



    public void distributePassengers() throws IsEmptyException {
        while(!currentPassengers.isEmpty()){
            int destinationBooth = (int)Math.floor(Math.random()*((booths.length-1)-0+1)+0);
            booths[destinationBooth].addPassenger(currentPassengers.dequeue());
        }
    }

    public void addPassengers(int n){
        for (int i = 0; i < n; i++) {
            currentPassengers.enqueue(new Passenger());
        }
    }

    public void boothsHandlePassangers() throws IsEmptyException {
        for (int i = 0; i < getBooths().length; i++) {
            getBooths()[i].handlePassenger();
        }
    }

    public Booth[] getBooths() {
        return booths;
    }

    public StaticStack<Ticket> getTicketStack() {
        return ticketStack;
    }

    public DynamicQueue<Passenger> getCurrentPassengers() {
        return currentPassengers;
    }

    public void showStack() throws IsEmptyException {
        collectBoothTickets();
        while (!getTicketStack().isEmpty()){
            try {
                Ticket tempTicket = getTicketStack().peek();
                System.out.println(tempTicket.toString());
                getTicketStack().pop();

            }catch (IsEmptyException e){
                e.getMessage();
            }
        }
    }

}
