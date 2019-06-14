package com.vistalis.php_codes.Helpers;

import android.content.Context;
import android.content.SharedPreferences;
import java.lang.String;


public class SharedPref {

    public static String PREF_FILE = "learn_php";

        /**
         * Set a string shared preference
         * @param key - Key to set shared preference
         * @param value - Value for the key
         */
        public static void setSharedPreferenceString(Context context, java.lang.String key, java.lang.String value)
        {
            SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putString(key, value);
            editor.apply();
        }

        /**
         * Set a integer shared preference
         * @param key - Key to set shared preference
         * @param value - Value for the key
         */
        public static void setSharedPreferenceInt(Context context, java.lang.String key, int value)
        {
            SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putInt(key, value);
            editor.apply();
        }

        public static void setSharedPreferenceLong(Context context, java.lang.String key, long value)
        {
            SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putLong(key, value);
            editor.apply();
        }

        /**
         * Set a Boolean shared preference
         * @param key - Key to set shared preference
         * @param value - Value for the key
         */
        public static void setSharedPreferenceBoolean(Context context, java.lang.String key, boolean value)
        {
            SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
            SharedPreferences.Editor editor = settings.edit();
            editor.putBoolean(key, value);
            editor.apply();
        }

        /**
         * Get a string shared preference
         * @param key - Key to look up in shared preferences.
         * @param defValue - Default value to be returned if shared preference isn't found.
         * @return value - String containing value of the shared preference if found.
         */
        public static java.lang.String getSharedPreferenceString(Context context, java.lang.String key, java.lang.String defValue){
            SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
            return settings.getString(key, defValue);
        }

        /**
         * Get a integer shared preference
         * @param key - Key to look up in shared preferences.
         * @param defValue - Default value to be returned if shared preference isn't found.
         * @return value - String containing value of the shared preference if found.
         */
        public static int getSharedPreferenceInt(Context context, java.lang.String key, int defValue)
        {
            SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
            return settings.getInt(key, defValue);
        }

        /**
         * Get a boolean shared preference
         * @param key - Key to look up in shared preferences.
         * @param defValue - Default value to be returned if shared preference isn't found.
         * @return value - String containing value of the shared preference if found.
         */
        public static boolean getSharedPreferenceBoolean(Context context, java.lang.String key, boolean defValue)
        {
            SharedPreferences settings = context.getSharedPreferences(PREF_FILE, 0);
            return settings.getBoolean(key, defValue);
        }


}
