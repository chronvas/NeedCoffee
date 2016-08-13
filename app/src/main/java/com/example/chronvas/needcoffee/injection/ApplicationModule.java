package com.example.chronvas.needcoffee.injection;

import android.app.Application;
import android.content.Context;

import com.example.chronvas.needcoffee.helpers.LocationHelper;
import com.example.chronvas.needcoffee.helpers.SharedPrefHelper;
import com.example.chronvas.needcoffee.http.Network;
import com.example.chronvas.needcoffee.model.MapsActivityModel;
import com.example.chronvas.needcoffee.presenter.MapsActivityMVP;
import com.example.chronvas.needcoffee.presenter.MapsActivityPresenter;

import org.greenrobot.eventbus.EventBus;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by chronvas on 3/8/2016.
 */
@Module
public class ApplicationModule {

    private Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return application;
    }

    @Provides
    @Singleton
    public EventBus provideBus() {
        return new EventBus();
    }

    @Provides
    @Singleton
    public SharedPrefHelper provideSharedPrefHelper(Context context){
        return new SharedPrefHelper(context);
    }

    @Provides
    MapsActivityMVP.Presenter provideMapsActivityPresenter(MapsActivityMVP.Model model,
                                                           Network.VenueSearchCalls venueSearchCalls,
                                                           Network.LocationCalls locationCalls,
                                                           EventBus bus,
                                                           LocationHelper locationHelper) {

        return new MapsActivityPresenter(model,venueSearchCalls, locationCalls, bus, locationHelper);
    }

    @Provides
    MapsActivityMVP.Model provideMapsActivityModel(SharedPrefHelper sharedPrefHelper){

        return new MapsActivityModel(sharedPrefHelper);
    }

    @Singleton
    @Provides
    public LocationHelper provideLocationObservable(Context context) {
        return new LocationHelper(context);
    }
}
