package com.example.otrstattelecom.utils;

public class URLS {
    private static final String URL_ROOT = "https://servicedesk.tattelecom.ru/";
    private static final String URL_PUSH = "http://217.23.185.198:3080";
    public static final String URL_REGISTER = URL_ROOT + "signup";
    public static final String URL_LOGIN= URL_ROOT + "login";

    public static String getUrlRoot() {
        return URL_ROOT;
    }

    public static String getUrlPush() {
        return URL_PUSH;
    }
}
