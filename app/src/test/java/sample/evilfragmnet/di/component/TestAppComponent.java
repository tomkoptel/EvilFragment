package sample.evilfragmnet.di.component;

import sample.evilfragmnet.di.TestAppModule;

import dagger.Component;
import sample.evilfragmnet.di.PerApplication;
import sample.evilfragmnet.di.module.NetworkModule;

/**
 * @author Tom Koptel
 */
@PerApplication
@Component(
        modules = {
                TestAppModule.class,
                NetworkModule.class,
        }
)
public interface TestAppComponent extends AppComponent {
}
