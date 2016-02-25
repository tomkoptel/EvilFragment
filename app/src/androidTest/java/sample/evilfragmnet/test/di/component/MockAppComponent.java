package sample.evilfragmnet.test.di.component;

import dagger.Component;
import sample.evilfragmnet.di.PerApplication;
import sample.evilfragmnet.di.component.AppComponent;
import sample.evilfragmnet.di.module.NetworkModule;
import sample.evilfragmnet.test.di.model.MockAppModule;

/**
 * @author Tom Koptel
 */
@PerApplication
@Component(
        modules = {
                MockAppModule.class,
                NetworkModule.class,
        }
)
public interface MockAppComponent extends AppComponent {
}
