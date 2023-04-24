package books;

import special_types.Series;
import utils.BookUtils;

public class Book implements BookUtils{
    private String bookName;
    private String[] authors;
    private double rating;
    private String[] tags;
    private String isbn;
    private String publisher;
    private String genre;
    private double price;
    private int completion;
    private Series series;

    public Book(String bookName, String[] authors, double rating, String[] tags, String isbn, String publisher, String genre, double price, int completion,
            Series series) {
        this.bookName = bookName;
        this.authors = authors;
        this.rating = rating;
        this.tags = tags;
        this.isbn = isbn;
        this.publisher = publisher;
        this.genre = genre;
        this.price = price;
        this.completion = completion;
        this.series = series;
    }

    public Book(){
        
    }

    public String[] getAuthors() {
        return authors;
    }

    public void setAuthors(String[] authors) {
        this.authors = authors;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String[] getTags() {
        return tags;
    }

    public void setTags(String[] tags) {
        this.tags = tags;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCompletion() {
        return completion;
    }

    public void setCompletion(int completion) {
        this.completion = completion;
    }

    public Series getSeries() {
        return series;
    }

    public void setSeries(Series series) {
        this.series = series;
    }


    public String getBookName() {
        return this.bookName;
    }


    public void setBookName(String bookName) {
        this.bookName = bookName;
    }


    public String getPublisher() {
        return publisher;
    }


    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public String getFileString() {
        return null;
    }

    @Override
    public String getType() {
        return null;
    }

    @Override
    public String displayBook() {
        return null;
    }

    

    
}
