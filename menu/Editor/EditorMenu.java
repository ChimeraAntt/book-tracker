package menu.Editor;

import java.util.Scanner;

import books.*;

public class EditorMenu {
    public static void edit(Scanner scanner, Bookshelf shelf, int currentBookIndex){
        boolean isEditing = true;
        Book book = shelf.getBooks().get(currentBookIndex-1);
        while(isEditing){
            try{
                System.out.println("--------------------------");
                if(book.getType().equals("physical")){
                    isEditing = editPhysical(scanner, book);
                }else if(book.getType().equals("ebook")){
                    isEditing = editEBook(scanner, book);
                }else if(book.getType().equals("audiobook")){
                    isEditing = editAudioBook(scanner, book);
                }
            }catch(Exception e){
                System.out.println("Something went wrong...");
            }
        }
    }
    private static boolean editPhysical(Scanner scanner, Book book){
        System.out.println("""
            What do you wish to edit?
            1) Book Name
            2) Authors
            3) Rating
            4) Tags
            5) ISBN
            6) Publisher
            7) Genre
            8) Price
            9) Completion
            10) Series
            11) Length
            12) Dust Jacket
            13) Signed?
            14) Finish Editing
        """);

        System.out.print("Edit: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        if(option > 0 && option <= 10){
            Editor.mainEditor(scanner, option, book);
        }else if(option <= 13){
            OtherEditors.physicalBookEditor(scanner, option, book);
        }else if(option == 14){
            return false;
        }
        return true;
    }

    private static boolean editEBook(Scanner scanner, Book book){
        System.out.println("""
            What do you wish to edit?
            1) Book Name
            2) Authors
            3) Rating
            4) Tags
            5) ISBN
            6) Publisher
            7) Genre
            8) Price
            9) Completion
            10) Series
            11) Length
            12) Finish Editing
        """);

        System.out.print("Edit: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        if(option > 0 && option <= 10){
            Editor.mainEditor(scanner, option, book);
        }else if(option == 11){
            OtherEditors.eBookEditor(scanner, option, book);
        }else if(option == 12){
            return false;
        }
        return true;
    }

    private static boolean editAudioBook(Scanner scanner, Book book){
        System.out.println("""
            What do you wish to edit?
            1) Book Name
            2) Authors
            3) Rating
            4) Tags
            5) ISBN
            6) Publisher
            7) Genre
            8) Price
            9) Completion
            10) Series
            11) Length
            12) Narrator
            13) Finish Editing
        """);

        System.out.print("Edit: ");
        int option = scanner.nextInt();
        scanner.nextLine();
        if(option > 0 && option <= 10){
            Editor.mainEditor(scanner, option, book);
        }else if(option <= 12){
            OtherEditors.audioBookEditor(scanner, option, book);
        }else if(option == 13){
            return false;
        }
        return true;
    }

}
