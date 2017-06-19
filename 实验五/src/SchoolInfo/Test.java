package SchoolInfo;

/**
 * Created by benjaminzhang on 16/04/2017.
 * Copyright © benjaminzhang 2017.
 */
class Test {
    static void testingSystem(Class a, Class b){
        System.out.println("Entering testing sequence...");     //进入测试类
        a.addClassInfo(1,"SnowFly","ClassMasterTest1");
        b.addClassInfo(2,"SnowFlyLi","ClassMasterTest2");

        a.addStuInfo();
        b.addStuInfo();

        a.getClassInfo();
        b.getClassInfo();
        System.out.println("\nTesting sequence completed...");      //退出测试类
    }
}
