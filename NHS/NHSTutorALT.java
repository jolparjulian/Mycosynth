package NHS;
import java.io.*;
import java.util.*;
import javafx.application.*;
import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.geometry.*;
import javafx.scene.*;
import javafx.scene.control.*;
import javafx.scene.control.TableColumn.CellDataFeatures;
import javafx.scene.input.*;
import javafx.scene.layout.*;
import javafx.scene.text.*;
import javafx.stage.*;
import javafx.util.Callback;

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
			+ "are pairing for Monday or Wednesday, then choose whether you "
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
		pane1.add(hbox1, 0, 2);
		Button but11 = new Button("Monday");
		Button but12 = new Button("Wednesday");
		but11.setPrefSize(200, 100);
		but12.setPrefSize(200, 100);
		but11.setStyle("-fx-font: 20 calibri;");		
		but12.setStyle("-fx-font: 20 calibri;");
		HBox hbox6 = new HBox(but11, but12);
		hbox6.setSpacing(50);
		pane1.add(hbox6, 0, 1);
		hbox6.setAlignment(Pos.CENTER);
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
		
		//tutor choice minor changes
		GridPane pane3 = new GridPane();
		pane3.setAlignment(Pos.CENTER);
		pane3.setVgap(20);
		pane3.setHgap(20);
		ComboBox<String> combob1 = new ComboBox<>();
		Button but7 = new Button("Save");
		pane3.addRow(0, but7, combob1);
		TextField tfield1 = new TextField();
		TextField tfield2 = new TextField();
		GridPane minipane1 = new GridPane();
		GridPane minipane2 = new GridPane();
		minipane1.setAlignment(Pos.CENTER);
		minipane1.setHgap(10);
		minipane1.setVgap(10);
		minipane1.addRow(0, new Label("4:30"), new Label("5:00"), new Label("5:30"));
		CheckBox cbox1 = new CheckBox();
		CheckBox cbox2 = new CheckBox();
		CheckBox cbox3 = new CheckBox();
		minipane1.addRow(1, cbox1, cbox2, cbox3);
		GridPane.setHalignment(cbox1, HPos.CENTER);
		GridPane.setHalignment(cbox2, HPos.CENTER);
		GridPane.setHalignment(cbox3, HPos.CENTER);
		minipane2.setAlignment(Pos.CENTER);
		minipane2.setHgap(10);
		minipane2.setVgap(10);
		minipane2.addRow(0, new Label("Monday"), new Label("Wednesday"));
		CheckBox cbox4 = new CheckBox();
		CheckBox cbox5 = new CheckBox();
		minipane2.addRow(1, cbox4, cbox5);
		GridPane.setHalignment(cbox4, HPos.CENTER);
		GridPane.setHalignment(cbox5, HPos.CENTER);
		CheckBox cbox6 = new CheckBox("English");
		CheckBox cbox7 = new CheckBox("Government");
		CheckBox cbox8 = new CheckBox("History");
		CheckBox cbox9 = new CheckBox("Algebra 1/2");
		CheckBox cbox10 = new CheckBox("Geometry/Trig");
		CheckBox cbox11 = new CheckBox("Pre-Calc/Calc");
		CheckBox cbox12 = new CheckBox("Statistics");
		CheckBox cbox13 = new CheckBox("Biology");
		CheckBox cbox14 = new CheckBox("Chemistry");
		CheckBox cbox15 = new CheckBox("Physics");
		CheckBox cbox16 = new CheckBox("Comp Sci");
		CheckBox cbox17 = new CheckBox("SAT/ACT");
		VBox vbox1 = new VBox(cbox6, cbox7, cbox8, cbox9, cbox10, cbox11, cbox12, cbox13, cbox14,
			cbox15, cbox16, cbox17);
		vbox1.setSpacing(5);
		pane3.addRow(1, new Label("Email: "), tfield1);
		pane3.addRow(2, new Label("Timeslots: "), minipane1);
		pane3.addRow(3, new Label("Days: "), minipane2);
		pane3.addRow(4, new Label("Subjects: "), vbox1);
		pane3.addRow(5, new Label("Sessions: "), tfield2);
		Button but5 = new Button("Back");
		Button but6 = new Button("Next");
		but5.setPrefSize(75, 50);
		but6.setPrefSize(75, 50);
		but5.setStyle("-fx-font: 14 calibri;");		
		but6.setStyle("-fx-font: 14 calibri;");
		GridPane pane4 = new GridPane();
		pane4.setHgap(170);
		pane4.setVgap(20);
		pane4.setAlignment(Pos.BOTTOM_CENTER);
		pane4.setPadding(new Insets(100, 50, 50, 50));
		Text text3 = new Text("Edit minor tutor information here. Press save after each tutor.");
		text3.setStyle("-fx-font: 16 calibri;");
		pane4.add(text3, 1, 0);
		Button but8 = new Button("Exit");
		but8.setPrefWidth(75);
		pane4.add(but8, 0, 0);
		pane4.addRow(1, but5, pane3, but6);
		GridPane.setValignment(but5, VPos.BOTTOM);
		GridPane.setValignment(but6, VPos.BOTTOM);
		Scene scene3 = new Scene(pane4, 1000, 700);

		//tutee input
		GridPane pane5 = new GridPane();
		pane5.setAlignment(Pos.CENTER);
		pane5.setVgap(50);
		Text text4 = new Text("Copy this week's existing tutee database (email, subject, timeslots)" +
			" and paste it into the box below.");
		text4.setStyle("-fx-font: 20 calibri;");
		text4.setWrappingWidth(600);
		text4.setTextAlignment(TextAlignment.CENTER);
		HBox hbox4 = new HBox(text4);
		hbox4.setAlignment(Pos.CENTER);
		pane5.add(hbox4, 0, 0);	
		TextArea tarea2 = new TextArea();
		tarea2.setPrefSize(800, 400);
		pane5.add(tarea2, 0, 1);
		Button but9 = new Button("Back");
		Button but10 = new Button("Pair");
		but9.setPrefSize(75, 50);
		but10.setPrefSize(75, 50);
		but9.setStyle("-fx-font: 14 calibri;");		
		but10.setStyle("-fx-font: 14 calibri;");
		HBox hbox5 = new HBox(but9, but10);
		hbox5.setSpacing(750);
		pane5.add(hbox5, 0, 2);
		Scene scene4 = new Scene(pane5, 1000, 700);

		//tuteeOTHER pairing
		TableView<tutee> tv1 = new TableView<>();
		TableColumn<tutee, String> emailColee = new TableColumn("Email");
		emailColee.setCellValueFactory(new Callback<CellDataFeatures<tutee, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<tutee, String> p) {
				return new ReadOnlyObjectWrapper(p.getValue().email);
			}
		});
		TableColumn<tutee, String> subjectColee = new TableColumn("Subject");
		subjectColee.setCellValueFactory(new Callback<CellDataFeatures<tutee, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<tutee, String> p) {
				return new ReadOnlyObjectWrapper(p.getValue().subject);
			}
		});
		emailColee.setMinWidth(200);
		subjectColee.setMinWidth(75);
		Button but13 = new Button("Pair");
		but13.setPrefSize(75, 50);
		but13.setStyle("-fx-font: 14 calibri;");
		VBox vbox2 = new VBox(tv1, but13);
		vbox2.setSpacing(50);
		vbox2.setAlignment(Pos.CENTER);
		TableView<tutor> tv2 = new TableView<>();
		TableColumn<tutor, String> sessionColor = new TableColumn("SC");
		sessionColor.setCellValueFactory(new Callback<CellDataFeatures<tutor, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<tutor, String> p) {
				return new ReadOnlyObjectWrapper(p.getValue().sessionCount);
			}
		});
		TableColumn<tutor, String> emailColor = new TableColumn("Email");
		emailColor.setCellValueFactory(new Callback<CellDataFeatures<tutor, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<tutor, String> p) {
				return new ReadOnlyObjectWrapper(p.getValue().email);
			}
		});
		TableColumn<tutor, String> subjectColor = new TableColumn("Subjects");
		subjectColor.setCellValueFactory(new Callback<CellDataFeatures<tutor, String>, ObservableValue<String>>() {
			public ObservableValue<String> call(CellDataFeatures<tutor, String> p) {
				String sub = "";
				for (int k = 0; k < 12; k++) {
					if (p.getValue().subjects[k]) {
						switch (k) {
							case 0: sub += ("English, "); break;
							case 1: sub += ("Government, "); break;
							case 2: sub += ("History, "); break;
							case 3: sub += ("Algebra 1/2, "); break;
							case 4: sub += ("Geometry/Trig, "); break;
							case 5: sub += ("Pre-Calc/Calc, "); break;
							case 6: sub += ("Statistics, "); break;
							case 7: sub += ("Biology, "); break;
							case 8: sub += ("Chemistry, "); break;
							case 9: sub += ("Physics, "); break;
							case 10: sub += ("Comp Sci, "); break;
							case 11: sub += ("SAT/ACT"); break;
						}
					}
				}	
				return new ReadOnlyObjectWrapper(sub);
			}
		});	
		emailColor.setMinWidth(200);
		subjectColor.setMinWidth(400);
		HBox hbox7 = new HBox(vbox2, tv2);
		hbox7.setSpacing(50);
		hbox7.setAlignment(Pos.CENTER);
		Text text5 = new Text("Select a tutee and then select a tutor to pair them with, then select pair.");
		text5.setStyle("-fx-font: 20 calibri;");
		text5.setWrappingWidth(600);
		text5.setTextAlignment(TextAlignment.CENTER);
		VBox vbox3 = new VBox(text5, hbox7);
		vbox3.setSpacing(50);
		vbox3.setAlignment(Pos.CENTER);
		vbox3.setPadding(new Insets(100, 50, 50, 50));
		Scene scene5 = new Scene(vbox3, 1000, 700);

		//printing
		TextArea tarea3 = new TextArea("  Timeslot    Subject         Tutor Email                      Tutee Email\n");
		Tab tab1 = new Tab("Pairings", tarea3); //formatted pairings
		tarea3.setStyle("-fx-font: 14 monospace");
		TextArea tarea4 = new TextArea("  Tutor Email                      Timeslot                      Subject\n");
		Tab tab2 = new Tab("Today's Unpaired Tutors", tarea4); //formatted tutorList0
		tarea4.setStyle("-fx-font: 14 monospace");
		TextArea tarea5 = new TextArea("  Tutor Email                      Timeslot                      Subject\n");
		Tab tab3 = new Tab("All Tutors", tarea5); //formatted tutorList
		tarea5.setStyle("-fx-font: 14 monospace");
		TextArea tarea6 = new TextArea("Tutee Email                      Timeslot                      Subject\n");
		Tab tab4 = new Tab("All Tutees", tarea6); //formatted tuteeList
		tarea6.setStyle("-fx-font: 14 monospace");
		TabPane tp1 = new TabPane(tab1, tab2, tab3, tab4);
		tp1.setMinWidth(750);;
		Button but14 = new Button("Copy Pairings");
		Button but15 = new Button("Copy Emails");
		but14.setPrefSize(100, 50);
		but14.setStyle("-fx-font: 14 calibri;");
		but15.setPrefSize(100, 50);
		but15.setStyle("-fx-font: 14 calibri;");
		VBox vbox4 = new VBox(but14, but15);
		vbox4.setSpacing(50);
		vbox4.setAlignment(Pos.CENTER);
		HBox hbox8 = new HBox(vbox4, tp1);
		hbox8.setSpacing(50);
		hbox8.setAlignment(Pos.CENTER);
		hbox8.setPadding(new Insets(50, 50, 50,50));
		Scene scene6 = new Scene(hbox8, 1000, 700);
		Button but16 = new Button("printing"); //only used for the fire method, not to be shown

		//initializers
		File inFile = new File("C:\\Users\\jolpa\\OneDrive\\Desktop\\Codes\\NHS\\nhs1.txt");
		File outFile = new File("C:\\Users\\jolpa\\OneDrive\\Desktop\\Codes\\NHS\\nhs2.txt");
		Scanner input3 = new Scanner(outFile);		
		ArrayList<tutor> tutorList = new ArrayList<>();
		ArrayList<tutor> tutorList0 = new ArrayList<>();
		ArrayList<tutor> tutorList1 = new ArrayList<>();
		ArrayList<tutor> tutorList2 = new ArrayList<>();
		ArrayList<tutor> tutorList3 = new ArrayList<>();
		ArrayList<String> tutorEmails = new ArrayList<>();
		ArrayList<tutee> tuteeList = new ArrayList<>();
		ArrayList<tutee> tuteeList1 = new ArrayList<>();
		ArrayList<tutee> tuteeList2 = new ArrayList<>();
		ArrayList<tutee> tuteeList3 = new ArrayList<>();
		ArrayList<tutee> tuteeOTHER = new ArrayList<>();
		HashMap<tutor, tutee> pairing1 = new HashMap<>();
		HashMap<tutor, tutee> pairing2 = new HashMap<>();
		HashMap<tutor, tutee> pairing3 = new HashMap<>();
		LinkedHashMap<ArrayList<tutor>, ArrayList<ArrayList<tutor>>> tutorMaster = new LinkedHashMap<>();
		LinkedHashMap<ArrayList<tutee>, ArrayList<ArrayList<tutee>>> tuteeMaster = new LinkedHashMap<>();
		int[] curDay = {0};
		final Clipboard clipboard = Clipboard.getSystemClipboard();
		final ClipboardContent content = new ClipboardContent();
		Calendar cal = new GregorianCalendar();

		//commands
		but1.setOnAction(e -> stage.setScene(scene2)); //home to input
		but2.setOnAction(e -> {
			try {
				ObjectInputStream input = new ObjectInputStream(new FileInputStream(inFile));
				try {
					while (true) {
						tutor Paul = (tutor) input.readObject();
						if (String.valueOf(Paul.email).equalsIgnoreCase("END")) {
							break;
						}
						tutorList.add(Paul);
					}					
					tutorList.forEach(t -> {
						if (t.dayslots[curDay[0]]){
							tutorList0.add(t);
							if (t.timeslots[0]){
								tutorList1.add(t);
							}
							if (t.timeslots[1]){
								tutorList2.add(t);
							}
							if (t.timeslots[2]){
								tutorList3.add(t);
							}
						}						
					});					
				} catch (ClassNotFoundException e1) {
					e1.printStackTrace();
				}
				input.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
			tutorList.forEach(t -> tutorEmails.add(t.email));
			Collections.sort(tutorEmails, String.CASE_INSENSITIVE_ORDER);
			combob1.getItems().addAll(tutorEmails);
			stage.setScene(scene3);
		}); //home to minor changes
		but11.setOnAction(e -> curDay[0] = 0); //assign day to monday
		but12.setOnAction(e -> curDay[0] = 1); //assign day to wednesday
 		but3.setOnAction(e -> stage.setScene(scene1)); //input back to home
		but4.setOnAction(e -> {
			Scanner input1 = new Scanner(tarea1.getText() + "\nEND");
			while (true) { //add all tutors for first time
				String email = input1.next();
				if (email.equalsIgnoreCase("END")) {
					break;
				}
				boolean[] tims = new boolean[3];
				while (true) {
					String a = input1.next();
					if (a.charAt(a.length() - 1) == ',') {
						switch (a.substring(0, 3)) {
							case "4:3": tims[0] = true; break;
							case "5:0": tims[1] = true; break;
							case "5:3": tims[2] = true; break;
						}
					}
					else {
						switch (a.substring(0, 3)) {
							case "4:3": tims[0] = true; break;
							case "5:0": tims[1] = true; break;
							case "5:3": tims[2] = true; break;
						}
						break;
					}
				}
				boolean[] subjects = new boolean[12];
				while (true) {
					String b = input1.next();
					switch (b.substring(0, 3)) {
						case "Eng": subjects[0] = true; break;
						case "Gov": subjects[1] = true; break;
						case "His": subjects[2] = true; break;
						case "Alg": subjects[3] = true; input1.next(); input1.next(); b = input1.next(); break;
						case "Geo": subjects[4] = true; break;
						case "Pre": subjects[5] = true; break;
						case "Sta": subjects[6] = true; break;
						case "Bio": subjects[7] = true; break;
						case "Che": subjects[8] = true; break;
						case "Phy": subjects[9] = true; break;
						case "Com": subjects[10] = true; b = input1.next(); break;
						case "SAT": subjects[11] = true; break;
					}
					if (b.charAt(b.length() - 1) != ',') {
						break;
					}
				}
				boolean[] day = new boolean[2];
				while (true) {
					String d = input1.next();
					switch (d.substring(0, 3)) {
						case "Mon": day[0] = true; break;
						case "Wed": day[1] = true; break;
						case "Ano": d = input1.next();
					}
					if (d.charAt(d.length() - 1) != ',') {
						break;
					}
				}
				int sess = input1.nextInt();
				tutor Chad = new tutor(email, tims, day, subjects, sess);
				tutorList.add(Chad);
				if (Chad.dayslots[curDay[0]]) {
					tutorList0.add(Chad);
					if (tims[0]) {
						tutorList1.add(Chad);
					}
					if (tims[1]) {
						tutorList2.add(Chad);
					}
					if (tims[2]) {
						tutorList3.add(Chad);
					}
				}			
			}
			input1.close();
			tutorList.forEach(t -> tutorEmails.add(t.email));
			Collections.sort(tutorEmails, String.CASE_INSENSITIVE_ORDER);
			combob1.getItems().addAll(tutorEmails);
			stage.setScene(scene4);
		}); //input to tutee
		but7.setOnAction(e -> {
			String janEmail = combob1.getValue();
			int janIndex = 0;
			while (janEmail != String.valueOf(tutorList.get(janIndex).email)) {
				janIndex++;
			}
			tutorList.get(janIndex).email = tfield1.getText();
			tutorList.get(janIndex).timeslots[0] = cbox1.isSelected();
			tutorList.get(janIndex).timeslots[1] = cbox2.isSelected();
			tutorList.get(janIndex).timeslots[2] = cbox3.isSelected();
			tutorList.get(janIndex).dayslots[0] = cbox4.isSelected();
			tutorList.get(janIndex).dayslots[1] = cbox5.isSelected();
			tutorList.get(janIndex).subjects[0] = cbox6.isSelected();
			tutorList.get(janIndex).subjects[1] = cbox7.isSelected();
			tutorList.get(janIndex).subjects[2] = cbox8.isSelected();
			tutorList.get(janIndex).subjects[3] = cbox9.isSelected();
			tutorList.get(janIndex).subjects[4] = cbox10.isSelected();
			tutorList.get(janIndex).subjects[5] = cbox11.isSelected();
			tutorList.get(janIndex).subjects[6] = cbox12.isSelected();
			tutorList.get(janIndex).subjects[7] = cbox13.isSelected();
			tutorList.get(janIndex).subjects[8] = cbox14.isSelected();
			tutorList.get(janIndex).subjects[9] = cbox15.isSelected();
			tutorList.get(janIndex).subjects[10] = cbox16.isSelected();
			tutorList.get(janIndex).subjects[11] = cbox17.isSelected();
			tutorList.get(janIndex).sessionCount = Integer.parseInt(tfield2.getText());
		}); //minor tutor info change
		combob1.setOnAction(e -> {
			String kevinEmail = combob1.getValue();
			int kevinIndex = 0;
			while (kevinEmail != String.valueOf(tutorList.get(kevinIndex).email)) {
				kevinIndex++;
			}
			tfield1.setText(kevinEmail);
			cbox1.setSelected(tutorList.get(kevinIndex).timeslots[0]);
			cbox2.setSelected(tutorList.get(kevinIndex).timeslots[1]);
			cbox3.setSelected(tutorList.get(kevinIndex).timeslots[2]);
			cbox4.setSelected(tutorList.get(kevinIndex).dayslots[0]);
			cbox5.setSelected(tutorList.get(kevinIndex).dayslots[1]);
			cbox6.setSelected(tutorList.get(kevinIndex).subjects[0]);
			cbox7.setSelected(tutorList.get(kevinIndex).subjects[1]);
			cbox8.setSelected(tutorList.get(kevinIndex).subjects[2]);
			cbox9.setSelected(tutorList.get(kevinIndex).subjects[3]);
			cbox10.setSelected(tutorList.get(kevinIndex).subjects[4]);
			cbox11.setSelected(tutorList.get(kevinIndex).subjects[5]);
			cbox12.setSelected(tutorList.get(kevinIndex).subjects[6]);
			cbox13.setSelected(tutorList.get(kevinIndex).subjects[7]);
			cbox14.setSelected(tutorList.get(kevinIndex).subjects[8]);
			cbox15.setSelected(tutorList.get(kevinIndex).subjects[9]);
			cbox16.setSelected(tutorList.get(kevinIndex).subjects[10]);
			cbox17.setSelected(tutorList.get(kevinIndex).subjects[11]);
			tfield2.setText(String.valueOf(tutorList.get(kevinIndex).sessionCount));
		});	//fill tutor info for minor tutor info change
		but5.setOnAction(e -> stage.setScene(scene1)); //minor tutor info change back to home
		but6.setOnAction(e -> stage.setScene(scene4)); //minor tutor info change to tutee
		but8.setOnAction(e -> {
			try {
				ObjectOutputStream output1 = new ObjectOutputStream(new FileOutputStream(inFile));
				tutorList.forEach(t -> {
					try {
						output1.writeObject(t);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				});
				output1.writeObject(new tutor ("END", new boolean[3], new boolean[2], new boolean[12], 0));
				output1.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			stage.close();
		}); //minor tutor info change to exit
		but9.setOnAction(e -> stage.setScene(scene3)); //tutee input to minor tutor info change
		but16.setOnAction(e -> {
			String[] t3sa = {""};
			pairing1.forEach((q, r) -> {
				t3sa[0] += String.format("%-2d%-12s%-16s%-33s%-33s\n", q.sessionCount, "4:30-5:00", r.subject, q.email, r.email);
			});
			pairing2.forEach((q, r) -> {
				t3sa[0] += String.format("%-2d%-12s%-16s%-33s%-33s\n", q.sessionCount, "5:00-5:30", r.subject, q.email, r.email);
			});
			pairing3.forEach((q, r) -> {
				t3sa[0] += String.format("%-2d%-12s%-16s%-33s%-33s\n", q.sessionCount, "5:30-6:00", r.subject, q.email, r.email);
			});
			tarea3.setText(tarea3.getText() + t3sa[0]);

			String[] t4sa = {""};
			tutorList0.removeAll(pairing1.keySet());
			tutorList0.removeAll(pairing2.keySet());
			tutorList0.removeAll(pairing3.keySet());
			tutorList0.trimToSize();
			tutorList0.sort((t1, t2) -> t1.subcount - t2.subcount);
			tutorList0.sort((t1, t2) -> t1.sessionCount - t2.sessionCount);
			for (int j = 0; j < tutorList0.size(); j++){
				t4sa[0] += String.format("%-2d%-33s", tutorList0.get(j).sessionCount, tutorList0.get(j).email);
				if (tutorList0.get(j).timeslots[0]) {
					t4sa[0] += ("4:30-5:00 ");
				}
				else {
					t4sa[0] += ("          ");
				}
				if (tutorList0.get(j).timeslots[1]) {
					t4sa[0] += ("5:00-5:30 ");
				}
				else {
					t4sa[0] += ("          ");
				}
				if (tutorList0.get(j).timeslots[2]) {
					t4sa[0] += ("5:30-6:00 ");
				}
				else {
					t4sa[0] += ("          ");
				}
				for (int k = 0; k < 12; k++) {
					if (tutorList0.get(j).subjects[k]) {
						switch (k) {
							case 0: t4sa[0] += ("English, "); break;
							case 1: t4sa[0] += ("Government, "); break;
							case 2: t4sa[0] += ("History, "); break;
							case 3: t4sa[0] += ("Algebra 1/2, "); break;
							case 4: t4sa[0] += ("Geometry/Trig, "); break;
							case 5: t4sa[0] += ("Pre-Calc/Calc, "); break;
							case 6: t4sa[0] += ("Statistics, "); break;
							case 7: t4sa[0] += ("Biology, "); break;
							case 8: t4sa[0] += ("Chemistry, "); break;
							case 9: t4sa[0] += ("Physics, "); break;
							case 10: t4sa[0] += ("Comp Sci, "); break;
							case 11: t4sa[0] += ("SAT/ACT"); break;
						}
					}
				}
				t4sa[0] += "\n";
			}
			tarea4.setText(tarea4.getText() + t4sa[0]);

			String[] t5sa = {""};			
			tutorList.sort((t1, t2) -> t1.subcount - t2.subcount);
			tutorList.sort((t1, t2) -> t1.sessionCount - t2.sessionCount);
			for (int j = 0; j < tutorList.size(); j++){
				t5sa[0] += String.format("%-2d%-33s", tutorList.get(j).sessionCount, tutorList.get(j).email);
				if (tutorList.get(j).timeslots[0]) {
					t5sa[0] += ("4:30-5:00 ");
				}
				else {
					t5sa[0] += ("          ");
				}
				if (tutorList.get(j).timeslots[1]) {
					t5sa[0] += ("5:00-5:30 ");
				}
				else {
					t5sa[0] += ("          ");
				}
				if (tutorList.get(j).timeslots[2]) {
					t5sa[0] += ("5:30-6:00 ");
				}
				else {
					t5sa[0] += ("          ");
				}
				for (int k = 0; k < 12; k++) {
					if (tutorList.get(j).subjects[k]) {
						switch (k) {
							case 0: t5sa[0] += ("English, "); break;
							case 1: t5sa[0] += ("Government, "); break;
							case 2: t5sa[0] += ("History, "); break;
							case 3: t5sa[0] += ("Algebra 1/2, "); break;
							case 4: t5sa[0] += ("Geometry/Trig, "); break;
							case 5: t5sa[0] += ("Pre-Calc/Calc, "); break;
							case 6: t5sa[0] += ("Statistics, "); break;
							case 7: t5sa[0] += ("Biology, "); break;
							case 8: t5sa[0] += ("Chemistry, "); break;
							case 9: t5sa[0] += ("Physics, "); break;
							case 10: t5sa[0] += ("Comp Sci, "); break;
							case 11: t5sa[0] += ("SAT/ACT"); break;
						}
					}
				}
				t5sa[0] += "\n";
			}
			tarea5.setText(tarea5.getText() + t5sa[0]);

			String[] t6sa = {""};
			for (int j = 0; j < tuteeList.size(); j++){
				t6sa[0] += String.format("%-33s", tuteeList.get(j).email);
				if (tuteeList.get(j).timeslot[0]) {
					t6sa[0] += ("4:30-5:00 ");
				}
				else {
					t6sa[0] += ("          ");
				}
				if (tuteeList.get(j).timeslot[1]) {
					t6sa[0] += ("5:00-5:30 ");
				}
				else {
					t6sa[0] += ("          ");
				}
				if (tuteeList.get(j).timeslot[2]) {
					t6sa[0] += ("5:30-6:00 ");
				}
				else {
					t6sa[0] += ("          ");
				}
				t6sa[0] += tuteeList.get(j).subject + "\n";
			}
			tarea6.setText(tarea6.getText() + t6sa[0]);
		
			//write tutors to nhs1
			try {
				ObjectOutputStream output1 = new ObjectOutputStream(new FileOutputStream(inFile));
				tutorList.forEach(t -> {
					try {
						output1.writeObject(t);
					} catch (IOException e1) {
						e1.printStackTrace();
					}
				});
				output1.writeObject(new tutor ("END", new boolean[3], new boolean[2], new boolean[12], 0));
				output1.close();
			} catch (IOException e2) {
				e2.printStackTrace();
			}
			//write pairings to nhs2
			String[] pairnhs2 = {"", ""};
			int daydiff = 0;
			if (curDay[0] == 0){
				daydiff = 2 - cal.get(Calendar.DAY_OF_WEEK);
			}
			else if (curDay[0] == 1) {
				daydiff = 4 - cal.get(Calendar.DAY_OF_WEEK);
			}
			if (daydiff < 0) {
				daydiff += 7;
			}
			int month = cal.get(Calendar.MONTH) + 1;
			int day = cal.get(Calendar.DAY_OF_MONTH);
			pairnhs2[0] += month + "/" + (day + daydiff) + "\n";
			pairing1.forEach((q, r) -> {
				pairnhs2[0] += String.format("%-2d%-12s%-16s%-33s%-33s\n", q.sessionCount, "4:30-5:00", r.subject, q.email, r.email);
			});
			pairing2.forEach((q, r) -> {
				pairnhs2[0] += String.format("%-2d%-12s%-16s%-33s%-33s\n", q.sessionCount, "4:30-5:00", r.subject, q.email, r.email);
			});
			pairing3.forEach((q, r) -> {
				pairnhs2[0] += String.format("%-2d%-12s%-16s%-33s%-33s\n", q.sessionCount, "4:30-5:00", r.subject, q.email, r.email);
			});
			while (true) {
				String l = input3.nextLine();
				pairnhs2[1] += l + "\n";
				if (l.equalsIgnoreCase("END")) {
					break;
				}
			}
			input3.close();
			try {
				PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
				output.write(pairnhs2[0] + pairnhs2[1]);
				output.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}	
		}); //creates textAreas for printing scene
		but10.setOnAction(e -> {
			Scanner input2 = new Scanner(tarea2.getText() + "\nEND");
			while (true) {  //start tutee
				String subject = ""; 
				String email2N = input2.next();
				if (email2N.equalsIgnoreCase("END")) {
					break;
				}
				String c = input2.next();
				switch (c.substring(0, 3)) {
					case "Eng": subject = "English"; break;
					case "Gov": subject = "Government"; break;
					case "His": subject = "History"; break;
					case "Alg": subject = "Algebra 1/2"; input2.next(); input2.next(); c = input2.next(); break;
					case "Geo": subject = "Geometry/Trig"; break;
					case "Pre": subject = "Pre-Calc/Calc"; break;
					case "Sta": subject = "Statistics"; break;
					case "Bio": subject = "Biology"; break;
					case "Che": subject = "Chemistry"; break;
					case "Phy": subject = "Physics"; break;
					case "Com": subject = "Comp Sci"; c = input2.next(); break;
					case "SAT": subject = "SAT/ACT"; break;
					default:
						while (true){
							subject += c;
							if (input2.hasNext("4:30-5:00") || input2.hasNext("5:00-5:30") || input2.hasNext("5:30-6:00")){
								break;
							}
							else{
								c = input2.next();
							}
						}
						break;
				}
				boolean[] time = new boolean[3];
				while (true) {
					String d = input2.next();
					if (d.charAt(d.length() - 1) == ',') {
						switch (d.substring(0, 3)) {
							case "4:3": time[0] = true; break;
							case "5:0": time[1] = true; break;
							case "5:3": time[2] = true; break;
						}
					}
					else {
						switch (d.substring(0, 3)) {
							case "4:3": time[0] = true; break;
							case "5:0": time[1] = true; break;
							case "5:3": time[2] = true; break;
						}
						break;
					}
				}
				tutee George = new tutee(email2N, time, subject);
				tuteeList.add(George);
				if (time[0]) {
					tuteeList1.add(George);
				}
				if (time[1]) {
					tuteeList2.add(George);
				}
				if (time[2]) {
					tuteeList3.add(George);
				} 
			} //finish adding tutees
			input2.close();
			for (int j = 0; j < 3; j++) {
				ArrayList<ArrayList<tutor>> bl = new ArrayList<>(12);
				for (int i = 0; i < 12; i++) {
					ArrayList<tutor> al = new ArrayList<>();
					bl.add(al);
				}
				switch (j) {
					case 0: tutorMaster.put(tutorList1, bl); break;
					case 1: tutorMaster.put(tutorList2, bl); break;
					case 2: tutorMaster.put(tutorList3, bl); break;
				}
			}
			for (int j = 0; j < 3; j++) {
				ArrayList<ArrayList<tutee>> bl = new ArrayList<>(12);
				for (int i = 0; i < 12; i++) {
					ArrayList<tutee> al = new ArrayList<>();
					bl.add(al);
				}
				switch (j) {
					case 0: tuteeMaster.put(tuteeList1, bl); break;
					case 1: tuteeMaster.put(tuteeList2, bl); break;
					case 2: tuteeMaster.put(tuteeList3, bl); break;
				}
			}
			
			tutorMaster.forEach((n, m) -> { //n is the 3 timeslots, each m contains 12 subjects, with each subject containing
				n.forEach(t -> {            // a list of tutors.
					for (int i = 0; i < 12; i++) {
						if (t.subjects[i]) {
							m.get(i).add(t);
						}
					}
				});
				n.trimToSize();
				m.forEach(s -> {
					s.trimToSize();
					s.sort((t1, t2) -> t1.subcount - t2.subcount);
					s.sort((t1, t2) -> t1.sessionCount - t2.sessionCount);
				});
			});
			tuteeMaster.forEach((n, m) -> { //n is the 1st timeslot, each m contains 12 subjects, with each subject containing 
				n.forEach(t -> {            // a list of tutees.
					switch (t.subject.substring(0, 3)) {
						case "Eng": m.get(0).add(t); break;
						case "Gov": m.get(1).add(t); break;
						case "His": m.get(2).add(t); break;
						case "Alg": m.get(3).add(t); break;
						case "Geo": m.get(4).add(t); break;
						case "Pre": m.get(5).add(t); break;
						case "Sta": m.get(6).add(t); break;
						case "Bio": m.get(7).add(t); break;
						case "Che": m.get(8).add(t); break;
						case "Phy": m.get(9).add(t); break;
						case "Com": m.get(10).add(t); break;
						case "SAT": m.get(11).add(t); break;
						default: tuteeOTHER.add(t); break;
					}
				});
				n.trimToSize();
				m.forEach(s -> {
					s.trimToSize();
					s.sort((t1, t2) -> t1.timeCount - t2.timeCount);
				});
			});
		
			tuteeMaster.forEach((n, m) -> { //pairing for each subject in each timeslot
				int small = 100;
				int cursub = 13;
				for (int i = 0; i < 12; i++) {
					if (m.get(i).size() != 0 && m.get(i).size() < small) {
						small = m.get(i).size();
						cursub = i;
					}
				}
				while (cursub != 13) {
					if (m.get(cursub).size() > 0) {
						if (n == tuteeList1) {
							if (m.get(cursub).size() > tutorMaster.get(tutorList1).get(cursub).size()) {
								for (int k = 0; k < m.get(cursub).size() - tutorMaster.get(tutorList1).get(cursub).size(); k++) {
									tuteeOTHER.add(m.get(cursub).get(tutorMaster.get(tutorList1).get(cursub).size() + k));
								}
							}
						}
						if (n == tuteeList2){
							if (m.get(cursub).size() > tutorMaster.get(tutorList2).get(cursub).size()) {
								for (int k = 0; k < m.get(cursub).size() - tutorMaster.get(tutorList2).get(cursub).size(); k++) {
									tuteeOTHER.add(m.get(cursub).get(tutorMaster.get(tutorList2).get(cursub).size() + k));
								}
							}
						}
						if (n == tuteeList3) {
							if (m.get(cursub).size() > tutorMaster.get(tutorList3).get(cursub).size()) {
								for (int k = 0; k < m.get(cursub).size() - tutorMaster.get(tutorList3).get(cursub).size(); k++) {
									tuteeOTHER.add(m.get(cursub).get(tutorMaster.get(tutorList3).get(cursub).size() + k));
								}
							}
						}
						tuteeMaster.get(tuteeList1).get(cursub).removeAll(tuteeOTHER);					
						tuteeMaster.get(tuteeList2).get(cursub).removeAll(tuteeOTHER);
						tuteeMaster.get(tuteeList3).get(cursub).removeAll(tuteeOTHER);
						small = m.get(cursub).size();
						
						for (int j = 0; j < small; j++) {
							tutee alpha = m.get(cursub).get(j);
							if (n == tuteeList1) {
								pairing1.put(tutorMaster.get(tutorList1).get(cursub).get(j), alpha);
								tutorMaster.get(tutorList1).get(cursub).get(j).sessionCount++;
								for (int h = 0; h < 12; h++) {
									tutorMaster.get(tutorList1).get(h).remove(tutorMaster.get(tutorList1).get(cursub).get(j));
								}
								
								for (int u = 0; u < tuteeMaster.get(tuteeList2).get(cursub).size(); u++) {
									if (String.valueOf(tuteeMaster.get(tuteeList2).get(cursub).get(u).email) == 
											String.valueOf(alpha.email)) {
										tuteeMaster.get(tuteeList2).get(cursub).remove(u);
									}
								}
								for (int u = 0; u < tuteeMaster.get(tuteeList3).get(cursub).size(); u++) {
									if (String.valueOf(tuteeMaster.get(tuteeList3).get(cursub).get(u).email) == 
											String.valueOf(alpha.email)) {
										tuteeMaster.get(tuteeList3).get(cursub).remove(u);
									}
								}
							}
							else if (n == tuteeList2) {
								pairing2.put(tutorMaster.get(tutorList2).get(cursub).get(j), alpha);
								tutorMaster.get(tutorList2).get(cursub).get(j).sessionCount++;
								for (int h = 0; h < 12; h++) {
									tutorMaster.get(tutorList2).get(h).remove(tutorMaster.get(tutorList2).get(cursub).get(j));
								}
								
								for (int u = 0; u < tuteeMaster.get(tuteeList1).get(cursub).size(); u++) {
									if (String.valueOf(tuteeMaster.get(tuteeList1).get(cursub).get(u).email) == 
											String.valueOf(alpha.email)) {
										tuteeMaster.get(tuteeList1).get(cursub).remove(u);
									}
								}
								for (int u = 0; u < tuteeMaster.get(tuteeList3).get(cursub).size(); u++) {
									if (String.valueOf(tuteeMaster.get(tuteeList3).get(cursub).get(u).email) == 
											String.valueOf(alpha.email)) {
										tuteeMaster.get(tuteeList3).get(cursub).remove(u);
									}
								}
							}
							else if (n == tuteeList3) {
								pairing3.put(tutorMaster.get(tutorList3).get(cursub).get(j), alpha);
								tutorMaster.get(tutorList3).get(cursub).get(j).sessionCount++;
								for (int h = 0; h < 12; h++) {
									tutorMaster.get(tutorList3).get(h).remove(tutorMaster.get(tutorList3).get(cursub).get(j));
								}
								
								for (int u = 0; u < tuteeMaster.get(tuteeList1).get(cursub).size(); u++) {
									if (String.valueOf(tuteeMaster.get(tuteeList1).get(cursub).get(u).email) == 
											String.valueOf(alpha.email)) {
										tuteeMaster.get(tuteeList1).get(cursub).remove(u);
									}
								}
								for (int u = 0; u < tuteeMaster.get(tuteeList2).get(cursub).size(); u++) {
									if (String.valueOf(tuteeMaster.get(tuteeList2).get(cursub).get(u).email) == 
											String.valueOf(alpha.email)) {
										tuteeMaster.get(tuteeList2).get(cursub).remove(u);
									}
								}
							}
						}	
						m.get(cursub).clear();
					}
					small = 100;
					cursub = 13;
					for (int i = 0; i < 12; i++) {
						if (m.get(i).size() != 0 && m.get(i).size() < small) {
							small = m.get(i).size();
							cursub = i;
						}
					}
				}
				tutorMaster.forEach((o, p) -> { 
					p.forEach(s -> {
						s.trimToSize();
						s.sort((t1, t2) -> t1.subcount - t2.subcount);
						s.sort((t1, t2) -> t1.sessionCount - t2.sessionCount);
					});
				});
			});
			//if tuteeOTHER: stage.setScene(tuteeOTHER PAIRINGS);
			if (tuteeOTHER.size() > 0){
				tv1.setItems(FXCollections.observableArrayList(tuteeOTHER));
				tv1.getColumns().addAll(emailColee, subjectColee);
				stage.setScene(scene5);
			}
			if (tuteeOTHER.size() == 0) {
				but16.fire();				
				stage.setScene(scene6);
			}
		}); //tutee input and end sequence
		tv1.setOnMouseClicked(e -> {
			ArrayList<tutor> tv2al = new ArrayList<>();
			if (tv1.getSelectionModel().getSelectedItem().timeslot[0]){
				tv2al.addAll(tutorList1);
				tv2al.removeAll(pairing1.keySet());
			}
			if (tv1.getSelectionModel().getSelectedItem().timeslot[1]){
				tv2al.addAll(tutorList2);
				tv2al.removeAll(pairing2.keySet());
			}
			if (tv1.getSelectionModel().getSelectedItem().timeslot[2]){
				tv2al.addAll(tutorList3);
				tv2al.removeAll(pairing3.keySet());
			}
			tv2.getItems().clear();
			tv2.getColumns().clear();
			tv2al.sort((t1, t2) -> t1.subcount - t2.subcount);
			tv2al.sort((t1, t2) -> t1.sessionCount - t2.sessionCount);
			tv2.setItems(FXCollections.observableArrayList(tv2al));
			tv2.getColumns().addAll(sessionColor, emailColor, subjectColor);
		});
		but13.setOnAction(e -> {
			if (tv1.getSelectionModel().getSelectedItem().timeslot[0] && tv2.getSelectionModel().getSelectedItem().timeslots[0]){
				pairing1.put(tv2.getSelectionModel().getSelectedItem(), tv1.getSelectionModel().getSelectedItem());
			}
			else if (tv1.getSelectionModel().getSelectedItem().timeslot[1] && tv2.getSelectionModel().getSelectedItem().timeslots[1]){
				pairing2.put(tv2.getSelectionModel().getSelectedItem(), tv1.getSelectionModel().getSelectedItem());
			}
			else if (tv1.getSelectionModel().getSelectedItem().timeslot[2] && tv2.getSelectionModel().getSelectedItem().timeslots[2]){
				pairing3.put(tv2.getSelectionModel().getSelectedItem(), tv1.getSelectionModel().getSelectedItem());
			}
			tv2.getSelectionModel().getSelectedItem().sessionCount++;
			tutorList0.remove(tv2.getSelectionModel().getSelectedItem());
			tuteeOTHER.remove(tv1.getSelectionModel().getSelectedItem());
			tv2.getItems().clear();
			tv2.getColumns().clear();
			tv1.getItems().clear();
			tv1.getColumns().clear();
			if (tuteeOTHER.size() > 0){
				tv1.setItems(FXCollections.observableArrayList(tuteeOTHER));
				tv1.getColumns().addAll(emailColee, subjectColee);
				stage.setScene(scene5);
			}
			if (tuteeOTHER.size() == 0) {
				but16.fire();
				stage.setScene(scene6);
			}
		}); //tuteeOTHER pairing and end sequence
		but14.setOnAction(e -> {
			String[] copStr = {""};
			ArrayList<String> alTimslot = new ArrayList<>();
			alTimslot.add("Timeslot");
			ArrayList<String> alSubject = new ArrayList<>();
			alSubject.add("Subject");
			ArrayList<String> alEmailor = new ArrayList<>();
			alEmailor.add("Tutor Email");
			ArrayList<String> alEmailee = new ArrayList<>();
			alEmailee.add("Tutee Email");
			pairing1.forEach((q, r) -> {
				alTimslot.add("4:30-5:00");
				alSubject.add(r.subject);
				alEmailor.add(q.email);
				alEmailee.add(r.email);
			});
			pairing2.forEach((q, r) -> {
				alTimslot.add("5:00-5:30");
				alSubject.add(r.subject);
				alEmailor.add(q.email);
				alEmailee.add(r.email);
			});
			pairing3.forEach((q, r) -> {
				alTimslot.add("5:30-6:00");
				alSubject.add(r.subject);
				alEmailor.add(q.email);
				alEmailee.add(r.email);
			});
			double[] widths = {0.0, 0.0};
			alSubject.forEach(s -> {
				if ((new Text(s)).getBoundsInLocal().getWidth() > widths[0]) {
					widths[0] = (new Text(s)).getBoundsInLocal().getWidth();
				}
			});
			alEmailor.forEach(s -> {
				if ((new Text(s)).getBoundsInLocal().getWidth() > widths[1]) {
					widths[1] = (new Text(s)).getBoundsInLocal().getWidth();
				}
			});
			int[] tabsNeeded = new int[2];
			double tabWidth = (new Text("\t")).getBoundsInLocal().getWidth();
			for (int i = 0; i < 2; i++){
				tabsNeeded[i] = (int) Math.ceil(widths[i] / tabWidth);
			}
			for (int i = 0; i < alTimslot.size(); i++) {
				copStr[0] += alTimslot.get(i) + "\t" + alSubject.get(i);
				for (int j = 0; j < tabsNeeded[0] - 
						(int) Math.floor((new Text(alSubject.get(i))).getBoundsInLocal().getWidth() / tabWidth); j++){
					copStr[0] += "\t";
				}
				copStr[0] += alEmailor.get(i);
				for (int j = 0; j < tabsNeeded[1] - 
						(int) Math.floor((new Text(alEmailor.get(i))).getBoundsInLocal().getWidth() / tabWidth); j++){
					copStr[0] += "\t";
				}
				copStr[0] += alEmailee.get(i) + "\n";
			}
			content.putString(copStr[0]);
			clipboard.setContent(content);
		}); //copy pairings to clipboard
		but15.setOnAction(e -> {
			String[] emails = {""};
			pairing1.keySet().forEach(t -> emails[0] += t.email +"\n");
			pairing2.keySet().forEach(t -> emails[0] += t.email +"\n");
			pairing3.keySet().forEach(t -> emails[0] += t.email +"\n");
			pairing1.values().forEach(t -> emails[0] += t.email + "\n");
			pairing2.values().forEach(t -> emails[0] += t.email + "\n");
			pairing3.values().forEach(t -> emails[0] += t.email + "\n");
			content.putString(emails[0]);
			clipboard.setContent(content);
		}); //copy emails to clipboard
	}

	static class tutor implements Serializable{
		private static final long serialVersionUID = 1L;

		String email;
		boolean[] timeslots;
		boolean[] dayslots;
		boolean[] subjects;
		int subcount;
		int sessionCount = 0;
		
		tutor (String email, boolean[] timeslots, boolean[] dayslots, boolean[] subjects){
			this.email = email;
			this.timeslots = timeslots;
			this.dayslots = dayslots;
			this.subjects = subjects;
			for (boolean n: subjects) {
				if (n) {
					subcount++;
				}
			}
		}
		tutor (String email, boolean[] timeslots, boolean[] dayslots, boolean[] subjects, int sessionCount){
			this.email = email;
			this.timeslots = timeslots;
			this.dayslots = dayslots;
			this.subjects = subjects;
			for (boolean n: subjects) {
				if (n) {
					subcount++;
				}
			}
			this.sessionCount = sessionCount;
		}
	}
	static class tutee {
		String email;
		boolean[] timeslot = new boolean[3];
		String subject;
		int timeCount = 0;
		
		tutee (String email, boolean[] timeslot, String subject){
			this.email = email;
			this.timeslot = timeslot;
			this.subject = subject;
			for (int i = 0; i < 3; i++){
				if (timeslot[i]){
					timeCount++;
				}
			}
		}
	}
}