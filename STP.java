import java.util.ArrayList;
import java.util.Date;

public class STP {
    private double totalWages;
    private double totalTax;
    private double totalNet;
    private double totalSuper;
    private double bas;
    private Date date;
    private Employees employees;
    private ArrayList<Report> reports;
    private STPLog stpLog;
    private Employer employer;
        
    public STP(Employer employer, Employees employees) {
        this.employer = employer;
        this.employees = employees;
    }

//STP Menu
    public void menu() {
        System.out.println("STP Menu: \n"+
            "F- Find PAYG Report\n"+
            "V- View STP Report\n"+
            "A- Archive STP Report\n"+
            "R- Retrieve STP Report\n"+
            "S- Show STP Log\n"+
            "X- Close");
    }

    public void STPMenu() {
        stpLog = new STPLog();
        char choice;
        menu();
        while((choice=Utils.choice(employer+"Menu Commands (F/V/A/R/S/X)"))!='X') {
            switch(choice) {
                case'F': PAYGReport();break;
                case'V': STPReport(); break;
                case'A': archiveReport(); break;
                case'R': retrieveSTPReport(); break;
                case'S': showSTPLog(); break;
            }
        }
    }

//PAYG report
    public void PAYGReport() {
        Employee e = employees.findEmployee();
        if(e!=null) {
            Report r = new Report(e);
            r.report(r);
        }
    }

//STP report
    public void STPReport() {
        System.out.println("STP Report ");
        System.out.format(Utils.stpTableHeader, "-----------------", "-------------", "-------------", "-------------", "-------------");
        System.out.format(Utils.stpFormatHeader, "Employee Name", "   Wages", "    TAX", "    Net", "   Super");
        System.out.format(Utils.stpTableHeader, "-----------------", "-------------", "-------------", "-------------", "-------------");
            employees.STPReport();
        System.out.format(Utils.stpTableHeader, "-----------------", "-------------", "-------------", "-------------", "-------------");
        System.out.print("\n");
            totalWages = employees.getTotalWages();
            totalTax = employees.getTotalTax();
            totalNet = employees.getTotalNet();
            totalSuper = employees.getTotalSuper();
            bas = totalTax + totalSuper;
        System.out.format(Utils.stpReportTable, "-----------------", "-------------");
        System.out.format(Utils.stpReport, "Total Wages", totalWages);
        System.out.format(Utils.stpReport, "Total Tax", totalTax);
        System.out.format(Utils.stpReport, "Total Net", totalNet);
        System.out.format(Utils.stpReport, "Total Super", totalSuper);
        System.out.format(Utils.stpReport, "Quarterly Bas", bas);
        System.out.format(Utils.stpReportTable, "-----------------", "-------------");
    }

//Archive report
    public void archiveReport() {
        this.date = java.util.Calendar.getInstance().getTime();
        System.out.println("STP record is created on: "+Utils.formattedDate(date));
        stpLog.archiveReport(this);
    }

//get date
    public String getDate() {
        return Utils.formattedDate(date);
    }

//Show STP Log
    public void showSTPLog() {
        // stpLog.ShowSTPLog(date.toString());
        date = java.util.Calendar.getInstance().getTime();
        String d = Utils.formattedDate(date);
        stpLog.ShowSTPLog(d);
    }
    
//Retrieve STP Report
    public void retrieveSTPReport() {
        String d = Utils.string("Date");
        if(stpLog.retrieveSTPReport(d)==null) {
            System.out.println("No STP is recorded on: "+d);
        }
        else {stpLog.retrieveSTPReport(d).STPReport(); }
        // System.out.println(this.getDate());
    }
}
