package SchoolInfo;

import java.util.Scanner;

/**
 * Created by benjaminzhang on 16/04/2017.
 * Copyright © benjaminzhang 2017.
 */
class Class {
    private int classNum = 1, classPeopleNum = 1;
    private String teachername, classMasterName;

    Class(){
        classNum = 1;
        teachername = "Null";
        classMasterName = "Null";
    }

    Class(int classNum, String tearcherName, String classMasterName){
        this.classNum = classNum;
        this.teachername = tearcherName;
        this.classMasterName = classMasterName;
    }

    protected void getClassInfo(){
        System.out.println("\n"+classNum+" 班信息为：");
        System.out.println("班级人数： "+classNum);
        System.out.println("老师姓名： "+teachername);
        System.out.println("班长姓名： "+classMasterName);
        System.out.println("学生信息为：");
        for (int i = 0; i < classPeopleNum-1; i++)
            stuInClassAll[i].getStudentInfo();
    }

    private Student stuInClassAll[] = new Student[10];

    protected void addClassInfo(int classNum, String tearcherName, String classMasterName){
        this.classNum = classNum;
        this.teachername = tearcherName;
        this.classMasterName = classMasterName;
    }

    protected void addStuInfo(){
        int  inputStatus = 0;
        String name;
        int age = -1, examNum, generalGrades = 0, peGrades = 0;
        Scanner input = new Scanner(System.in);
        System.out.println("输入"+classNum+"班学生信息：");
        do {
            System.out.println("请输入学生姓名：");
            name = input.nextLine();
            System.out.println("请输入学生年龄");
            age = input.nextInt();
            System.out.println("请输入学生考号");
            examNum = input.nextInt();
            System.out.println("请输入学生综合成绩");
            generalGrades = input.nextInt();
            System.out.println("请输入学生体育成绩");
            peGrades = input.nextInt();
            stuInClassAll[classPeopleNum - 1]=new Student(name,examNum,generalGrades,peGrades);
            stuInClassAll[classPeopleNum - 1].setAgeClass(age,classNum);
            classPeopleNum++;
            System.out.println("是否继续输入下一个学生信息？（1为是，0为否）");
            inputStatus = input.nextInt();
            while (inputStatus!=1&&inputStatus!=0){     //输入错误，重新输入
                System.out.println("输入错误，请重新输入！");
                inputStatus = input.nextInt();
            }
            input.nextLine();
        }while (inputStatus == 1);
    }
}
