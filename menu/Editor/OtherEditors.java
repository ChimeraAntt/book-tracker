package menu.Editor;

import java.util.Scanner;

import books.Book;
import books.book_formats.AudioBook;
import books.book_formats.EBook;
import books.book_formats.PhysicalBook;
import special_types.Time;
import utils.InputUtils;

public class OtherEditors {
    public static void physicalBookEditor(Scanner scanner, int option, Book book){
        PhysicalBook b = (PhysicalBook) book;
        switch(option){
            case 11:
                System.out.print("What do you wish to change the length to?\n(Type 'Cancel' to cancel)\nNew Length: ");
                String newLength = scanner.nextLine();
                if(!newLength.equalsIgnoreCase("cancel")){
                    boolean confirm = InputUtils.confirmChoice(scanner, newLength);
                    if(confirm){
                        b.setLength(Integer.parseInt(newLength));
                    }else{
                        System.out.println("Edit Cancelled...");
                    }
                }
                break;
            case 12:
                System.out.print("What do you wish to change the dust jacked status to (yes/no)?\n(Type 'Cancel' to cancel)\nNew Dust Jacket Status: ");
                String newDJ = scanner.nextLine();
                if(!newDJ.equalsIgnoreCase("cancel")){
                    boolean confirm = InputUtils.confirmChoice(scanner, newDJ);
                    if(confirm){
                        if(newDJ.equalsIgnoreCase("yes")){
                            b.setDustJacket(true);
                        }else if(newDJ.equalsIgnoreCase("no")){
                            b.setDustJacket(false);
                        }
                    }else{
                        System.out.println("Edit Cancelled...");
                    }
                }
                break;
            case 13:
                System.out.print("What do you wish to change the signed status to (yes/no)?\n(Type 'Cancel' to cancel)\nNew Signature Status: ");
                String newSigned = scanner.nextLine();
                if(!newSigned.equalsIgnoreCase("cancel")){
                    boolean confirm = InputUtils.confirmChoice(scanner, newSigned);
                    if(confirm){
                        if(newSigned.equalsIgnoreCase("yes")){
                            b.setSigned(true);
                        }else if(newSigned.equalsIgnoreCase("no")){
                            b.setSigned(false);
                        }
                    }else{
                        System.out.println("Edit Cancelled...");
                    }
                }
                break;
        }
    }
    public static void audioBookEditor(Scanner scanner, int option, Book book){
        AudioBook b = (AudioBook) book;
        switch(option){
            case 11:
                System.out.print("What do you wish to change the length to (in hours:minutes:seconds)?\n(Type 'Cancel' to cancel)\nNew Length: ");
                String newLength = scanner.nextLine();
                if(!newLength.equalsIgnoreCase("cancel")){
                    boolean confirm = InputUtils.confirmChoice(scanner, newLength);
                    if(confirm){
                        String[] time = newLength.split(":");

                        b.setLength(new Time(time[0], time[1], time[2]));
                    }else{
                        System.out.println("Edit Cancelled...");
                    }
                }
                break;
            case 12:
            System.out.print("What do you wish to change the Narrator to?\n(Type 'Cancel' to cancel)\nNew Narrator: ");
                String newNarrator = scanner.nextLine();
                if(!newNarrator.equalsIgnoreCase("cancel")){
                    boolean confirm = InputUtils.confirmChoice(scanner, newNarrator);
                    if(confirm){
                        b.setNarrator(newNarrator);
                    }else{
                        System.out.println("Edit Cancelled...");
                    }
                }
                break;
        }
    }
    public static void eBookEditor(Scanner scanner, int option, Book book){
        EBook b = (EBook) book;
        switch(option){
            case 11:
                System.out.print("What do you wish to change the length to?\n(Type 'Cancel' to cancel)\nNew Length: ");
                String newLength = scanner.nextLine();
                if(!newLength.equalsIgnoreCase("cancel")){
                    boolean confirm = InputUtils.confirmChoice(scanner, newLength);
                    if(confirm){
                        b.setLength(Integer.parseInt(newLength));
                    }else{
                        System.out.println("Edit Cancelled...");
                    }
                }
                break;
        }
    }
}
