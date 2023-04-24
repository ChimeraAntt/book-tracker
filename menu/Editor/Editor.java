package menu.Editor;

import java.util.Scanner;

import books.Book;
import special_types.Series;
import utils.InputUtils;

public class Editor {
    public static void mainEditor(Scanner scanner, int option, Book book){
        switch(option){
            case 1:
                System.out.print("What do you wish to change the books name to?\n(Type 'Cancel' to cancel)\nNew Name: ");
                String newName = scanner.nextLine();
                if(!newName.equalsIgnoreCase("cancel")){
                    boolean confirm = InputUtils.confirmChoice(scanner, newName);
                    if(confirm){
                        book.setBookName(newName);
                    }else{
                        System.out.println("Edit Cancelled...");
                    }
                }
                break;
            case 2:
                System.out.println("Which author do you want to change?");
                int counter = 1;
                int numberOfAuthors = book.getAuthors().length;
                for(String s: book.getAuthors()){
                    System.out.println(counter + ") " + s);
                    counter++;
                }
                System.out.print("Choice: ");
                String authorChoice = scanner.nextLine();
                if(Integer.parseInt(authorChoice) <= numberOfAuthors){
                    System.out.print("What do you wish to change this author to?\n(Type 'Cancel' to cancel)\nNew Author: ");
                    String newAuthor = scanner.nextLine();
                    if(!newAuthor.equals("cancel")){
                        boolean confirm = InputUtils.confirmChoice(scanner, newAuthor);
                        if(confirm){
                            String[] newAuthors = book.getAuthors();
                            newAuthors[Integer.parseInt(authorChoice)-1] = newAuthor;
                            book.setAuthors(newAuthors);
                        }else{
                            System.out.println("Edit Cancelled...");
                        }
                    }
                }else{
                    System.out.println("This option not found...");
                }
                break;
            case 3:
                System.out.print("What do you wish to change the books rating to?\n(Type 'Cancel' to cancel)\nNew Rating: ");
                String newRating = scanner.nextLine();
                if(!newRating.equalsIgnoreCase("cancel")){
                    boolean confirm = InputUtils.confirmChoice(scanner, newRating);
                    if(confirm){
                        book.setRating(Integer.parseInt(newRating));
                    }else{
                        System.out.println("Edit Cancelled...");
                    }
                }
                break;
            case 4:
                System.out.println("Which tag do you want to change?");
                int counter2 = 1;
                int numberOfTags = book.getTags().length;
                for(String s: book.getTags()){
                    System.out.println(counter2 + ") " + s);
                    counter2++;
                }
                System.out.print("Choice: ");
                String tagChoice = scanner.nextLine();
                if(Integer.parseInt(tagChoice) <= numberOfTags){
                    System.out.print("What do you wish to change this tag to?\n(Type 'Cancel' to cancel)\nNew Tag: ");
                    String newTag = scanner.nextLine();
                    if(!newTag.equals("cancel")){
                        boolean confirm = InputUtils.confirmChoice(scanner, newTag);
                        if(confirm){
                            String[] newTags = book.getTags();
                            newTags[Integer.parseInt(tagChoice)-1] = newTag;
                            book.setTags(newTags);
                        }else{
                            System.out.println("Edit Cancelled...");
                        }
                    }
                }else{
                    System.out.println("This option not found...");
                }
                break;
            case 5:
                System.out.print("What do you wish to change the books ISBN to?\n(Type 'Cancel' to cancel)\nNew ISBN: ");
                String newISBN = scanner.nextLine();
                if(!newISBN.equalsIgnoreCase("cancel")){
                    boolean confirm = InputUtils.confirmChoice(scanner, newISBN);
                    if(confirm){
                        book.setIsbn(newISBN);
                    }else{
                        System.out.println("Edit Cancelled...");
                    }
                }
                break;
            case 6:
                System.out.print("What do you wish to change the books publisher to?\n(Type 'Cancel' to cancel)\nNew Publisher: ");
                String newPublisher = scanner.nextLine();
                if(!newPublisher.equalsIgnoreCase("cancel")){
                    boolean confirm = InputUtils.confirmChoice(scanner, newPublisher);
                    if(confirm){
                        book.setPublisher(newPublisher);
                    }else{
                        System.out.println("Edit Cancelled...");
                    }
                }
                break;
            case 7:
                System.out.print("What do you wish to change the books genre to?\n(Type 'Cancel' to cancel)\nNew Genre: ");
                String newGenre = scanner.nextLine();
                if(!newGenre.equalsIgnoreCase("cancel")){
                    boolean confirm = InputUtils.confirmChoice(scanner, newGenre);
                    if(confirm){
                        book.setGenre(newGenre);
                    }else{
                        System.out.println("Edit Cancelled...");
                    }
                }
                break;
            case 8:
                System.out.print("What do you wish to change the books price to?\n(Type 'Cancel' to cancel)\nNew Price: ");
                String newPrice = scanner.nextLine();
                if(!newPrice.equalsIgnoreCase("cancel")){
                    boolean confirm = InputUtils.confirmChoice(scanner, newPrice);
                    if(confirm){
                        book.setPrice(Double.parseDouble(newPrice));
                    }else{
                        System.out.println("Edit Cancelled...");
                    }
                }
                break;
            case 9:
                System.out.print("What do you wish to change the books completion to?\n(Type 'Cancel' to cancel)\nNew Completion: ");
                String newCompletion = scanner.nextLine();
                if(!newCompletion.equalsIgnoreCase("cancel")){
                    boolean confirm = InputUtils.confirmChoice(scanner, newCompletion);
                    if(confirm){
                        book.setCompletion(Integer.parseInt(newCompletion));
                    }else{
                        System.out.println("Edit Cancelled...");
                    }
                }
                break;
            case 10:
                System.out.print("What do you wish to change the series name to?\n(Type 'Cancel' to cancel)\nNew Series Name: ");
                String newSeriesName = scanner.nextLine();
                if(!newSeriesName.equalsIgnoreCase("cancel")){
                    boolean confirm = InputUtils.confirmChoice(scanner, newSeriesName);
                    if(!confirm){
                        System.out.println("Edit Cancelled...");
                        break;
                    }
                    System.out.print("What do you wish to change the series number to?\nNew Series Name: ");
                    String newSeriesNumber = scanner.nextLine();
                    Series newSeries = new Series(newSeriesName, Integer.parseInt(newSeriesNumber));
                    book.setSeries(newSeries);
                }
                break;     
        }
    }
}
