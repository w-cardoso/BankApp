package br.com.wevs.bankapp.validator;

import android.content.Context;
import android.widget.EditText;

import br.com.wevs.bankapp.R;

public class StandardValidator implements Validator {

    private final EditText field;
    private final Context context;

    public StandardValidator(EditText field, Context context) {
        this.field = field;
        this.context = context;
    }

    @Override
    public boolean isValid() {
        if (!validateFieldRequired()) return false;
        removeError();
        return false;
    }

    private boolean validateFieldRequired() {
        String text = field.getText().toString();
        if (text.isEmpty()) {
            field.setError("Campo esta vazio");
            return false;
        }
        return true;

    }

    private void removeError() {
        field.setError(null);
    }
}
