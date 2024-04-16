package com.epam.rd.autotasks.meetautocode;

import java.text.DecimalFormat;
import java.time.LocalTime;
import java.util.Scanner;

public class ElectronicWatch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seconds = scanner.nextInt();
        double hours = (seconds>=86400) ? ((seconds-86400)/60d)/60 : (seconds/60d)/60;
        double minutes = (hours - (int) hours)*60;
        double seconds1 = (minutes - (int) minutes)*60;

        DecimalFormat decimalFormat = new DecimalFormat("00");
        String minutes1 = decimalFormat.format(Math.floor(minutes));
        String seconds3 = decimalFormat.format(seconds1);

        System.out.println((int) hours + ":" + minutes1 + ":" + seconds3);
    }
}
