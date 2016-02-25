package sample.evilfragmnet;

import android.app.Application;

import sample.evilfragmnet.di.component.AppComponent;
import sample.evilfragmnet.di.component.DaggerAppComponent;
import sample.evilfragmnet.di.module.AppModule;

/**
 * @author Tom Koptel
 */
public class App extends Application implements GraphObject {

    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public AppComponent getComponent() {
        if (mAppComponent == null) {
            mAppComponent = DaggerAppComponent.builder()
                    .appModule(new AppModule(this))
                    .build();
        }
        return mAppComponent;
    }
}
