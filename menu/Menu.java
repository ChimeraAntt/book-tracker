package menu;

import java.io.File;
import java.util.Scanner;

import books.Bookshelf;
import file_utils.FileUtils;
import help.Help;
import menu.Editor.EditorMenu;

public class Menu {

    public static Bookshelf menuOptions(Scanner scanner, Bookshelf shelf, int currentBookIndex){
        int option = 0;
        try{
            System.out.println("""
            1) Edit Current Entry
            2) Delete Current Entry
            3) Retrieve a specific entry
            4) Create a New Entry
            5) Create a New Bookshelf
            6) Delete Bookshelf
            7) View Next Entry
            8) View Previous Entry
            9) Help
            10) Save Bookshelf
            11) Load Bookshelf
            12) Sort Entries
            13) Quit Program
            """);
            System.out.print("Please choose what you would wish to do: ");
            option = scanner.nextInt();
            scanner.nextLine();
            if(!(0<option && option<=13)){
                System.out.println("Please enter a valid option");
            }else{
                if(option == 1){
                    EditorMenu.edit(scanner, shelf, currentBookIndex);
                }else if(option == 2){
                    Delete.delete(scanner, shelf, currentBookIndex);
                }else if(option == 3){
                    BookOptions.retriever(scanner, shelf);
                }else if(option == 4){
                    BookOptions.createEntry(scanner, shelf);
                }else if(option == 5){
                    return ShelfOptions.createShelf(scanner);
                }else if(option == 6){
                    return ShelfOptions.deleteShelf(scanner, shelf);
                }else if(option == 7){
                    if(shelf.getCurrentBookIndex() == shelf.getBooks().size()){
                        Bookshelf.setCurrentBookIndex(1);
                    }else{
                        Bookshelf.setCurrentBookIndex(shelf.getCurrentBookIndex()+1);
                    }
                }else if(option == 8){
                    if(shelf.getCurrentBookIndex()==1){
                        Bookshelf.setCurrentBookIndex(shelf.getBooks().size());
                    }else{
                        Bookshelf.setCurrentBookIndex(shelf.getCurrentBookIndex()-1);
                    }
                }else if(option == 9){
                    Help.about();
                    
                }else if(option == 10){
                    FileUtils.save(scanner, shelf);
                    
                }else if(option == 11){
                    System.out.println("Which Bookshelf do you wish to load?");
                    for(File f: new File("src/data/bookshelves").listFiles()){
                        String[] file = f.toString().split("/");
                        String textFile = file[3];
                        String fileName = textFile.substring(0, textFile.indexOf("."));
                        System.out.println(fileName);
                    }
                    System.out.print("Choose an option: ");
                    String choice = scanner.nextLine();
                    return FileUtils.load(scanner, choice.toLowerCase()); 
                }else if(option == 12){
                    Sorter sorter = new Sorter();
                    return sorter.sortArray(scanner, shelf);
                }else if(option == 13){
                    System.out.println("Do you really want to quit? (Y/N): ");
                    if(scanner.nextLine().equalsIgnoreCase("y")){
                        FileUtils.save(scanner, shelf);
                        System.exit(0);
                    }
                    System.out.println("Quit cancelled...");
                }
            }
            return shelf;
        }catch(Exception e){
            System.out.println(e);
            System.out.println("Something went wrong...");
            return shelf;
        }
    }
}
