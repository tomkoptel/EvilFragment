package sample.evilfragmnet.presentation.contract;

import android.support.annotation.NonNull;

import java.util.List;

import sample.evilfragmnet.presentation.model.ItemViewModel;

/**
 * @author Tom Koptel
 */
public interface StubContract {
    interface View {
        void showResult(@NonNull List<ItemViewModel> result);
    }

    interface Action {
        void loadData();
    }
}
