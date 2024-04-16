package com.epam.rd.autotasks;

import java.util.Scanner;

public class Average {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Use Scanner methods to read input
        int sum = 0;
        int count = 0;
        int actual;
        do{
            actual = sc.nextInt();
            if(actual != 0){
                sum += actual;
                count ++;
            }
        }while(actual != 0);

        System.out.println((sum/count));
    }

}