package help;
public class Help{
    public static void about(){
        System.out.println("BookTracker is a book logging program which you can use to track books you have read.\nIt can track Harcover and Paperback Books, AudioBooks, and EBooks");
    }

    public static boolean help(String string, int currentOption){
        if(string.equalsIgnoreCase("-help-")){
            switch(currentOption){
                case 1:
                    nameHelp();
                    return true;
                case 2:
                    authorHelp();
                    return true;
                case 3:
                    ratingHelp();
                    return true;
                case 4:
                    tagHelp();
                    return true;
                case 5:
                    isbnHelp();
                    return true;
                case 6:
                    publishHelp();
                    return true;
                case 7:
                    genreHelp();
                    return true;
                case 8:
                    priceHelp();
                    return true;
                case 9:
                    completionHelp();
                    return true;
                case 10:
                    seriesHelp();
                    return true;
                case 11:
                    lengthHelp();
                    return true;
                case 12:
                    narratorHelp();
                    return true;
                case 13:
                    dustJacketHelp();
                    return true;
                case 14:
                    signedHelp();
                    return true;
            }
        }
        return false;
    }
    
    private static void nameHelp(){
        System.out.println("The Book's Title can be found in many places\n(Spine, Cover, Copyright page, Title page, etc)");
    }

    private static void authorHelp(){
        System.out.println("Authors are the people who write the book. Sometimes a book can have multiple authors.\nYou can often find it near the Book's Title");
    }

    private static void ratingHelp(){
        System.out.println("This is what you think of the book\nIt can be thought of like 1 (You Hate the Book) to 10 (You Love the Book)");
    }
    
    private static void tagHelp(){
        System.out.println("Tags are used to categorize books using custom categories.\nYou could make categories such as \"Favorites\" or \"Books from the 1950s\"\nYou can do whatever tags you wish!");
    }

    private static void isbnHelp(){
        System.out.println("An ISBN (International Standard Book Number) is a number used to identify Books.");
        System.out.println("They are either 13 or 10 digits long. The 13 digit ones begin with 978 or 979.");
        System.out.println("ISBNs can be found near the book's barcode and on the copyright page.");
    }

    private static void publishHelp(){
        System.out.println("The publisher is the company that distributes the book\n This is often found on the title page.");
    }

    private static void genreHelp(){
        System.out.println("The Genre is another category.\nThere are many different Genres, such as Fantasy and Romance");
        System.out.println("Non-Fiction books are categorized by topic rather than genre\nThe topic could be anything from Ancient History to Quantum Physics");
    }

    private static void priceHelp(){
        System.out.println("The price is how much the book costed.");
    }

    private static void completionHelp(){
        System.out.println("Completion is a way to tell how much of the book you've finished from 0-100%");
    }

    private static void seriesHelp(){
        System.out.println("Some books are part of a larger group of books called a series\nThe series and the books place in the series can usually be found near the books title, especially near the spine.");
    }

    private static void lengthHelp(){
        System.out.println("Each page of a book has a number, the amount of pages is the length");
        System.out.println("For audiobooks, the length is the book's total duration. This is usually found with all the other audiobook info");
    }

    private static void narratorHelp(){
        System.out.println("Audiobooks are narrated by a person called a narrator.\nThe narrator's name can be found near the authors");
    }

    private static void dustJacketHelp(){
        System.out.println("Many hardcover books (and some paperback) come with a dust jacket, which is a piece of plastic wrapped around it.");
        System.out.println("The dust jacket is used to protect the book from damage, such as scuffs and dust.");
    }

    private static void signedHelp(){
        System.out.println("Sometimes books are signed by the author or another person who worked on the book.\nThis is usually found within the first few pages.");
    }
}