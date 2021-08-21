package pers.ruikai.pwms.compiler;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.AbstractParseTreeVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import pers.ruikai.pwms.compiler.PWMSParser.AttrnameContext;
import pers.ruikai.pwms.compiler.PWMSParser.AttrvalueContext;
import pers.ruikai.pwms.compiler.PWMSParser.CategoryContext;
import pers.ruikai.pwms.compiler.PWMSParser.CodeContext;
import pers.ruikai.pwms.compiler.PWMSParser.DateContext;
import pers.ruikai.pwms.compiler.PWMSParser.NameContext;
import pers.ruikai.pwms.compiler.PWMSParser.NoteContext;
import pers.ruikai.pwms.compiler.PWMSParser.NumberContext;
import pers.ruikai.pwms.compiler.PWMSParser.RecordContext;
import pers.ruikai.pwms.compiler.PWMSParser.RecordsContext;
import pers.ruikai.pwms.compiler.PWMSParser.UnitContext;
import pers.ruikai.pwms.models.Category;
import pers.ruikai.pwms.models.Transaction;
import pers.ruikai.pwms.utils.DateConverter;
import pers.ruikai.pwms.utils.ListElementFinder;
import pers.ruikai.pwms.warehouse.Warehouse;

public class Builder extends AbstractParseTreeVisitor<Void> implements PWMSVisitor<Void>{

    private List<Category> categories;
    private Date date;

    public Builder() {
        categories = new ArrayList<>();
        date = new Date();
    }

    public Warehouse build(InputStream is) throws IOException {
        CharStream input = CharStreams.fromStream(is);
        PWMSLexer lexer = new PWMSLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PWMSParser parser = new PWMSParser(tokens);
        parser.setBuildParseTree(true);      // tell ANTLR to build a parse tree
        ParseTree tree = parser.records(); // parse
        visit(tree);
        return new Warehouse(categories);
    }

    public Warehouse build(String path) throws IOException{
        InputStream is = new FileInputStream(path);
        return build(is);
    }

    @Override
    public Void visitRecords(RecordsContext ctx) {
        for(CategoryContext c : ctx.category()) {
            visit(c);
        }
        for(RecordContext c: ctx.record()) {
            visit(c);
        }
        return null;
    }

    @Override
    public Void visitCategory(CategoryContext ctx) {
        String name = ctx.name().getText();
        String code = ctx.code().getText();
        Category category = new Category(name, code);

        for(AttrnameContext attr : ctx.attrname()) {
            category.addAttrName(attr.getText());
        }
        categories.add(category);
        return null;
    }

    @Override
    public Void visitRecord(RecordContext ctx) {
        if(ctx.date()!=null) {
            try {
                this.date = DateConverter.string2Date(ctx.date().getText());
            }
            catch(ParseException e) {
                // do nothing
            }
        }

        Transaction tx = new Transaction();
        tx.setDate(date);

        if(ctx.IN()!=null) {
            tx.setInOrOut(Transaction.InOrOut.IN);
        }
        else {
            tx.setInOrOut(Transaction.InOrOut.OUT);
        }

        String name = ctx.name().getText();
        ListElementFinder<Category> finder = new ListElementFinder<>(categories);
        try {
            Category category = finder.findFirst((Category c) -> (c.getName().equals(name)));
            assert (category!=null);
            category.addTransaction(tx);
        }
        catch(ParseException e) {
            return null;
        }
        catch(AssertionError e) {
            return null;
        }
        catch(Exception e) {
            return null;
        }

        if(ctx.note()!=null) tx.setNote(ctx.note().getText());
        tx.setNumber(Integer.parseInt(ctx.number().getText()));
        tx.setUnit(ctx.unit().getText());

        for(AttrvalueContext value: ctx.attrvalue()) {
            tx.addValue(value.getText());
        }

        return null;
    }

    @Override
    public Void visitName(NameContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitCode(CodeContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitAttrname(AttrnameContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitDate(DateContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitNumber(NumberContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitUnit(UnitContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitNote(NoteContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Void visitAttrvalue(AttrvalueContext ctx) {
        // TODO Auto-generated method stub
        return null;
    }


}
