class ProjectLeader extends Programmer{

	public ProjectLeader(int thePayrollNumber, String theName, double theBasicMohthlySalary, String theLanguage) {
		super(thePayrollNumber, theName, theBasicMohthlySalary, theLanguage);
	}
	
	@Override
	double getMonthlySalary() {
		return super.getMonthlySalary() + theBasicMohthlySalary * 0.2;
	}
}

