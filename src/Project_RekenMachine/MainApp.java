package Project_RekenMachine;

import java.util.Scanner;
public class MainApp {
    public static void main(String[] args) {
        RekenMachine rekenMachine = new RekenMachine();
        Scanner myScanner = new Scanner(System.in);
        System.out.println("Please enter your choice");
        System.out.println("1. Basic operation +/-");
        System.out.println("2. Standard operation +/-/*/ / /%");
        System.out.println("3. Square ");
        int choice = myScanner.nextInt();
        switch (choice)
        {
            case 1:
            {
             double   result = rekenMachine.basicExp();
             System.out.println(result);
             break;
            }

            case 2:
            {
                double   result = rekenMachine.standardExp();
                System.out.println(result);
                break;
            }

            case 3:
            {
                rekenMachine.squareOfNumber();
                break;
            }
        }


    }

}





