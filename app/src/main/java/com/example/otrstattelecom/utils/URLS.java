package com.example.otrstattelecom.utils;

public class URLS {
    private static final String URL_ROOT = "http://192.168.111.119/";
    public static final String URL_REGISTER = URL_ROOT + "signup";
    public static final String URL_LOGIN= URL_ROOT + "login";

    public static String getUrlRoot() {
        return URL_ROOT;
    }
}
