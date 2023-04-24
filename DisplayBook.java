import books.*;

public class DisplayBook {
    public static String displayBook(Bookshelf shelf, int index){
        if(!(shelf == null)){
            return shelf.getBooks().get(index).displayBook();
        }else{
            return "No Books Found...";
        }
    }
}
