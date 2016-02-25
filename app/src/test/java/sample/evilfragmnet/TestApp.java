package sample.evilfragmnet;

import sample.evilfragmnet.di.component.AppComponent;
import sample.evilfragmnet.di.component.DaggerTestAppComponent;
import sample.evilfragmnet.di.TestAppModule;

/**
 * @author Tom Koptel
 */
public class TestApp extends App {
    @Override
    public AppComponent getComponent() {
        return DaggerTestAppComponent.builder()
                .testAppModule(new TestAppModule(this))
                .build();
    }
}
