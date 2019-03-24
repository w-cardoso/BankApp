package br.com.wevs.bankapp.ui.activity.home;

import java.util.List;

import br.com.wevs.bankapp.model.Statement;

public interface HomeContract {

    interface HomeViewInterface{
        void showToast(String s);
        void displayStatement(List<Statement> statement);
        void displayError(String s);
    }

    interface HomePresenterInterface{
        void getStatementList(int id);
    }
}
