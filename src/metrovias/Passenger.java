package metrovias;

public class Passenger {
    private float waitTime;
    private float arrivalTime;
    private float exitTime;

    public Passenger() {
        this.waitTime = 0;
        this.arrivalTime = 0;
        this.exitTime = 0;
    }

    public float getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(float actualTimePassed) {
        waitTime =  actualTimePassed-arrivalTime;
    }

    public void setArrivalTime(float arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setExitTime(float exitTime) {
        this.exitTime = exitTime;
    }
}
