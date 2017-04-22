package SchoolInfo;

/**
 * Created by benjaminzhang on 16/04/2017.
 * Copyright © benjaminzhang 2017.
 */
class Student {
    private String name;
    private int age = -1, classNum = 1, examNum, generalGrades = 0, peGrades = 0;

    Student(String name, int examNum, int generalGrades, int peGrades){
        this.name = name;
        this.examNum = examNum;
        this.generalGrades = generalGrades;
        this.peGrades = peGrades;
    }

    protected void setAgeClass(int age, int classNum){
        this.age = age;
        this.classNum = classNum;
    }

    protected void getStudentName(){
        System.out.println("姓名为 "+name);
    }

    protected void getStudentInfo(){
        System.out.println("姓名："+name+"\t年龄："+age+"\t班级："+classNum+"\t考号："+examNum+"\t综合成绩："+generalGrades+"\t体育成绩："+peGrades);
    }

}