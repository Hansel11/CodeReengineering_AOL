package cr_aol;

import java.util.ArrayList;
import java.util.Scanner;

import cr_aol_model.ExchangeStudent;
import cr_aol_model.RegularStudent;
import cr_aol_model.Student;
import cr_aol_utility.IOUtility;
import cr_aol_utility.FileUtility;


public class Program {
	
	Scanner sc = new Scanner(System.in);
	ArrayList<Student> students;

	public Program() {
		studentMenu();
	}
	
	private void studentMenu() {
		students = FileUtility.readAll();
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
				opt = IOUtility.inputInt();
			}while(opt < 1 || opt > 5);
			
			switch(opt){
			case 1:
				viewStudent();
				break;
			case 2:
				insertStudent();
				break;
			case 3:
				deleteStudent();
				break;
			case 4:
				saveData();
				break;
			case 5:
				exitProgram();
				return;
			}
		}
	}
	
	private void exitProgram() {
		saveData();
		sc.close();
		System.exit(0);
	}
	
	private void saveData() {
		FileUtility.save(students);
		IOUtility.pressEnter();
	}

	private void printAllStudents() {
		System.out.println();
		System.out.println("Student List");
		IOUtility.printLine();
		System.out.printf("| No. | %-5s | %-20s | %-20s | %-8s | %-20s | %-20s | %-20s |\n"
				,"ID","Name","Major","Semester", "Tuition Fee", "Intern Company","Exchange Country");
		IOUtility.printLine();
		int i = 1;
		for (Student student : students) {
			System.out.printf("| %2s. ",i);
			i++;
			student.printData();
		}
		IOUtility.printLine();
	}

	private void deleteStudent() {
		if(students.size()==0)System.out.println("There are no students to delete.");
		else {
			printAllStudents();
			int opt = -1;
			int size = students.size();
			do {
				System.out.printf("Input student to delete [1 - %d] (Press 0 to cancel): ",size);
				opt = IOUtility.inputInt();
			}while(opt<0 || opt>size);
			
			if(opt != 0) {
				students.remove(opt-1);
				System.out.println("Student successfully removed!");
			}
		}
		IOUtility.pressEnter();
	}
	
	private void viewStudent() {		
		if(students.size()==0)System.out.println("There are no students to view.");
		else printAllStudents();
		IOUtility.pressEnter();
	}

	private Student createStudent() {
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
			semester = IOUtility.inputInt();
		}while(semester<1 || semester>8);
		
		int totalHoursPerWeek = -1;
		do {
			System.out.print("Input student total hours per week [10 - 40]: ");
			totalHoursPerWeek = IOUtility.inputInt();
		}while(totalHoursPerWeek<10 || totalHoursPerWeek>40);
		
		switch(type) {
		case "Regular":
			String company = "";
			do {
				System.out.print("Input student intern company [3..20]: ");
				company = sc.nextLine();
			}while(company.length()<3 || company.length()>20);
			return new RegularStudent(name,major,semester,totalHoursPerWeek,company);
			
		case "Exchange":
			String country = "";
			do {
				System.out.print("Input student exchange country [3..20]: ");
				country = sc.nextLine();
			}while(country.length()<3 || country.length()>20);
			return new ExchangeStudent(name,major,semester,totalHoursPerWeek,country);
		}
		
		return null;
	}
	
	private void insertStudent() {
		students.add(createStudent());
		System.out.println("Student successfully added!");
		IOUtility.pressEnter();
	}

	public static void main(String[] args) {
		new Program();
	}

}
