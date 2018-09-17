package com.zcj.blg.phoneanswer.util;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.zcj.blg.phoneanswer.activity.MyApplication;

public class SharePreferencTools {

    private static SharedPreferences mSharedPreferences;

    public static void putBoolean(String key, boolean value) {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
        }
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.commit();
    }

    public static boolean getBoolean(String key, boolean defValue) {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
        }
        boolean result = mSharedPreferences.getBoolean(key, defValue);
        return result;
    }

    public static void putString(String key, String value) {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
        }
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public static String getString(String key, String defValue) {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
        }
        return mSharedPreferences.getString(key, defValue);
    }

    public static void putInt(String key, int value) {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
        }
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    public static int getInt(String key, int defValue) {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
        }
        return mSharedPreferences.getInt(key, defValue);
    }

    public static void putLong(String key, long value) {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
        }
        final SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putLong(key, value);
        editor.commit();
    }

    public static long getLong(String key, int defValue) {
        if (mSharedPreferences == null) {
            mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(MyApplication.getContext());
        }
        return mSharedPreferences.getLong(key, defValue);
    }


}