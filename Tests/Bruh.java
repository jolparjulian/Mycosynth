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
        GridPane pane = new GridPane();
        Button ass = new Button("ok");
        Button but = new Button("uh");
        ass.setPrefSize(200, 100);
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(100, 200, 100, 200));
        pane.setHgap(20);
        pane.add(ass, 0, 0);
        pane.add(but, 1, 0);
        Scene scene = new Scene(pane, 1000, 700);
        primaryStage.setScene(scene);
        primaryStage.show();
        Button bruh = new Button("bruh");
        Scene scene2 = new Scene(bruh, 200, 200);
        ass.setOnAction(e -> {
            primaryStage.setScene(scene2);
        });
    }
}
