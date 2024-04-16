package com.epam.rd.autotasks.meetstrangers;

import java.io.IOException;
import java.util.Scanner;

public class HelloStrangers {
    public static void main(String[] args) throws IOException {
        //Write a program, asks for a number - amount of strangers to meet.
        //Then reads stranger names line by line and prints line by line "Hello, ...".
        Scanner sc = new Scanner(System.in);
        int strangers = sc.nextInt();

        if (strangers == 0){
            System.out.println("Oh, it looks like there is no one here");
        } else if(strangers < 0){
            System.out.println("Seriously? Why so negative?");
        } else{
            sc.nextLine();
            String[] names = new String[strangers];
            for (int i=0 ; i<strangers; i++){
                names[i] = sc.nextLine();
            }
            for (int i = 0 ; i < strangers ; i++){
                System.out.println("Hello, " + names[i]);
            }
        }
    }
}
