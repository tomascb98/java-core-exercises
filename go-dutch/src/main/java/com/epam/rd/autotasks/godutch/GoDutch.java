package com.epam.rd.autotasks.godutch;

import java.util.Scanner;

public class GoDutch {

    public static void main(String[] args) {
        //Write code here
        Scanner sc = new Scanner(System.in);
        int bill = sc.nextInt();
        int people = sc.nextInt();

        if(people<=0){
            System.out.println("Number of friends cannot be negative or zero");
        }else if (bill < 0){
            System.out.println("Bill total amount cannot be negative");
        }else {
            int divBill = (int) (bill*1.10)/people;
            System.out.println(divBill);
        }
    }
}
