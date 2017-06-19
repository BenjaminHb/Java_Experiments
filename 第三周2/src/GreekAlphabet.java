/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class GreekAlphabet {
    public static void main(String[] args) {
        for (char i = 'α'; i <= 'ω'; i++) {
            System.out.print(i+" ");
        }
        System.out.println();
        for (char i = 'Α'; i <= 'Ω'; i++) {
            if (i!='\u03A2')   System.out.print(i+" ");
            else    System.out.print("Σ ");     //特殊情况处理
        }
    }
}
