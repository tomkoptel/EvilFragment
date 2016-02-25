package sample.evilfragmnet.test;

import sample.evilfragmnet.App;
import sample.evilfragmnet.di.component.AppComponent;
import sample.evilfragmnet.test.di.component.DaggerMockAppComponent;
import sample.evilfragmnet.test.di.model.MockAppModule;

/**
 * @author Tom Koptel
 */
public class MockApp extends App {
    @Override
    public AppComponent getComponent() {
        return DaggerMockAppComponent.builder()
                .mockAppModule(new MockAppModule(this))
                .build();
    }
}
