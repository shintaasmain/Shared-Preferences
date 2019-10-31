package com.example.sharedpreferences;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {
    private static SharedPref INSTANCE;
    private SharedPreferences sharedPreferences;

    public static final String SP_USERNAME = "spNAMA";
    private final String SP_NAME = "loginsession";
    SharedPreferences.Editor spEditor;

    public SharedPref(Context context) {
        sharedPreferences = context
                .getApplicationContext()
                .getSharedPreferences(SP_NAME, Context.MODE_PRIVATE);
        spEditor = sharedPreferences.edit();
    }

    public static SharedPref getInstance(Context context){
        if (INSTANCE == null) {
            INSTANCE = new SharedPref(context);
        }
        return INSTANCE;
    }
    public SharedPreferences pref () {
        return sharedPreferences;
    }
    public Boolean isLogin () {
        return sharedPreferences.getBoolean("isLogin",false);}

    public void setLogin(boolean isCall){
        sharedPreferences.edit().putBoolean("isLogin",isCall).apply();
    }
    public void setName(String spName){
        sharedPreferences.edit().putString(SP_USERNAME, spName).apply();
    }

    public String getName(){
        return sharedPreferences.getString(SP_USERNAME,"");
    }
}

