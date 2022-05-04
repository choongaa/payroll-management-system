public class Report {

    private String name;
    private double wages;
    private double tax;
    private double net;
    private double superannuation;

    public Report(Employee employee) {
        this.name = employee.getName();
        this.wages = employee.getIncome();
        this.tax = employee.getDeduction();
        this.net = employee.getNet();
        this.superannuation = employee.getSuperannuation();
    }

    public final String getName() {return name;}
    public final double getWages() {return wages;}
    public final double getTax() {return tax;}
    public final double getNet() {return net;}
    public final double getSuperannuation() {return superannuation;}

    public void report(Report r) {
        System.out.println("PAYG Report ");
        System.out.format(Utils.stpTableHeader, "-----------------", "-------------", "-------------", "-------------", "-------------");
        System.out.format(Utils.stpFormatHeader, "Employee Name", "   Wages", "    TAX", "    Net", "   Super");
        System.out.format(Utils.stpTableHeader, "-----------------", "-------------", "-------------", "-------------", "-------------");
        System.out.format(Utils.stpFormat, r.getName(), r.getWages(), r.getTax(), r.getNet(), r.getSuperannuation());
        System.out.format(Utils.stpTableHeader, "-----------------", "-------------", "-------------", "-------------", "-------------");
    }
}
