package br.com.wevs.bankapp.service;

import java.util.Observable;

import br.com.wevs.bankapp.model.LoginResponse;
import br.com.wevs.bankapp.model.UserAccount;
import io.reactivex.Completable;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.POST;

public interface NetworkInterface {
    @POST("login")
    Call<LoginResponse> users (@Field("user") String user,
                               @Field("password") String password);

}
