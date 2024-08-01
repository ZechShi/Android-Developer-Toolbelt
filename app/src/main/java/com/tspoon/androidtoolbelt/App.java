package com.tspoon.androidtoolbelt;

import android.app.Application;


import com.tspoon.androidtoolbelt.component.service.ServiceHolder;
import com.tspoon.androidtoolbelt.component.service.ServiceHolderImpl;

import timber.log.Timber;

public class App extends Application {

    private static final ServiceHolder sServiceHolder = new ServiceHolderImpl();

    @Override
    public void onCreate() {
        super.onCreate();
        Timber.plant(new Timber.DebugTree());
    }

    public static ServiceHolder getServiceHolder() {
        return sServiceHolder;
    }
}
