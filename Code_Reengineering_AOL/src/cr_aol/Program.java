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


public class Program {
	private String fileLocation = System.getProperty("user.dir")+"/bin/Students.csv";
	Scanner sc = new Scanner(System.in);
	ArrayList<Student> students;

	public Program() {
		studentMenu();
	}
	
	private void studentMenu() {
		try {
			students = new ArrayList<>();
			BufferedReader br = new BufferedReader(new FileReader(fileLocation));
			String line;
			while ((line = br.readLine())!= null) {
				String[] temp = line.split(",");
				if(temp[6].equals("-")) {
					RegularStudent reg = new RegularStudent
							(temp[0],temp[1],temp[2],Integer.valueOf(temp[3]),Integer.valueOf(temp[4]),temp[5]);
					students.add(reg);
				}
				else {
					ExchangeStudent exc = new ExchangeStudent
							(temp[0],temp[1],temp[2],Integer.valueOf(temp[3]),Integer.valueOf(temp[4]),temp[6]);
					students.add(exc);
				}
			}
			br.close();
		} catch (IOException e) {
		}
		while(true) {
			System.out.println("Manage Student");
			System.out.println("==================");
			System.out.println("1. View Students");
			System.out.println("2. Insert Student");
			System.out.println("3. Delete Student");
			System.out.println("4. Save Data");
			System.out.println("5. Exit");
			System.out.println("==================");
			int opt = -1;
			do {
				System.out.print(">> ");
				opt = inputInt();
			}while(opt < 1 || opt > 5);
			
			switch(opt){
			case 1:
				processOption("view");
				break;
			case 2:
				processOption("insert");
				break;
			case 3:
				processOption("delete");
				break;
			case 4:
				processOption("save");
				break;
			case 5:
				processOption("exit");
			}
		}
	}
	
	private void processOption(String option) {
		if(option.equals("view")) {
			viewStudent();
		}if(option.equals("insert")) {
			insertStudent();
		}if(option.equals("delete")) {
			deleteStudent();
		}if(option.equals("save")) {
			saveData();
		}if(option.equals("exit")) {
			exitProgram();
		}
	}
	
	private void exitProgram() {
		saveData();
		sc.close();
		System.exit(0);
		return;
	}
	
	private void saveData() {
		save(students);
		System.out.println("Press enter to continue...");
		sc.nextLine();
	}
	
	private void printOneStudent(Student student) {
		System.out.printf("| %-5s | %-20s | %-20s | %-8d | %-20d\n"
				,student.id,student.name,student.major,student.semester,student.tuitionFee());
	}

	private void deleteStudent() {
		if(students.size()==0)System.out.println("There are no students to delete.");
		else {
			System.out.println();
			System.out.println("Student List");
			for(int i=0;i<141;i++)System.out.print("=");
			System.out.println();
			System.out.printf("| No. | %-5s | %-20s | %-20s | %-8s | %-20s | %-20s | %-20s |\n"
					,"ID","Name","Major","Semester", "Tuition Fee", "Intern Company","Exchange Country");
			for(int i=0;i<141;i++)System.out.print("=");
			System.out.println();
			int j = 1;
			for (Student student : students) {
				System.out.printf("| %2s. ",j);
				j++;
				if(student instanceof RegularStudent) {
					RegularStudent rs = (RegularStudent) student;
					System.out.printf("| %-5s | %-20s | %-20s | %-8d | %-20d | %-20s | %-20s |\n"
							,rs.id,rs.name,rs.major,rs.semester,rs.tuitionFee(),rs.internCompany,"-");
				}
				if(student instanceof ExchangeStudent) {
					ExchangeStudent es = (ExchangeStudent) student;
					System.out.printf("| %-5s | %-20s | %-20s | %-8d | %-20d | %-20s | %-20s |\n"
							,es.id,es.name,es.major,es.semester,es.tuitionFee(),"-",es.exchangeCountry);
				}
			}
			for(int i=0;i<141;i++)System.out.print("=");
			System.out.println();
			int opt = -1;
			int size = students.size();
			do {
				System.out.printf("Input student to delete [1 - %d] (Press 0 to cancel): ",size);
				opt = inputInt();
			}while(opt<0 || opt>size);
			
			if(opt != 0) {
				students.remove(opt-1);
				System.out.println("Student successfully removed!");
			}
		}
		System.out.println("Press enter to continue...");
		sc.nextLine();
	}
	
