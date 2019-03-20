package com.obitestvernull.commonClassesAndUtils.analitics;

import android.content.Context;


import io.sentry.Sentry;
import io.sentry.android.AndroidSentryClientFactory;
import io.sentry.event.BreadcrumbBuilder;
import io.sentry.event.UserBuilder;

public class SentryAnalitics {
    public static Sentry sentryMessage;
    public static Sentry sentryError;
    static String sentryDsn = "https://c08a3834aa114368bd2fe4098524f3a6:fbf3f2d145364ab2ab9e11fbea19d697@sentry.bstd.ru/76";

    public static void sendSentryAnaliticMessage(Context context, String message) {
        sentryMessage.getContext().setUser(new UserBuilder().build());
        sentryMessage.init(sentryDsn, new AndroidSentryClientFactory(context));
        sentryMessage.capture(message);
    }

    public static void sendSentryAnaliticERRORwithBreadcrumbMessage(Context context, String message) {
        sentryError.getContext().setUser(new UserBuilder().build());
        sentryError.init(sentryDsn, new AndroidSentryClientFactory(context));
        sentryError.getContext().recordBreadcrumb(new BreadcrumbBuilder().setMessage(message).build());

        try {
            throw new UnsupportedOperationException("тут какая то ошибка....");
        } catch (Exception e) {
            sentryError.capture(e);
        }
    }
}
