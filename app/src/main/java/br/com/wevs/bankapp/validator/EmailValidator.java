package br.com.wevs.bankapp.validator;

import android.content.Context;
import android.widget.EditText;

public class EmailValidator implements Validator {
    private final EditText fieldEmail;
    private final StandardValidator standardValidator;
    private final Context context;

    public EmailValidator(EditText fieldEmail, Context context) {
        this.fieldEmail = fieldEmail;
        this.standardValidator = new StandardValidator(this.fieldEmail, context);
        this.context = context;
    }

    private boolean standardValidate(String email) {
        if (email.matches(".+@.+\\..+")) {
            return true;
        }
        fieldEmail.setError("Digite um email válido");
        return false;
    }


    @Override
    public boolean isValid() {
       // if (!standardValidator.isValid()) return false;
        String email = fieldEmail.getText().toString();
        if (!standardValidate(email)) return false;
        return true;
    }
}
