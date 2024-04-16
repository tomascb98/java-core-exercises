package com.epam.rd.autotasks.snail;

import java.util.Scanner;

public class Snail
{
    public static void main(String[] args)
    {
        //Write a program that reads a,b and h (line by lyne in this order) and prints
        //the number of days for which the snail reach the top of the tree.
        //a - feet that snail travels up each day, b - feet that slides down each night, h - height of the tree
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int h = sc.nextInt();

        if(a<=b && h>a){
            System.out.println("Impossible");
        } else {
            int dias = 0;
            int alturaActual=0;

            do {
                alturaActual += a;
                dias++;
                if(alturaActual>=h){
                    break;
                } else {
                    alturaActual -= b;
                }
            }while (alturaActual <= h);
            System.out.println(dias);
        }

    }
}
