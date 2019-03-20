package com.obitestvernull.commonClassesAndUtils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class CheckTheInternet {

    private static boolean isOnline(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnected()) {
            return true;
        }
        return false;
    }

    //проверяем есть ли интернет одной строкой
    public static void checkTheConnection(Context context) {
        if (CheckTheInternet.isOnline(context)) {

        } else {
            Toast.makeText(context, "отсутствует соединение с интернет", Toast.LENGTH_SHORT).show();
        }
    }

}
