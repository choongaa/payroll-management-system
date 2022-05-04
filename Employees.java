import java.util.ArrayList;

public class Employees {

    private ArrayList<Employee> employees = new ArrayList<Employee>();

    public Employees() {
        employees.add(new Employee("Thomas Muller", "thomas.muller@uts.com", "99991111", "3 Byern St. Sydney 2001", "888-888", "Full-Time", 40, 35));
        employees.add(new Employee("Alice Stefan", "alice.stefan@uts.com", "88881111", "24 Pitt St. Sydney 2001", "777-123", "Part-Time", 20, 29));
        employees.add(new Employee("Lucy Lu", "lucy.lu@uts.com", "98981100", "11 Hunter St. Sydney 2100", "111-154", "Casual", 20, 45));
        employees.add(new Employee("Andreas Brehme", "andreas.b@uts.com", "90001222", "91 Sussex St. Sydney", "172-288", "Full-Time", 40, 33));
        employees.add(new Employee("Ruddy Voller", "ruddy.v@uts.com", "98980000", "15 Stan St. Sydney 2100", "155-154", "Full-Time", 40, 80));
        employees.add(new Employee("Monica Shwarz", "monica.s@uts.com", "92241188", "155 Jones St. Sydney 2001", "110-994", "Casual", 8, 20));
    }

//Table
    private void printTable() {
        System.out.format(Utils.tableHeader, "----------------------", "---------------------------", "------------", "------------");
        System.out.format(Utils.employeeFormat, "Employee Name", "Email", " Phone", "Type");
        System.out.format(Utils.tableHeader, "----------------------", "---------------------------", "------------", "------------");
    }

    private void printLine() {
        System.out.format(Utils.tableHeader, "----------------------", "---------------------------", "------------", "------------");
    }

//View employees
    public void viewEmployees() {
        printTable();
        for(Employee employee : employees) {
            System.out.format(Utils.employeeFormat, employee.getName(), employee.getEmail(), employee.getPhone(), employee.getType());
        }
        printLine();
    }

//Add employee
    public void addEmployee() {
        String name = Utils.string("Name");
        String email = Utils.string("Email");
        String phone = Utils.string("Phone");
        String address = Utils.string("Address");
        String TFN = Utils.string("TFN");
        String type = Utils.string("Type");
        int hours = Utils.number("Paid Hours");
        double rate = Utils.amount("Hourly Rate");
        employees.add(new Employee(name, email, phone, address, TFN, type, hours, rate));
        System.out.println(name+" record has been created.");
    }

//view employee
    public void viewEmployee() {
        boolean match = false;
        String name = Utils.string("Name");
        for(Employee employee : employees) {
            if(employee.getName().equals(name)) {
                match = true;
                printTable();
                System.out.format(Utils.employeeFormat, employee.getName(), employee.getEmail(), employee.getPhone(), employee.getType());
                printLine();
            }
        }
        if(match == false) {
            System.out.println(name+" record does not exist!");
        }
    }

//update employee
    public void updateEmployee() {
        String name = Utils.string("Name");
        int i = -1;
        System.out.println("Updating "+name+" record: ");
            String updateName = Utils.string("Name");
            String updateEmail = Utils.string("Email");
            String updatePhone = Utils.string("Phone");
            String updateAddress = Utils.string("Address");
            String updateTFN = Utils.string("TFN");
            String updateType = Utils.string("Type");
            int updateHours = Utils.number("Paid Hours");
            double updateRate = Utils.amount("Hourly Rate");
        for(Employee employee : employees) {
            i++;
            if((employee.getName()).equals(name)) {
                employees.set(i, new Employee(updateName, updateEmail, 
                    updatePhone, updateAddress, updateTFN, updateType, 
                    updateHours, updateRate));
            }
        }
        System.out.println(name+" record has been updated.");
    }

//delete employee
    public void deleteEmployee() {
        String name = Utils.string("Name");
        int i = 0;
        boolean match = false;
        for(int p=0; employees.get(p).getName().equals(name) || p<employees.size()-1; p++) {
            if(employees.get(p).getName().equals(name)) {
                match = true;
                i = p;
            }
        }

        if(match == true) {
            employees.remove(i);
            System.out.println(name+" record has been deleted.");
        }
        else{
            System.out.println(name+" record does not exist!");
        }
    }

//PAYG report 2.0
    public Employee findEmployee() {
        String name = Utils.string("Name");
        boolean match = false;
        for(Employee employee : employees) {
            if(employee.getName().equals(name)) {
                match = true;
                return employee;
            }
        }
        if(match==false) {
            System.out.println("PAYG does not exist for "+name+"!");
        }
        return null;
    }

//STP report
    public void STPReport() {
        for(Employee employee : employees) {
            System.out.format(Utils.stpFormat, employee.getName(), 
                employee.getIncome(), employee.getDeduction(), employee.getNet(), 
                employee.getSuperannuation());
        }
    }

    public double getTotalWages() {
        double total = 0;
        for(Employee employee : employees) {
            total += employee.getIncome();
        }
        return total;
    }

    public double getTotalTax() {
        double total = 0;
        for(Employee employee : employees) {
            total += employee.getDeduction();
        }
        return total;
    }

    public double getTotalNet() {
        double total = 0;
        for(Employee employee : employees) {
            total += employee.getNet();
        }
        return total;
    }

    public double getTotalSuper() {
        double total = 0;
        for(Employee employee : employees) {
            total += employee.getSuperannuation();
        }
        return total;
    }

}
