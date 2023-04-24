package menu;

import java.util.ArrayList;
import java.util.Scanner;

import help.Help;
import books.*;
import books.book_formats.AudioBook;
import books.book_formats.EBook;
import books.book_formats.PhysicalBook;
import special_types.Physical;
import special_types.Series;
import special_types.Time;
import utils.VariableUtils;

public class BookOptions {
    public static Book retriever(Scanner scanner, Bookshelf shelf){
        Book retrievedBook;
        try{
            int counter = 1;
            for(Book b: shelf.getBooks()){
                System.out.println(counter + ") " + b.getBookName());
                counter++;
            }
            System.out.print("Whick book would you like to retrieve: ");
            String choice = scanner.nextLine();
            if(VariableUtils.isNumber(choice)){
                retrievedBook = shelf.getBooks().get(Integer.parseInt(choice)-1);
                System.out.println(retrievedBook.getBookName() + " has been retrieved");
                Bookshelf.setCurrentBookIndex(Integer.parseInt(choice));
            }else{
                System.out.println("Please choose a valid option");
            }
        }catch(Exception e){
            System.out.println("Retrieval Failed...");
            retrievedBook = shelf.getBooks().get(1);
        }

        return null;
    }

    public static void createEntry(Scanner scanner, Bookshelf shelf){
        System.out.print("""
        What type of entry do you wish to make?
        1) Hardcover Book
        2) Paperback Book
        3) AudioBook
        4) EBook
        5) Cancel
        Choice: """);
        String choice = scanner.nextLine();
        int choiceNum;
        if(VariableUtils.isNumber(choice)) { choiceNum = Integer.parseInt(choice);}else { choiceNum = 5; }
        switch(choiceNum){
            case 1:
                PhysicalBook a = (PhysicalBook) create(scanner, "hardcover");
                if(confirm(scanner, a)){
                    shelf.addBook(a);
                    break;
                }
                System.out.println("Entry creation cancelled...");
                break;
            case 2:
                PhysicalBook b = (PhysicalBook) create(scanner, "paperback");
                if(confirm(scanner, b)){
                    shelf.addBook(b);
                    break;
                }
                System.out.println("Entry creation cancelled...");
                break;
            case 3:
                AudioBook c = (AudioBook) create(scanner, "audiobook");
                if(confirm(scanner, c)){
                    shelf.addBook(c);
                    break;
                }
                System.out.println("Entry creation cancelled...");
                break;
            case 4:
                EBook d = (EBook) create(scanner, "ebook");
                if(confirm(scanner, d)){
                    shelf.addBook(d);
                    break;
                }
                System.out.println("Entry creation cancelled...");
                break;
            case 5:
                System.out.println("Entry creation cancelled.");
        }
    }

