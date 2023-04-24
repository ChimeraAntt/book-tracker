package books.book_formats;

import books.Book;
import special_types.Physical;
import special_types.Series;

public class PhysicalBook extends Book{
    private int length;
    private boolean dustJacket;
    private boolean isSigned;
    private Physical hardOrPaper;

    public PhysicalBook(String bookName, String[] authors, double rating, String[] tags, String isbn, String publisher, String genre, double price,
            int completion, Series series, int length, boolean dustJacket, boolean isSigned, Physical hardOrPaper) {
        super(bookName, authors, rating, tags, isbn, publisher, genre, price, completion, series);
        this.length = length;
        this.dustJacket = dustJacket;
        this.isSigned = isSigned;
        this.hardOrPaper = hardOrPaper;
    }

    @Override
    public String getType() {
        return "physical";
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
            + this.length + "\t"
            + this.dustJacket + "\t"
            + this.isSigned + "\t"
            + this.hardOrPaper + "\t";
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
        String jacket = "This book doesn't have a dust jacket";
        if(this.dustJacket){
            jacket = "This book has a dust jacket";
        }
        String signed = "This book isnt signed";
        if(this.isSigned){
            signed = "This book is signed";
        }
        return ("This " + hardOrPaper.getType() + " book is called " + this.getBookName()
                + "\nThis book was written by these authors: " + authors
                + "\nYou rated this book " + getRating() + "/10"
                + "\nThis book has the tags: " + tags
                + "\nThis book's ISBN is " + getIsbn()
                + "\nThis book was published by " + getPublisher()
                + "\nThis book's genre is " + getGenre()
                + "\nThis book costed $" + getPrice()
                + "\nYou are " + getCompletion() + "% done the book"
                + "\nThis book is  book #" + getSeries().getSeriesNum() + " in the series " + getSeries().getSeriesName()
                + "\nThis book is " + this.length + " pages long"
                + "\n" + jacket + "\n" + signed);
    }
    
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public boolean isDustJacket() {
        return dustJacket;
    }

    public void setDustJacket(boolean dustJacket) {
        this.dustJacket = dustJacket;
    }

    public boolean isSigned() {
        return isSigned;
    }

    public void setSigned(boolean isSigned) {
        this.isSigned = isSigned;
    }

    public Physical getHardOrPaper() {
        return hardOrPaper;
    }

    public void setHardOrPaper(Physical hardOrPaper) {
        this.hardOrPaper = hardOrPaper;
    }

    
}
