package br.com.wevs.bankapp.ui.activity.home;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.Arrays;
import java.util.List;

import br.com.wevs.bankapp.R;
import br.com.wevs.bankapp.model.Statement;
import br.com.wevs.bankapp.model.UserAccount;
import br.com.wevs.bankapp.ui.recyclerview.adapter.ListStatementsAdapter;

public class HomeActivity extends AppCompatActivity implements HomeContract.HomeViewInterface {

    private String TAG = "MainActivity";
    private HomePresenter homePresenter;
    private ListStatementsAdapter adapter;
    private RecyclerView rcv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        UserAccount user = getIntent().getExtras().getParcelable("user");
        homePresenter = new HomePresenter(this);
        rcv = findViewById(R.id.home_rcv);
        homePresenter.getStatementList(user.getUserId());


    }

    @Override
    public void showToast(String s) {

    }

    @Override
    public void displayStatement(List<Statement> statement) {
        adapter = new ListStatementsAdapter(statement,this);
        rcv.setAdapter(adapter);
    }




    @Override
    public void displayError(String s) {

    }
}
