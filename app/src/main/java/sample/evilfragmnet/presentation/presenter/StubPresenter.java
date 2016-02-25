package sample.evilfragmnet.presentation.presenter;

import java.util.List;

import javax.inject.Inject;

import rx.functions.Action1;
import rx.functions.Func1;
import rx.observers.Subscribers;
import sample.evilfragmnet.AppSchedulers;
import sample.evilfragmnet.domain.model.AppItem;
import sample.evilfragmnet.domain.route.page.ItemsLoader;
import sample.evilfragmnet.di.PerActivity;
import sample.evilfragmnet.presentation.contract.StubContract;
import sample.evilfragmnet.presentation.model.ItemViewModel;
import sample.evilfragmnet.presentation.model.mapper.ItemViewMapper;

/**
 * @author Tom Koptel
 */
@PerActivity
public class StubPresenter extends Presenter<StubContract.View> implements StubContract.Action {
    private ItemsLoader<List<AppItem>> mItemsLoader;
    private ItemViewMapper mItemViewMapper;
    private AppSchedulers mSchedulers;

    @Inject
    public StubPresenter(
            ItemsLoader<List<AppItem>> itemsLoader,
            ItemViewMapper itemViewMapper,
            AppSchedulers schedulers
    ) {
        mItemsLoader = itemsLoader;
        mItemViewMapper = itemViewMapper;
        mSchedulers = schedulers;
    }

    @Override
    public void resume() {
    }

    @Override
    public void pause() {
    }

    @Override
    public void destroy() {
    }

    @Override
    public void loadData() {
        mItemsLoader.firstPage()
                .map(new Func1<List<AppItem>, List<ItemViewModel>>() {
                    @Override
                    public List<ItemViewModel> call(List<AppItem> appItems) {
                        return mItemViewMapper.toViewModels(appItems);
                    }
                })
                .subscribeOn(mSchedulers.backgroundThread())
                .observeOn(mSchedulers.uiThread())
                .subscribe(
                        Subscribers.create(new Action1<List<ItemViewModel>>() {
                            @Override
                            public void call(List<ItemViewModel> items) {
                                getView().showResult(items);
                            }
                        })
                );
    }
}
