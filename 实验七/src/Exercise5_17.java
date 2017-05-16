import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by benjaminzhang on 15/05/2017.
 * Copyright © benjaminzhang 2017.
 */

abstract class StateOrOutStateStudent {
    final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
    String schoolName;
    String studentName;
    int creditCardDate;
    Date date = null;
    double bill;

    static int daysBetween(Date smdate, Date bdate) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        smdate = sdf.parse(sdf.format(smdate));
        bdate = sdf.parse(sdf.format(bdate));
        Calendar cal = Calendar.getInstance();
        cal.setTime(smdate);
        long time1 = cal.getTimeInMillis();
        cal.setTime(bdate);
        long time2 = cal.getTimeInMillis();
        long between_days = (time2 - time1) / (1000 * 3600 * 24);
        return Integer.parseInt(String.valueOf(between_days));
    }

    void printInfo() {
        System.out.println("School name: " + schoolName);
        System.out.println("Name: " + studentName);
        System.out.println("Credit card uesd time: " + creditCardDate + " days");
        System.out.println("Total bill: " + bill);
    }
}

class JavaStateUniversityStudent extends StateOrOutStateStudent {
    final double biilPer = 75;
}

class OutStateStudent extends StateOrOutStateStudent {
    final double biilPer = 200;
}

public class Exercise5_17 {
    public static void main(String[] args) throws ParseException {
        Date nowDate = new Date();
        JavaStateUniversityStudent javaStu = new JavaStateUniversityStudent();
        OutStateStudent outStu = new OutStateStudent();
        javaStu.schoolName = "Java State University";
        javaStu.studentName = "java";
        outStu.schoolName = "Out-state University";
        outStu.studentName = "outJava";
        javaStu.date = javaStu.sdf.parse("2012-03-02");
        outStu.date = outStu.sdf.parse("2013-05-06");
        javaStu.creditCardDate = StateOrOutStateStudent.daysBetween(javaStu.date, nowDate);
        outStu.creditCardDate = StateOrOutStateStudent.daysBetween(outStu.date, nowDate);
        javaStu.bill = javaStu.biilPer * 120;
        outStu.bill = outStu.biilPer * 120;

        System.out.println("State:");
        javaStu.printInfo();
        System.out.println();
        System.out.println("Out State:");
        outStu.printInfo();
    }
}
