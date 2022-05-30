package cr_aol;

import java.util.ArrayList;
import java.util.Scanner;

import cr_aol_model.ExchangeStudent;
import cr_aol_model.RegularStudent;
import cr_aol_model.Student;


public class Program {
	
	Scanner sc = new Scanner(System.in);
	ArrayList<Student> students;

	public Program() {
		students = Utility.readAll();
		while(true)studentMenu();
	}
	
	private void studentMenu() {
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
			opt = Utility.inputInt();
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
			saveData();
			sc.close();
			System.exit(0);
			return;
		}
	}
	
	private void saveData() {
		Utility.save(students);
		Utility.pressEnter();
	}

	private void printAllStudents() {
		System.out.println();
		System.out.println("Student List");
		Utility.printLine();
		System.out.printf("| No. | %-5s | %-20s | %-20s | %-8s | %-20s | %-20s |\n"
				,"ID","Name","Major","Semester","Intern Company","Exchange Country");
		Utility.printLine();
		int i = 1;
		for (Student student : students) {
			System.out.printf("| %2s. ",i);
			i++;
			student.printData();
		}
		Utility.printLine();
	}

	private void deleteStudent() {
		if(students.size()==0)System.out.println("There are no students to delete.");
		else {
			printAllStudents();
			int opt = -1;
			int size = students.size();
			do {
				System.out.printf("Input student to delete [1 - %d] (Press 0 to cancel): ",size);
				opt = Utility.inputInt();
			}while(opt<0 || opt>size);
			
			if(opt != 0) {
				students.remove(opt-1);
				System.out.println("Student successfully removed!");
			}
		}
		Utility.pressEnter();
	}
	
	private void updateStudent() {
		
	}
	
	private void viewStudent() {
		if(students.size()==0)System.out.println("There are no students to view.");
		else printAllStudents();
		Utility.pressEnter();
	}

	private void insertStudent() {
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
			semester = Utility.inputInt();
		}while(semester<1 || semester>8);
		
		switch(type) {
		case "Regular":
			String company = "";
			do {
				System.out.print("Input student intern company [3..20]: ");
				company = sc.nextLine();
			}while(company.length()<3 || company.length()>20);
			RegularStudent reg = new RegularStudent(name,major,semester,company);
			students.add(reg);
			break;
			
		case "Exchange":
			String country = "";
			do {
				System.out.print("Input student exchange country [3..20]: ");
				country = sc.nextLine();
			}while(country.length()<3 || country.length()>20);
			ExchangeStudent exc = new ExchangeStudent(name,major,semester,country);
			students.add(exc);
			break;
		}
		
		System.out.println("Student successfully added!");
		Utility.pressEnter();
	}

	public static void main(String[] args) {
		new Program();
	}

}
