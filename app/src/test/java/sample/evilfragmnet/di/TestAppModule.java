package sample.evilfragmnet.di;

import dagger.Module;
import dagger.Provides;
import sample.evilfragmnet.App;
import sample.evilfragmnet.AppSchedulers;
import sample.evilfragmnet.MockAppSchedulers;
import sample.evilfragmnet.di.module.AppModule;

/**
 * @author Tom Koptel
 */
@Module
public class TestAppModule extends AppModule {
    public TestAppModule(App app) {
        super(app);
    }

    @Provides
    @PerApplication
    AppSchedulers providesAppSchedulers() {
        return new MockAppSchedulers();
    }
}
