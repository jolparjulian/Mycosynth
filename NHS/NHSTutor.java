package NHS;
import java.io.*;
import java.util.*;
import java.awt.Desktop;

public class NHSTutor {
	public static void main(String[] args) throws IOException {
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


		
		while (true) { //add all tutors for first time
			String email = input.next();
			if (email.equalsIgnoreCase("END")) {
				break;
			}
			String[] tims = new String[3];
			while (true) {
				String a = input.next();
				if (a.charAt(a.length() - 1) == ',') {
					switch (a.substring(0, 3)) {
						case "4:3": tims[0] = "4:30-5:00"; break;
						case "5:0": tims[1] = "5:00-5:30"; break;
						case "5:3": tims[2] = "5:30-6:00"; break;
					}
				}
				else {
					switch (a.substring(0, 3)) {
						case "4:3": tims[0] = "4:30-5:00"; break;
						case "5:0": tims[1] = "5:00-5:30"; break;
						case "5:3": tims[2] = "5:30-6:00"; break;
					}
					break;
				}
			}
			boolean[] subjects = new boolean[12];
			while (true) {
				String b = input.next();
				switch (b.substring(0, 3)) {
					case "Eng": subjects[0] = true; break;
					case "Gov": subjects[1] = true; break;
					case "His": subjects[2] = true; break;
					case "Alg": subjects[3] = true; input.next(); input.next(); b = input.next(); break;
					case "Geo": subjects[4] = true; break;
					case "Pre": subjects[5] = true; break;
					case "Sta": subjects[6] = true; break;
					case "Bio": subjects[7] = true; break;
					case "Che": subjects[8] = true; break;
					case "Phy": subjects[9] = true; break;
					case "Com": subjects[10] = true; b = input.next(); break;
					case "SAT": subjects[11] = true; break;
				}
				if (b.charAt(b.length() - 1) != ',') {
					break;
				}
			}
			boolean[] day = new boolean[2];
			while (true) {
				String d = input.next();
				switch (d.substring(0, 3)) {
					case "Mon": day[0] = true; break;
					case "Wed": day[1] = true; break;
					case "Ano": d = input.next();
				}
				if (d.charAt(d.length() - 1) != ',') {
					break;
				}
			}
			int sess = input.nextInt();
			tutor Chad = new tutor(email, tims, day, subjects, sess);
			tutorList.add(Chad);
			if (Chad.dayslots[1]) { /////////////////////////////////////////////
				tutorList0.add(Chad);
				if (tims[0] == "4:30-5:00") {
					tutorList1.add(Chad);
				}
				if (tims[1] == "5:00-5:30") {
					tutorList2.add(Chad);
				}
				if (tims[2] == "5:30-6:00") {
					tutorList3.add(Chad);
				}
			}			
		} //finish adding tutors
		
		/*Scanner incut = new Scanner(System.in);
		System.out.print("Remove any tutors (true or false)? "); //boolean enter
		boolean looper = false;
		looper = incut.nextBoolean();
		while (looper) {
			String cutEmail = incut.next(); //email enter
			for (int i = 0; i < tutorList0.size(); i++) {
				if (tutorList0.get(i).email.equalsIgnoreCase(cutEmail)) {
					tutorList0.remove(tutorList0.get(i));
				}
			}
			for (int i = 0; i < tutorList1.size(); i++) {
				if (tutorList1.get(i).email.equalsIgnoreCase(cutEmail)) {
					tutorList1.remove(tutorList1.get(i));
				}
			}
			for (int i = 0; i < tutorList2.size(); i++) {
				if (tutorList2.get(i).email.equalsIgnoreCase(cutEmail)) {
					tutorList2.remove(tutorList2.get(i));
				}
			}
			for (int i = 0; i < tutorList3.size(); i++) {
				if (tutorList3.get(i).email.equalsIgnoreCase(cutEmail)) {
					tutorList3.remove(tutorList3.get(i));
				}
			}//oladipo-omokanwaye@pgcps.org
			System.out.print("Remove anyone? ");
			looper = incut.nextBoolean();
		}
		incut.close();
		 //finish populating tutors
		*/
		while (true) {  //start tutee
			String subject = ""; 
			String email2N = input.next();
			if (email2N.equalsIgnoreCase("END")) {
				break;
			}
			String c = input.next();
			switch (c.substring(0, 3)) {
				case "Eng": subject = "English"; break;
				case "Gov": subject = "Government"; break;
				case "His": subject = "History"; break;
				case "Alg": subject = "Algebra 1/2"; input.next(); input.next(); c = input.next(); break;
				case "Geo": subject = "Geometry/Trig"; break;
				case "Pre": subject = "Pre-Calc/Calc"; break;
				case "Sta": subject = "Statistics"; break;
				case "Bio": subject = "Biology"; break;
				case "Che": subject = "Chemistry"; break;
				case "Phy": subject = "Physics"; break;
				case "Com": subject = "Comp Sci"; c = input.next(); break;
				case "SAT": subject = "SAT/ACT"; break;
				default:
					subject = c;
					while (c.charAt(0) != '4' || c.charAt(0) != '5') {
						c = input.next();
						subject = subject + " " + c;
					}
					break;
			}
			String[] time = new String[3];
			while (true) {
				String d = input.next();
				if (d.charAt(d.length() - 1) == ',') {
					switch (d.substring(0, 3)) {
						case "4:3": time[0] = "4:30-5:00"; break;
						case "5:0": time[1] = "5:00-5:30"; break;
						case "5:3": time[2] = "5:30-6:00"; break;
					}
				}
				else {
					switch (d.substring(0, 3)) {
						case "4:3": time[0] = "4:30-5:00"; break;
						case "5:0": time[1] = "5:00-5:30"; break;
						case "5:3": time[2] = "5:30-6:00"; break;
					}
					break;
				}
			}
			
			if (time[0] == "4:30-5:00") {
				tuteeList1.add(new tutee(email2N, time, subject));
			}
			if (time[1] == "5:00-5:30") {
				tuteeList2.add(new tutee(email2N, time, subject));
			}
			if (time[2] == "5:30-6:00") {
				tuteeList3.add(new tutee(email2N, time, subject));
			} 
		} //finish adding tutees
		input.close();
		
		
		LinkedHashMap<ArrayList<tutor>, ArrayList<ArrayList<tutor>>> tutorMaster = new LinkedHashMap<>();
		LinkedHashMap<ArrayList<tutee>, ArrayList<ArrayList<tutee>>> tuteeMaster = new LinkedHashMap<>();
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
		
		
		PrintWriter output = new PrintWriter(new BufferedWriter(new FileWriter(outFile)));
		output.println("  Timeslot    Subject         Tutor Email                      Tutee Email");
		pairing1.forEach((q, r) -> {
			output.printf("%-2d%-12s%-16s%-33s%-33s\n", q.sessionCount, "4:30-5:00", r.subject, q.email, r.email);
		});
		pairing2.forEach((q, r) -> {
			output.printf("%-2d%-12s%-16s%-33s%-33s\n", q.sessionCount, "5:00-5:30", r.subject, q.email, r.email);
		});
		pairing3.forEach((q, r) -> {
			output.printf("%-2d%-12s%-16s%-33s%-33s\n", q.sessionCount, "5:30-6:00", r.subject, q.email, r.email);
		});
		//4:30-5:00   Pre-Calculus/Calculus   ebunoluwj-sholagbade@pgcps.org   ebunoluwj-sholagbade@pgcps.org
		
		output.println("\nTutees not assigned:");
		output.println("Tutee Email                      Subject      Timeslot    ");
		tuteeOTHER.forEach(t -> {
			output.printf("%-33s%-13s", t.email, t.subject);
			for (String s: t.timeslot) {
				if (s == "4:30-5:00") {
					output.print("4:30-5:00 ");
				}
				if (s == "5:00-5:30") {
					output.print("5:00-5:30 ");
				}
				if (s == "5:30-6:00") {
					output.print("5:30-6:00 ");
				}
			}
			output.println("");
		});	
		
		tutorList0.removeAll(pairing1.keySet());
		tutorList0.removeAll(pairing2.keySet());
		tutorList0.removeAll(pairing3.keySet());
		tutorList0.trimToSize();
		output.println("\nTutors not assigned: "); 
		output.println("  Tutor Email                      Timeslot                      Subject                 ");
		for (int j = 0; j < tutorList0.size(); j++) {
			output.printf("%-2d%-33s", tutorList0.get(j).sessionCount, tutorList0.get(j).email);
			if (tutorList0.get(j).timeslots[0] == "4:30-5:00") {
				output.print("4:30-5:00 ");
			}
			else {
				output.print("          ");
			}
			if (tutorList0.get(j).timeslots[1] == "5:00-5:30") {
				output.print("5:00-5:30 ");
			}
			else {
				output.print("          ");
			}
			if (tutorList0.get(j).timeslots[2] == "5:30-6:00") {
				output.print("5:30-6:00 ");
			}
			else {
				output.print("          ");
			}
			for (int k = 0; k < 12; k++) {
				if (tutorList0.get(j).subjects[k]) {
					switch (k) {
						case 0: output.print("English, "); break;
						case 1: output.print("Government, "); break;
						case 2: output.print("History, "); break;
						case 3: output.print("Algebra 1/2, "); break;
						case 4: output.print("Geometry/Trig, "); break;
						case 5: output.print("Pre-Calc/Calc, "); break;
						case 6: output.print("Statistics, "); break;
						case 7: output.print("Biology, "); break;
						case 8: output.print("Chemistry, "); break;
						case 9: output.print("Physics, "); break;
						case 10: output.print("Comp Sci, "); break;
						case 11: output.print("SAT/ACT"); break;
					}
				}
			}		
			output.println(" ");
		}
		output.close();
		Desktop.getDesktop().open(outFile);
				
	}
	static class tutor{
		String email;
		String[] timeslots;
		boolean[] dayslots;
		boolean[] subjects;
		int subcount;
		int sessionCount = 0;
		
		tutor (String email, String[] timeslots, boolean[] dayslots, boolean[] subjects){
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
		tutor (String email, String[] timeslots, boolean[] dayslots, boolean[] subjects, int sessionCount){
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
		String[] timeslot;
		String subject;
		int timeCount = 0;
		
		tutee (String email, String[] timeslot, String subject){
			this.email = email;
			this.timeslot = timeslot;
			this.subject = subject;
			for (String n: timeslot) {
				if (n == "4:30-5:00") {
					timeCount++;
				}
				if (n == "5:00-5:30") {
					timeCount++;
				}
				if (n == "5:30-6:00") {
					timeCount++;
				}
			}
		}
	}
}
