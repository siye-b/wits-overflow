package com.example.witsly;

import java.util.regex.Pattern;

public class Verifier {

    private static final Pattern EMAIL_ADDRESS =
            Pattern.compile(
                    "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}"
                            + // between 1 and 256 characters which contain alphanumeric characters and certain
                            // acceptable symbols
                            "\\@"
                            + // @ sign
                            "(students.wits.ac.za|wits.ac.za)" // two Wits associated domains
            );

    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile(
                    "^"
                            + "(?=.*[0-9])"
                            + // at least 1 digit
                            "(?=.*[a-z])"
                            + // at least 1 lower case letter
                            "(?=.*[A-Z])"
                            + // at least 1 upper case letter
                            "(?=.*[a-zA-Z])"
                            + // any upper or lower case letter
                            "(?=.*[@#$%^&+=!])"
                            + // at least 1 special character
                            "(?=\\S+$)"
                            + // no white spaces
                            ".{8,}"
                            + // at least 8 characters
                            "$");


    public boolean verifyPassword(String password){
        return PASSWORD_PATTERN.matcher(password).matches();
    }

    public boolean verifyEmail(String email){
        return EMAIL_ADDRESS.matcher(email).matches();
    }
}
