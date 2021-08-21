package pers.ruikai.pwms.models;

import java.util.ArrayList;
import java.util.List;

public class Category {
    private String name;
    private String code;
    private List<String> attrNames;
    private List<Transaction> transactions;

    public Category() {
        attrNames = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    public Category(String name, String code) {
        this();
        this.name = name;
        this.code = code;
    }

    @Override
    public boolean equals(Object obj) {
        return name.equals(((Category)obj).name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public boolean addAttrName(String name) {
        return attrNames.add(name);
    }

    public boolean addTransaction(Transaction transaction) {
        transaction.setCatetory(this);
        return transactions.add(transaction);
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getCode() {
        return code;
    }
    public void setCode(String code) {
        this.code = code;
    }
    public List<String> getAttrNames() {
        return attrNames;
    }
    public void setAttrNames(List<String> attrNames) {
        this.attrNames = attrNames;
    }
    public List<Transaction> getTransactions() {
        return transactions;
    }
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
