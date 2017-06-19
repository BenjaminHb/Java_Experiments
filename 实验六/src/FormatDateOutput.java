import java.util.Random;

/**
 * Created by benjaminzhang on 17/04/2017.
 * Copyright © benjaminzhang 2017.
 */
public class FormatDateOutput {
    private static String[] dateStorage = new String[10];
    private static String[] dateStorage2 = new String[10];

    private int correctDay(int dayIn, int monthIn, int yearIn) {        //纠正随机生成的日期，使其日期能与月份对应
        switch (monthIn) {
            case 2: {
                dayIn = dayIn > 28 ? 28 : dayIn;
                if (yearIn % 4 == 0 && yearIn % 100 != 0 || yearIn % 400 == 0)
                    return 29;
                else return dayIn;
            }
            case 4:
                return dayIn > 30 ? 30 : dayIn;
            case 6:
                return dayIn > 30 ? 30 : dayIn;
            case 9:
                return dayIn > 30 ? 30 : dayIn;
            case 11:
                return dayIn > 30 ? 30 : dayIn;
            default:
                return dayIn;
        }
    }

    private void dateConvert(int i, int day, int month, int year, String[] date2, String[] mon) {       //将传入的日期转换为题目要求形式的字符串
        date2[i] = day + "";
        if (day == 1 || day == 11 || day == 21 || day == 31)
            date2[i] += "st";
        else if (day == 2 || day == 12 || day == 22)
            date2[i] += "nd";
        else if (day == 3 || day == 13 || day == 23)
            date2[i] += "rd";
        else date2[i] += "th";
        date2[i] += mon[month - 1];
        if (year >= 40)
            date2[i] += "19" + year;
        else {      //若随机生成的年份只有1位数，则补'0'
            if (Math.log10(year) < 1) date2[i] += "200" + year;
            else date2[i] += "20" + year;
        }
    }

    public static void main(String[] args) {
        FormatDateOutput fDO = new FormatDateOutput();
        String[] month = new String[12];

        Random random = new Random();
        month[0] = "January";
        month[1] = "February";
        month[2] = "March";
        month[3] = "April";
        month[4] = "May";
        month[5] = "June";
        month[6] = "July";
        month[7] = "August";
        month[8] = "September";
        month[9] = "October";
        month[10] = "November";
        month[11] = "December";

        for (int i = 0; i < 10; i++) {
            int monthRan = random.nextInt(12) + 1;      //随机生成1-12之间的整数
            int dayRan = random.nextInt(31) + 1;        //随机生成1-31之间的整数
            int yearRan = random.nextInt(100);          //随机生成0-99之间的整数
            dayRan = fDO.correctDay(dayRan, monthRan, yearRan);     //纠正随机生成的日期
            dateStorage[i] = monthRan + "/" + dayRan + "/" + yearRan;       //将正确的日期转换为字符串
            fDO.dateConvert(i, dayRan, monthRan, yearRan, dateStorage2, month);
        }

        for (int i = 0; i < 10; i++) {
            System.out.println("Generate random date is \t" + dateStorage[i] + ".  \tThat's \t" + dateStorage2[i]);
        }
    }
}
