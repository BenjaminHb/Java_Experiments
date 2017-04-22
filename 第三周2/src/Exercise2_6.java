import java.util.Scanner;

/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise2_6 {
    public static void main(String[] args) {
        int status=-1,month;
        System.out.println("请输入月份：");
        Scanner input=new Scanner(System.in);
        do {        //检测输入月份是否合法
            month=input.nextInt();
            if (month>0&&month<13)  status=0;
            if (status==-1) System.out.println("输入错误，请重新输入月份：");
        }while (status!=0);
        switch (month){
            case 1:
                System.out.println("当前月份 "+month+" 月有 31 天");
                break;
            case 2:
                System.out.println("当前月份 "+month+" 月有 28 或 29 天");
                break;
            case 3:
                System.out.println("当前月份 "+month+" 月有 31 天");
                break;
            case 4:
                System.out.println("当前月份 "+month+" 月有 30 天");
                break;
            case 5:
                System.out.println("当前月份 "+month+" 月有 31 天");
                break;
            case 6:
                System.out.println("当前月份 "+month+" 月有 30 天");
                break;
            case 7:
                System.out.println("当前月份 "+month+" 月有 31 天");
                break;
            case 8:
                System.out.println("当前月份 "+month+" 月有 31 天");
                break;
            case 9:
                System.out.println("当前月份 "+month+" 月有 30 天");
                break;
            case 10:
                System.out.println("当前月份 "+month+" 月有 31 天");
                break;
            case 11:
                System.out.println("当前月份 "+month+" 月有 30 天");
                break;
            case 12:
                System.out.println("当前月份 "+month+" 月有 31 天");
                break;
        }
    }
}
