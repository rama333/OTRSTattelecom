package com.example.otrstattelecom.utils;

public class URLS {
    private static final String URL_ROOT = "http://192.168.143.133/";
    private static final String URL_PUSH = "http://192.168.114.145/";
    public static final String URL_REGISTER = URL_ROOT + "signup";
    public static final String URL_LOGIN= URL_ROOT + "login";

    public static String getUrlRoot() {
        return URL_ROOT;
    }

    public static String getUrlPush() {
        return URL_PUSH;
    }
}
