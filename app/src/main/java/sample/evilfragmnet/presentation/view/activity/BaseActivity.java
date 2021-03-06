package sample.evilfragmnet.presentation.view.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import sample.evilfragmnet.GraphObject;
import sample.evilfragmnet.di.component.AppComponent;
import sample.evilfragmnet.di.module.ActivityModule;

/**
 * @author Tom Koptel
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getAppComponent().inject(this);
    }

    protected AppComponent getAppComponent() {
        return GraphObject.Factory.from(this).getComponent();
    }

    protected ActivityModule getActivityModule() {
        return new ActivityModule(this);
    }
}
