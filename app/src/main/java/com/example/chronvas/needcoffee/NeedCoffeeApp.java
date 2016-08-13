package com.example.chronvas.needcoffee;

import android.*;
import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;

import com.example.chronvas.needcoffee.injection.ApiModule;
import com.example.chronvas.needcoffee.injection.ApplicationComponent;
import com.example.chronvas.needcoffee.injection.ApplicationModule;
import com.example.chronvas.needcoffee.injection.DaggerApplicationComponent;
import com.karumi.dexter.Dexter;

import io.realm.Realm;
import io.realm.RealmConfiguration;

/**
 * Created by chronvas on 3/8/2016.
 */

public class NeedCoffeeApp extends MultiDexApplication{

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .apiModule(new ApiModule())
                .build();

        //Dexter.initialize(this);

        //Realm config
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder(this)
                .build();
        Realm.setDefaultConfiguration(realmConfiguration);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        MultiDex.install(this);

    }
}
