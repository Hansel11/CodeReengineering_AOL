package cr_aol_model;

public class RegularStudent extends Student{
	private String internCompany;
	
	public RegularStudent(String id, String name, String major, int semester, String internCompany) {
		super(id, name, major, semester);
		this.internCompany = internCompany;
	}

	public RegularStudent(String name, String major, int semester, String internCompany) {
		super(name, major, semester);
		this.internCompany = internCompany;
	}
	
	public String getInternCompany() {
		return internCompany;
	}

	public void setInternCompany(String internCompany) {
		this.internCompany = internCompany;
	}

	@Override
	public void printData() {
		System.out.printf("| %-5s | %-20s | %-20s | %-8d | %-20s | %-20s |\n"
				,id,name,major,semester,internCompany,"-");
	}

	@Override
	public String saveData() {
		String str = super.saveData();
		return str+internCompany+",-"+"\n";
	}
}
