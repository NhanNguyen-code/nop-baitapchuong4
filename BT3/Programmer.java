public abstract class Programmer extends Employee {
	protected String theLanguage;

	public Programmer(int thePayrollNumber, String theName, double theBasicMohthlySalary, String theLanguage) {
		super(thePayrollNumber, theName, theBasicMohthlySalary);
		setTheLanguage(theLanguage);
	}

	public String getTheLanguage() {
		return theLanguage;
	}

	public void setTheLanguage(String theLanguage) {
		if(theLanguage == null || theLanguage.trim().isEmpty())
			throw new IllegalArgumentException("The language must not be empty");
		this.theLanguage = theLanguage;
	}
	@Override
	double getMonthlySalary() {
		return theLanguage.equalsIgnoreCase("Java") ? theBasicMohthlySalary * 1.2 : theBasicMohthlySalary;
	}
	
	@Override
	public String toString() {
		return String.format("%s || %20s", super.toString(), getMonthlySalary());
	}
}