    private static Book create(Scanner scanner, String type){
        try{
            String bookName, rating, isbn, publisher, genre,
                price, completion;
            String[] authors, tags;
            System.out.println("If you need help for an option, type \"-help-\" instead of a value\n(Be sure to include the '-' in order to differentiate it from an actual value)");
            
            boolean needsHelp = true;
            do{ //Book Name
                System.out.print("What is the Books name?\nName: ");
                bookName = scanner.nextLine();
                System.out.println(bookName);
                needsHelp = Help.help(bookName, 1);
            }while(needsHelp);

            do{ // Authors
                System.out.println("List the authors below, when finished just enter \"Done\"");
                boolean isDone = false;
                int counter = 1;
                ArrayList<String> authList = new ArrayList<>();
                while(!isDone){
                    System.out.print(counter + ") ");
                    String auth = scanner.nextLine();
                    needsHelp = Help.help(auth, 2);
                    counter++;
                    if(!auth.equalsIgnoreCase("done")){
                        authList.add(auth);
                    }else{
                        isDone = true;
                    }
                }
                authors = authList.toArray(new String[authList.size()]);
            }while(needsHelp);

            do{ //Rating
                System.out.print("What do you rate the book on a scale from 1-10?\nRating: ");
                rating = scanner.nextLine();
                needsHelp = Help.help(rating, 3);
                if(VariableUtils.isNumber(rating) == false){
                    needsHelp = true;
                    System.out.println("Please enter a valid number");
                }
            }while(needsHelp);

            do{ //Tags
                System.out.println("List the tags below, when finished just enter \"Done\"");
                boolean isDone = false;
                int counter = 1;
                ArrayList<String> tagList = new ArrayList<>();
                while(!isDone){
                    System.out.print(counter + ") ");
                    String tag = scanner.nextLine();
                    needsHelp = Help.help(tag, 4);
                    counter++;
                    if(!tag.equalsIgnoreCase("done")){
                        tagList.add(tag);
                    }else{
                        isDone = true;
                    }
                }
                tags = tagList.toArray(new String[tagList.size()]);
            }while(needsHelp);

            do{ // ISBN
                System.out.print("What is the books ISBN?\nISBN: ");
                isbn = scanner.nextLine();
                needsHelp = Help.help(isbn, 5);
            }while(needsHelp);

            do{ // Publisher
                System.out.print("Who published the book?\nPublisher: ");
                publisher = scanner.nextLine();
                needsHelp = Help.help(publisher, 6);
            }while(needsHelp);

            do{ // Genre
                System.out.print("What is the books genre?\nGenre: ");
                genre = scanner.nextLine();
                needsHelp = Help.help(genre, 7);
            }while(needsHelp);

            do{ // Cost
                System.out.print("How much did the book cost\nPrice: ");
                price = scanner.nextLine();
                needsHelp = Help.help(price, 8);
                if(VariableUtils.isNumber(price) == false){
                    needsHelp = true;
                    System.out.println("Please enter a valid number");
                }
            }while(needsHelp);
        
            do{ //Completion
                System.out.print("How far are you into the book on a scale from 0-100\nCompletion: ");
                completion = scanner.nextLine();
                needsHelp = Help.help(completion, 9);
                if(VariableUtils.isNumber(completion) == false){
                    needsHelp = true;
                    System.out.println("Please enter a valid number");
                }
            }while(needsHelp);

            Series series;
            do{ // Series
                System.out.print("If the book is part of a series enter the series name\n"
                    + "If not, type \"None\" instead.\nSeries Name: ");
                String seriesName = scanner.nextLine();
                needsHelp = Help.help(seriesName, 10);
                System.out.print("If the book is part of a series enter the books number within the series\n"
                    + "If not, type \"0\" instead.\nSeries Number: ");
                String seriesNum = scanner.nextLine();
                series = new Series(seriesName, Integer.parseInt(seriesNum));
                needsHelp = Help.help(seriesNum, 10);
                if(VariableUtils.isNumber(seriesNum) == false){
                    needsHelp = true;
                    System.out.println("Please enter a valid number");
                }
            }while(needsHelp);

            if(type.equals("hardcover")){ //Hardcover Book
                String[] hardcover = physical(scanner, Physical.HARDCOVER);
                PhysicalBook physicalBook = new PhysicalBook(bookName, authors, Integer.parseInt(rating),
                    tags, isbn, publisher, genre, Double.parseDouble(price), Integer.parseInt(completion),
                    series, Integer.parseInt(hardcover[0]), hardcover[1].equalsIgnoreCase("y"),
                    hardcover[2].equalsIgnoreCase("n"), Physical.HARDCOVER);
                return physicalBook;
            }else if(type.equals("paperback")){ // Paperback Book
                String[] paperback = physical(scanner, Physical.PAPERBACK);
                PhysicalBook physicalBook = new PhysicalBook(bookName, authors, Integer.parseInt(rating),
                    tags, isbn, publisher, genre, Double.parseDouble(price), Integer.parseInt(completion),
                    series, Integer.parseInt(paperback[0]), paperback[1].equalsIgnoreCase("y"),
                    paperback[2].equalsIgnoreCase("n"), Physical.HARDCOVER);
                return physicalBook;
            }else if(type.equals("audiobook")){ //AudioBook
                String[] audio = audio(scanner);
                String[] timeArray = audio[0].split(":");
                Time time = new Time(timeArray[0], timeArray[1], timeArray[2]);
                AudioBook audioBook = new AudioBook(bookName, authors, Integer.parseInt(rating),
                    tags, isbn, publisher, genre, Double.parseDouble(price), Integer.parseInt(completion),
                    series, time, audio[1]);
                return audioBook;
            }else if(type.equals("ebook")){ //EBook
                String length = ebook(scanner);
                EBook eBook = new EBook(bookName, authors, Integer.parseInt(rating),
                    tags, isbn, publisher, genre, Double.parseDouble(price), Integer.parseInt(completion),
                    series, Integer.parseInt(length));
                return eBook;
            }
            return null;
        }catch(Exception e){
            System.out.println("Something went wrong...");
            return null;
        }
    }
    
    private static String[] physical(Scanner scanner, Physical physical){
        String length, hasDustJacket, isSigned;

        boolean needsHelp = true;
        do{ // Length
            System.out.print("How long is this book (in pages)\nLength: ");
            length = scanner.nextLine();
            needsHelp = Help.help(length, 11);
            if(VariableUtils.isNumber(length) == false){
                needsHelp = true;
                System.out.println("Please enter a valid number");
            }

        }while(needsHelp);

        do{ // Dust Jacket
            System.out.print("Does the book have a dust jacket? (Y/N)\nDust Jacket: ");
            hasDustJacket = scanner.nextLine();
            needsHelp = Help.help(hasDustJacket, 13);
        }while(needsHelp);

        do{ //Signed
            System.out.print("Is the book signed? (Y/N)\nSigned?: ");
            isSigned = scanner.nextLine();
            needsHelp = Help.help(isSigned, 14);
        }while(needsHelp);

        return new String[]{length, hasDustJacket, isSigned};
    }

    private static String[] audio(Scanner scanner){
        String length, narrator;

        boolean needsHelp = true;
        do{ // Length
            System.out.print("How long is the book (Hours:Minutes:Seconds)\nLength: ");
            length = scanner.nextLine();
            needsHelp = Help.help(length, 11);
        }while(needsHelp);

        do{ // Narrator
            System.out.println("Who narrates the audiobook?\nNarrator: ");
            narrator = scanner.nextLine();
            needsHelp = Help.help(narrator, 12);
        }while(needsHelp);
        return new String[]{length, narrator};
    }

    private static String ebook(Scanner scanner){
        String length;
        boolean needsHelp = true;
        do{ //Length
            System.out.print("How long is this book (in pages)\nLength: ");
            length = scanner.nextLine();
            needsHelp = Help.help(length, 11);
            if(VariableUtils.isNumber(length) == false){
                needsHelp = true;
                System.out.println("Please enter a valid number");
            }
        }while(needsHelp);

        return length;
    }

    private static boolean confirm(Scanner scanner, Book b){
        System.out.println("Does the below list look accurate?");

        System.out.println(
            b.displayBook()
        );

        System.out.println("Add This Entry? (Y/N): ");
        String ans = scanner.nextLine();
        if(ans.toLowerCase().startsWith("y")){
            return true;
        }
        return false;
    }

}
