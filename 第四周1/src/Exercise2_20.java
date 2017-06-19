import java.util.Scanner;

/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise2_20 {
    public static void main(String[] args) {
        String str;
        Scanner input = new Scanner(System.in);
        System.out.println("请输入学生们的成绩：（用空格分割每个学生的成绩）");
        str = input.nextLine();
        double[] inputGrades = new double[100];
        double sum = 0, avg, s = 0, s_Temp;
        int gradesNum = 0, i = 0;
        StringBuffer strBuf = new StringBuffer();
        do {        //
            if (i < str.length() && str.charAt(i) != ' ') {     //检测空格
                strBuf.append(str.charAt(i));
            } else {
                inputGrades[gradesNum] = Double.parseDouble(strBuf.toString());     //存储成绩
                sum += inputGrades[gradesNum];
                gradesNum++;
                strBuf.setLength(0);
            }
            i++;
        } while (i <= str.length());
        avg = sum / gradesNum;      //计算平均成绩
        for (int j = 0; j < gradesNum; j++) {      //计算方差
            s_Temp = Math.pow(inputGrades[j] - avg, 2);
            s += s_Temp;
        }
        s = s / gradesNum;
        s = Math.sqrt(s);
        System.out.println("学生们的平均成绩为：" + avg + "\n学生们的成绩的标准方差为：" + s);
    }
}
