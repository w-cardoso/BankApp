package br.com.wevs.bankapp.validator;

import android.content.Context;
import android.widget.EditText;

public class PasswordValidator implements Validator {

    private final EditText fieldPassword;
    private final StandardValidator standardValidator;
    private final Context context;

    public PasswordValidator(EditText fieldPassword, Context context) {
        this.fieldPassword = fieldPassword;
        this.standardValidator = new StandardValidator(fieldPassword, context);
        this.context = context;
    }

    private boolean standardValidate(String password) {
        if (password.matches("((?=.*\\d)(?=.*[A-Z])(?=.*\\W).{8,16})")) {
            return true;
        }
        fieldPassword.setError("Sua senha não possui os requisitos minimos");
        return false;

    }


    @Override
    public boolean isValid() {
       // if (!standardValidator.isValid()) return false;
        String password = fieldPassword.getText().toString();
        if (!standardValidate(password)) return false;
        return true;
    }
}
