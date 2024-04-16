package com.epam.rd.autotasks.sequence;
import java.util.Scanner;

public class FindMaxInSeq {
    public static int max() {

        // Put your code here
        Scanner sc = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int actual;
        do{
            actual = sc.nextInt();
            if(actual>max && actual != 0){
                max = actual;
            }
        }while(actual != 0);

        return max;
    }

    public static void main(String[] args) {

        System.out.println("Test your code here!\n");

        // Get a result of your code

        System.out.println(max());
    }
}
