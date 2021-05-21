package metrovias;

import org.junit.Assert;
import util.IsEmptyException;

public class MainTest {
    public static void main(String[] args) {
        /*int i = 0;
        int oneCounter = 0;
        int zeroCounter = 0;

        while(i<100000){
            if((int)Math.floor(Math.random()*((1)-0+1)+0) == 0){
                zeroCounter++;
            } else{
                oneCounter++;
            }
            i++;
        }

        System.out.println("Ceros: " + zeroCounter);
        System.out.println("Unos: " + oneCounter);*/

        //System.out.println("    __  ___________________  ____ _    _________   _____\n   /  |/  / ____/_  __/ __ \\/ __ \\ |  / /  _/   | / ___/ \n  / /|_/ / __/   / / / /_/ / / / / | / // // /| | \\__ \\ \n / /  / / /___  / / / _, _/ /_/ /| |/ // // ___ |___/ / \n/_/  /_/_____/ /_/ /_/ |_|\\____/ |___/___/_/  |_/____/  \n");

        Station station = new Station(2);
        station.addPassengers(15);
        try {
            station.distributePassengers();
            station.boothsHandlePassangers();
            station.boothsHandlePassangers();
            station.boothsHandlePassangers();
            for (int i = 0; i < station.getBooths().length; i++) {
                if (!station.getBooths()[i].getLocalTickets().isEmpty()){
                    int tempSize = station.getBooths()[i].getLocalTickets().size();
                    System.out.println(station.getBooths()[i].timeAverage());
                    System.out.println(station.getBooths()[i].getLocalTickets().size());
                }
            }
        }catch (IsEmptyException e){
            e.getMessage();
        }

        //https://patorjk.com/software/taag/#p=display&f=Slant&t=METROVIAS


    }


}
