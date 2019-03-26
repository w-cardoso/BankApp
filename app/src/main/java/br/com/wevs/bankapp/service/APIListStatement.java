package br.com.wevs.bankapp.service;


import br.com.wevs.bankapp.model.ListStatementResponse;
import io.reactivex.Observable;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface APIListStatement {
    @GET("statements/{id}")
    Observable<ListStatementResponse> getMovies(@Path("id") int id);
}
