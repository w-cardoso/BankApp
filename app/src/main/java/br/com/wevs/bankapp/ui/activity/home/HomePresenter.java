package br.com.wevs.bankapp.ui.activity.home;


import br.com.wevs.bankapp.model.ListStatementResponse;
import br.com.wevs.bankapp.model.Statement;
import br.com.wevs.bankapp.service.NetworkClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomePresenter implements HomeContract.HomePresenterInterface {

    HomeContract.HomeViewInterface mvi;
    private String TAG = "HomePresenter";

    public HomePresenter(HomeContract.HomeViewInterface mvi) {
        this.mvi = mvi;
    }

    @Override
    public void getStatementList(int id) {
        Call<ListStatementResponse> loginResponse = NetworkClient.getAPIListStatement().getMovies(id);
        loginResponse.enqueue(new Callback<ListStatementResponse>() {


            @Override
            public void onResponse(Call<ListStatementResponse> call, Response<ListStatementResponse> response) {
                mvi.displayStatement(response.body().getStatementList());
            }

            @Override
            public void onFailure(Call<ListStatementResponse> call, Throwable t) {

            }
        });

    }
}