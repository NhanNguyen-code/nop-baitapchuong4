public abstract class Employee {
	protected int thePayrollNumber;
	protected String theName;
	protected double theBasicMohthlySalary;
	public Employee(int thePayrollNumber, String theName, double theBasicMohthlySalary) {
		if(thePayrollNumber < 0) 
			throw new IllegalArgumentException("The Payroll Num not valid");
		if(theName == null || theName.trim().isEmpty())
			throw new IllegalArgumentException("The Name invalid");
			
		this.thePayrollNumber = thePayrollNumber;
		setTheName(theName);
		setTheBasicMohthlySalary(theBasicMohthlySalary);
	}
	public String getTheName() {
		return theName;
	}
	public void setTheName(String theName) {
		if(theName == null || theName.trim().isEmpty())
			throw new IllegalArgumentException("The Name invalid");
		this.theName = theName;
	}
	public double getTheBasicMohthlySalary() {
		return theBasicMohthlySalary;
	}
	public void setTheBasicMohthlySalary(double theBasicMohthlySalary) {
		if(theBasicMohthlySalary < 0.0) 
			throw new IllegalArgumentException("The basic monthly salary must be better than or equal 0");
		this.theBasicMohthlySalary = theBasicMohthlySalary;
	}
	public int getThePayrollNumber() {
		return thePayrollNumber;
	}
	abstract double getMonthlySalary();
	@Override
	public String toString() {
		
		return String.format("%10s || %30s || %20s", thePayrollNumber, theName, theBasicMohthlySalary);
	}
}
