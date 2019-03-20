package com.obitestvernull.commonClassesAndUtils.analitics;

import android.content.Context;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerLib;

import java.util.HashMap;
import java.util.Map;

public class AppsFlyerAnalitics {

    public static void sendMessageAppsFlyerAnalitics(Context context, String paramName) {
        Map<String,Object> eventValues = new HashMap<>();
        eventValues.put(AFInAppEventParameterName.REVENUE, 1200);
        eventValues.put(AFInAppEventParameterName.CURRENCY, paramName);
        AppsFlyerLib.getInstance().trackEvent(context, AFInAppEventType.PURCHASE, eventValues);
    }
}
