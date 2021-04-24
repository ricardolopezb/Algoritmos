package metrovias;

import util.DynamicQueue;
import util.IsEmptyException;
import util.StaticStack;

public class Booth {
    private DynamicQueue<Passenger> queue;
    private int revenue;
    private StaticStack<Ticket> localTickets;

    private int timePassed;

    public Booth() {
        this.queue = new DynamicQueue<>();
        this.revenue = 0;
        this.timePassed = 0;
        this.localTickets = new StaticStack<>();

    }

    public StaticStack<Ticket> getLocalTickets() {
        return localTickets;
    }

    public void handlePassenger() throws IsEmptyException {
        int prob = (int)Math.floor(Math.random()*((1)-0+1)+0);
        if(prob == 1){
           Passenger passenger = queue.dequeue();
           passenger.setWaitTime(timePassed);
           Ticket ticket = new Ticket(passenger);
           revenue+=ticket.getPrice();
           localTickets.stack(ticket);

        }
        ++timePassed;
    }

    public void addPassenger(Passenger p){
        queue.enqueue(p);
    }

    public int getRevenue(){
        return revenue;
    }
}
