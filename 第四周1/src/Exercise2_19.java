import java.util.Scanner;

/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise2_19 {
    public static void main(String[] args) {
        String str = new String();
        StringBuffer strBuf = new StringBuffer();
        Exercise2_19 exercise = new Exercise2_19();
        Scanner input = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String inputStr = input.nextLine();
        System.out.println("输入的字符串为：\n" + inputStr + "\nString类型变量的初始值为：\n" + str + "\nStringBuffer类型变量的初始值为：\n" + strBuf);
        exercise.LinkStr(str, strBuf, inputStr);
        System.out.println("将输入的字符串连接到这两个变量后\nString类型变量的初始值为：\n" + str + "\nStringBuffer类型变量的初始值为：\n" + strBuf);
    }

    void LinkStr(String str, StringBuffer strBuf, String inputstr) {
        str = str + inputstr;
        strBuf = strBuf.append(inputstr);
    }
}
