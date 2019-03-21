package br.com.wevs.bankapp.ui.activity.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

import br.com.wevs.bankapp.R;
import br.com.wevs.bankapp.ui.activity.home.HomeActivity;
import br.com.wevs.bankapp.validator.EmailValidator;
import br.com.wevs.bankapp.validator.PasswordValidator;
import br.com.wevs.bankapp.validator.Validator;

public class LoginActivity extends AppCompatActivity {

    private final List<Validator> validators = new ArrayList<>();
    private Button btnLogin;
    private EditText edtUser;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeFields();
    }

    private void initializeFields() {
        setUpFieldEmail();
        setUpFieldPassword();
        setUpButtonLogin();
    }


    private void setUpFieldEmail() {
        edtUser = findViewById(R.id.login_edt_user);
        final EmailValidator validator = new EmailValidator(edtUser, getApplicationContext());
        validators.add(validator);
        edtUser.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validator.isValid();
                }
            }
        });
    }

    private void setUpFieldPassword() {
        edtPassword = findViewById(R.id.login_edt_password);
        final PasswordValidator validator = new PasswordValidator(edtPassword, getApplicationContext());
        validators.add(validator);
        edtPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (!hasFocus) {
                    validator.isValid();
                }
            }
        });
    }

    private void setUpButtonLogin() {
        btnLogin = findViewById(R.id.login_btn);
            btnLogin.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    boolean formIsValid = validAllFields();
                    if (formIsValid) {
                        startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                    }
                }
            });

    }

    private boolean validAllFields() {
        boolean formIsValid = true;
        for (Validator validator : validators) {
            if (!validator.isValid()) {
                formIsValid = false;
            }
        }
        return formIsValid;
    }
}
