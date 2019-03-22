package br.com.wevs.bankapp.service;

import br.com.wevs.bankapp.model.Login;
import br.com.wevs.bankapp.model.LoginResponse;
import br.com.wevs.bankapp.model.UserAccount;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface APIUserClient {

    @POST("/API/Tokens")
    Call<LoginResponse> login(@Body Login login);


}
