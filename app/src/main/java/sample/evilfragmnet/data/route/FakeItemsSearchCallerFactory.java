package sample.evilfragmnet.data.route;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import rx.Observable;
import sample.evilfragmnet.domain.model.AppItem;
import sample.evilfragmnet.domain.route.AbstractRouteCaller;
import sample.evilfragmnet.domain.route.RouteCaller;
import sample.evilfragmnet.domain.route.RouteCallerFactory;

/**
 * @author Tom Koptel
 */
public final class FakeItemsSearchCallerFactory implements RouteCallerFactory<List<AppItem>> {
    private final RouteCaller<List<AppItem>> mCaller = new AbstractRouteCaller<List<AppItem>>(0, 100) {
        @Override
        protected Observable<List<AppItem>> performCall(int offset, int limit) {
            List<AppItem> list = new ArrayList<>(limit);
            for (int i = offset; i < limit + offset; i++) {
                list.add(new AppItem("Unique Item: " + i));
            }
            return Observable.just(list);
        }
    };
    private final List<RouteCaller<List<AppItem>>> mCallers = Collections.singletonList(mCaller);

    @Override
    public Observable<List<RouteCaller<List<AppItem>>>> getAllCallers() {
        return Observable.just(mCallers);
    }
}
