

package machine;
import java.util.*;
public class CoffeeMachine {

    // static variables

    static Scanner scanner = new Scanner(System.in);
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int cups = 9;
    static int money = 550;
    static boolean exit = false;


    // method for buy

    static void buy() {
        System.out.println();
        System.out.println("Write action (buy, fill, take, remaining, exit):");

        System.out.print("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
        String coffeeChoice = scanner.next();
        switch (coffeeChoice) {
            case "1":
                if(makeCoffee(250,0,16)) {
                    water -= 250;
                    coffeeBeans -= 16;
                    money += 4;
                    cups -= 1;
                    break;
                }
            case "2":
                if(makeCoffee(350,75,20)) {
                    water -= 350;
                    milk -= 75;
                    coffeeBeans -= 20;
                    money += 7;
                    cups -= 1;
                    break;
                }
            case "3":
                if(makeCoffee(200,100,12)) {
                    water -= 200;
                    milk -= 100;
                    coffeeBeans -= 12;
                    money += 6;
                    cups -= 1;
                    break;
                }
            case "back":
                break;

            default:
                break;
        }
        curStatus = Status.CHOOSING;
    }

    // method for fill
    static void fill() {
        System.out.println("Write how many ml of water do you want to add:");
        int addWater = scanner.nextInt();
        water += addWater;

        System.out.println("Write how many ml of milk do your want to add:");
        int addMilk = scanner.nextInt();
        milk += addMilk;

        System.out.println("Write how many grams of coffee beans do you want to add:");
        int addBeans = scanner.nextInt();
        coffeeBeans += addBeans;

        System.out.println("Write how many disposable cups of coffee do you want to add:");
        int addCups = scanner.nextInt();
        cups += addCups;

        curStatus = Status.CHOOSING;
    }

    // method for take

    static void take(){
        System.out.println("I gave you $" + money);
        money = 0;

        curStatus = Status.CHOOSING;
    }

    //method for remaining

    static void remaining(){
        System.out.println();
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(coffeeBeans + " of coffee beans");
        System.out.println(cups + " of disposable cups");
        System.out.println(money + " of money");
        System.out.println();

        curStatus = Status.CHOOSING;
    }

    //method for exit

    static void exit(){

        curStatus = Status.EXITING;
    }

    //method for calculating coffee can be made or not

    static boolean makeCoffee(int waterReq, int milkReq, int coffeeReq){
        if(water >= waterReq){
            if(milk >= milkReq) {
                if(coffeeBeans >= coffeeReq) {
                    System.out.println("I have enough resource, making you a coffee!");
                    return true;
                }
                else {
                    System.out.println("Sorry, not enough beans!");
                    return false;
                }
            }
            else {
                System.out.println("Sorry, not enough milk!");
                return false;
            }

        }
        else{
            System.out.println("Sorry, not enough water!");
            return false;
        }


    }

    //enum for status
    enum Status{
        CHOOSING, BUYING, FILLING, TAKING, REMAINING, EXITING
    }

    static Status curStatus = Status.CHOOSING;

    // main method for CoffeeMachine




    public static void main(String[] args) {


        //This will iterate till the conditions is being false

        do {
            System.out.println(curStatus);
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String action = scanner.next();
            switch (action) {

                case "buy":
                    curStatus = Status.BUYING;
                    buy();
                    break;
                case "fill":
                    curStatus = Status.FILLING;
                    fill();
                    break;
                case "take":
                    curStatus = Status.TAKING;
                    take();
                    break;
                case "remaining":
                    curStatus = Status.REMAINING;
                    remaining();
                    break;
                case "exit":
                    exit();
                    break;
            }
        }while(curStatus != Status.EXITING);


    }
}

