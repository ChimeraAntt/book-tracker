package books;

import java.util.ArrayList;

public class Bookshelf {
    private ArrayList<Book> books;
    private String shelfName;
    private static int currentBookIndex;

    public Bookshelf(String shelfName, ArrayList<Book> books){
        this.shelfName = shelfName;
        this.books = books;
        currentBookIndex = 1;
    }

    public Bookshelf(String name){
        this.shelfName = name;
        this.books = new ArrayList<>();
        currentBookIndex = 1;
    }

    public ArrayList<Book> getBooks() {
        return books;
    }
    public String getShelfName() {
        return shelfName;
    }

    public void setShelfName(String shelfName) {
        this.shelfName = shelfName;
    }

    public void addBook(Book book){
        this.books.add(book);
    }
    public void remove(int index){
        this.books.remove(index);
    }

    public static void setCurrentBookIndex(int index) {
        currentBookIndex = index;
    }

    public int getCurrentBookIndex() {
        return currentBookIndex;
    }
    
}
