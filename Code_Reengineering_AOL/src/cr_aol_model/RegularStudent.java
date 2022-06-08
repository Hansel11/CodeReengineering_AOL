package cr_aol_model;

public class RegularStudent extends Student{
	public String internCompany;
	
	public RegularStudent(String id, String name, String major, int semester, int totalHoursPerWeek, String internCompany) {
		super(id, name, major, semester, totalHoursPerWeek);
		this.internCompany = internCompany;
	}

	public RegularStudent(String name, String major, int semester, int totalHoursPerWeek, String internCompany) {
		super(name, major, semester, totalHoursPerWeek);
		this.internCompany = internCompany;
	}

	@Override
	public String saveData() {
		String str = super.saveData();
		return str+internCompany+",-"+"\n";
	}
	
	@Override
	public int tuitionFee() {
		
		int total = this.totalHoursPerWeek * 200000;
		if(total > 6000000) {
			return (int)((double)total * 1.2);
		}
		else {
			return total;
		}
	}
}