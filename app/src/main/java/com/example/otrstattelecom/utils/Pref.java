package com.example.otrstattelecom.utils;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

import com.example.otrstattelecom.model.Token;
import com.example.otrstattelecom.view.LoginActivity;


public class Pref {
    public static final String EXTRA_USER = "USERID";

    private static final String SHARED_PREF_NAME = "preftest";
    private static final String KEY_TOKEN = "user_token";
    private static final String KEY_PASSWORD = "user_password";
    private static final String KEY_ID = "user_id";
    private static final String KEY_SPEC = "user_spec";
    private static final String KEY_IS_LOGGED_IN = "is_logged_in";
    private static Pref mInstance;
    private static Context mCtx;

    private Pref (Context context) {
        mCtx = context;
    }

    public static synchronized Pref getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new Pref(context);
        }
        return mInstance;
    }

    public void setUserLogin(String token, String userId) {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_TOKEN, token);
        editor.putString(EXTRA_USER, userId);

        editor.putBoolean(KEY_IS_LOGGED_IN,true);
        editor.apply();
    }
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public Token getToken() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return new Token(
                sharedPreferences.getString(KEY_TOKEN, null)

        );
    }

    public String getUserId(){
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        return sharedPreferences.getString(EXTRA_USER, null);
    }

    public void logout() {
        SharedPreferences sharedPreferences = mCtx.getSharedPreferences(SHARED_PREF_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
        mCtx.startActivity(new Intent(mCtx, LoginActivity.class));
    }

}
