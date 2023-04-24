package file_utils;

import java.io.File;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

import books.*;
import books.book_formats.AudioBook;
import books.book_formats.EBook;
import books.book_formats.PhysicalBook;
import special_types.Physical;
import special_types.Series;
import special_types.Time;
import utils.ArrayUtils;

public class FileUtils{
    public static void save(Scanner scanner, Bookshelf shelf){
        try{
            File file = new File("src/data/bookshelves/" + shelf.getShelfName().toLowerCase() + ".txt");
            if(shelf.getBooks().size() > 0){
                System.out.print("Do you wish to overwrite file? (Y/N): ");
                String ans = scanner.nextLine();
                if(ans.substring(0,1).equalsIgnoreCase("y")){
                    PrintWriter writer = new PrintWriter(file);
                    for(Book b:shelf.getBooks()){
                        String s = b.getFileString();
                        writer.print(s + "\n");
                    }
                    System.out.println("Succesfully written to file!");
                    writer.close();
                }else{
                    System.out.println("Save cancelled...");
                }
            }else{
                System.out.println("Something went wrong...\nPlease check that file exists or that Bookshelf is not empty...");
            }
        }catch(Exception e){
            System.out.println("Something went wrong!!");
        }
    }

    public static Bookshelf load(Scanner scanner, String shelfName){
        try{
            ArrayList<Book> books = new ArrayList<>();
            File file = new File("src/data/bookshelves/" + shelfName.toLowerCase() + ".txt");
            Scanner reader = new Scanner(file);

            if(file.exists()){
                while(reader.hasNextLine()){
                    String line = reader.nextLine();
                    String[] tagArray = line.split("-");
                    String[] authArray = tagArray[0].split("\\?");
                    String[] mainArray = authArray[0].split("\t");

                    String[] authors = ArrayUtils.removeIndex(authArray, 0);
                    String[] tags = ArrayUtils.removeIndex(tagArray, 0);
                    String[] main = ArrayUtils.removeIndex(mainArray, 0);

                    if(mainArray[0].equals("physical")){
                        Physical p = checkPhys(main[12]);
                        PhysicalBook book = new PhysicalBook(
                            main[0], authors, Double.parseDouble(main[1]), tags, main[2], main[3],
                            main[4], Double.parseDouble(main[5]), Integer.parseInt(main[6]), new Series(main[7],
                            Integer.parseInt(main[8])),Integer.parseInt(main[9]), Boolean.parseBoolean(main[10]),
                            Boolean.parseBoolean(main[11]), p);
                        books.add(book);
                    }else if(mainArray[0].equals("audiobook")){
                        String[] time = main[9].split(":");
                        Time t = new Time(time[0], time[1], time[2]);
                        AudioBook book = new AudioBook(
                            main[0], authors, Double.parseDouble(main[1]), tags, main[2], main[3],
                            main[4], Double.parseDouble(main[5]), Integer.parseInt(main[6]), new Series(main[7],
                            Integer.parseInt(main[8])), t, main[10]);
                            books.add(book);
                    }else if(mainArray[0].equals("ebook")){
                        EBook book = new EBook(
                            main[0], authors, Double.parseDouble(main[1]), tags, main[2], main[3],
                            main[4], Double.parseDouble(main[5]), Integer.parseInt(main[6]), new Series(main[7],
                            Integer.parseInt(main[8])), Integer.parseInt(main[9]));
                            books.add(book);
                    }else{
                        reader.close();
                        throw new Exception();
                    }
                }

                System.out.println("Succesfully Loaded!");
            }else{
                System.out.println("File Not Fund...");
                reader.close();
                throw new Error();
            }

            reader.close();
            return new Bookshelf(shelfName, books);
        }catch(Exception e){
            System.out.println("Load Failed...");
            System.out.println(e);
            return null;
        }
    }

    public static Physical checkPhys(String string) {
        Physical phys;
        if(string.equals("hardcover")){
            phys = Physical.HARDCOVER;
        }else{
            phys = Physical.PAPERBACK;
        }
        return phys;
    }
}
