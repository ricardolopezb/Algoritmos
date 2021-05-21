package metrovias;

import org.hamcrest.core.Is;
import util.IsEmptyException;
import util.Scanner;
import util.Stack.StaticStack;

public class Simulation {

    public static void main(String[] args) {

        int timeLambda = Scanner.getInt("    __  ___________________  ____ _    _________   _____\n   /  |/  / ____/_  __/ __ \\/ __ \\ |  / /  _/   | / ___/ \n  / /|_/ / __/   / / / /_/ / / / / | / // // /| | \\__ \\ \n / /  / / /___  / / / _, _/ /_/ /| |/ // // ___ |___/ / \n/_/  /_/_____/ /_/ /_/ |_|\\____/ |___/___/_/  |_/____/  \n\n\nInsert time lambda (in seconds, ej: 30):\t");
        timeLambda = checkValue(timeLambda,1,Integer.MAX_VALUE,"Insert time lambda (in seconds, ej: 30):\t");
        int boothAmmount = Scanner.getInt("\n\nInsert ammount of booths in your sation (between 5 and 25):\t");
        boothAmmount = checkValue(boothAmmount,4,25,"Insert ammount of booths in your sation (between 5 and 25):\t");
        Station station = new Station(boothAmmount,timeLambda);

        while(true){
            int option = Scanner.getInt("\n\nMENU\n\n1. Advance "+timeLambda+" seconds.\n2. See specific booth info.\n3. Exit.\nInsert option:\t");
            switch (option){
                case 1:
                    station.addPassengers(5);
                    try {
                        station.distributePassengers();
                        station.boothsHandlePassangers();
                    }catch (IsEmptyException e){
                        e.getMessage();
                    }
                    System.out.println("\n\nTime advanced "+timeLambda+" seconds.");
                    break;
                case 2:
                    int choice = Scanner.getInt("Insert booth number:\t");
                    choice = checkValue(choice,1,25,"Insert booth number:\t");
                    station.getBooths()[choice-1].showInfo();
                    break;
                case 3:
                    try {
                        station.showStack();
                    }catch (IsEmptyException e){
                        e.getMessage();
                    }
                    System.exit(0);
                    break;
                default:
                    System.out.println("\n\nInsert a valid option.");
                    break;
            }

        }

    }

    public static void showStack(StaticStack<Ticket> stack){
        while (!stack.isEmpty()){
            try {
                Ticket tempTicket = stack.peek();
                System.out.println(tempTicket.toString());
                stack.pop();

            }catch (IsEmptyException e){
                e.getMessage();
            }
        }
    }

    public static int checkValue(int value, int minRange, int maxRange, String text){
        while (value<minRange || value>maxRange){
            System.out.println("\n\nInsert a valid number.\n\n");
            value = Scanner.getInt(text);
        }
        return value;
    }
}
