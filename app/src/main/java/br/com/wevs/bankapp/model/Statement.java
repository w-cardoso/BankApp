package br.com.wevs.bankapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Statement {
    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("desc")
    @Expose
    private String description;

    @SerializedName("date")
    @Expose
    private String date;

    @SerializedName("value")
    @Expose
    private double value;

    public Statement() {
    }

    public Statement(String title, String description, String date, double value) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.value = value;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }
}
