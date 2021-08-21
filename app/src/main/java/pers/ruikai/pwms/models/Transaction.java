package pers.ruikai.pwms.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Transaction {

    public enum InOrOut {
        IN, OUT
    }

    private Date date;
    private InOrOut inOrOut;
    private Category catetory;
    private int number;
    private String unit;
    private String note;
    private List<String> values;

    public Transaction() {
        values = new ArrayList<>();
    }

    public boolean addValue(String value) {
        return values.add(value);
    }
    public List<String> getValues() {
        return values;
    }
    public void setValues(List<String> values) {
        this.values = values;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public InOrOut getInOrOut() {
        return inOrOut;
    }
    public void setInOrOut(InOrOut inOrOut) {
        this.inOrOut = inOrOut;
    }
    public Category getCatetory() {
        return catetory;
    }
    public void setCatetory(Category catetory) {
        this.catetory = catetory;
    }
    public int getNumber() {
        return number;
    }
    public void setNumber(int number) {
        this.number = number;
    }
    public String getUnit() {
        return unit;
    }
    public void setUnit(String unit) {
        this.unit = unit;
    }
    public String getNote() {
        return note;
    }
    public void setNote(String note) {
        this.note = note;
    }

}
