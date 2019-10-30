package com.example.sharedpreferences.helper;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPref {

    private static SharedPref INSTANCE;
    private SharedPreferences sharedPreferences;


    private SharedPref(Context context) {
        sharedPreferences = context
                .getApplicationContext()
                .getSharedPreferences("com.example.sharedpreferences", Context.MODE_PRIVATE);
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
        }


