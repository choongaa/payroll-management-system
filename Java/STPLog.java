import java.util.ArrayList;

public class STPLog {
    private ArrayList<STP> stpLog = new ArrayList<STP>();

    public STPLog() {
    }

//Show STP Log
    public void ShowSTPLog(String date) {
        System.out.println("STP Archive:");
        System.out.format(Utils.stpArchiveTable, "--------------", "--------------");
        System.out.format(Utils.stpArchive, " STP Record", "    Date");
        System.out.format(Utils.stpArchiveTable, "--------------", "--------------");
        if(stpLog.size()>0) {
            for(int i=1; i<stpLog.size()+1; i++)
            System.out.format(Utils.stpArchive, "STP "+i, " "+date);
        }
        System.out.format(Utils.stpArchiveTable, "--------------", "--------------");
    }

//Archive report
    public void archiveReport(STP stp) {
        stpLog.add(stp);
    }

//Retrieve STP report
    public STP retrieveSTPReport(String date) {
        for(STP log : stpLog) {
            if(log.getDate().equals(date)) {
                return log;
            }
        }
        return null;
    }

}
