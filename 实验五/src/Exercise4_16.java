import java.util.Scanner;

/**
 * Created by benjaminzhang on 28/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise4_16 {
    private static class LengthType {
        private double length;
        private String type = "Null";
    }

    private static double ft2M = 0.3048, ft2Cm = 30.48, ft2In = 12;
    private static double in2Ft = 1.0 / ft2In, in2M = 0.0254, in2Cm = 2.54;
    private static double m2Cm = 100, m2Ft = 3.2808399, m2In = 39.3700787;
    private static double cm2M = 0.01, cm2Ft = 0.0328084, cm2In = 0.3937008;

    private static void ioCtrl(int io, LengthType ioLengthType){
        int unit;
        Scanner input = new Scanner(System.in);
        System.out.print("\nPlease select ");
        if (io == 0)
            System.out.print("input");
        if (io == 1)
            System.out.print("output");
        System.out.println(" unit:");
        System.out.println("1: ft\t\t2: in");
        System.out.println("3: m\t\t4: cm");

        unit = input.nextInt();
        while (unit<1||unit>4){
            System.out.println("Input ERROR!");
            System.out.print("\nPlease select ");
            if (io == 0)
                System.out.print("input");
            if (io == 1)
                System.out.print("output");
            System.out.println(" unit:");
            System.out.println("1: ft\t\t2: in");
            System.out.println("3: m\t\t4: cm");
            unit = input.nextInt();
        }
        switch (unit){
            case 1: ioLengthType.type = "ft";break;
            case 2: ioLengthType.type = "in";break;
            case 3: ioLengthType.type = "m";break;
            case 4: ioLengthType.type = "cm";break;
        }
        if (io == 0){
            System.out.println("\nPlease input "+ioLengthType.type);
            ioLengthType.length = input.nextDouble();
        }
    }

    private static void convertCtrl(LengthType inConvertLength, LengthType outConvertLength){
        switch (inConvertLength.type){
            case "ft":switch (outConvertLength.type){
                case "ft": outConvertLength.length = inConvertLength.length;break;
                case "in": outConvertLength.length = inConvertLength.length * ft2In;break;
                case "m": outConvertLength.length = inConvertLength.length * ft2M;break;
                case "cm": outConvertLength.length = inConvertLength.length * ft2Cm;break;
            }break;
            case "in":switch (outConvertLength.type){
                case "ft": outConvertLength.length = inConvertLength.length * in2Ft;break;
                case "in": outConvertLength.length = inConvertLength.length;break;
                case "m": outConvertLength.length = inConvertLength.length * in2M;break;
                case "cm": outConvertLength.length = inConvertLength.length * in2Cm;break;
            }break;
            case "m":switch (outConvertLength.type){
                case "ft": outConvertLength.length = inConvertLength.length * m2Ft;break;
                case "in": outConvertLength.length = inConvertLength.length * m2In;break;
                case "m": outConvertLength.length = inConvertLength.length;break;
                case "cm": outConvertLength.length = inConvertLength.length * m2Cm;break;
            }break;
            case "cm":switch (outConvertLength.type){
                case "ft": outConvertLength.length = inConvertLength.length * cm2Ft;break;
                case "in": outConvertLength.length = inConvertLength.length * cm2In;break;
                case "m": outConvertLength.length = inConvertLength.length * cm2M;break;
                case "cm": outConvertLength.length = inConvertLength.length;break;
            }break;
        }
        System.out.print("\n"+inConvertLength.length+" "+inConvertLength.type+
                " >>>> "+outConvertLength.length+" "+outConvertLength.type);
    }

    public static void main(String[] args) {
        LengthType inLength = new LengthType();
        LengthType outLength = new LengthType();
        System.out.println("Length converter");
        ioCtrl(0,inLength);
        ioCtrl(1,outLength);
        convertCtrl(inLength, outLength);
    }
}
