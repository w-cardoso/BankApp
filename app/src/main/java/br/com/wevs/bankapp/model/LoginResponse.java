package br.com.wevs.bankapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class LoginResponse {

    @SerializedName("userAccount")
    @Expose
    private UserAccount userAccount;

    @SerializedName("error")
    @Expose
    private ErrorResponse error;

    public LoginResponse(UserAccount userAccount, ErrorResponse error) {
        this.userAccount = userAccount;
        this.error = error;
    }

    public UserAccount getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(UserAccount userAccount) {
        this.userAccount = userAccount;
    }

    public ErrorResponse getError() {
        return error;
    }

    public void setError(ErrorResponse error) {
        this.error = error;
    }
}
