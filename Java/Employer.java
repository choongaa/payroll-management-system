public class Employer {

    private String name;
    private String email;
    private String password;
    private Employees employees;
    private STP stp;

    public Employer(String name, String email, String password, Employees employees) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.employees = employees;
    }

    public final String getName() {return name;}
    public final String getEmail() {return email;}
    public final String getPassword() {return password;}

//employer menu
    public void employerMenu() {
        System.out.println("Employer Menu:");
    }

    public void employerMenuOptions() {
        System.out.println("Employer Menu: \n" +
            "C- Add Employee\n" +
            "R- View Employee\n" +
            "U- Update Employee\n" +
            "D- Delete Employee\n" +
            "V- View Employees\n" +
            "S- STP Menu\n" +
            "X- Logout");
    }

    public void menu() {
        stp = new STP(this, employees);
        char choice;
        employerMenuOptions();
            while((choice = Utils.choice("Session Admin: "+name+" - Menu Commands (C/R/U/D/V/S/X)")) != 'X') {
                switch(choice) {
                    case'C': employees.addEmployee(); break;
                    case'R': employees.viewEmployee(); break;
                    case'U': employees.updateEmployee(); break;
                    case'D': employees.deleteEmployee(); break;
                    case'V': employees.viewEmployees(); break;
                    case'S': stp.STPMenu(); System.out.print("\n"); employerMenu(); break;
                }
            }
    }

    @Override
    public String toString() {
        return "Session Admin: "+name+" - ";
    }

}
