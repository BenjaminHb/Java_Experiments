/**
 * Created by benjaminzhang on 15/05/2017.
 * Copyright © benjaminzhang 2017.
 */

class Student {
    protected void study() {
        System.out.println("I'm studying.");
    }

    protected void doHomework() {
        System.out.println("I'm doing my homework.");
    }

    protected void attendClass() {
        System.out.println("I'm attend classes and listening.");
    }
}

class JuniorSchoolStudent extends Student {
    protected void juniorschool() {
        System.out.println("I'm studying in junior school.");
    }
}

class MiddleSchoolStudent extends Student {
    protected void middleschool() {
        System.out.println("I'm studying in middle school.");
    }
}

class CollegeStudent extends Student {
    protected void college() {
        System.out.println("I'm studying in college.");
    }
}

public class Exercise5_3 {
    public static void main(String[] args) {
        JuniorSchoolStudent stu1 = new JuniorSchoolStudent();
        MiddleSchoolStudent stu2 = new MiddleSchoolStudent();
        CollegeStudent stu3 = new CollegeStudent();
        System.out.println("Junior school student stu1:");
        stu1.study();
        stu1.doHomework();
        stu1.attendClass();
        stu1.juniorschool();
        System.out.println("\nMiddle school student stu2:");
        stu2.study();
        stu2.doHomework();
        stu2.attendClass();
        stu2.middleschool();
        System.out.println("\nCollege student stu3:");
        stu3.study();
        stu3.doHomework();
        stu3.attendClass();
        stu3.college();
    }
}
