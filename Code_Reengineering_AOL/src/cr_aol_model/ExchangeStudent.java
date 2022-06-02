package cr_aol_model;

public class ExchangeStudent extends Student{
	private String exchangeCountry;

	public ExchangeStudent(String id, String name, String major, int semester, String exchangeCountry) {
		super(id, name, major, semester);
		this.exchangeCountry = exchangeCountry;
	}
	
	public ExchangeStudent(String name, String major, int semester, String exchangeCountry) {
		super(name, major, semester);
		this.exchangeCountry = exchangeCountry;
	}

	public String getExchangeCountry() {
		return exchangeCountry;
	}

	public void setExchangeCountry(String exchangeCountry) {
		this.exchangeCountry = exchangeCountry;
	}

	@Override
	public String saveData() {
		String str = super.saveData();
		return str+"-,"+exchangeCountry+"\n";
	}
}
