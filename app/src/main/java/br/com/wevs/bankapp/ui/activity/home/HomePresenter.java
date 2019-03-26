package br.com.wevs.bankapp.ui.activity.home;


import br.com.wevs.bankapp.model.ListStatementResponse;
import br.com.wevs.bankapp.model.LoginResponse;
import br.com.wevs.bankapp.service.NetworkClient;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements HomeContract.HomePresenterInterface {

    private HomeContract.HomeViewInterface mvi;

    public HomePresenter(HomeContract.HomeViewInterface mvi) {
        this.mvi = mvi;
    }

    @Override
    public void getStatementList(int id) {
        getObservable(id).subscribeWith(getObserver());
    }

    public Observable<ListStatementResponse> getObservable(int id) {
        return NetworkClient.getAPIListStatement()
                .getMovies(id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public DisposableObserver<ListStatementResponse> getObserver() {
        return new DisposableObserver<ListStatementResponse>() {
            @Override
            public void onNext(ListStatementResponse statementResponse) {
                mvi.displayStatement(statementResponse.getStatementList());
            }

            @Override
            public void onError(Throwable e) {
                mvi.displayError(e.toString());
            }

            @Override
            public void onComplete() {

            }
        };
    }


}