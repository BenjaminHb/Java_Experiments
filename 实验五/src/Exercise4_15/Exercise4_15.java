package Exercise4_15;

import java.util.Scanner;

/**
 * Created by benjaminzhang on 28/03/2017.
 * Copyright © benjaminzhang 2017.
 */
public class Exercise4_15 {
    private int addressInfoNum = 0;

    private Address[] addr = new Address[10];

    private void addaddrInfo(){
        int  inputStatus = 0;
        String name, email;
        Scanner input = new Scanner(System.in);
        System.out.println("Please input name and email info:");
        do {
            System.out.println("Please input name:");
            name = input.nextLine();
            System.out.println("Please input email:");
            email = input.nextLine();
            addr[addressInfoNum] = new Address(name, email);
            addressInfoNum++;
            System.out.println("Proceed to input address info? (Yes: 1, No: 0)");
            inputStatus = input.nextInt();
            while (inputStatus!=1&&inputStatus!=0){
                System.out.println("Input ERROR!");
                System.out.println("Proceed to input address info? (Yes: 1, No: 0)");
                inputStatus = input.nextInt();
            }
            input.nextLine();
        }while (inputStatus == 1);
    }

    private void getaddrInfo(){
        System.out.println("Address informations:");
        for (int i = 0; i < addressInfoNum; i++)
            addr[i].getAddressInfo();
    }

    public static void main(String[] args) {
        Exercise4_15 addressBook = new Exercise4_15();
        addressBook.addaddrInfo();
        addressBook.getaddrInfo();
    }
}
