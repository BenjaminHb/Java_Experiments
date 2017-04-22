/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise2_5 {
    public static void main(String[] args) {
        int num=1678,temp=num,i=0;
        int[] array=new int[10];
        System.out.println("\tn = "+num);
        System.out.print("n的每一位数字是 ");
        for (;num>0;i++){       //循环取每一位的数字
            array[i]=num%10;
            num=num/10;
        }
        for (;i>0;i--){
            System.out.print(array[i-1]);
            if (i!=1)  System.out.print(",");       //最后一位数字后不输出'，'
        }
        System.out.println("。");
    }
}
