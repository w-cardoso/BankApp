package br.com.wevs.bankapp.ui.activity.login;

import br.com.wevs.bankapp.model.UserAccount;

public interface LoginContract {


    interface LoginViewInterface{
        void showToast(String s);
        void displayMovies(UserAccount user);
        void displayError(String s);
    }

    interface LoginPresenterInterface{
        void validateUser(String user, String password);
    }
}
