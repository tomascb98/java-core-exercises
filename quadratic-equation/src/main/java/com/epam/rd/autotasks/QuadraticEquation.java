package com.epam.rd.autotasks;

import java.util.Locale;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class QuadraticEquation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in).useLocale(Locale.US);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();

        double x1 = (-b + Math.sqrt(b*b - 4*a*c))/(2*a);
        double x2 = (-b - Math.sqrt(b*b - 4*a*c))/(2*a);

        if(x1!=x2 && !(Double.isNaN(x1) && Double.isNaN(x2))){
            System.out.println(x1 + " " + x2);
        }else if(x1 == x2 && !(Double.isNaN(x1) && Double.isNaN(x2))){
            System.out.println(x1);
        } else {
            System.out.println("no roots");
        }

    }

}