package br.com.wevs.bankapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListStatementResponse {
    @SerializedName("statementList")
    @Expose
    private List<Statement> statementList;

    @SerializedName("error")
    @Expose
    private ErrorResponse error;

    public ListStatementResponse(List<Statement> statementList, ErrorResponse error) {
        this.statementList = statementList;
        this.error = error;
    }

    public List<Statement> getStatementList() {
        return statementList;
    }

    public void setStatementList(List<Statement> statementList) {
        this.statementList = statementList;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
