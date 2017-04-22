/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise2_12 {
    public static void main(String[] args) {
        String str="Java is an object oriented programming language";       //新建字符串对象
        System.out.println(str);        //输出字符串
        int wordLength=0,j=0;
        double avg;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)!=' ') wordLength++;       //统计字母总数
            else j++;       //统计单词总数
        }
        avg=(double)wordLength/j;
        System.out.println("每个单词的平均字母数为 "+avg);
    }
}
