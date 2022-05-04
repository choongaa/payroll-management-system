import java.util.ArrayList;

public class Employers {

    private ArrayList<Employer> employers = new ArrayList<Employer>();

    public Employers() {
        Employees employees = new Employees();
        employers.add(new Employer("John Smith", "john.smith@uts.com", "super123", employees));
        employers.add(new Employer("Jane Doe", "jave.doe@uts.com", "user222", employees));
    }

//Login process
    private void STPMenu() {
        System.out.println("STP Payroll Management System:");
    }

    public void login() {
        boolean match = false;
        String email = Utils.string("Email");
        String password = Utils.string("Password");
        for(Employer employer : employers) {
            if((employer.getEmail()).equals(email) && (employer.getPassword()).equals(password)) {
                match = true;
                employer.menu();                
                System.out.print("\n");
                STPMenu();
            }
        }
        if(match == false) {
            System.out.println("Incorrect employer details!");
        }
    }
}
