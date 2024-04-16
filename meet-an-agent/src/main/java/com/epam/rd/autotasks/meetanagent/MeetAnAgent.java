package com.epam.rd.autotasks.meetanagent;

import java.util.Scanner;

public class MeetAnAgent {
    final static int PASSWORD = 133976; //You can change pass, but don't change the type

    public static void main(String[] args) {
        //put you code here if the input equals to the secret password number, prints "Hello, Agent",
        //otherwise, prints "Access denied".
        Scanner sc = new Scanner(System.in);
        int pass = sc.nextInt();
        if(pass == PASSWORD){
            System.out.println("Hello, Agent");
        } else {
            System.out.println("Access denied");
        }
    }
}
