package com.obitestvernull.theNullModule;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.geolocationcheckautomaticly.R;
import com.google.firebase.crash.FirebaseCrash;
import com.obitestvernull.commonClassesAndUtils.CheckTheInternet;
import com.obitestvernull.commonClassesAndUtils.analitics.AppsFlyerAnalitics;
import com.obitestvernull.commonClassesAndUtils.analitics.GoogleAnalitics;
import com.obitestvernull.commonClassesAndUtils.analitics.SentryAnalitics;
import com.obitestvernull.commonClassesAndUtils.analitics.YandexMetricaAnalitics;
import com.obitestvernull.firstModuleNearestStore.activityOne.ActivityModuleOne;
import com.obitestvernull.ActivityVova.ActivityVova;
import com.obitestvernull.secondModuleCitiesAndStores.activityTwo.SecondModuleActivity;


public class TheNullActivity extends AppCompatActivity {

    Button buttonTheNearestStore, buttonGetOtherStoreInNullAct,akzii;
    private String TAG = "TheNullActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_the_null);

        CheckTheInternet.checkTheConnection(this);

        FirebaseCrash.log("нулевая активность создана");
        FirebaseCrash.logcat(Log.ERROR, TAG, "NPE caught");
        Throwable e = new Throwable();
        FirebaseCrash.report(e);
        akzii = findViewById(R.id.akzii);
        buttonTheNearestStore = findViewById(R.id.buttonTheNearestStore);
        buttonGetOtherStoreInNullAct = findViewById(R.id.buttonGetOtherStoreInNullAct);

        buttonGetOtherStoreInNullAct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //пользуем сентра аналитик
                SentryAnalitics.sendSentryAnaliticMessage(getBaseContext(), "произвольное сообщение - пользователь выбрал ручной поиск магазов");
                SentryAnalitics.sendSentryAnaliticERRORwithBreadcrumbMessage(getBaseContext(), "хлебная кроха, выбрал все ручками");

                //пользуем яндекс метрику
                YandexMetricaAnalitics.sendMessageYandexMetrica(getBaseContext(), "произвольное сообщение - пользователь выбрал ручной поиск магазов");

                //пользуем гугл файербез аналитик
                GoogleAnalitics.sendMessageGoogleFireBaseAnalitics(getBaseContext(), "0123", "Васек", "Нажал кнопочку РУКАМИ ВЫБРАТЬ МАГАЗИН");

                //пользуем эппсфлайер аналитику
                AppsFlyerAnalitics.sendMessageAppsFlyerAnalitics(getBaseContext(), "произвольное сообщение - пользователь выбрал ручной поиск магазов");

                Intent intent =  new Intent(getBaseContext(), SecondModuleActivity.class);
                startActivity(intent);
            }
        });

        buttonTheNearestStore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //пользуем сентра аналитик
                SentryAnalitics.sendSentryAnaliticMessage(getBaseContext(), "произвольное сообщение - пользователь выбрал автоматический поиск магазов");
                SentryAnalitics.sendSentryAnaliticERRORwithBreadcrumbMessage(getBaseContext(), "хлебная кроха, выбрал все автоматически");

                //пользуем яндекс метрику
                YandexMetricaAnalitics.sendMessageYandexMetrica(getBaseContext(), "произвольное сообщение - пользователь выбрал автоматический поиск магазов");

                //пользуем гугл файербез аналитик
                GoogleAnalitics.sendMessageGoogleFireBaseAnalitics(getBaseContext(), "0123", "Петруха", "Нажал кнопочку ВСЕ НА АВТОМАТЕ ХОЧУ");

                //пользуем эппсфлайер аналитику
                AppsFlyerAnalitics.sendMessageAppsFlyerAnalitics(getBaseContext(), "Нажал кнопочку ВСЕ НА АВТОМАТЕ ХОЧУ");

                Intent intent = new Intent(getBaseContext(), ActivityModuleOne.class);
                startActivity(intent);
            }
        });

        akzii.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(TheNullActivity.this, ActivityVova.class);
                startActivity(intent);
            }
        });
    }
}
