package sample.evilfragmnet.di.module;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import sample.evilfragmnet.App;
import sample.evilfragmnet.AppSchedulers;
import sample.evilfragmnet.di.ApplicationContext;
import sample.evilfragmnet.di.PerApplication;

/**
 * @author Tom Koptel
 */
@Module
public class AppModule {
    private final App mApp;

    public AppModule(App app) {
        mApp = app;
    }

    @ApplicationContext
    @PerApplication
    @Provides
    Context providesAppContext() {
        return mApp;
    }

    @Provides
    @PerApplication
    AppSchedulers providesAppSchedulers() {
        return AppSchedulers.DEFAULT;
    }
}
