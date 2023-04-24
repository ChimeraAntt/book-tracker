import java.io.File;
import java.util.Scanner;

import books.Bookshelf;
import file_utils.FileUtils;
import menu.Menu;
import menu.ShelfOptions;
import utils.InputUtils;

public class Main{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Bookshelf currentShelf = null;
        if(new File("src/data/bookshelves").listFiles().length == 0){
            System.out.print("No bookshelves found... Make a new one? (Y/N): ");
            if(scanner.nextLine().toLowerCase().startsWith("y")){
                currentShelf = ShelfOptions.createShelf(scanner);
            }else{
                System.out.println("Program Closing...");
                System.exit(0);
            }
        }else{
            boolean r = true;
            while(r){
                System.out.println("Which Bookshelf do you wish to load?");
                for(File f: new File("src/data/bookshelves").listFiles()){
                    String[] file = f.toString().split("/");
                    String textFile = file[3];
                    String fileName = textFile.substring(0, textFile.indexOf("."));
                    System.out.println(fileName);
                }
                System.out.print("Choose an option: ");
                String choice = scanner.nextLine();
                if(new File("src/data/bookshelves/" + choice.toLowerCase() + ".txt").exists()){
                    currentShelf = FileUtils.load(scanner, choice.toLowerCase());
                    break;
                }else{
                    System.out.println("Please choose a valid option...");
                    InputUtils.pressEnter(scanner);
                }
            }  
        }
        boolean running = true;
        
        while(running){
            System.out.println("Book " + currentShelf.getCurrentBookIndex() + ":");
            System.out.println(DisplayBook.displayBook(currentShelf, currentShelf.getCurrentBookIndex()-1));
            System.out.println("------------------------------------------");
            currentShelf = Menu.menuOptions(scanner, currentShelf, currentShelf.getCurrentBookIndex());
            InputUtils.pressEnter(scanner);
        }

    }
}