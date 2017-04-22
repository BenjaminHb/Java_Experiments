/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Prime_Judge {
    public static void main(String[] args) {
        int status=0,input;
        input=Integer.valueOf(args[0]);     //将字符串转换为整数
        for (int i=1;i<input;i++){
            if (input%i==0)     status++;       //记录检测过程中的是否是素数的情况
        }
        if (status>1||input<=1)     System.out.println("No, "+input+" is not a prime!");
        else     System.out.println("Yes, " + input+" is a prime!");
    }
}
