package cr_aol_model;

import java.util.Random;

public abstract class Student{
	public String id, name, major;
	public int semester, totalHoursPerWeek;
	public double gpa;
	
	public Student(String id, String name, String major, int semester, int totalHoursPerWeek) {
		this.id = id;
		this.name = name;
		this.major = major;
		this.semester = semester;
		this.totalHoursPerWeek = totalHoursPerWeek;
	}

	public Student(String name, String major, int semester, int totalHoursPerWeek) {
		this.id = generateId();
		this.name = name;
		this.major = major;
		this.semester = semester;
		this.totalHoursPerWeek = totalHoursPerWeek;
	}
	
	public String saveData() {
		StringBuilder sb = new StringBuilder();
		sb.append(id);
		sb.append(",");
		sb.append(name);
		sb.append(",");
		sb.append(major);
		sb.append(",");
		sb.append(semester);
		sb.append(",");
		sb.append(totalHoursPerWeek);
		sb.append(",");
		return sb.toString(); 
	}
	
	private String generateId() {
		Random rand = new Random();
		String val = "22";
		for(int i=0;i<3;i++)val+=rand.nextInt(10);
		return val;
	}
	
	public abstract int tuitionFee();
}