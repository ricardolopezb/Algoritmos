package metrovias;

import DynamicQueue;
import util.IsEmptyException;
import util.Stack.StaticStack;

public class Booth {
    private DynamicQueue<Passenger> queue;
    private int revenue;
    private StaticStack<Ticket> localTickets;
    private float timeMultiplicator;
    private int timePassed;

    public Booth(float timeMultiplicator) {
        this.queue = new DynamicQueue<>();
        this.revenue = 0;
        this.timePassed = 0;
        this.localTickets = new StaticStack<>();
        this.timeMultiplicator = timeMultiplicator;

    }

    public StaticStack<Ticket> getLocalTickets() {
        return localTickets;
    }

    public void handlePassenger() throws IsEmptyException {
        int prob = (int)Math.floor(Math.random()*((1)-0+1)+0);
        if(prob == 1){
           Passenger passenger = queue.dequeue();
           ++timePassed;
           passenger.setWaitTime(timePassed*timeMultiplicator);
           Ticket ticket = new Ticket(passenger);
           revenue+=ticket.getPrice();
           localTickets.stack(ticket);

        }
        else ++timePassed;
    }

    public float timeAverage() throws IsEmptyException {
        StaticStack<Ticket> tempStack = new StaticStack<>();
        int size = getLocalTickets().size();
        float sum = 0;
        while (!getLocalTickets().isEmpty()){
            Ticket tempTicket = getLocalTickets().peek();
            sum+= tempTicket.getPassenger().getWaitTime();
            tempStack.stack(tempTicket);
            getLocalTickets().pop();
        }
        setLocalTickets(tempStack);
        if (size != 0) return (sum/size);
        else return 0;
    }

    public void addPassenger(Passenger p){
        queue.enqueue(p);
    }

    public int getRevenue(){
        return revenue;
    }

    public DynamicQueue<Passenger> getQueue() {
        return queue;
    }

    public int getTimePassed() {
        return timePassed;
    }

    public void showInfo(){
        try{
            System.out.println("\n\nTime average = " + timeAverage() + " seconds.\n");
            System.out.println("Revenue = "+getRevenue()+" pesos.\n\n");
        }catch (IsEmptyException e){
            e.getMessage();
        }
    }

    private String localTicketsToString() {
        StaticStack<Ticket> tempStack = new StaticStack<>();
        String toReturn = "Local Tickets:";
        while (!getLocalTickets().isEmpty()){
            Ticket tempTicket = getLocalTickets().peek();
            toReturn+="\n"+tempTicket.toString();
            tempStack.stack(tempTicket);
        }
        setLocalTickets(tempStack);
        return toReturn;
    }

    private String queueToString() throws IsEmptyException {
        String toReturn = "Passengers:";
        int count = 1;
        DynamicQueue<Passenger> tempQueue = new DynamicQueue<>();
        while (!getQueue().isEmpty()){
            Passenger tempPassenger = getQueue().dequeue();
            toReturn+="\n"+count+". "+tempPassenger.toString();
            tempQueue.enqueue(tempPassenger);
            ++count;
        }
        setQueue(tempQueue);
        return toReturn;
    }

    public void setLocalTickets(StaticStack<Ticket> localTickets) {
        this.localTickets = localTickets;
    }

    public void setQueue(DynamicQueue<Passenger> queue) {
        this.queue = queue;
    }

    public float getTimeMultiplicator() {
        return timeMultiplicator;
    }
}
