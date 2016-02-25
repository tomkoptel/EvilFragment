package sample.evilfragmnet.domain.route;

import java.util.List;

/**
 * @author Tom Koptel
 */
public interface RouteCallerFactory<T> {
    rx.Observable<List<RouteCaller<T>>> getAllCallers();
}
