package Tests;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.*;

public class Bruh extends Application{
    public static void main(String[] args) {
        Application.launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        TableView<String> tv = new TableView<>();
        tv.setEditable(true);
        TableColumn<String, String> emailCol = new TableColumn<>("email");
        TableColumn<String, String> subjectCol = new TableColumn<>("subject");
        TableColumn<String, String> timeCol = new TableColumn<>("times");
        tv.getColumns().addAll(emailCol, subjectCol, timeCol);
        VBox pane = new VBox(tv);
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
