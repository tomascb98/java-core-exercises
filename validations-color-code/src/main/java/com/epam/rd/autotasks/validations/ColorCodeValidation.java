package com.epam.rd.autotasks.validations;

import java.util.regex.Pattern;

public class ColorCodeValidation {
    public static boolean validateColorCode(String color) {
        if(color == null || color.isEmpty() || color.isBlank()) return false;
        String pattern = "^#[a-fA-F0-9]{3}$|^#[a-fA-F0-9]{6}$";
        return Pattern.matches(pattern, color);

    }
}





