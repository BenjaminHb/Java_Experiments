import java.util.Scanner;

/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise2_9 {
    public static void main(String[] args) {
        int inputNum,temp;
        Scanner input=new Scanner(System.in);       //新建一个对象来扫描用户的输入
        System.out.println("请输入要输入的整数个数：");
        do {
            inputNum=input.nextInt();
            if (inputNum<=0)    System.out.println("输入有误，请重新输入要输入的整数个数：");      //检测用户的输入是否合法
        }while (inputNum<=0);

        int[] num=new int[inputNum];
        for (int i=1;i<=inputNum;i++){
            System.out.println("请输入第 "+i+" 个整数");
            temp=input.nextInt();       //扫描用户的输入
            num[i-1]=temp;
        }

        for (int i=0;i<inputNum;i++){       //冒泡排序
            for (int j=inputNum-1;j>i;j--){
                if (num[i]>num[j]){
                    temp=num[i];
                    num[i]=num[j];
                    num[j]=temp;
                }
            }
        }
        System.out.println("输入的整数中最大的为 "+num[inputNum-1]+" ，最小为 "+num[0]+" 。\n经过排序后，由小到大的序列为");
        for (int i=0;i<inputNum;i++){       //输出结果
            System.out.print(num[i]+" ");
        }
    }
}
