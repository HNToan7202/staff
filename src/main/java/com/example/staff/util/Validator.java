package com.example.staff.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static Matcher matcher = null;
    public static Pattern pattern = null;


    public static boolean isPhoneNumber(String number) {
        pattern = Pattern.compile(Constants.PHONE_NUMBER);
        matcher = pattern.matcher(number);
        return matcher.matches();
    }
    public static boolean isDate(String date) {
        pattern = Pattern.compile(Constants.DATE);
        matcher = pattern.matcher(date);
        return matcher.matches();
    }
    public static boolean isEmail(String email) {
        pattern = Pattern.compile(Constants.EMAIL);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }

}
