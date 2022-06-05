package cr_aol_model;

import java.util.Random;

public abstract class Student{
	protected String id, name, major;
	protected int semester, totalHoursPerWeek;
	
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
	
	public abstract void printData();
	
	public abstract int tuitionFee();
	
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

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getTotalHoursPerWeek() {
		return totalHoursPerWeek;
	}

	public void setTotalHoursPerWeek(int totalHoursPerWeek) {
		this.totalHoursPerWeek = totalHoursPerWeek;
	}
	
	
}

