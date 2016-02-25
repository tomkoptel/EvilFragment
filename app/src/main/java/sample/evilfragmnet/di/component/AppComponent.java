package sample.evilfragmnet.di.component;

import dagger.Component;
import sample.evilfragmnet.di.PerApplication;
import sample.evilfragmnet.di.module.ActivityModule;
import sample.evilfragmnet.di.module.AppModule;
import sample.evilfragmnet.di.module.NetworkModule;
import sample.evilfragmnet.presentation.view.activity.BaseActivity;

/**
 * @author Tom Koptel
 */
@PerApplication
@Component(
        modules = {
                AppModule.class,
                NetworkModule.class,
        }
)
public interface AppComponent {
    void inject(BaseActivity baseActivity);

    StubActivityComponent plus(ActivityModule activityModule);
}
