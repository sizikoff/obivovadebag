package com.obitestvernull.commonClassesAndUtils.analitics;

import android.content.Context;

import com.yandex.metrica.YandexMetrica;
import com.yandex.metrica.profile.Attribute;
import com.yandex.metrica.profile.GenderAttribute;
import com.yandex.metrica.profile.UserProfile;

public class YandexMetricaAnalitics {

    public static final String APIKeyYandexMetrica = "f1f73ebb-a17d-48b9-88f3-370e9b1d4aca";

    public static void sendMessageYandexMetrica(Context context, String message) {
        YandexMetrica.getReporter(context, APIKeyYandexMetrica).reportEvent(message);
    }

    public static void sendUserProfileYandexMetrica(String name, GenderAttribute.Gender gender, int age, boolean notificationsEnabled) {
        // Создание объекта UserProfile.
        UserProfile userProfile = UserProfile.newBuilder()
                // Обновление предопределенных атрибутов.
                .apply(Attribute.name().withValue(name))
                .apply(Attribute.gender().withValue(gender))
                .apply(Attribute.birthDate().withAge(age))
                .apply(Attribute.notificationsEnabled().withValue(notificationsEnabled))
                // Обновление собственных атрибутов.
                .apply(Attribute.customString("первый атрибут").withValue("фигня какая нить"))
                .apply(Attribute.customNumber("второй атрибут").withValue(55))
                .apply(Attribute.customCounter("третий атрибут").withDelta(20))
                .build();
        // ProfileID задается через метод класса YandexMetrica.
        YandexMetrica.setUserProfileID("id");

        // Отправка объекта UserProfile.
        YandexMetrica.reportUserProfile(userProfile);
    }


}
