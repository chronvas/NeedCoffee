package com.example.chronvas.needcoffee.injection;

import com.example.chronvas.needcoffee.MapsActivity;
import com.example.chronvas.needcoffee.NeedCoffeeApp;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by chronvas on 3/8/2016.
 */

@Singleton
@Component(modules = {ApplicationModule.class, ApiModule.class})
public interface ApplicationComponent {

    void inject(NeedCoffeeApp targer);

    void inject(MapsActivity target);
}
