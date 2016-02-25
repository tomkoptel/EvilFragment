package sample.evilfragmnet.di.module;

import java.util.Collections;
import java.util.List;

import dagger.Module;
import dagger.Provides;
import sample.evilfragmnet.AppSchedulers;
import sample.evilfragmnet.data.route.FakeItemsSearchCallerFactory;
import sample.evilfragmnet.domain.model.AppItem;
import sample.evilfragmnet.domain.route.RouteCallerFactory;
import sample.evilfragmnet.domain.route.Router;
import sample.evilfragmnet.domain.route.page.ItemsLoader;
import sample.evilfragmnet.di.PerActivity;
import sample.evilfragmnet.presentation.model.mapper.ItemViewMapper;
import sample.evilfragmnet.presentation.presenter.StubPresenter;

/**
 * @author Tom Koptel
 */
@Module
public class StubActivityModule {
    @PerActivity
    @Provides
    StubPresenter providesPresenter(ItemViewMapper viewMapper, AppSchedulers appSchedulers) {
        RouteCallerFactory<List<AppItem>> fake = new FakeItemsSearchCallerFactory();
        List<RouteCallerFactory<List<AppItem>>> routeCallerFactories = Collections.singletonList(fake);

        Router<List<AppItem>> router = new Router<>(routeCallerFactories);
        ItemsLoader<List<AppItem>> itemsLoader = new ItemsLoader<>(router);

        return new StubPresenter(itemsLoader, viewMapper, appSchedulers);
    }
}
