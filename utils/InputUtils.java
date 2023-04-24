package utils;

import java.util.Scanner;

public class InputUtils {
    public static void pressEnter(Scanner scanner){
        System.out.print("\nPress enter to continue...");
        scanner.nextLine();
        System.out.print("\n-------------------------------\n");
    }
    public static boolean confirmChoice(Scanner scanner, String choice){
        System.out.println("New value will be \""+choice+"\"\nConfirm Choice? (Y/N): ");
        String yn = scanner.nextLine();
        if(yn.toLowerCase().startsWith("y")){
            return true;
        }else{
            return false;
        }
    }
}
