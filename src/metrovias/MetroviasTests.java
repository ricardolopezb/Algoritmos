package metrovias;

import org.junit.Assert;
import org.junit.Test;
import util.IsEmptyException;

public class MetroviasTests {
    
    @Test
    public void boothsCreationTest(){

        Station station = new Station(5,1);

        int count = 0;
        for (int i = 0; i < station.getBooths().length; i++) {
            if (station.getBooths()[i] != null) ++count;
        }

        Assert.assertEquals(5,count);
    }

    @Test
    public void uniqueCodeTest(){

        Ticket[] tickets= new Ticket[100001];

        for (int i = 0; i <=100000; i++) {
            tickets[i] = new Ticket(new Passenger());
        }

        Assert.assertTrue(tickets[0].getCode() != tickets[1].getCode());
        Assert.assertEquals(0,tickets[100000].getCode());

    }

    @Test
    public void passangersEnterToStationTest(){

        Station station = new Station(5);
        station.addPassengers(5);
        Assert.assertEquals(5,station.getCurrentPassengers().size());

    }

    @Test
    public void distributePassangersTest(){

        Station station = new Station(2);
        station.addPassengers(5);
        try{
            station.distributePassengers();
        }catch (IsEmptyException e){
            e.getMessage();
        }

        Assert.assertEquals(0,station.getCurrentPassengers().size());
        for (int i = 0; i < 2; i++) {

            Assert.assertTrue(!station.getBooths()[i].getQueue().isEmpty());//juega con la chance, pq falla y no falla -> funca

        }

    }

    @Test //Checkear test si esta bine hecho
    public void boothHandlingPassangersTest(){
        Station station = new Station(2);
        station.addPassengers(5);
        try{
            station.distributePassengers();
        }catch (IsEmptyException e){
            e.getMessage();
        }

        for (int i = 0; i < 2; i++) {
            if (!station.getBooths()[i].getQueue().isEmpty()){
                try {
                    int tempSize = station.getBooths()[i].getQueue().size();
                    station.getBooths()[i].handlePassenger();
                    Assert.assertTrue(station.getBooths()[i].getTimePassed() > 0);
                    if (!station.getBooths()[i].getLocalTickets().isEmpty()){
                        Assert.assertTrue(station.getBooths()[i].getLocalTickets().size() > 0);
                        Assert.assertTrue(station.getBooths()[i].getQueue().size() < tempSize);
                        Passenger tempPassanger = station.getBooths()[i].getLocalTickets().peek().getPassenger();
                        Assert.assertTrue(tempPassanger.getWaitTime() > 0);
                    }
                    else {
                        Assert.assertFalse(station.getBooths()[i].getLocalTickets().size() > 0);
                        Assert.assertFalse(station.getBooths()[i].getQueue().size() < tempSize);
                        Assert.assertTrue(station.getBooths()[i].getLocalTickets().size() == 0);
                    }
                }catch (IsEmptyException e){
                    e.getMessage();
                }

            }
        }


    }

    @Test
    public void timeAverageTest(){
        Station station = new Station(2);
        station.addPassengers(5);
        try {
            station.distributePassengers();
            station.boothsHandlePassangers();
            for (int i = 0; i < station.getBooths().length; i++) {
                if (!station.getBooths()[i].getLocalTickets().isEmpty()){
                    int tempSize = station.getBooths()[i].getLocalTickets().size();
                    Assert.assertTrue(station.getBooths()[i].timeAverage()>0);
                    Assert.assertTrue(station.getBooths()[i].getLocalTickets().size() == tempSize);
                }
            }
        }catch (IsEmptyException e){
            e.getMessage();
        }


    }





}