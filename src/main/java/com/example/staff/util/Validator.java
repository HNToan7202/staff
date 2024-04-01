package com.example.staff.util;


import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validator {
    public static Matcher matcher = null;
    public static Pattern pattern = null;

    public static boolean isGender(String gender) {
        pattern = Pattern.compile(Constants.GENDER);
        matcher = pattern.matcher(gender);
        return matcher.matches();
    }
    public static boolean isPhoneNumber(String number) {
        pattern = Pattern.compile(Constants.PHONE_VN_PATTERN);
        matcher = pattern.matcher(number);
        return matcher.matches();
    }
    public static boolean isDate(String date) {
        pattern = Pattern.compile(Constants.DATE_PATTERN);
        matcher = pattern.matcher(date);
        return matcher.matches();
    }
    public static boolean isEmail(String email) {
        pattern = Pattern.compile(Constants.VALID_EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        return matcher.matches();
    }
    public static boolean isName(String name) {
        pattern = Pattern.compile(Constants.NAME_PATTERN);
        matcher = pattern.matcher(name);
        return matcher.matches();
    }

}
