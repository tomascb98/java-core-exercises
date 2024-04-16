package com.epam.rd.autotasks.pizzasplit;

import java.util.Scanner;

public class PizzaSplit {
    public static void main(String[] args) {
        //Write a program, reading number of people and number of pieces per pizza and then
        //printing minimum number of pizzas to order to split all the pizzas equally and with no remainder
        Scanner sc = new Scanner(System.in);
        int people = sc.nextInt();
        int slices = sc.nextInt();
        boolean flag = true;
        int numberOfPizzas = 1;

        while(flag){
            double numberPizzas = (double) slices*numberOfPizzas/people % 1d;
            if(numberPizzas == 0){
                System.out.println(numberOfPizzas);
                break;
            } else {
                numberOfPizzas++;
            }
        }


    }
}
