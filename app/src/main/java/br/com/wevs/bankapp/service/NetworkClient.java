package br.com.wevs.bankapp.service;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClient {

    public static Retrofit retrofit;

    private NetworkClient() {
    }

    public static final String BASE_URL = "https://bank-app-test.herokuapp.com/api/";


    public static APIUserClient getAPIUserClient(){
        return RetrofitClient.getClient(BASE_URL).create(APIUserClient.class);
    }

    public static APIListStatement getAPIListStatement(){
        return RetrofitClient.getClient(BASE_URL).create(APIListStatement.class);
    }

}
