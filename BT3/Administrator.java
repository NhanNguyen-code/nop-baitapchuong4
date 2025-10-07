public class Administrator extends Employee{
	private String theDepartment;

	public Administrator(int thePayrollNumber, String theName, double theBasicMohthlySalary, String theDepartment) {
		super(thePayrollNumber, theName, theBasicMohthlySalary);
		setTheDepartment(theDepartment);;
	}

	public String getTheDepartment() {
		return theDepartment;
	}

	public void setTheDepartment(String theDepartment) {
		if(theDepartment == null || theDepartment.trim().isEmpty())
			throw new IllegalArgumentException("The department must not be empty");
		this.theDepartment = theDepartment;
	}
	@Override
	double getMonthlySalary() {
		return theBasicMohthlySalary * 1.4;
	}
	@Override
	public String toString() {
		return String.format("%s || %20s", super.toString(), getMonthlySalary());
	}
}
