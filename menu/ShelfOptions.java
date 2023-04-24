package menu;

import java.io.File;
import java.util.Scanner;

import books.Bookshelf;
import file_utils.FileUtils;
import utils.VariableUtils;

public class ShelfOptions {
    public static Bookshelf createShelf(Scanner scanner){
        System.out.println("First create a book for the shelf");
        Bookshelf shelf = new Bookshelf("");
        BookOptions.createEntry(scanner, shelf);
        System.out.print("Now make a name for the shelf: ");
        String name = scanner.nextLine();
        shelf.setShelfName(name);
        FileUtils.save(scanner, shelf);
        return shelf;
    }

    public static Bookshelf deleteShelf(Scanner scanner, Bookshelf shelf){
        try{
            File file = new File("src/data/bookshelves/" + shelf.getShelfName().toLowerCase() + ".txt");
            if(file.exists()){
                System.out.println("Do you really want to delete this shelf?");
                if(scanner.nextLine().toLowerCase().startsWith("y")){
                    file.delete();
                }else{
                    return shelf;
                }
            }
            File dir = new File("src/data/bookshelves");
            if(dir.length() > 0){
                boolean chosen = false;
                while(!chosen){
                    System.out.println("What shelf do you wish to open");
                    String[] shelves = dir.list();
                    int counter = 1;
                    for(String s: shelves){
                        System.out.println(counter + ") " + s.split(".")[0]);
                    }
                    System.out.println("which shelf do you wish to open");
                    String choice = scanner.nextLine();
                    if(VariableUtils.isNumber(choice)){
                        return FileUtils.load(scanner, shelves[Integer.parseInt(choice)].split(".")[0]);
                    }else{
                        System.out.println("Please choose a valid option...");
                        continue;
                    }
                }
            }else{
                System.out.println("No other shelves found...");
                System.out.println("Do you want to create a new shelf?");
                if(scanner.nextLine().equalsIgnoreCase("y")){
                    return createShelf(scanner);
                }else{
                    System.out.println("New shelf not created...");
                    return null;
                }
            }
        }catch(Exception e){
            System.out.println("Something went wrong");
            return shelf;
        }
        return shelf;
    }
}
