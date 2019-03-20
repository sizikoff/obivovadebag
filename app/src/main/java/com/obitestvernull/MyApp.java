package com.obitestvernull;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.util.Log;

import com.appsflyer.AFInAppEventParameterName;
import com.appsflyer.AFInAppEventType;
import com.appsflyer.AppsFlyerConversionListener;
import com.appsflyer.AppsFlyerLib;
import com.obitestvernull.commonClassesAndUtils.analitics.YandexMetricaAnalitics;
import com.obitestvernull.commonClassesAndUtils.database.DatabaseWithObjects;
import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.YandexMetricaConfig;
import com.yandex.metrica.profile.GenderAttribute;

import java.util.HashMap;
import java.util.Map;

public class MyApp extends Application {

    private static final String AF_DEV_KEY = "qqKydxKXjWbNoCXtxjJYVb";

    private final String TAG = "MyApplication";

    private DatabaseWithObjects databaseWithObjects;

    public static MyApp instance;

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;
        databaseWithObjects = Room.databaseBuilder(this, DatabaseWithObjects.class, "database").allowMainThreadQueries().build();

        //пользуем эпсфлаер аналитику
        AppsFlyerConversionListener conversionDataListener = new AppsFlyerConversionListener() {

                    @Override
                    public void onInstallConversionDataLoaded(Map<String, String> conversionData) {
                        Log.i(TAG, "onInstallConversionDataLoaded");
                    }

                    @Override
                    public void onInstallConversionFailure(String errorMessage) {
                        Log.i(TAG, "onInstallConversionFailur");
                    }

                    @Override
                    public void onAppOpenAttribution(Map<String, String> attributionData) {
                        Log.i(TAG, "onAppOpenAttribution");
                    }

                    @Override
                    public void onAttributionFailure(String errorMessage) {
                        Log.i(TAG, "onAttributionFailure");
                    }
                };
        AppsFlyerLib.getInstance().init(AF_DEV_KEY, conversionDataListener, getApplicationContext());
        AppsFlyerLib.getInstance().startTracking(this, "приложение ОБИ Абрамов");

        Map<String,Object> eventValues = new HashMap<>();
        eventValues.put(AFInAppEventParameterName.REVENUE, 1200);
        eventValues.put(AFInAppEventParameterName.CURRENCY, "РУБЛИКИ ВАСЯ");
        AppsFlyerLib.getInstance().trackEvent(this, AFInAppEventType.PURCHASE, eventValues);

        //пользуем яндекс анатилитку
        // Создание расширенной конфигурации библиотеки.
        YandexMetricaConfig config = YandexMetricaConfig.newConfigBuilder(YandexMetricaAnalitics.APIKeyYandexMetrica).build();
        // Инициализация AppMetrica SDK.
        YandexMetrica.activate(getApplicationContext(), config);
        // Отслеживание активности пользователей.
        YandexMetrica.enableActivityAutoTracking(this);

        //отправляем профиль
        YandexMetricaAnalitics.sendUserProfileYandexMetrica("Петя", GenderAttribute.Gender.MALE, 35, false);

    }


    public static MyApp getInstance() {
        return instance;
    }
    public DatabaseWithObjects getDatabaseWithObjects() {
        return databaseWithObjects;
    }
}