/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise2_12 {
    public static void main(String[] args) {
        String str="Java is a object oriented programming language";       //新建字符串对象
        System.out.println(str);        //输出字符串
        int wordLengthSum=0,j=0;
        int[] wordLength = new int[100];
        double avg;
        for (int i=0;i<str.length();i++){
            if (str.charAt(i)!=' ') {
                wordLengthSum++;       //统计字母总数
                wordLength[j]++;
            }
            else j++;       //统计单词总数
        }
        for (int i = 0; i <= j; i++) {      //输出每个单词的字母数
            System.out.print(wordLength[i]);
            for (int w = 0; w < wordLength[i] - (int) Math.log10(wordLength[i]); w++){      //统一输出格式，数字对齐单词
                System.out.print(" ");
            }
        }
        avg=(double)wordLengthSum/j;
        System.out.println("\n每个单词的平均字母数为 "+avg);
    }
}
