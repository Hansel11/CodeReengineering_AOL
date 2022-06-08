package cr_aol_model;

public class ExchangeStudent extends Student {
	private String exchangeCountry;

	public ExchangeStudent(String id, String name, String major, int semester, int totalHoursPerWeek,
			String exchangeCountry) {
		super(id, name, major, semester, totalHoursPerWeek);
		this.exchangeCountry = exchangeCountry;
	}

	public ExchangeStudent(String name, String major, int semester, int totalHoursPerWeek, String exchangeCountry) {
		super(name, major, semester, totalHoursPerWeek);
		this.exchangeCountry = exchangeCountry;
	}

	public String getOriginCountry() {
		return exchangeCountry;
	}

	public void setOriginCountry(String originCountry) {
		this.exchangeCountry = originCountry;
	}

	@Override
	public void printData() {
		System.out.printf("| %-5s | %-20s | %-20s | %-8d | %-20d | %-20s | %-20s |\n", id, name, major, semester,
				tuitionFee(), "-", exchangeCountry);
	}

	@Override
	public String saveData() {
		String str = super.saveData();
		return str + "-," + exchangeCountry + "\n";
	}

	@Override
	public int tuitionFee() {

		if (total() > 7500000) {
			return (int)((double)total() * 1.25);
		} else {
			return total();
		}
	}

	private int total() {
		return this.totalHoursPerWeek * 250000;
	}
}
