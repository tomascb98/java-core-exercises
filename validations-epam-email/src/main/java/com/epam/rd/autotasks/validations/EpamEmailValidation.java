package com.epam.rd.autotasks.validations;

import java.util.regex.Pattern;

public class EpamEmailValidation {

    public static boolean validateEpamEmail(String email) {
        if(email == null || email.isEmpty() || email.isBlank()) return false;
        String emailPattern = "^[a-zA-Z]+_[a-zA-Z]+[0-9]?@epam.com$";
        return Pattern.matches(emailPattern, email);

    }
}





