package br.com.wevs.bankapp.model;

public class Statement {
    private String title;
    private String description;
    private String date;
    private String value;

    public Statement(String title, String description, String date, String value) {
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
