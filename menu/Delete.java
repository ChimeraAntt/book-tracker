package menu;

import java.util.Scanner;

import books.Bookshelf;

public class Delete {
    public static void delete(Scanner scanner, Bookshelf shelf, int index){
        try{
            System.out.println("Do you really want to delete " + shelf.getBooks().get(index-1).getBookName() + "? (Y/N): ");
            String yn = scanner.nextLine();
            if(yn.toLowerCase().startsWith("y")){
                shelf.remove(index-1);
                Bookshelf.setCurrentBookIndex(index-1);
                System.out.println("Deletion Successful!");
            }else{
                System.out.println("Deletion Cancelled");
            }
        }catch(Exception e){
            System.out.println("Something went wrong...");
        }
    }
}
