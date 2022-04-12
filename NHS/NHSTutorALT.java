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
		ComboBox<String> combob1 = new ComboBox<>(); //tutorList0 > email values to be added
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
		


		//initializers
		File inFile = new File("C:\\Users\\jolpa\\OneDrive\\Desktop\\Codes\\NHS\\nhs1.txt");
		File outFile = new File("C:\\Users\\jolpa\\OneDrive\\Desktop\\Codes\\NHS\\nhs2.txt");
		Scanner input = new Scanner(inFile);		
		ArrayList<tutor> tutorList = new ArrayList<>();
		ArrayList<tutor> tutorList0 = new ArrayList<>();
		ArrayList<tutor> tutorList1 = new ArrayList<>();
		ArrayList<tutor> tutorList2 = new ArrayList<>();
		ArrayList<tutor> tutorList3 = new ArrayList<>();
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


		//commands
		but1.setOnAction(e -> stage.setScene(scene2)); //home to input
		but2.setOnAction(e -> {
			//read storage file
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
			ArrayList<String> tutorEmails = new ArrayList<>();
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
			but7.fire();
			//rewrite tutor info
			stage.close();
		}); //minor tutor info change to exit
		but9.setOnAction(e -> stage.setScene(scene3)); //tutee input to minor tutor info change
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
						subject = c;
						while (c.charAt(0) != '4' || c.charAt(0) != '5') {
							c = input2.next();
							subject = subject + " " + c;
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
				
				if (time[0]) {
					tuteeList1.add(new tutee(email2N, time, subject));
				}
				if (time[1]) {
					tuteeList2.add(new tutee(email2N, time, subject));
				}
				if (time[2]) {
					tuteeList3.add(new tutee(email2N, time, subject));
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
						default: tuteeOTHER.add(t); n.remove(t); break;
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
			//if !tuteeOTHER: stage.setScene(PRINTING);
		}); //tutee input through other pairings to printing
	}

	static class tutor{
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