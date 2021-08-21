package pers.ruikai.pwms.formatter;

import java.util.ArrayList;
import java.util.Formattable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.jakewharton.fliptables.FlipTable;

import pers.ruikai.pwms.models.Category;
import pers.ruikai.pwms.models.Transaction;
import pers.ruikai.pwms.models.Transaction.InOrOut;
import pers.ruikai.pwms.utils.DateConverter;
import pers.ruikai.pwms.warehouse.Warehouse;

public class TextFormatter {

    private static int numObject(Category category) {
        int ret = 0;
        for(Transaction tx : category.getTransactions()) {
            int cnt = tx.getNumber();
            if(tx.getInOrOut()==InOrOut.OUT) {
                cnt = -cnt;
            }
            ret += cnt;
        }
        return ret;
    }

    private static List<String> format(Transaction tx) {
        List<String> ret = new ArrayList<>();
        ret.add(DateConverter.date2String(tx.getDate()));
        ret.add(tx.getInOrOut()==InOrOut.IN?"IN":"OUT");
        ret.add(String.valueOf(tx.getNumber()));
        for(String value: tx.getValues()) {
            ret.add(value);
        }
        return ret;
    }

    private static String formatTable(String []header, String [][]cells) {
        // class Substitution {
        //     int row = 0;
        //     int column = 0;
        //     int index = 0;
        //     String chinese = null;

        //     public Substitution(int row, int column, int index, String chinese) {
        //         this.row = row;
        //         this.column = column;
        //         this.index = index;
        //         this.chinese = chinese;
        //     }
        // }
        for(int i=0; i<header.length; i++) {
            Pattern pattern = Pattern.compile("([^\u0000-\u007F])");
            Matcher matcher = pattern.matcher(header[i]);
            String rep = matcher.replaceAll(".$1");
            header[i] = rep;
        }

        int rows = cells.length;
        int cols = cells[0].length;
        for(int i=0; i<rows; i++) {
            for(int j=0; j<cols; j++) {
                Pattern pattern = Pattern.compile("([^\u0000-\u007F])");
                Matcher matcher = pattern.matcher(cells[i][j]);
                String rep = matcher.replaceAll(".$1");
                cells[i][j] = rep;
            }
        }


        String table = FlipTable.of(header, cells);
        table = table.replace(".", "");
        return table;
    }

    private static String format(Category category) {
        List<String> lines = new ArrayList<>();
        String ret = null;

        lines.add(String.format("[%s] %d %d", category.getName(), numObject(category),
            category.getTransactions().size()));

        List<String> header = new ArrayList<>();
        header.add("Date");
        header.add("IN/OUT");
        header.add("Number");
        for(String name : category.getAttrNames()) {
            header.add(name);
        }

        List<String []> rows = new ArrayList<>();
        for(Transaction tx: category.getTransactions()) {
            List<String> row = format(tx);
            String [] rowArray = new String[row.size()];
            rows.add(row.toArray(rowArray));
        }

        String [] headerArray = new String[header.size()];
        String [][]rowsArray = new String[rows.size()][rows.get(0).length];
        headerArray = header.toArray(headerArray);
        rowsArray = rows.toArray(rowsArray);
        lines.add(formatTable(headerArray, rowsArray));

        ret = String.join("\n", lines);
        return ret;
    }

    public static String format(Warehouse warehouse) {
        String ret = "";
        List<Category> categories = warehouse.getCategories();
        for(Category category: categories) {
            ret += format(category);
            ret += "\n\n";
        }
        return ret;
    }
}
