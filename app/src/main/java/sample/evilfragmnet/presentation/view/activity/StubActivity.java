package sample.evilfragmnet.presentation.view.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import javax.inject.Inject;

import butterknife.Bind;
import butterknife.ButterKnife;
import sample.evilfragmnet.R;
import sample.evilfragmnet.di.module.ActivityModule;
import sample.evilfragmnet.presentation.contract.StubContract;
import sample.evilfragmnet.presentation.model.ItemViewModel;
import sample.evilfragmnet.presentation.presenter.StubPresenter;

public class StubActivity extends BaseActivity implements StubContract.View {

    @Bind(R.id.listView)
    ListView listView;

    @Inject
    StubPresenter mPresenter;

    private ArrayAdapter<ItemViewModel> mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stub);
        ButterKnife.bind(this);

        mAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1);
        listView.setAdapter(mAdapter);

        getAppComponent()
                .plus(new ActivityModule(this))
                .inject(this);

        mPresenter.injectView(this);
        mPresenter.loadData();
    }

    @Override
    public void showResult(@NonNull List<ItemViewModel> result) {
        mAdapter.addAll(result);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mPresenter.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mPresenter.pause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPresenter.destroy();
    }
}