	private void viewStudent() {
		if(students.size()==0)System.out.println("There are no students to view.");
		else {
			System.out.println();
			System.out.println("Student List");
			for(int i=0;i<141;i++)System.out.print("=");
			System.out.println();
			System.out.printf("| No. | %-5s | %-20s | %-20s | %-8s | %-20s | %-20s | %-20s |\n"
					,"ID","Name","Major","Semester", "Tuition Fee", "Intern Company","Exchange Country");
			for(int i=0;i<141;i++)System.out.print("=");
			System.out.println();
			int j = 1;
			for (Student student : students) {
				System.out.printf("| %2s. ",j);
				j++;
				if(student instanceof RegularStudent) {
					RegularStudent rs = (RegularStudent) student;
					System.out.printf("| %-5s | %-20s | %-20s | %-8d | %-20d | %-20s | %-20s |\n"
				,rs.id,rs.name,rs.major,rs.semester,rs.tuitionFee(),rs.internCompany,"-");
				}
				if(student instanceof ExchangeStudent) {
					ExchangeStudent es = (ExchangeStudent) student;
					System.out.printf("| %-5s | %-20s | %-20s | %-8d | %-20d | %-20s | %-20s |\n"
				,es.id,es.name,es.major,es.semester,es.tuitionFee(),"-",es.exchangeCountry);
				}
			}
			for(int i=0;i<141;i++)System.out.print("=");
			System.out.println();
		}
		System.out.println("Press enter to continue...");
		sc.nextLine();
	}
	
	private Student createStudent(String type, String name, String major, int semester, int totalHoursPerWeek, String company, String country) {
		switch(type) {
		case "Regular":
			RegularStudent reg = new RegularStudent(name,major,semester, totalHoursPerWeek, company);
			return reg;
			
		case "Exchange":
			ExchangeStudent exc = new ExchangeStudent(name,major,semester, totalHoursPerWeek, country);
			return exc;
		}
		return null;
	}

	private void insertStudent() {
//		RegularStudent(String id, String name, String major, int semester, String internCompany) {
//			super(id, name, major, semester);
//			this.internCompany = internCompany;
//		}
//		ExchangeStudent(String id, String name, String major, int semester, String exchangeCountry) {
//			super(id, name, major, semester);
//			this.exchangeCountry = exchangeCountry;
//		}
		String type = "";
		do {
			System.out.print("Input student type [Regular | Exchange]: ");
			type = sc.nextLine();
		}while(!type.equals("Regular") && !type.equals("Exchange"));
		
		String name = "";
		do {
			System.out.print("Input student name: ");
			name = sc.nextLine();
		}while(name.equals(""));
		
		String major = "";
		do {
			System.out.print("Input student major [5..20]: ");
			major = sc.nextLine();
		}while(major.length()<5 || major.length()>20);
		
		int semester = -1;
		do {
			System.out.print("Input student semester [1 - 8]: ");
			semester = inputInt();
		}while(semester<1 || semester>8);
		
		int totalHoursPerWeek = -1;
		do {
			System.out.print("Input student total hours per week [10 - 40]: ");
			totalHoursPerWeek = inputInt();
		}while(totalHoursPerWeek<10 || totalHoursPerWeek>40);
		
		String company = "";
		String country = "";
		switch(type) {
		case "Regular":
			do {
				System.out.print("Input student intern company [3..20]: ");
				company = sc.nextLine();
			}while(company.length()<3 || company.length()>20);
			break;
			
		case "Exchange":
			do {
				System.out.print("Input student exchange country [3..20]: ");
				country = sc.nextLine();
			}while(country.length()<3 || country.length()>20);
			break;
		}
		
		Student student = createStudent(type, name, major, semester, totalHoursPerWeek, company, country);
		students.add(student);
		
		System.out.println("Student successfully added!");
		System.out.println("Press enter to continue...");
		sc.nextLine();
	}
	
	public void save(ArrayList<Student> students) {
		try {
			FileWriter writer = new FileWriter(fileLocation);
			for (Student student : students) {
				writer.write(student.saveData());
			}
			writer.flush();
			writer.close();
			System.out.println("Data successfully saved!");
		} catch (IOException e) {
			System.out.println("Data save failed!");
		}
	}
	
	public int inputInt() {
		int input = -1;
		try {
			input = sc.nextInt();
		}catch(Exception ex) {}
		sc.nextLine();
		return input;
	}
	
	public static void main(String[] args) {
		new Program();
	}
	

}