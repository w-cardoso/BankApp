package br.com.wevs.bankapp.ui.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.shimmer.ShimmerFrameLayout;

import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;
import br.com.wevs.bankapp.R;
import br.com.wevs.bankapp.model.Statement;
import br.com.wevs.bankapp.model.UserAccount;
import br.com.wevs.bankapp.ui.activity.login.LoginActivity;
import br.com.wevs.bankapp.ui.recyclerview.adapter.ListStatementsAdapter;

public class HomeActivity extends AppCompatActivity implements HomeContract.HomeViewInterface {

    private String TAG = "MainActivity";
    private HomePresenter homePresenter;
    private ListStatementsAdapter adapter;
    private RecyclerView rcv;
    private TextView txtName, txtAccount, txtBalance;
    private ImageView img_logout;
    private ShimmerFrameLayout shimmerFrameLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        UserAccount user = getUserAccount();
        findView();
        fillFields(user);
        setUpsMvp();
        getListStatements(user);
        logoutApp();
        shimmerFrameLayout.startShimmer();

    }

    private void logoutApp() {
        img_logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(HomeActivity.this, LoginActivity.class));
                finish();
            }
        });
    }

    private void getListStatements(UserAccount user) {

        homePresenter.getStatementList(user.getUserId());
    }

    private void setUpsMvp() {
        homePresenter = new HomePresenter(this);
    }

    private UserAccount getUserAccount() {
        return getIntent().getExtras().getParcelable("user");
    }

    private void fillFields(UserAccount user) {
        txtName.setText(user.getName());
        txtAccount.setText(user.getBankAccount()+" / "+user.getAgency());
        String valueBr = transformInCoin(user);
        txtBalance.setText(valueBr);
    }

    private String transformInCoin(UserAccount user) {
        Double value = user.getBalance();
        Locale coinBr = new Locale("pt", "BR");
        return NumberFormat.getCurrencyInstance(coinBr).format(value);
    }

    private void findView() {
        rcv = findViewById(R.id.home_rcv);
        txtName = findViewById(R.id.home_txt_name);
        txtAccount = findViewById(R.id.home_txt_account);
        txtBalance = findViewById(R.id.home_txt_balance);
        img_logout = findViewById(R.id.home_logout);
        shimmerFrameLayout = findViewById(R.id.shimmer_view_container);
    }



    @Override
    public void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_LONG);
    }

    @Override
    public void displayStatement(List<Statement> statement) {


        adapter = new ListStatementsAdapter(statement,this);
        rcv.setAdapter(adapter);
    }


    @Override
    public void displayError(String error) {
        showToast(error);
    }
}
