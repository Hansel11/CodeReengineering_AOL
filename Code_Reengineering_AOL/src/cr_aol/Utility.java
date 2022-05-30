package cr_aol;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import cr_aol_model.ExchangeStudent;
import cr_aol_model.RegularStudent;
import cr_aol_model.Student;

public class Utility {
	private static String fileLocation = System.getProperty("user.dir")+"/bin/Students.csv";
	private static Scanner sc = new Scanner(System.in);

	public Utility() {
		super();
	}
	
	public static ArrayList<Student> readAll(){
		ArrayList<Student> students = new ArrayList<>();
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(fileLocation));
			String line;
			while ((line = br.readLine())!= null) {
				String[] temp = line.split(",");
				if(temp[5].equals("-")) {
					RegularStudent reg = new RegularStudent
							(temp[0],temp[1],temp[2],Integer.valueOf(temp[3]),temp[4]);
					students.add(reg);
				}
				else {
					ExchangeStudent exc = new ExchangeStudent
							(temp[0],temp[1],temp[2],Integer.valueOf(temp[3]),temp[5]);
					students.add(exc);
				}
			}
			br.close();
		} catch (IOException e) {
		}

		return students;
	}
	
	public static void save(ArrayList<Student> students) {
		try {
			FileWriter writer = new FileWriter(fileLocation);
			for (Student student : students) {
				writer.append(student.saveData());
			}
			writer.flush();
			writer.close();
			System.out.println("Data successfully saved!");
		} catch (IOException e) {
			System.out.println("Data save failed!");
		}
	}
	
	public static void printLine() {
		for(int i=0;i<118;i++)System.out.print("=");
		System.out.println();
	}
	
	public static void pressEnter() {
		System.out.println("Press enter to continue...");
		sc.nextLine();
	}
	
	public static int inputInt() {
		int input = -1;
		try {
			input = sc.nextInt();
		}catch(Exception ex) {}
		sc.nextLine();
		return input;
	}

}
