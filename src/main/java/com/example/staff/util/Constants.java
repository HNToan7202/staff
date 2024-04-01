package com.example.staff.util;

public class Constants {
    public static final String PHONE_VN_PATTERN = "^(09|03|07|08|05)+([0-9]{8})$";
    public static final String VALID_EMAIL_PATTERN = "^[a-zA-Z0-9_+&*-]+(?:\\." +
            "[a-zA-Z0-9_+&*-]+)*@" +
            "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
            "A-Z]{2,7}$";
    public static final String DATE_PATTERN = "^([0-2][0-9]|(3)[0-1])(\\-)(((0)[0-9])|((1)[0-2]))(\\-)\\d{4}$";
    public static final String DATE_FORMAT = "dd-MM-yyyy";
    public static final String GENDER = "^(MALE|FEMALE|OTHER)$";
    public static final String ID_PATTERN = "^[0-9]{3}$";
    public static final String NAME_PATTERN = "^[\\p{L}\\s]+";






}
