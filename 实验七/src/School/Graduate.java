package School;

import java.util.Scanner;

/**
 * Created by bnjaminzhang on 15/05/2017.
 * Copyright © benjaminzhang 2017.
 */
class Graduate implements StudentManageInterface, TeacherManageInterface {
    private String name;
    private String sex;
    private int age;
    private double fee;
    private double pay;

    public static void main(String[] args) {
        Graduate stu = new Graduate();
        stu.name = "zhangsan";
        System.out.println("Graduate name: "+stu.name+"\nPlease input graduate "+stu.name+"'s gender: (Male or Female)");
        Scanner input = new Scanner(System.in);
        stu.sex = input.nextLine();
        System.out.println("Please set graduate "+stu.name+"'s age:");
        stu.age = input.nextInt();
        System.out.println("Please set graduate "+stu.name+"'s fee:");
        stu.setFee(input.nextDouble());
        System.out.println("Please set graduate "+stu.name+"'s pay:");
        stu.setPay(input.nextDouble());

        System.out.println("\nGraduate "+stu.name+": " + stu.sex);
        System.out.println("Graduate "+stu.name+"'s age is " + stu.age);
        System.out.println("Graduate "+stu.name+"'s fee is " + stu.getFee());
        System.out.println("Graduate "+stu.name+"'s pay is " + stu.getPay());
        System.out.println("Graduate "+stu.name+"'s annual fee is " + 12 * stu.getFee());
        System.out.println("Graduate "+stu.name+"'s annual pay is " + 12 * stu.getPay());
        System.out.println();
        if (12 * (stu.getPay() - stu.getFee()) - 2000 >= 0)
            System.out.println("Status: NORMAL");
        else
            System.out.println("Status: PROVIDEALOAN");
    }

    public double getFee() {
        return fee;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public double getPay() {
        return pay;
    }

    public void setPay(double pay) {
        this.pay = pay;
    }
}