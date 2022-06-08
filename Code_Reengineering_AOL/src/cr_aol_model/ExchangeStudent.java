package cr_aol_model;

public class ExchangeStudent extends Student{
	public String exchangeCountry;
	public String universityName;

	public ExchangeStudent(String id, String name, String major, int semester, int totalHoursPerWeek, String exchangeCountry) {
		super(id, name, major, semester, totalHoursPerWeek);
		this.exchangeCountry = exchangeCountry;
	}
	
	public ExchangeStudent(String name, String major, int semester, int totalHoursPerWeek, String exchangeCountry) {
		super(name, major, semester, totalHoursPerWeek);
		this.exchangeCountry = exchangeCountry;
	}

	@Override
	public String saveData() {
		String str = super.saveData();
		return str+"-,"+exchangeCountry+"\n";
	}
	
	@Override
	public int tuitionFee() {
		
		int total = this.totalHoursPerWeek * 250000;
		if(total > 7500000) {
			return (int)((double)total * 1.25);
		}
		else {
			return total;
		}
	}
}