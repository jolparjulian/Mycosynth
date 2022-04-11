package NHS;
import java.io.*;
import java.util.*;
import java.awt.Desktop;
import javafx.application.*;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;

public class NHSTutorALT extends Application {
	public static void main (String[] args){
		Application.launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		//tutor choice
		GridPane pane1 = new GridPane();
		pane1.setAlignment(Pos.CENTER);
		pane1.setVgap(50);
		Text text1 = new Text("Welcome to the NHS Tutoring Pairing Program. To start, select whether you " 
			+ "would like to use a new tutor database (Input) or an existing one (Retrieve).");
		text1.setStyle("-fx-font: 20 calibri;");
		text1.setWrappingWidth(650);
		text1.setTextAlignment(TextAlignment.CENTER);
		pane1.add(text1, 0, 0);
		Button but1 = new Button("Input");
		Button but2 = new Button("Retrieve");
		but1.setPrefSize(300, 150);
		but2.setPrefSize(300, 150);
		but1.setStyle("-fx-font: 20 calibri;");		
		but2.setStyle("-fx-font: 20 calibri;");
		HBox hbox1 = new HBox(but1, but2);
		hbox1.setSpacing(50);
		pane1.add(hbox1, 0, 1);
		Scene scene1 = new Scene(pane1, 1000, 700);
		stage.setScene(scene1);
		stage.setTitle("NHS Tutor Pairing Program");
		stage.show();

		//tutor choice input
		GridPane pane2 = new GridPane();
		pane2.setAlignment(Pos.CENTER);
		pane2.setVgap(50);
		Text text2 = new Text("Copy the existing tutor database (email, timeslots, subjects, days, sessions)" +
			" and paste it into the box below.");
		text2.setStyle("-fx-font: 20 calibri;");
		text2.setWrappingWidth(600);
		text2.setTextAlignment(TextAlignment.CENTER);
		HBox hbox3 = new HBox(text2);
		hbox3.setAlignment(Pos.CENTER);
		pane2.add(hbox3, 0, 0);	
		TextArea tarea1 = new TextArea();
		tarea1.setPrefSize(800, 400);
		pane2.add(tarea1, 0, 1);
		Button but3 = new Button("Back");
		Button but4 = new Button("Next");
		but3.setPrefSize(75, 50);
		but4.setPrefSize(75, 50);
		but3.setStyle("-fx-font: 14 calibri;");		
		but4.setStyle("-fx-font: 14 calibri;");
		HBox hbox2 = new HBox(but3, but4);
		hbox2.setSpacing(750);
		pane2.add(hbox2, 0, 2);
		Scene scene2 = new Scene(pane2, 1000, 700);
		
		//tutor choice retrieve

		//tutor choice removal

		//commands
		but1.setOnAction(e -> stage.setScene(scene2)); //input
		//but2.setOnAction(e -> stage.setScene(MINOR CHANGE SCENE)); //retrieve
		but3.setOnAction(e -> stage.setScene(scene1)); //input back to home
		but4.setOnAction(e -> {
			tarea1.appendText("\nEND");
			//add tutors
			//stage.setScene();
		}); //input to removal
	}
}