package pers.ruikai.pwms.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
/**
 * represent for a transaction record
 *
 * including information about <br>
 *      - date <br>
 *      - in or out <br>
 *      - category <br>
 *      - number: how many things are import or removed <br>
 *      - unit: in which unit we count the thing <br>
 *      - note: some additional information about the things <br>
 *      - values: corresponding to the category attribute names <br>
 *
 * @version 0.0.1
 */
public class Transaction {

    public enum InOrOut {
        IN, OUT
    }

    private Date date;
    private InOrOut inOrOut;
    private Category category;
    private int number;
    private String unit;
    private String note;
    private List<String> values;
    /**
     * constructor
     */
    public Transaction() {
        values = new ArrayList<>();
    }
    /**
     *
     * @param value attribute value
     * @return true if success
     */
    public boolean addValue(String value) {
        return values.add(value);
    }
    /**
     * @return list of the attribute values
     */
    public List<String> getValues() {
        return values;
    }
    /**
     *
     * @param values list of the attribute values
     */
    public void setValues(List<String> values) {
        this.values = values;
    }
    /**
     *
     * @return date date of this transaction
     */
    public Date getDate() {
        return date;
    }
    /**
     *
     * @param date date of this transaction
     */
    public void setDate(Date date) {
        this.date = date;
    }
    /**
     *
     * @return IN or OUT, type: enum InOrOut
     */
    public InOrOut getInOrOut() {
        return inOrOut;
    }
    /**
     *
     * @param inOrOut IN or OUT, type: enum InOrOut
     */
    public void setInOrOut(InOrOut inOrOut) {
        this.inOrOut = inOrOut;
    }
    /**
     *
     * @return category category the thing in the transaction belongs to
     */
    public Category getCategory() {
        return category;
    }
    /**
     *
     * @param category category the thing in the transaction belongs to
     */
    public void setCategory(Category category) {
        this.category = category;
    }
    /**
     *
     * @return number of the thing in the transaction
     */
    public int getNumber() {
        return number;
    }
    /**
     *
     * @param number number of the thing in the transaction
     */
    public void setNumber(int number) {
        this.number = number;
    }
    /**
     *
     * @return unit unit of the thing in the transaction
     */
    public String getUnit() {
        return unit;
    }
    /**
     *
     * @param unit unit of the thing in the transaction
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }
    /**
     *
     * @return additional information of this transaction
     */
    public String getNote() {
        return note;
    }
    /**
     *
     * @param note additional information of this transaction
     */
    public void setNote(String note) {
        this.note = note;
    }

}
