package books.book_formats;

import special_types.Time;

import books.Book;
import special_types.Series;

public class AudioBook extends Book{
    private Time length;
    private String narrator;

    public AudioBook(String bookName, String[] authors, double rating, String[] tags, String isbn, String publisher, String genre, double price,
            int completion, Series series, Time length, String narrator) {
        super(bookName, authors, rating, tags, isbn, publisher, genre, price, completion, series);
        this.length = length;
        this.narrator = narrator;
    }

    @Override
    public String getType() {
        return "audiobook";
    }

    @Override
    public String getFileString() {
        String[] authorArray;
        if(this.getAuthors().length == 0){
            authorArray = new String[1];
            authorArray[0] = null;
        }else{
            authorArray = this.getAuthors();
        }

        String[] tagArray;
        if(this.getTags().length == 0){
            tagArray = new String[1];
            tagArray[0] = null;
        }else{
            tagArray = this.getTags();
        }
        String returnString = this.getType() + "\t"
            + this.getBookName() + "\t"
            + this.getRating() + "\t"
            + this.getIsbn() + "\t"
            + this.getPublisher() + "\t"
            + this.getGenre() + "\t"
            + this.getPrice() + "\t"
            + this.getCompletion() + "\t"
            + this.getSeries().getSeriesName() + "\t"
            + this.getSeries().getSeriesNum() + "\t"
            + this.getLength() + "\t"
            + this.narrator;
        for(String s:authorArray){
            returnString += "?" + s;
        }
        for(String s:tagArray){
            returnString += "-" + s;
        }
        return returnString;
    }

    @Override
    public String displayBook() {
        String authors = "";
        int a = 0;
        for(String s:this.getAuthors()){
            if(a == 0){
                authors += s;
            }else{
                authors += ", " + s;
            }
            a++;
        }
        String tags = "";
        a = 0;
        for(String s:this.getTags()){
            if(a == 0){
                tags += s;
            }else{

                tags += ", " + s;
            }
            a++;
        }
        
        String[] timeStrArr = this.length.getTimeArray();
        String timeStr = "This book is " + timeStrArr[0] + " hours, " + timeStrArr[1] + " minutes, and " + timeStrArr[2] + " seconds long";

        return ("This Audiobook is called " + this.getBookName()
                + "\nThis book was written by these authors: " + authors
                + "\nThis book was narrated by " + narrator
                + "\nYou rated this book " + getRating() + "/10"
                + "\nThis book has the tags: " + tags
                + "\nThis book's ISBN is " + getIsbn()
                + "\nThis book was published by " + getPublisher()
                + "\nThis book's genre is " + getGenre()
                + "\nThis book costed $" + getPrice()
                + "\nYou are " + getCompletion() + "% done the book"
                + "\nThis book is book #" + getSeries().getSeriesNum() + " in the series " + getSeries().getSeriesName()
                + timeStr);
    }

    public String getLength() {
        return length.getTime();
    }

    public void setLength(Time length) {
        this.length = length;
    }

    public String getNarrator() {
        return narrator;
    }

    public void setNarrator(String narrator) {
        this.narrator = narrator;
    }

    
}
