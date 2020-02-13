package com.example.crud.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

public class Preferences {
    static final String Token = "TOKEN";
    private static SharedPreferences getSharedPreferences(Context context){
        return PreferenceManager.getDefaultSharedPreferences(context);
    }

    public static void setToken(Context context,String token){
        SharedPreferences.Editor editor=getSharedPreferences(context).edit();
        editor.putString(Token,token);
        editor.apply();
    }

    public  static String getToken(Context context){
        return getSharedPreferences(context).getString(Token,"");
    }


}
