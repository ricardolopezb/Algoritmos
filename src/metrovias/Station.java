package metrovias;

import util.DynamicQueue;
import util.IsEmptyException;
import util.StaticStack;


/**
 *
 * todo terminar punto 1, ver como sacar la media de tiempo por booth
 *
 * todo armar la simulacion
 *
 *
 */

public class Station {
    private Booth[] booths;
    private StaticStack<Ticket> ticketStack;
    private DynamicQueue<Passenger> currentPassengers;

    public Station(int boothNum) {
        this.booths = new Booth[boothNum];
        for (int i = 0; i < booths.length; i++) {
            booths[i] = new Booth();
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




}
