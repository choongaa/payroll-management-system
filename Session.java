public class Session {
    private Employers employers;
    
    public Session(){
        employers = new Employers();
    }

    public static void main(String[] args){
        new Session().use();
    }

//Login
    private void loginMenu() {
        System.out.println("STP Payroll Management System:\n"+
            "L- Login\n"+
            "X- Exit");
    }

    public void use() {
        char choice;
        loginMenu();
            while((choice = Utils.choice("Command (L/X)"))!='X') {
                if(choice != 'L') {
                    loginMenu();
                }
                if(choice == 'L') {
                    employers.login();
                }
            }
        System.out.println("\n"+
            "Session Terminated!");
    }
}
