import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
    public static final String stpReportTable = "+%17s+%13s+%n";
    public static final String stpReport = "| %-15s |  %-11.2f|%n";
    public static final String stpTableHeader = "+%17s+%13s+%13s+%13s+%13s+%n";
    public static final String stpFormatHeader = "| %-15s | %-11s | %-11s | %-11s | %-11s |%n";
    public static final String stpFormat = "| %-15s | %-11.2f | %-11.2f | %-11.2f | %-11.2f |%n";
    public static final String tableHeader = "+%22s+%27s+%12s+%12s+%n";
    public static final String employeeFormat = "| %-20s | %-25s | %-10s | %-10s |%n";
    public static final SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    public static final String stpArchiveTable = "+%14s+%14s+%n";
    public static final String stpArchive = "| %-12s | %-12s |%n";

    public static String string(String prompt){
        System.out.print(prompt+": ");
        return In.nextLine();
    }
    
    public static char choice(String prompt){
        System.out.print(prompt+": ");
        return In.nextChar();
    }
    
    public static double amount(String prompt){
        System.out.print(prompt+": ");
        return In.nextDouble();
    }
    
    public static int number(String prompt){
        System.out.print(prompt+": ");
        return In.nextInt();
    }

//symbol = $, value = amount
    public static String formattedValue(String symbol, double value){
        return String.format(symbol+"%.2f", value);
    }
    
    public static String formattedDate(Date date){
        return dateFormat.format(date);
    }
    
    public static Date parseDate(String date) throws ParseException{
        return dateFormat.parse(date);
    }
}
