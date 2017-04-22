/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Calculate_X {
    double output=1;
    void Calculate(double x, int n) {
        if (n==0)   output=1;       //考虑特殊情况
        else {
            output*=x;
            n--;
            if (n>0)    Calculate(x,n);     //递归调用自己
        }
    }
    public static void main(String[] args) {
        double x=Double.parseDouble(args[0]);       //将字符串转换为双精度浮点数
        int n=Integer.parseInt(args[1]);        //将字符串转换为整数
        Calculate_X input=new Calculate_X();        //新建对象
        input.Calculate(x,n);       //调用方法
        System.out.println("x^n= "+input.output);
    }
}
