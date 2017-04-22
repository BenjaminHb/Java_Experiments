package SchoolInfo;

import java.util.Scanner;

/**
 * Created by benjaminzhang on 28/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class School {
    static String schoolName;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学校的名称：");
        schoolName = input.nextLine();
        System.out.println("\n学校名称为："+schoolName+"\n");

        Class class1 = new Class();
        Class class2 = new Class();

        Test.testingSystem(class1,class2);
    }
}