public class Employee {
    private String name;
    private String email;
    private String phone;
    private String address;
    private String TFN;
    private String type; 
    private int hours;
    private double payPerHour;
    private double income;
    private double rate;
    private double net;
    private double deduction;
    private double superRate;
    private double superannuation;
    private Employer employer;

    public Employee(String name, String email, String phone, String address, String TFN, String type, int hours, double payPerHour) {
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.address = address;
        this.TFN = TFN;
        this.type = type;
        this.hours = hours;
        this.payPerHour = payPerHour;
        this.income = hours*payPerHour*52.0;
        if(income<15000) {this.rate = 0;}
        else if(income<45000&&income>=15000) {this.rate = 0.19;}
        else if(income<120000&&income>=45000) {this.rate = 0.32;}
        else if(income<180000&&income>=120000) {this.rate = 0.37;}
        else if(income<=180000) {this.rate = 0.45;}
        this.net = income-(income*rate);
        this.deduction = income-net;
        this.superRate = 0.09;
        this.superannuation = income*superRate; }

    public final String getName() {return name;}
    public final String getEmail() {return email;}
    public final String getPhone() {return phone;}
    public final String getAddress() {return address;}
    public final String getTFN() {return TFN;}
    public final String getType() {return type;}
    public final int getHours() {return hours;}
    public final double getIncome() {return income;}
    public final double getSuperannuation() {return superannuation;}
    public final double getNet() {return net;}
    public final double getDeduction() {return deduction;}
}
