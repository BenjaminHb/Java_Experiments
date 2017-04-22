/**
 * Created by benjaminzhang on 20/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Hex_to_Dec {
    public static void main(String[] args) {
        long outputDec = Integer.parseInt(args[0],16);      //将字符串转换为整数
        System.out.println("十六进制数 "+args[0]+"，十进制数 "+outputDec+"。");
    }
}
