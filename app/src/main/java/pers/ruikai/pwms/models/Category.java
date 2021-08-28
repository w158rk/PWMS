package pers.ruikai.pwms.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Represent for a category for personal belongings <br>
 *
 * - name category name <br>
 * - code category code <br>
 * - attrNames list of attribute names <br>
 * - attrNames list of transactions whose thing belongs to this category <br>
 *
 *
 */
public class Category {
    private String name;
    private String code;
    private List<String> attrNames;
    private List<Transaction> transactions;

    /**
     * constructor
     */
    public Category() {
        attrNames = new ArrayList<>();
        transactions = new ArrayList<>();
    }

    /**
     *
     * @param name category name
     * @param code category code
     */
    public Category(String name, String code) {
        this();
        this.name = name;
        this.code = code;
    }

    /**
     * override equals, we only compare the name field
     *
     * @param obj the compared target
     */
    @Override
    public boolean equals(Object obj) {
        return name.equals(((Category)obj).name);
    }

    /**
     * override hashcode, we only hash the name field
     */
    @Override
    public int hashCode() {
        return name.hashCode();
    }

    /**
     * add an attribute name
     *
     * @param name to-be-added attribute name
     * @return true if success
     */
    public boolean addAttrName(String name) {
        return attrNames.add(name);
    }

    /**
     * add a transaction
     * @param transaction to-be-added transaction
     * @return true if success
     */
    public boolean addTransaction(Transaction transaction) {
        transaction.setCategory(this);
        return transactions.add(transaction);
    }

    /**
     *
     * @return category name
     */
    public String getName() {
        return name;
    }
    /**
     *
     * @param name category name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     *
     * @return category code
     */
    public String getCode() {
        return code;
    }
    /**
     *
     * @param code category code
     */
    public void setCode(String code) {
        this.code = code;
    }
    /**
     *
     * @return the list of attribute names
     */
    public List<String> getAttrNames() {
        return attrNames;
    }
    /**
     *
     * @param attrNames the list of attribute names
     */
    public void setAttrNames(List<String> attrNames) {
        this.attrNames = attrNames;
    }
    /**
     *
     * @return the list of transactions related belonging to this category
     */
    public List<Transaction> getTransactions() {
        return transactions;
    }
    /**
     *
     * @param transactions the list of transactions related belonging to this category
     */
    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }

}
