import books.Book;
import javafx.application.Application;
import javafx.geometry.Orientation;
import javafx.stage.Stage;
import special_types.Series;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Control;
import javafx.scene.control.Label;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.FlowPane;
import javafx.scene.paint.Color;

public class BookView extends Application{
    @Override
    public void start(Stage primaryStage) {
        Book mainBook = new Book("The Book", new String[]{"Author Guy", "Other Guy"},
        4.5, new String[]{"Worst Books of all time", "Books that i would eat"},
        "9871234567890", "Book Publishers of America", "Sci-Fi",
        30.50, 33, new Series("The Book Series", 2));

        FlowPane bookDisplay = new FlowPane();
        bookDisplay.setOrientation(Orientation.VERTICAL);
        bookDisplay.setVgap(10);
        bookDisplay.setMaxHeight(Control.USE_PREF_SIZE);
        bookDisplay.setBorder(new Border(new BorderStroke(Color.BLACK, BorderStrokeStyle.SOLID, CornerRadii.EMPTY, BorderWidths.DEFAULT)));
        BorderPane bp = new BorderPane();
        bp.setTop(bookDisplay);

        Label bookName = new Label("Book Name: " + mainBook.getBookName());
        Label bookSeries = new Label("Book Series: " + mainBook.getSeries().getSeriesName() + ", " + mainBook.getSeries().getSeriesNum());
        Label bookPrice = new Label("Book Price: $" + mainBook.getPrice());
        Label bookISBN = new Label("Book ISBN: " + mainBook.getIsbn());
        Label bookGenre = new Label("Book Genre: " + mainBook.getGenre());
        Label bookCompletion = new Label("Book Completion: " + mainBook.getCompletion() + "%");
        Label bookRating = new Label("Book Rating: " + mainBook.getRating() + "/10");
        Label bookPublisher = new Label("Book Publisher: " + mainBook.getPublisher());

        bookDisplay.getChildren().add(bookName);
        bookDisplay.getChildren().add(bookSeries);
        for(String a: mainBook.getAuthors()){
            bookDisplay.getChildren().add(new Label("Author: " + a));
        }
        bookDisplay.getChildren().add(bookPrice);
        bookDisplay.getChildren().add(bookISBN);
        bookDisplay.getChildren().add(bookGenre);
        bookDisplay.getChildren().add(bookCompletion);
        bookDisplay.getChildren().add(bookRating);
        bookDisplay.getChildren().add(bookPublisher);
        for(String a: mainBook.getTags()){
            bookDisplay.getChildren().add(new Label("Tag: " + a));
        }
        Scene scene = new Scene(bp, 500, 600);
        primaryStage.setTitle("Book Tracker");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args) {        
        launch(args);
    }
}
