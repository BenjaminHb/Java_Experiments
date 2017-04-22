import java.util.Scanner;

/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise2_7 {
    public static void main(String[] args) {
        int num=0,primeStatus=0,status=0;
        int[] prime=new int[100];
        Scanner input=new Scanner(System.in);       //新建一个对象来扫描用户的输入
        System.out.println("请输入一个整数：");
        int inputInt=input.nextInt();
        for (int i=1;i<=inputInt;i++){
            for (int j=2;j<i;j++){
                if (i%j==0) {       //判断i是不是为素数
                    status = -1;
                }
            }
            if (status==0) {        //若i是素数
                for (int w = 0; w <= num; w++) {        //检测数组里是否已经存在这个素数
                    if (prime[w] == i) primeStatus = 1;
                }
                if (primeStatus == 0) {         //若数组里不存在这个素数，测将其添加到数组中
                    prime[num] = i;
                    num++;
                }
                primeStatus = 0;        //恢复环境
            }
            status=0;       //恢复环境
        }
        if (num==0||inputInt<=1)  System.out.println("输入的整数 "+inputInt+" 内不存在素数");
        else {
            System.out.println("输入的整数 "+inputInt+" 内的素数为 ");
            for (int i=1;i<num;i++){
                System.out.print(prime[i]+" ");
            }
            System.out.println();
        }
    }
}
