package sample.evilfragmnet.di.component;

import dagger.Subcomponent;
import sample.evilfragmnet.di.PerActivity;
import sample.evilfragmnet.di.module.ActivityModule;
import sample.evilfragmnet.di.module.StubActivityModule;
import sample.evilfragmnet.presentation.view.activity.StubActivity;

/**
 * @author Tom Koptel
 */
@PerActivity
@Subcomponent(
        modules = {
                ActivityModule.class,
                StubActivityModule.class,
        }
)
public interface StubActivityComponent {
    void inject(StubActivity activity);
}
