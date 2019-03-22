package br.com.wevs.bankapp.ui.activity.login;

import br.com.wevs.bankapp.model.Login;
import br.com.wevs.bankapp.model.LoginResponse;
import br.com.wevs.bankapp.service.NetworkClient;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginPresenter implements LoginContract.LoginPresenterInterface {

    LoginContract.LoginViewInterface mvi;
    private String TAG = "MainPresenter";

    public LoginPresenter(LoginContract.LoginViewInterface mvi) {
        this.mvi = mvi;
    }


    @Override
    public void validateUser(String user, String password) {
        Login login = new Login();
        login.setUser(user);
        login.setPassword(password);
        Call<LoginResponse> loginResponse = NetworkClient.getAPIUserClient().login(login);
        loginResponse.enqueue(new Callback<LoginResponse>() {
            @Override
            public void onResponse(Call<LoginResponse> call, Response<LoginResponse> response) {
                LoginResponse user = response.body();
                mvi.displayMovies(response.body().getUserAccount());

            }

            @Override
            public void onFailure(Call<LoginResponse> call, Throwable t) {
                mvi.displayError("Não foi possivel efetuar o login");
            }
        });

    }





}
