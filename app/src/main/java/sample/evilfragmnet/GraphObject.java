package sample.evilfragmnet;

import android.content.Context;

import sample.evilfragmnet.di.component.AppComponent;

/**
 * @author Tom Koptel
 */
public interface GraphObject {
    AppComponent getComponent();

    class Factory {
        private Factory() {}

        public static GraphObject from(Context context) {
            return ((App) context.getApplicationContext());
        }
    }
}
