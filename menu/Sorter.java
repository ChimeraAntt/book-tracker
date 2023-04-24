package menu;

import java.util.Comparator;
import java.util.Scanner;

import books.*;
import utils.VariableUtils;

public class Sorter {
    public Bookshelf sortArray(Scanner scanner, Bookshelf books){
        System.out.println("""
            What do you wish to sort by?
            1) Book Name
            2) Rating
            3) ISBN
            4) Publisher
            5) Genre
            6) Price
            7) Completion
            8) Series
            9) Author
        """);
        String category = scanner.nextLine();
        if(!VariableUtils.isNumber(category)){
            return books;
        }
        SortHelper sortHelper = new SortHelper(Integer.parseInt(category));
        books.getBooks().sort(sortHelper);
        return books;
    }

    private class SortHelper implements Comparator<Book> {

        private int category;
        SortHelper(int category){
            this.category = category;
        }

        @Override 
        public int compare(Book one, Book two) {
            if(category == 1){
                return one.getBookName().compareTo(two.getBookName());
            }else if(category == 2){
                return Double.compare(one.getRating(), two.getRating());
            }else if(category == 3){
                return one.getIsbn().compareTo(two.getIsbn());
            }else if(category == 4){
                return one.getPublisher().compareTo(two.getPublisher());
            }else if(category == 5){
                return one.getGenre().compareTo(two.getGenre());
            }else if(category == 6){
                return Double.compare(one.getPrice(), two.getPrice());
            }else if(category == 7){
                return Integer.compare(one.getCompletion(), two.getCompletion());
            }else if(category == 8){
                int seriesDiff = one.getSeries().getSeriesName().compareTo(two.getSeries().getSeriesName());
                if (seriesDiff != 0){
                    return seriesDiff;
                }
                return one.getSeries().getSeriesNum() - two.getSeries().getSeriesNum();
            }else if(category == 9){
                return one.getAuthors()[0].compareTo(two.getAuthors()[0]);
            }else{
                return 0;
            }
        }

    }
}